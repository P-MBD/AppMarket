package com.example.appmarket.adapter;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appmarket.fragemt.DetailFragment;
import com.squareup.picasso.Picasso;

import com.example.appmarket.R;
import com.example.appmarket.Webservice.ApiClient;
import com.example.appmarket.model.Application;

import java.util.List;

public class ApplicationAdapter extends RecyclerView.Adapter<ApplicationAdapter.ApplicationViewHolder> {

    private final Context context;
    private final List<Application> applicationList;

    public ApplicationAdapter(Context context, List<Application> applications) {
        this.context = context;
        this.applicationList = applications;
    }

    @NonNull
    @Override
    public ApplicationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.apps_row, parent, false);
        return new ApplicationViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ApplicationViewHolder holder, int position) {
        Application application = applicationList.get(position);
        holder.txt_title.setText(application.getTitle());

        String path = ApiClient.BASE_URL + "images/";
        Picasso.get()
                .load(path + application.getIcon())
                .error(R.drawable.baseline_error_24) // آیکون خطا در صورت عدم بارگذاری تصویر
                .into(holder.Img_app);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // باز کردن DetailFragment
                Fragment detailFragment = new DetailFragment();
                Bundle bundle = new Bundle();
                bundle.putParcelable("application", application); // استفاده از putParcelable
                detailFragment.setArguments(bundle);

                // نمایش Fragment جدید
                FragmentManager fragmentManager = ((FragmentActivity) context).getSupportFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.container, detailFragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

    }

    @Override
    public int getItemCount() {
        return applicationList.size();
    }

    public void updateData(List<Application> newApplications) {
        applicationList.clear();
        applicationList.addAll(newApplications);
        notifyDataSetChanged();
    }

    public static class ApplicationViewHolder extends RecyclerView.ViewHolder {

        ImageView Img_app;
        TextView txt_title;

        public ApplicationViewHolder(View itemView) {
            super(itemView);
            Img_app = itemView.findViewById(R.id.img_app);
            txt_title = itemView.findViewById(R.id.txt_title);
        }
    }
}
