package com.example.appmarket.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.squareup.picasso.Picasso;

import com.example.appmarket.R;
import com.example.appmarket.Webservice.ApiClient;
import com.example.appmarket.model.Application;

import java.util.ArrayList;
import java.util.List;

public class ApplicationAdapter extends RecyclerView.Adapter<ApplicationAdapter.ViewHolder> {

    Context context;
    List<Application> applicationList;

    public ApplicationAdapter(Context context, List<Application> applications) {
        this.context = context;
        this.applicationList = applications;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.apps_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Application application = applicationList.get(position);
        holder.txt_title.setText(application.getTitle());

        String path = ApiClient.BASE_URL + "images/";
        Picasso.get().load(path + application.getIcon()).into(holder.Img_app);
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

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView Img_app;
        TextView txt_title;

        public ViewHolder(View itemView) {
            super(itemView);
            Img_app = itemView.findViewById(R.id.img_app);
            txt_title = itemView.findViewById(R.id.txt_title);
        }
    }
}
