package com.slamgantdroid.wonderfuljogja.model.api;

import com.google.gson.GsonBuilder;
import com.slamgantdroid.wonderfuljogja.model.utilities.Constants;

import retrofit.RestAdapter;
import retrofit.converter.GsonConverter;

/**
 * Created by WIN10 on 09/09/2017.
 */

public class RestApiManager {

    private WisataApi wisataApi;

    public WisataApi getWisataApi() {
        if (wisataApi == null) {
            GsonBuilder gsonBuilder = new GsonBuilder();
            gsonBuilder.registerTypeAdapter(String.class, new StringDeserializer());

            wisataApi = new RestAdapter.Builder()
                    .setEndpoint(Constants.BASE_URL)
                    .setConverter(new GsonConverter(gsonBuilder.create()))
                    .build()
                    .create(WisataApi.class);

        }

        return wisataApi;
    }

}
