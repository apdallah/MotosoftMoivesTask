package com.apdallahy3.motosoftmoivestask.Presentation.View.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.apdallahy3.motosoftmoivestask.Data.Cache.MoivesChache;
import com.apdallahy3.motosoftmoivestask.Data.Cache.MoivesChacheImpl;
import com.apdallahy3.motosoftmoivestask.Data.DataSource.MoivesCloudDataStore;
import com.apdallahy3.motosoftmoivestask.Data.Entities.MoiveEntitiy;
import com.apdallahy3.motosoftmoivestask.Domain.Interactors.GetMoivesList;
import com.apdallahy3.motosoftmoivestask.Domain.Repository.MoivesRepository;
import com.apdallahy3.motosoftmoivestask.Presentation.Presenter.MainActivityPresenter;
import com.apdallahy3.motosoftmoivestask.Presentation.View.Activites.MoiveDetailsActivity;
import com.apdallahy3.motosoftmoivestask.Presentation.View.Interfaces.MoiveListView;
import com.apdallahy3.motosoftmoivestask.Presentation.View.MoviesAdapter;
import com.apdallahy3.motosoftmoivestask.Presentation.View.Interfaces.OnItemClickListener;
import com.apdallahy3.motosoftmoivestask.R;

import java.io.Serializable;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MoivesFragment extends Fragment implements MoiveListView {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    View view;
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view=inflater.inflate(R.layout.fragment_blank, container, false);
        ButterKnife.bind(this,view);
        adapter=new MoviesAdapter( ((OnItemClickListener) getActivity()));
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),3));
        recyclerView.setAdapter(adapter);
        moivesChache=new MoivesChacheImpl();
        moivesCloudDataStore=new MoivesCloudDataStore(moivesChache);
        getMoivesList=new GetMoivesList(moivesCloudDataStore);
        miMainActivityPresenter=new MainActivityPresenter(getMoivesList);
        miMainActivityPresenter.setMoiveListView(this);
        miMainActivityPresenter.initialize();

        return view;
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


}
