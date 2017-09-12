package com.slamgantdroid.wonderfuljogja.model.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.slamgantdroid.wonderfuljogja.R;
import com.slamgantdroid.wonderfuljogja.model.pojo.Wisata;
import com.slamgantdroid.wonderfuljogja.model.utilities.Constants;

import java.util.List;

/**
 * Created by WIN10 on 09/09/2017.
 */

public class AdapterWisata extends RecyclerView.Adapter<AdapterWisata.ViewHolder> {

    public static String TAG = AdapterWisata.class.getSimpleName();

    private List<Wisata> mWisata;

    public AdapterWisata(List<Wisata> mWisataList) {
        mWisata = mWisataList;
    }

    public void addWisata(Wisata wisata) {
        mWisata.add(wisata);
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Wisata curretWisata = mWisata.get(position);

        holder.tvNamaWisata.setText(curretWisata.nama_wisata);
        holder.tvAlamatWisata.setText(curretWisata.alamat_wisata);

        Glide.with(holder.itemView.getContext())
                .load(Constants.IMAGE_URL + curretWisata.url_wisata)
                .placeholder(R.id.gambar_wisata)
                .into(holder.imageWisata);

    }

    @Override
    public int getItemCount() {
        return mWisata.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView tvNamaWisata;
        public TextView tvAlamatWisata;
        public ImageView imageWisata;

        public ViewHolder(View itemView) {
            super(itemView);

        tvNamaWisata = (TextView)itemView.findViewById(R.id.tvNamaWisata);
        tvAlamatWisata = (TextView)itemView.findViewById(R.id.tvAlamatWisata);
        imageWisata = (ImageView) itemView.findViewById(R.id.gambar_wisata);

        }

    }
}
