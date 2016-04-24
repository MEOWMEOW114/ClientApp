package com.easydeliver.clientapp.rest.service;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.squareup.okhttp.OkHttpClient;

import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.client.OkClient;
import retrofit.converter.GsonConverter;

/**
 * Created by tomlee on 1/3/16.
 */
public class ApiClientV4 {

    final static private String dddd="  ";

    private final FeedmeApiV4 restClient;
//    private final FeedmeRestaurantApiV4 restRestaurantClient;
//    private final FeedmeCommentApiV4 restCommentClient;
//    private final FeedmeUserApiV4 restUserClient;

    private static String ROOT =
//            "http://development.feedmeguru.com";
            "https://api.getkawa.com:8001/api/demo";
    //http://app.feedmeguru.com

    //

    private PendingAction pendingAction = PendingAction.NONE;

    public enum PendingAction {
        NONE,
        RESTAURANT,
        POST_STATUS_UPDATE
    }

    public ApiClientV4(Context context, final String authToken) {

//        if (pendingAction != null){
//            this.pendingAction = pendingAction;
//        }

//"2015-07-16 09:11:39",
        //
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy'-'MM'-'dd'T'HH':'mm':'ss'.'SSS'Z'")
//                .setDateFormat("yy-MM-dd hh:mm:ss")
                .create();

//        MyCookieManager myCookieManager = new MyCookieManager(context);
//        CookieHandler.setDefault(myCookieManager);
        OkHttpClient okHttpClient = new OkHttpClient();
//        okHttpClient.interceptors().add(new AddCookiesInterceptor(context));
//        okHttpClient.interceptors().add(new ReceivedCookiesInterceptor(context));

        RestAdapter.Builder builder = new RestAdapter.Builder()
                .setEndpoint(ROOT)



                .setRequestInterceptor(new RequestInterceptor() {
                    @Override
                    public void intercept(RequestFacade request) {
//                        request.addHeader("Content-Type", "application/json");
//                        request.addHeader("Accept", "application/vnd.bindo-v201501+json");
//                        request.addHeader("platform", "android");
//                        request.addHeader("appver", dddd + "");
                        if (authToken != null) {
//                            request.addHeader("Cookie", authToken);
                            request.addHeader("Authorization", "Feedme " + authToken);
//                            request.addHeader("X-USER-ACCESS-TOKEN", authToken);
                        }
                    }


                })
                .setConverter(new GsonConverter(gson))
                .setClient(new OkClient(okHttpClient))
                .setLogLevel(RestAdapter.LogLevel.FULL);

        RestAdapter restAdapter = builder.build();
        restClient = restAdapter.create(FeedmeApiV4.class);
//        restRestaurantClient = restAdapter.create(FeedmeRestaurantApiV4.class);
//        restCommentClient = restAdapter.create(FeedmeCommentApiV4.class);
//        restUserClient = restAdapter.create(FeedmeUserApiV4.class);
    }

    public FeedmeApiV4 getApiService() {
        return restClient;
    }
//    public FeedmeRestaurantApiV4 getRestaurantApiService() {
//        return restRestaurantClient;
//    }
//    public FeedmeCommentApiV4 getCommentApiService(){
//        return restCommentClient;
//    }
//
//    public FeedmeUserApiV4 getRestUserClient() {
//        return restUserClient;
//    }
}
