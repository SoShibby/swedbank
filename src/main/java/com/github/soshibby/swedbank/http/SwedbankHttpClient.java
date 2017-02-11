package com.github.soshibby.swedbank.http;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.soshibby.swedbank.exceptions.SwedbankServerException;
import com.github.soshibby.swedbank.util.Base64;
import com.github.soshibby.swedbank.util.HttpUtil;
import com.github.soshibby.swedbank.util.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by Henrik on 30/01/2017.
 * Http client for making request to Swedbanks API.
 */
public class SwedbankHttpClient {

    private static final Logger log = LoggerFactory.getLogger(SwedbankHttpClient.class);
    private ObjectMapper mapper = new ObjectMapper();
    private static final String BASE_URI = "https://auth.api.swedbank.se/TDE_DAP_Portal_REST_WEB/api/";
    private static final String API_VERSION = "v4";
    private String authorization;
    private Map<String, String> cookies = new HashMap<>();
    private String userAgent;

    public SwedbankHttpClient(String authorizationKey, String userAgent) {
        this.authorization = Base64.encode(authorizationKey);
        this.userAgent = userAgent;
    }

    public <T> T postRequest(String path, Map<String, Object> data, Class<T> clazz) throws SwedbankServerException {
        JsonNode json = mapper.convertValue(data, JsonNode.class);
        String strData;

        try {
            strData = mapper.writeValueAsString(json);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Failed to convert json node to string.", e);
        }

        return postRequest(path, strData, clazz);
    }

    public <T> T postRequest(String path, String data, Class<T> clazz) throws SwedbankServerException {
        String response = createRequest("POST", path, null, createHeaders(), data);
        return parseResponse(response, clazz);
    }

    public <T> T postRequest(String path, Class<T> clazz) throws SwedbankServerException {
        String response = createRequest("POST", path, null, createHeaders(), null);
        return parseResponse(response, clazz);
    }

    public <T> T getRequest(String path, Class<T> clazz) throws SwedbankServerException {
        return getRequest(path, null, clazz);
    }

    public <T> T getRequest(String path, Map<String, Object> query, Class<T> clazz) throws SwedbankServerException {
        String response = createRequest("GET", path, query, createHeaders(), null);
        return parseResponse(response, clazz);
    }

    private String createRequest(String method, String path, Map<String, Object> query, Map<String, Object> headers, String data) throws SwedbankServerException {
        HttpURLConnection connection = null;

        try {
            if (query == null) {
                query = new HashMap<>();
            }

            String dsid = generateDsid();
            query.put("dsid", dsid);

            //Create connection
            URL url;

            try {
                url = new URL(BASE_URI + API_VERSION + "/" + path + "?" + HttpUtil.createQueryString(query));
            } catch (MalformedURLException e) {
                throw new RuntimeException("Malformed url.", e);
            }

            log.info("Making request to: {}", url);
            connection = openConnection(url);
            connection.setUseCaches(false);
            connection.setRequestProperty("Cookie", createRequestCookies(dsid));
            setRequestMethod(connection, method);

            if (headers != null) {
                HttpUtil.setHeaders(connection, headers);
            }

            log.debug("Using the following headers: ");
            printHeaders(connection);

            //Send request
            if (data != null) {
                sendData(connection, data);
            }

            //Get Response
            int responseCode = getResponseCode(connection);
            String body = getResponseBody(connection, responseCode);

            log.info("Received status code {} for url {}. With response body: {}.", responseCode, url.toString(), body);

            if (responseCode < 400) {
                Map<String, String> responseCookies = HttpUtil.getCookies(connection);
                setCookies(responseCookies);
                return body;
            } else {
                throw new SwedbankServerException("Received status code " + responseCode + "for url " + url.toString() + ". With response body: " + body + ".");
            }
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
    }

    private void sendData(HttpURLConnection connection, String data) throws SwedbankServerException {
        connection.setRequestProperty("Content-Length", Integer.toString(data.getBytes().length));
        connection.setDoOutput(true);

        try {
            DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
            wr.writeBytes(data);
            wr.close();
        } catch (IOException e) {
            throw new SwedbankServerException("Failed to send data to server.", e);
        }
    }

    private void printHeaders(HttpURLConnection connection) {
        connection.getRequestProperties().forEach((name, value) -> log.debug("Header: {} - {}.", name, value));
    }

    private HttpURLConnection openConnection(URL url) throws SwedbankServerException {
        try {
            return (HttpURLConnection) url.openConnection();
        } catch (IOException e) {
            throw new SwedbankServerException("Failed to open connection to '" + url.toString() + "'.");
        }
    }

    private void setRequestMethod(HttpURLConnection connection, String method) {
        try {
            connection.setRequestMethod(method);
        } catch (ProtocolException e) {
            throw new RuntimeException("Invalid request method '" + method + "'.");
        }
    }

    private int getResponseCode(HttpURLConnection connection) throws SwedbankServerException {
        try {
            return connection.getResponseCode();
        } catch (IOException e) {
            throw new SwedbankServerException("Failed to get http response code.", e);
        }
    }

    private String getResponseBody(HttpURLConnection connection, int responseCode) throws SwedbankServerException {
        InputStream is = null;
        SwedbankServerException th = null;

        try {
            if (responseCode < 400) {
                is = connection.getInputStream();
            } else {
                is = connection.getErrorStream();
            }

            return StringUtil.toString(is);
        } catch (IOException e) {
            th = new SwedbankServerException("Failed to read response body.", e);
        } finally {
            try {
                if (is != null) {
                    is.close();
                }
            } catch (IOException e) {
                if (th != null) {
                    th.addSuppressed(e);
                    throw th;
                }
            }
        }

        throw th;
    }

    private <T> T parseResponse(String response, Class<T> clazz) {
        try {
            return mapper.readValue(response, clazz);
        } catch (IOException e) {
            throw new RuntimeException("Failed to map response to class.", e);
        }
    }

    private Map<String, Object> createHeaders() {
        Map<String, Object> headers = new HashMap<>();
        headers.put("User-Agent", userAgent);
        headers.put("Authorization", authorization);
        headers.put("Accept", "*/*");
        headers.put("Accept-Language", "sv-se");
        headers.put("Content-Type", "application/json; charset=UTF-8");
        headers.put("Connection", "keep-alive");
        headers.put("Proxy-Connection", "keep-alive");
        return headers;
    }

    private String generateDsid() {
        String uuid = UUID.randomUUID().toString();
        return uuid.substring(0, 8);
    }

    private String createRequestCookies(String dsid) {
        cookies.put("dsid", dsid);

        StringBuilder cookieString = new StringBuilder();
        cookies.forEach((key, value) -> {
            cookieString.append(key);
            cookieString.append("=");
            cookieString.append(value);
            cookieString.append(";");
        });

        return cookieString.toString();
    }

    private void setCookies(Map<String, String> cookies) {
        this.cookies.putAll(cookies);
    }

}
