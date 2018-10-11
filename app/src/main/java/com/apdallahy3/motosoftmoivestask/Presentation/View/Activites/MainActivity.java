package com.apdallahy3.motosoftmoivestask.Presentation.View.Activites;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.apdallahy3.motosoftmoivestask.Data.Cache.MoivesChache;
import com.apdallahy3.motosoftmoivestask.Data.Cache.MoivesChacheImpl;
import com.apdallahy3.motosoftmoivestask.Data.DataSource.MoivesCloudDataStore;
import com.apdallahy3.motosoftmoivestask.Data.Entities.MoiveEntitiy;
import com.apdallahy3.motosoftmoivestask.Domain.Interactors.GetMoivesList;
import com.apdallahy3.motosoftmoivestask.Domain.Repository.MoivesRepository;
import com.apdallahy3.motosoftmoivestask.Presentation.Presenter.MainActivityPresenter;
import com.apdallahy3.motosoftmoivestask.Presentation.View.MoiveListView;
import com.apdallahy3.motosoftmoivestask.Presentation.View.MoviesAdapter;
import com.apdallahy3.motosoftmoivestask.Presentation.View.OnItemClickListener;
import com.apdallahy3.motosoftmoivestask.R;

import java.io.Serializable;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MoiveListView,OnItemClickListener {

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    @BindView(R.id.progress_bar)
    ProgressBar progressBar;

    private MoviesAdapter adapter;
    private  List<MoiveEntitiy>moiveModels;
    private MoivesChache moivesChache;
    private MoivesCloudDataStore moivesCloudDataStore;
    private MoivesRepository moivesRepository;
    private GetMoivesList getMoivesList;
    private MainActivityPresenter miMainActivityPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        adapter=new MoviesAdapter(this);
        recyclerView.setLayoutManager(new GridLayoutManager(this,3));
        recyclerView.setAdapter(adapter);
        moivesChache=new MoivesChacheImpl();
        moivesCloudDataStore=new MoivesCloudDataStore(moivesChache);
        getMoivesList=new GetMoivesList(moivesCloudDataStore);
        miMainActivityPresenter=new MainActivityPresenter(getMoivesList);
        miMainActivityPresenter.setMoiveListView(this);
        miMainActivityPresenter.initialize();
     }

    @Override
    public void getMoivesList(List<MoiveEntitiy> moiveList) {

        adapter.setMoivesList(moiveList);
    }

    @Override
    public void showloading() {
        progressBar.setVisibility(View.VISIBLE);
        recyclerView.setVisibility(View.GONE);
    }

    @Override
    public void hideLoading() {

        progressBar.setVisibility(View.GONE);
        recyclerView.setVisibility(View.VISIBLE);
    }

    @Override
    public void onItemCLick() {

    }

    @Override
    public void onClick(MoiveEntitiy Item) {
        Intent intent=new Intent(this,MoiveDetailsActivity.class);
        intent.putExtra("movie", (Serializable) Item);
        startActivity(intent);
//        Toast.makeText(this, Item.getTitle(), Toast.LENGTH_SHORT).show();
    }
}
