package com.example.appmarket.Webservice;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    public static String BASE_URL="http://172.20.2.26:8000/api/";
    public  static Retrofit retrofit=null;

    public  static Retrofit getClient()
    {
        if(retrofit==null)
        {
    retrofit= new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();

        }
        return  retrofit;
    }
}
