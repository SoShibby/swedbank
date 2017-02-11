package com.github.soshibby.swedbank.converters;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

import java.io.IOException;

/**
 * Created by Henrik on 31/01/2017.
 */
public class SwedishDateConverter extends JsonDeserializer {

    private static final String TIME_ZONE = "Europe/Stockholm";

    @Override
    public DateTime deserialize(JsonParser jsonParser, DeserializationContext ctxt) throws IOException {
        String date = jsonParser.readValueAs(String.class);
        return DateTime.parse(date).withZone(DateTimeZone.forID(TIME_ZONE));
    }
}
