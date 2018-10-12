package com.apdallahy3.motosoftmoivestask.Presentation.View;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.apdallahy3.motosoftmoivestask.Data.Entities.MoiveEntitiy;
import com.apdallahy3.motosoftmoivestask.Presentation.View.Interfaces.OnItemClickListener;
import com.apdallahy3.motosoftmoivestask.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.ViewHolder> {
List<MoiveEntitiy>moivesList=new ArrayList<MoiveEntitiy>();
private final OnItemClickListener listener;

    public MoviesAdapter(OnItemClickListener listener) {
        this.listener = listener;
    }

    public void setMoivesList(List<MoiveEntitiy> moivesList) {
        Log.i("SetMoiveList",moivesList.size()+"");
        this.moivesList.clear();
        this.moivesList.addAll(moivesList) ;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view=LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.view_item,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Picasso.with(viewHolder.imageView.getContext())
                .load("https://image.tmdb.org/t/p/w500/"+moivesList.get(i).getPosterPath())
                .error(R.mipmap.ic_launcher)
                .into(viewHolder.imageView);
        viewHolder.click(moivesList.get(i),listener);
    }

    @Override
    public int getItemCount() {
        Log.i("Adapter",moivesList.size()+"");

        return moivesList!=null?moivesList.size():0;
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.imageview)
        ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
        public void click(final MoiveEntitiy moiveEntitiy, final OnItemClickListener listener) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onClick(moiveEntitiy);
                }
            });
        }

    }
}
