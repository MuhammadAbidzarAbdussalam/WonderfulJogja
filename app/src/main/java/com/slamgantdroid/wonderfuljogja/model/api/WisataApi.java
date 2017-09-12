package com.slamgantdroid.wonderfuljogja.model.api;

import retrofit.Callback;
import retrofit.http.GET;

/**
 * Created by WIN10 on 10/09/2017.
 */

public interface WisataApi {

    @GET("/jsonBootcamp.php")

    void getWisata(Callback<String> wisata);

}
