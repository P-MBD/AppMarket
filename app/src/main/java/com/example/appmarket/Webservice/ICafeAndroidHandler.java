package com.example.appmarket.Webservice;

import java.util.List;

import com.example.appmarket.model.Category;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ICafeAndroidHandler {

    @GET("applications/")
    public Call<List<com.example.appmarket.model.Application>> getBestApps();

    @GET("announcements/")
    public Call<List<com.example.appmarket.model.Application>> getAnnouncements();

    @FormUrlEncoded
    @POST("categories/")
    public Call<List<Category>> getCategories(@Field("from") int from, @Field("to") int to);
}
