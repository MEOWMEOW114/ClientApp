package com.easydeliver.clientapp.ui.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.easydeliver.clientapp.R;
import com.easydeliver.clientapp.model.DeliverOrder;
import com.easydeliver.clientapp.rest.service.ApiClientV4;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * A simple {@link BaseFragment} subclass.
 */
public class OrderDetailFragment extends BaseFragment {

    private DeliverOrder order;

    @Bind(R.id.order_from)
    TextView orderFrom;
    @Bind(R.id.order_to)
    TextView order_to;

    @Bind(R.id.object_desc)
    TextView object_desc;
    @Bind(R.id.extra_data)
    TextView extra_data;
    @Bind(R.id.target_desc)
    TextView target_desc;
    @Bind(R.id.price)
    TextView price;
    @Bind(R.id.status)
    TextView status;
//    @Bind(R.id.order_from)
//    TextView orderFrom;

    @Bind(R.id.btn_picku_photo)
    Button btn_picku_photo;

    @Bind(R.id.btn_assign_me)
    Button btn_assign_me;
    @Bind(R.id.btn_pickup)
    Button btn_pickup;
    @Bind(R.id.btn_complete)
    Button btn_complete;

    public static OrderDetailFragment newInstance(DeliverOrder restType) {
        OrderDetailFragment fragment = new OrderDetailFragment();
        Bundle args = new Bundle();
        args.putSerializable("order", restType);
        fragment.setArguments(args);
        return fragment;
    }

    public OrderDetailFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            order = (DeliverOrder) getArguments().getSerializable("order");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_order_detail, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);
        updateView();



    }

    @OnClick(R.id.btn_assign_me)
    public void assignMe(){
        DeliverOrder dd = new DeliverOrder();
        dd.active_status = "ASSIGNED";
        dd.assigned_to = "me";

        final ApiClientV4 coffeeService = new ApiClientV4(getActivity(),
                null);

        coffeeService.getApiService().updateOrder(order.id, dd,
                new Callback<DeliverOrder>() {
                    @Override
                    public void success(DeliverOrder deliverOrder, Response response) {
                        if ( getActivity() != null){
                            order = deliverOrder;
                            updateView();
                        }
                    }

                    @Override
                    public void failure(RetrofitError error) {

                    }
                });


    }

    @OnClick(R.id.btn_pickup)
    public void pickup(){
        DeliverOrder dd = new DeliverOrder();
        dd.active_status = "PICKED";
        dd.assigned_to = "me";

        final ApiClientV4 coffeeService = new ApiClientV4(getActivity(),
                null);

        coffeeService.getApiService().updateOrder(order.id, dd,
                new Callback<DeliverOrder>() {
                    @Override
                    public void success(DeliverOrder deliverOrder, Response response) {
                        if ( getActivity() != null){
                            order = deliverOrder;
                            updateView();
                        }
                    }

                    @Override
                    public void failure(RetrofitError error) {

                    }
                });


    }

    @OnClick(R.id.btn_complete)
    public void complete(){
        DeliverOrder dd = new DeliverOrder();
        dd.active_status = "DELIVERED";
        dd.assigned_to = "me";

        final ApiClientV4 coffeeService = new ApiClientV4(getActivity(),
                null);

        coffeeService.getApiService().updateOrder(order.id, dd,
                new Callback<DeliverOrder>() {
                    @Override
                    public void success(DeliverOrder deliverOrder, Response response) {
                        if ( getActivity() != null){
                            order = deliverOrder;
                            updateView();
                        }
                    }

                    @Override
                    public void failure(RetrofitError error) {

                    }
                });


    }

    private void updateView(){

        orderFrom.setText(order.order_from+"");

        order_to.setText(order.order_to+"");
        price.setText(order.price+"");
        target_desc.setText(order.target_desc+"");
        extra_data.setText(order.extra_data+"");
        object_desc.setText(order.object_desc+"");
        status.setText(order.active_status+"");

         btn_picku_photo.setVisibility(View.GONE);

         btn_assign_me.setVisibility(View.GONE);
         btn_pickup.setVisibility(View.GONE);
         btn_complete.setVisibility(View.GONE);

        if ( order.active_status.equals("CREATED")){
            btn_assign_me.setVisibility(View.VISIBLE);
        }

        if ( order.active_status.equals("ASSIGNED")){
            btn_pickup.setVisibility(View.VISIBLE);
            btn_picku_photo.setVisibility(View.VISIBLE);
        }

        if ( order.active_status.equals("PICKED")){
            btn_complete.setVisibility(View.VISIBLE);
        }

    }


}
