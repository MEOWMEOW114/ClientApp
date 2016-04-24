package com.easydeliver.clientapp.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.easydeliver.clientapp.R;
import com.easydeliver.clientapp.ui.fragment.DeliverOrderFragment;

import butterknife.Bind;
import butterknife.ButterKnife;

public class OrderActivity extends BaseActivity {

    private static final String TAG = OrderActivity.class.getSimpleName();

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
//        restType = (FilterMode) intent.getSerializableExtra(ARG_FILTER_MODE);
//        objectId = intent.getIntExtra( ARG_ID, -1);
//        userId =  intent.getIntExtra( ARG_USER_ID, -1);
//        title = intent.getStringExtra(ARG_TITLE);
//        isMyVisit = intent.getBooleanExtra(ARG_IS_MYVISIT, false);
//        String orderNumber = intent.getStringExtra(EXTRA_ORDER_NUMBER);
//        int partyId = intent.getIntExtra(EXTRA_PARTY_ID, 0);
//        final RoomTable rTable = intent.getParcelableExtra(PARAM_TABLE);

        ab.setTitle("");
        toolbarTitle.setText("Order List");
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
                            DeliverOrderFragment.newInstance(),
                            TAG)
                    .commit();


    }
}
