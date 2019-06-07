package com.hungpn.funnystories.topic;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.hungpn.funnystories.ITopic;
import com.hungpn.funnystories.R;

public class TopicAdapter extends RecyclerView.Adapter<TopicAdapter.TopicViewHolder> {
    private ITopic inter;
    int [] img = {R.drawable.im_28, R.drawable.im_2, R.drawable.im_3, R.drawable.im_4, R.drawable.im_5,
            R.drawable.im_6, R.drawable.im_7, R.drawable.im_10, R.drawable.im_12, R.drawable.im_13,
            R.drawable.im_14, R.drawable.im_15, R.drawable.im_22,R.drawable.im_27, R.drawable.im_1, };

    public TopicAdapter(ITopic inter) {
        this.inter = inter;
    }

    @NonNull
    @Override
    public TopicViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_layout, viewGroup, false);
        return new TopicViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final TopicViewHolder topicViewHolder, int i) {
        Topic topic = inter.getTopic(i);

        topicViewHolder.tvName.setText(topic.getName());
        topicViewHolder.ivBand.setImageResource(img[i]);
        topicViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inter.onClick(topicViewHolder.getAdapterPosition());
            }
        });
    }

    @Override
    public int getItemCount() {
        return inter.getSize();
    }

    static class TopicViewHolder extends RecyclerView.ViewHolder{
        private TextView tvName;

        private ImageView ivBand;
        public TopicViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_name);
            ivBand = itemView.findViewById(R.id.iv_band);
        }
    }
}
