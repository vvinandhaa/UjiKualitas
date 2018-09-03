package com.example.asus.ujikualitas;

import java.sql.Date;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by ASUS on 14/08/2018.
 */

public interface RegisterAPI {

    @FormUrlEncoded
    @POST("insertUjiAir.php")
    Call<Value> daftar(@Field("no_trs") String no_trs,
                       @Field("tgl_trs") String tgl_trs,
                       @Field("obyek") int obyek,
                       @Field("rekanan") int rekanan,
                       @Field("ket") String ket,
                       @Field("cr_at") String cr_at,
                       @Field("cr_by") String cr_by,
                       @Field("versi") int versi,
                       @Field("lokasi") String lokasi);

    @GET("readAll.php")
    Call<Value> view();

    @FormUrlEncoded
    @POST("updateUjiAir.php")
    Call<Value> ubah(@Field("id") String id,
            @Field("no_trs") String no_trs,
                     @Field("tgl_trs") String tgl_trs,
                     @Field("obyek") int obyek,
                     @Field("rekanan") int rekanan,
                     @Field("ket") String ket,
                     @Field("cr_at") String cr_at,
                     @Field("cr_by") String cr_by,
                     @Field("versi") int versi,
                     @Field("lokasi") String lokasi);
}