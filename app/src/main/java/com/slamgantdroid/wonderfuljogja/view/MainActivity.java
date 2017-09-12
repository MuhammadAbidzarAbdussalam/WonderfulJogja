package com.slamgantdroid.wonderfuljogja.view;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.slamgantdroid.wonderfuljogja.R;
import com.slamgantdroid.wonderfuljogja.controller.Controller;
import com.slamgantdroid.wonderfuljogja.model.adapter.AdapterWisata;
import com.slamgantdroid.wonderfuljogja.model.pojo.Wisata;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements Controller.WisataCallbackListener {


    @BindView(R.id.recycler_wisata)
    RecyclerView recyclerWisata;
    @BindView(R.id.swipeListWisata)
    SwipeRefreshLayout swipeListWisata;
    @BindView(R.id.toolbar_title)
    TextView toolbarTitle;

    private List<Wisata> mWisataList = new ArrayList<>();
    private AdapterWisata adaperWisata;
    private Controller controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        toolbarTitle = (TextView)findViewById(R.id.toolbar_title);

        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/jogjakartype.ttf");
        toolbarTitle.setTypeface(typeface);

        recyclerWisata = (RecyclerView) findViewById(R.id.recycler_wisata);
        swipeListWisata = (SwipeRefreshLayout) findViewById(R.id.swipeListWisata);
        controller = new Controller(MainActivity.this);

        configViews();

        controller.startFetching();


    }

    private void configViews() {

        recyclerWisata.setHasFixedSize(true);
        recyclerWisata.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        recyclerWisata.setRecycledViewPool(new RecyclerView.RecycledViewPool());

        adaperWisata = new AdapterWisata(mWisataList);
        recyclerWisata.setAdapter(adaperWisata);

        swipeListWisata.setColorSchemeResources(R.color.colorAccent,
                R.color.colorPrimary,
                R.color.colorPrimaryDark);

        swipeListWisata.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                controller.startFetching();
            }
        });

        //addWisata();
    }

    private void addWisata() {
        for (int i = 0; i < 100; i++) {

            Wisata wisata = new Wisata.Builder()
                    .setNama_wisata("Bekasi")
                    .setAlamat_wisata("Jl Gandaria 4")
                    .setUrl_wisata("http://")
                    .build();

            adaperWisata.addWisata(wisata);

        }
    }

    @Override
    public void onFetchStart() {

    }

    @Override
    public void onFetchProgress(Wisata wisata) {
        adaperWisata.addWisata(wisata);

    }

    @Override
    public void onFetchProgress(List<Wisata> wisataList) {

    }

    @Override
    public void onFetchComplete() {
        swipeListWisata.setRefreshing(false);
    }

    @Override
    public void onFetchFailed() {

    }
}
