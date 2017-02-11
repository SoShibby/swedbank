package com.github.soshibby.swedbank.util;

import java.net.HttpURLConnection;
import java.util.*;

/**
 * Created by Henrik on 31/01/2017.
 */
public class HttpUtil {

    public static String createQueryString(Map<String, Object> query) {
        StringJoiner stringJoiner = new StringJoiner("&");

        query.forEach((name, value) -> stringJoiner.add(name + "=" + value));

        return stringJoiner.toString();
    }

    public static void setHeaders(HttpURLConnection connection, Map<String, Object> headers) {
        headers.forEach((name, value) -> connection.setRequestProperty(name, value.toString()));
    }

    public static Map<String, String> getCookies(HttpURLConnection connection) {
        Map<String, List<String>> headerFields = connection.getHeaderFields();

        Set<String> headerFieldsSet = headerFields.keySet();
        Iterator<String> hearerFieldsIter = headerFieldsSet.iterator();

        Map<String, String> cookies = new HashMap<>();

        while (hearerFieldsIter.hasNext()) {

            String headerFieldKey = hearerFieldsIter.next();

            if ("Set-Cookie".equalsIgnoreCase(headerFieldKey)) {

                List<String> headerFieldValue = headerFields.get(headerFieldKey);

                for (String headerValue : headerFieldValue) {
                    String[] fields = headerValue.split(";");
                    String cookieValue = fields[0];

                    if (cookieValue.contains("=")) {
                        int delimiter = cookieValue.indexOf("=");
                        String key = cookieValue.substring(0, delimiter);
                        String value = cookieValue.substring(delimiter + 1);
                        cookies.put(key, value);
                    }
                }
            }
        }

        return cookies;
    }

}
