package com.slamgantdroid.wonderfuljogja.controller;

import android.util.Log;

import com.slamgantdroid.wonderfuljogja.model.api.RestApiManager;
import com.slamgantdroid.wonderfuljogja.model.pojo.Wisata;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by WIN10 on 09/09/2017.
 */

public class Controller {

    private static final String TAG = Controller.class.getSimpleName();
    private WisataCallbackListener mlistener;
    private RestApiManager mApiManager;

    public Controller(WisataCallbackListener listener) {
        mlistener = listener;
        mApiManager = new RestApiManager();
    }

    public void startFetching() {
        mApiManager.getWisataApi().getWisata(new Callback<String>() {
            @Override
            public void success(String s, Response response) {
                Log.d(TAG, "JSON :: " + s);

                try {
                    JSONObject object = new JSONObject(s);
                    JSONArray array = new JSONArray(object);

                    for (int i = 0; i < array.length(); i++) {
                        JSONObject jsonObject = array.getJSONObject(i);

                        Wisata wisata = new Wisata.Builder()
                                .setNama_wisata(jsonObject.getString("nama_pariwisata"))
                                .setAlamat_wisata(jsonObject.getString("alamat_pariwisata"))
                                .setUrl_wisata(jsonObject.getString("gambar_pariwisata"))
                                .setDetail_wisata(jsonObject.getString("detail_pariwisata"))
                                .build();

                        mlistener.onFetchProgress(wisata);
                    }
                } catch (JSONException e) {
                    mlistener.onFetchFailed();
                }

                mlistener.onFetchComplete();
            }

            @Override
            public void failure(RetrofitError error) {
                Log.d(TAG, "JSON :: " + error.getMessage());
                mlistener.onFetchComplete();
            }
        });
    }

    public interface WisataCallbackListener {

        void onFetchStart();

        void onFetchProgress(Wisata wisata);

        void onFetchProgress(List<Wisata> wisataList);

        void onFetchComplete();

        void onFetchFailed();
    }

}
