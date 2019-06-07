package com.hungpn.funnystories.title;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.hungpn.funnystories.ITitle;
import com.hungpn.funnystories.R;

public class TitleAdapter extends RecyclerView.Adapter<TitleAdapter.TitleViewHolder> {
    private ITitle inter;
    public TitleAdapter(ITitle inter) {
        this.inter = inter;
    }

    @NonNull
    @Override
    public TitleViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_title, viewGroup, false);
        return new TitleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final TitleViewHolder viewHolder, int i) {
        Title title = inter.getTitle(i);
        viewHolder.tvName.setText(title.getName());
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inter.onClick(viewHolder.getAdapterPosition() );
            }
        });
    }

    @Override
    public int getItemCount() {
        return inter.getSize();
    }

    static class TitleViewHolder extends RecyclerView.ViewHolder {
        private TextView tvName;

        public TitleViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_name_title);
        }
    }
}
