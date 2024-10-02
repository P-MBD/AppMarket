package com.example.appmarket.Webservice;

import android.util.Log;

import java.io.IOException;
import java.util.List;

import com.example.appmarket.model.Application;
import com.example.appmarket.model.IMessageListener;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RetrofitWebserviceCaller {

    private static final String TAG = "RetrofitWebserviceCaller";
    ICafeAndroidHandler apiInterface;

    public RetrofitWebserviceCaller() {
        apiInterface = ApiClient.getClient().create(ICafeAndroidHandler.class);
    }

    public void getBestApps(final IMessageListener iMessageListener) {
        Call<List<Application>> getBestApps = apiInterface.getBestApps();

        Log.d(TAG, "Sending request to get best apps...");

        getBestApps.enqueue(new Callback<List<Application>>() {
            @Override
            public void onResponse(Call<List<Application>> call, Response<List<Application>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    Log.d(TAG, "Response received: " + response.body().toString());
                    iMessageListener.onSuccess(response.body());
                } else {
                    try {
                        String error = response.errorBody().string();
                        Log.e(TAG, "Response error: " + error);
                        iMessageListener.onFailure(error);
                    } catch (IOException e) {
                        Log.e(TAG, "Error reading error body", e);
                        iMessageListener.onFailure("Failed to retrieve data");
                    }
                }
            }

            @Override
            public void onFailure(Call<List<Application>> call, Throwable t) {
                Log.e(TAG, "Error: " + t.getMessage());
                iMessageListener.onFailure(t.getMessage());
            }
        });
    }
}
