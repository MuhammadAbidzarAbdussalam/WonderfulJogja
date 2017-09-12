package com.slamgantdroid.wonderfuljogja.model.pojo;

/**
 * Created by WIN10 on 09/09/2017.
 */

public class Wisata {

    public String nama_wisata;
    public String url_wisata;
    public String alamat_wisata;
    public String detail_wisata;

    public Wisata(Builder builder) {
        nama_wisata = builder.nama_wisata;
        url_wisata = builder.url_wisata;
        alamat_wisata = builder.alamat_wisata;
        detail_wisata = builder.detail_wisata;
    }

    public static class Builder {

        private String nama_wisata;
        private String url_wisata;
        private String alamat_wisata;
        private String detail_wisata;

        public Builder setNama_wisata(String nama) {
            nama_wisata = nama;
            return Builder.this;
        }

        public Builder setUrl_wisata(String url) {
            url_wisata = url;
            return Builder.this;
        }

        public Builder setAlamat_wisata(String alamat) {
            alamat_wisata = alamat;
            return Builder.this;
        }

        public Builder setDetail_wisata(String detail) {
            detail_wisata = detail;
            return Builder.this;
        }

        public Wisata build() {
            return new Wisata(Builder.this);
        }
    }
}
