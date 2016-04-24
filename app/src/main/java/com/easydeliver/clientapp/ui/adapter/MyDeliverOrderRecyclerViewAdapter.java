package com.easydeliver.clientapp.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.easydeliver.clientapp.R;
import com.easydeliver.clientapp.model.DeliverOrder;
import com.easydeliver.clientapp.ui.fragment.DeliverOrderFragment;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * {@link RecyclerView.Adapter} that can display a {@link DeliverOrder} and makes a call to the
 * specified {@link DeliverOrderFragment.OnListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyDeliverOrderRecyclerViewAdapter extends RecyclerView.Adapter<MyDeliverOrderRecyclerViewAdapter.ViewHolder> {

    private final List<DeliverOrder> mValues;
    private final DeliverOrderFragment.OnListFragmentInteractionListener mListener;

    public MyDeliverOrderRecyclerViewAdapter(List<DeliverOrder> items, DeliverOrderFragment.OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.datetime.setText(mValues.get(position).extra_data +  " , " + mValues.get(position).target_desc+"\n");
        holder.title.setText("[" +mValues.get(position).id
                + " ]  "+ mValues.get(position).order_from +  "  >>  " + mValues.get(position).order_to );
        holder.description.setText(mValues.get(position).active_status+"");
        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction(holder.mItem);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        @Bind(R.id.image)
        ImageView image;
        @Bind(R.id.title)        TextView title;
        @Bind(R.id.datetime)        TextView datetime;
        @Bind(R.id.description)        TextView description;
        public DeliverOrder mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            ButterKnife.bind(this, itemView);

        }
//
//        @Override
//        public String toString() {
//            return super.toString() + " '" + mContentView.getText() + "'";
//        }
    }
}
