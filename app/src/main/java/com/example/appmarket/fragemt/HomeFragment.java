package com.example.appmarket.fragemt;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appmarket.R;
import com.example.appmarket.Webservice.RetrofitWebserviceCaller;
import com.example.appmarket.adapter.ApplicationAdapter;
import com.example.appmarket.model.Application;
import com.example.appmarket.model.IMessageListener;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private static final String TAG = "HomeFragment";
    RetrofitWebserviceCaller retrofitWebserviceCaller;
    RecyclerView recycler_best_apps;
    ApplicationAdapter applicationAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        retrofitWebserviceCaller = new RetrofitWebserviceCaller();
        recycler_best_apps = view.findViewById(R.id.recycler_best_apps);

        // تنظیم LayoutManager و آداپتر
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        recycler_best_apps.setLayoutManager(layoutManager);
        applicationAdapter = new ApplicationAdapter(getActivity(), new ArrayList<>());
        recycler_best_apps.setAdapter(applicationAdapter);

        getBestApps();

        return view;
    }

    public void getBestApps() {
        try {
            retrofitWebserviceCaller.getBestApps(new IMessageListener() {
                @Override
                public void onSuccess(List<Application> response) {
                    Log.d(TAG, "Applications retrieved: " + response.toString());
                    applicationAdapter.updateData(response);
                }

                @Override
                public void onFailure(String errorResponse) {
                    Log.e(TAG, "Failed to retrieve applications: " + errorResponse);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
