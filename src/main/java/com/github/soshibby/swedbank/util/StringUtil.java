package com.github.soshibby.swedbank.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by Henrik on 31/01/2017.
 */
public class StringUtil {

    public static String toString(InputStream stream) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(stream));
        StringBuilder response = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            response.append(line);
            response.append(System.lineSeparator());
        }

        return response.toString();
    }

}
