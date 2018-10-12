package com.apdallahy3.motosoftmoivestask.Presentation.View.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.apdallahy3.motosoftmoivestask.Data.Entities.MoiveEntitiy;
import com.apdallahy3.motosoftmoivestask.Presentation.Presenter.MoiveDetailPresnter;
import com.apdallahy3.motosoftmoivestask.Presentation.View.Interfaces.MoiveView;
import com.apdallahy3.motosoftmoivestask.R;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MoivesDetailsFragment extends Fragment implements MoiveView {
     @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
     }
View view;
    @BindView(R.id.imageview)
    ImageView poster;
    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.overview)
    TextView overview;
    @BindView(R.id.release_date)
    TextView releaseDate;
    @BindView(R.id.rate)
    TextView rating;
    private MoiveDetailPresnter moiveDetailPresnter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_moives_details, container, false);
        ButterKnife.bind(this,view);
        moiveDetailPresnter=new MoiveDetailPresnter(this);
        if(getArguments()!=null){
            MoiveEntitiy moiveEntitiy=(MoiveEntitiy)getArguments().getSerializable("movie");
            moiveDetailPresnter.setMoive(moiveEntitiy);
            Log.i("InfoDe",moiveEntitiy.getTitle());

            moiveDetailPresnter.initalize();

        }
        return view;
    }

    @Override
    public void setMoiveTitle(String title) {
        this.title.setText(title);
    }

    @Override
    public void setMoivePoster(String path) {
        Picasso.with(getContext())
                .load("https://image.tmdb.org/t/p/w500/"+path)
                .error(R.mipmap.ic_launcher)
                .into(this.poster);
    }

    @Override
    public void setMoiveRating(String rating) {
        this.rating.setText(rating);

    }

    @Override
    public void setMoiveReleaseDate(String releaseDate) {
        this.releaseDate.setText(releaseDate);

    }

    @Override
    public void setMoiveOverview(String overview) {
        this.overview.setText(overview);

    }
}
