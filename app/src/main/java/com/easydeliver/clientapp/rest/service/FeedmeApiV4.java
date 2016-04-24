package com.easydeliver.clientapp.rest.service;


import com.easydeliver.clientapp.model.DeliverOrder;
import com.easydeliver.clientapp.rest.model.DeliverListRes;

import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.PUT;
import retrofit.http.Path;

/**
 * Created by tomlee on 1/3/16.
 */
public interface FeedmeApiV4 {


    @PUT("/delivery/{id}/")
    public void updateOrder(
            @Path("id") Integer id,
            @Body DeliverOrder order,
            Callback<DeliverOrder> result
    );


    @POST("/delivery/")
    public void createOrder(
            @Body DeliverOrder order,
            Callback<DeliverOrder> result
    );
    @GET("/delivery/")
    public void getOrder(
            Callback<DeliverListRes> orderList
    );
//    @POST("/users/login_facebook/access_by_facebook")
//    public void facebookAuth(
//            @Body FacebookAuthWrapper loginWrapper,
//            Callback<UserResponse> responseCallback);
//
//    @POST("/users/login_general/signup")
//    public void emailSignUp(
//            @Body SignUpEmailRequestWrapper requestWrapper,
//            Callback<UserResponse> responseCallback);
//
//    @POST("/users/login_general/login")
//    public void emailSignIn(
//            @Body SignInEmailRequestWrapper requestWrapper,
//            Callback<UserResponse> responseCallback);
}
