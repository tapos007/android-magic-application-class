package com.example.tapos.magitionapplication.adpaters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.tapos.magitionapplication.R;
import com.example.tapos.magitionapplication.models.Magic;

import java.util.List;

/**
 * Created by tapos on 1/22/18.
 */
public class MagicAdapter extends RecyclerView.Adapter<MagicAdapter.MyViewHolder> {

    private Context mContext;
    private List<Magic> magicList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title ;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
        }
    }


    public MagicAdapter(Context mContext, List<Magic> magicList) {
        this.mContext = mContext;
        this.magicList = magicList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.album_card, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        Magic album = magicList.get(position);
        holder.title.setText(album.getTitle());

    }



    @Override
    public int getItemCount() {
        return magicList.size();
    }
}