package com.github.soshibby.swedbank.converters;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

/**
 * Created by Henrik on 31/01/2017.
 */
public class AmountConverter extends JsonDeserializer<Double> {

    @Override
    public Double deserialize(JsonParser jsonParser, DeserializationContext ctxt) throws IOException {
        NumberFormat format = NumberFormat.getInstance(Locale.FRANCE);
        String balance = jsonParser.readValueAs(String.class);

        if (balance == null) {
            return null;
        }

        balance = balance.replace(" ", "");

        try {
            return format.parse(balance).doubleValue();
        } catch (ParseException e) {
            throw new IOException("Failed to convert account balance (" + balance + ") string to double.", e);
        }
    }

}
