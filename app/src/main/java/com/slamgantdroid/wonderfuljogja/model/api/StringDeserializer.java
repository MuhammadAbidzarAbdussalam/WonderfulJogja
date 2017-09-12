package com.slamgantdroid.wonderfuljogja.model.api;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

/**
 * Created by WIN10 on 10/09/2017.
 */

public class StringDeserializer implements JsonDeserializer{
    @Override
    public Object deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        return json.toString();
    }
}
