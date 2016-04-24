package com.easydeliver.clientapp.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.easydeliver.clientapp.R;
import com.easydeliver.clientapp.model.DeliverOrder;
import com.easydeliver.clientapp.ui.fragment.OrderCreateFragment;

import butterknife.Bind;
import butterknife.ButterKnife;

public class OrderCreateActivity extends BaseActivity {
    private static final String TAG = OrderDetailActivity.class.getSimpleName();
    public static final String ARG_FILTER_MODE = "adsfasdfasdf";

    @Bind(R.id.toolbar)
    Toolbar toolbar;

    @Bind(R.id.toolbar_title)
    TextView toolbarTitle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_container_no_drawer);

        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
//        toolbar.setVisibility(View.GONE);

        final ActionBar ab = getSupportActionBar();
        ab.setElevation(100);
//        ab.setIcon(R.drawable.logo_white);
        ab.setDisplayHomeAsUpEnabled(true);
        ab.setHomeButtonEnabled(true);


        Intent intent = getIntent();
        DeliverOrder restType = (DeliverOrder) intent.getSerializableExtra(ARG_FILTER_MODE);
//        objectId = intent.getIntExtra( ARG_ID, -1);
//        userId =  intent.getIntExtra( ARG_USER_ID, -1);
//        title = intent.getStringExtra(ARG_TITLE);
//        isMyVisit = intent.getBooleanExtra(ARG_IS_MYVISIT, false);
//        String orderNumber = intent.getStringExtra(EXTRA_ORDER_NUMBER);
//        int partyId = intent.getIntExtra(EXTRA_PARTY_ID, 0);
//        final RoomTable rTable = intent.getParcelableExtra(PARAM_TABLE);

        ab.setTitle("");
        toolbarTitle.setText("Order Create");
//        if ( title == null){
//            setTitle();
//
//        } else {
//            toolbarTitle.setText(title + "");
//        }



        FragmentManager fragmentManager = getSupportFragmentManager();

//        Log.d("EXTRA_DAY" , intent.getStringExtra(EXTRA_DAY));



        fragmentManager.beginTransaction()

                .replace(R.id.container,
                        OrderCreateFragment.newInstance(),
                        TAG)
                .commit();

    }


//        setContentView(R.layout.activity_order_create);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//
//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });


}
