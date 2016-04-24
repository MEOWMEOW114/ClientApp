package com.easydeliver.clientapp.rest.model;

import com.easydeliver.clientapp.model.DeliverOrder;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by tomlee on 24/4/16.
 */
public class DeliverListRes {

    @SerializedName("results")
    public List<DeliverOrder> orderList;
}
