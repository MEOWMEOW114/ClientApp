package com.easydeliver.clientapp.model;

import java.io.Serializable;

/**
 * Created by tomlee on 24/4/16.
 */
public class DeliverOrder implements Serializable{

    public int id;
    public String name;
    public String order_from_time;
    public String order_from;

    public String order_to;

    public String order_to_time;

    public String object_desc;

    public String extra_data;

    public String target_desc;

    public String price;

    public String active_status;

    public String assigned_to;

    /*
     "id": 3,
        "name": "testing 3",
        "order_from": "元朗尚悅 18",
        "order_from_time": "2016-04-23T23:45:09Z",
        "order_to": "中環 ifc",
        "order_to_time": "2016-04-23T23:45:13Z",
        "object_desc": "貨 一箱",
        "extra_data": "準時  靚女司機",
        "target_desc": "西環泳棚. 有限公司",
        "price": "$30000",
        "active_status": "CREATED"
     */
}
