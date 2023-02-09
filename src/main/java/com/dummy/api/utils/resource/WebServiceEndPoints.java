package com.dummy.api.utils.resource;

import com.dummy.api.utils.constants.Endpoints;

public enum WebServiceEndPoints {

    URL(Endpoints.URL_EMPLOYEES);

    private final String url;

    WebServiceEndPoints(String url){
        this.url = url;
    }

    public String getUrl(){
        return url;
    }
}
