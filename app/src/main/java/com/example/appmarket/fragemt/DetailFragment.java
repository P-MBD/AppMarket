package com.example.appmarket.fragemt;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.appmarket.R;
import com.example.appmarket.model.Application;
import com.squareup.picasso.Picasso;

public class DetailFragment extends Fragment {

    private ImageView imgAppIcon;
    private TextView txtAppName, txtFullDescription;
    private Application application;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail, container, false);

        // دریافت داده‌های ارسال شده از Fragment قبلی
        if (getArguments() != null) {
            application = getArguments().getParcelable("application");

            if (application != null) {
                // تنظیم داده‌ها روی ویوها
                ImageView imgAppIcon = view.findViewById(R.id.img_app_icon);
                TextView txtAppName = view.findViewById(R.id.txt_app_name);
                TextView txtFullDescription = view.findViewById(R.id.txt_full_description);

                txtAppName.setText(application.getTitle());
                txtFullDescription.setText(application.getFullDescription());
                // بارگذاری تصویر با Picasso
                Picasso.get().load(application.getIcon()).into(imgAppIcon);
            }
        }

        return view;
    }
}
