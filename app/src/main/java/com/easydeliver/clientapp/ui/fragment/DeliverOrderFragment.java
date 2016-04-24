package com.easydeliver.clientapp.ui.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.easydeliver.clientapp.R;
import com.easydeliver.clientapp.model.DeliverOrder;
import com.easydeliver.clientapp.rest.model.DeliverListRes;
import com.easydeliver.clientapp.rest.service.ApiClientV4;
import com.easydeliver.clientapp.ui.activity.OrderDetailActivity;
import com.easydeliver.clientapp.ui.adapter.MyDeliverOrderRecyclerViewAdapter;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnListFragmentInteractionListener}
 * interface.
 */
public class DeliverOrderFragment extends BaseFragment {

    // TODO: Customize parameters
    private int mColumnCount = 1;
    public RecyclerView recyclerView;

    private OnListFragmentInteractionListener mListener;
    private ScheduledThreadPoolExecutor exec;

    public static DeliverOrderFragment newInstance() {
        DeliverOrderFragment fragment = new DeliverOrderFragment();

//        Bundle args = new Bundle();
//        args.putParcelableArrayList(ARG_PARAM345, restaurants);
//        fragment.setArguments(args);
        return fragment;
    }

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public DeliverOrderFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_deliverorder_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }
//            recyclerView.setAdapter(new MyDeliverOrderRecyclerViewAdapter(DummyContent.ITEMS, mListener));
        }
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


//        exec = new ScheduledThreadPoolExecutor(1);
//
//        exec.scheduleAtFixedRate(new MyTask(), 10, 5, TimeUnit.SECONDS);



    }

    @Override
    public void onPause() {
        super.onPause();
        exec.shutdown();
    }

    @Override
    public void onResume() {
        super.onResume();
        exec = new ScheduledThreadPoolExecutor(1);

        exec.scheduleAtFixedRate(new MyTask(), 2, 5, TimeUnit.SECONDS);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mListener = new OnListFragmentInteractionListener() {
            @Override
            public void onListFragmentInteraction(DeliverOrder item) {

                Intent intent = new Intent(getContext(), OrderDetailActivity.class);

                intent.putExtra(OrderDetailActivity.ARG_FILTER_MODE, item);

                startActivity(intent);
            }
        };
//        if (context instanceof OnListFragmentInteractionListener) {
////            mListener = (OnListFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnListFragmentInteractionListener");
//        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnListFragmentInteractionListener {
        // TODO: Update argument type and name
        void onListFragmentInteraction(DeliverOrder item);
    }


    class MyTask implements Runnable {

        @Override
        public void run() {
            if (getActivity() != null) {
                final ApiClientV4 coffeeService = new ApiClientV4(getActivity(),
                        null);

                coffeeService.getApiService().getOrder(new Callback<DeliverListRes>() {
                    @Override
                    public void success(DeliverListRes res, Response response) {
                        if (getActivity() != null) {
                            recyclerView.setAdapter(new MyDeliverOrderRecyclerViewAdapter(res.orderList, mListener));

                        }
                    }

                    @Override
                    public void failure(RetrofitError error) {

                    }
                });
            }
        }

    }
}
