package com.easydeliver.clientapp.ui.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.afollestad.materialdialogs.MaterialDialog;
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
public class OrderCreateFragment extends BaseFragment {
    @Bind(R.id.order_from)
    EditText orderFrom;
    @Bind(R.id.order_to)
    EditText order_to;

    @Bind(R.id.object_desc)
    EditText object_desc;
    @Bind(R.id.extra_data)
    EditText extra_data;
    @Bind(R.id.target_desc)
    EditText target_desc;
    @Bind(R.id.price)
    EditText price;

    public static OrderCreateFragment newInstance() {
        OrderCreateFragment fragment = new OrderCreateFragment();
        return fragment;
    }
    public OrderCreateFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_order_create, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        orderFrom.setText("");

        order_to.setText("");
        price.setText("");
        target_desc.setText("");
        extra_data.setText("");
        object_desc.setText("");

    }

    @OnClick(R.id.btn_complete)
    public void submit(){
        DeliverOrder dd = new DeliverOrder();
        dd.active_status = "CREATED";
        dd.order_from = orderFrom.getText().toString();
        dd.order_to = order_to.getText().toString();
        dd.price= price.getText().toString();
        dd.extra_data = extra_data.getText().toString();
        dd.object_desc = extra_data.getText().toString();
        final ApiClientV4 coffeeService = new ApiClientV4(getActivity(),
                null);

        coffeeService.getApiService().createOrder( dd,
                new Callback<DeliverOrder>() {
                    @Override
                    public void success(DeliverOrder deliverOrder, Response response) {




                        if( getActivity()!= null){

                            MaterialDialog.Builder builder =
                                    new MaterialDialog.Builder(getActivity())
                                            .title("Alert")
                                            .content("created")
                                            .positiveText("OK");
                            builder.show();
                            orderFrom.setText("");

                            order_to.setText("");
                            price.setText("");
                            target_desc.setText("");
                            extra_data.setText("");
                            object_desc.setText("");
                        }
                    }

                    @Override
                    public void failure(RetrofitError error) {

                    }
                });

    }

}
