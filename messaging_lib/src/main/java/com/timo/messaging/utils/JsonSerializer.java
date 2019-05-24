package com.timo.messaging.utils;

import com.google.gson.*;

import java.lang.reflect.Type;
import java.util.Date;

public class JsonSerializer {

    private final Gson gson;

    public JsonSerializer() {
        final GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(Date.class, new DateDeserializer());

        gson = gsonBuilder.create();
    }

    public <T> T parse(final String json, final Class<T> type) {
        return gson.fromJson(json, type);
    }

    public String toJson(final Object object) {
        return gson.toJson(object);
    }
}

class DateDeserializer implements com.google.gson.JsonDeserializer {

    public Date deserialize(final JsonElement json, final Type typeOfT, final JsonDeserializationContext context) throws JsonParseException {
        return json == null ? null : new Date(json.getAsLong());
    }
}
