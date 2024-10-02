package com.example.appmarket.model;

import java.util.List;

public interface IMessageListener {


    public void onSuccess(List<Application> applicationList);

    public void onFailure(String errorResponse);
}
