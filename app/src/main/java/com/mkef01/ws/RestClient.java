package com.mkef01.ws;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

public class RestClient {
    private static final String BASE_URL = "http://mkef01.azurewebsites.net/api/cruzolosdedos/";
    private static AsyncHttpClient client = new AsyncHttpClient();

    public static void post(String url, RequestParams params, AsyncHttpResponseHandler responseHandler){
        client.post(getAbsoluteUrl(url), params, responseHandler);
    }

    private static String getAbsoluteUrl(String relativeUrl) {
        return BASE_URL + relativeUrl;
    }
}
