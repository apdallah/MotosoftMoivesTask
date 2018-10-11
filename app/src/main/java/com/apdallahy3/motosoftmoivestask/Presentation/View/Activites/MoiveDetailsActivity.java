package com.apdallahy3.motosoftmoivestask.Presentation.View.Activites;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.apdallahy3.motosoftmoivestask.Data.Entities.MoiveEntitiy;
import com.apdallahy3.motosoftmoivestask.Presentation.Presenter.MoiveDetailPresnter;
import com.apdallahy3.motosoftmoivestask.Presentation.View.MoiveView;
import com.apdallahy3.motosoftmoivestask.R;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MoiveDetailsActivity extends AppCompatActivity implements MoiveView {
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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moive_details);
        ButterKnife.bind(this);
        moiveDetailPresnter=new MoiveDetailPresnter(this);
        if(getIntent().hasExtra("movie")){
            MoiveEntitiy moiveEntitiy=(MoiveEntitiy)getIntent().getSerializableExtra("movie");
            moiveDetailPresnter.setMoive(moiveEntitiy);
            Log.i("InfoDe",moiveEntitiy.getTitle());

            moiveDetailPresnter.initalize();

        }

    }

    @Override
    public void setMoiveTitle(String title) {
        this.title.setText(title);
    }

    @Override
    public void setMoivePoster(String path) {
        Picasso.with(this)
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
