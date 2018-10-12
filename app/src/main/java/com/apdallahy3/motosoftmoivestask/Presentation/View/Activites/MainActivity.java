package com.apdallahy3.motosoftmoivestask.Presentation.View.Activites;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;

import com.apdallahy3.motosoftmoivestask.Data.Entities.MoiveEntitiy;
import com.apdallahy3.motosoftmoivestask.Presentation.View.Fragments.MoivesDetailsFragment;
import com.apdallahy3.motosoftmoivestask.Presentation.View.Fragments.MoivesFragment;
import com.apdallahy3.motosoftmoivestask.Presentation.View.Interfaces.OnItemClickListener;
import com.apdallahy3.motosoftmoivestask.R;

import java.io.Serializable;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements OnItemClickListener {
//
//    @BindView(R.id.recycler_view)
//    RecyclerView recyclerView;
//
//    @BindView(R.id.progress_bar)
//    ProgressBar progressBar;

//    private MoviesAdapter adapter;
//    private  List<MoiveEntitiy>moiveModels;
//    private MoivesChache moivesChache;
//    private MoivesCloudDataStore moivesCloudDataStore;
//    private MoivesRepository moivesRepository;
//    private GetMoivesList getMoivesList;
//    private MainActivityPresenter miMainActivityPresenter;
    public static boolean twoPane;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_frags);
         getSupportFragmentManager().beginTransaction().
                replace(R.id.content_view, new MoivesFragment()).
                    commit();
        if(findViewById(R.id.movie_detail_container)!=null){
            twoPane=true;
            if (savedInstanceState == null) {
                getSupportFragmentManager().beginTransaction().
                        replace(R.id.movie_detail_container, new MoivesDetailsFragment()).
                        commit();
            }
        }else{
            twoPane=false;
        }
//        ButterKnife.bind(this);
//        adapter=new MoviesAdapter(this);
//        recyclerView.setLayoutManager(new GridLayoutManager(this,3));
//        recyclerView.setAdapter(adapter);
//        moivesChache=new MoivesChacheImpl();
//        moivesCloudDataStore=new MoivesCloudDataStore(moivesChache);
//        getMoivesList=new GetMoivesList(moivesCloudDataStore);
//        miMainActivityPresenter=new MainActivityPresenter(getMoivesList);
//        miMainActivityPresenter.setMoiveListView(this);
//        miMainActivityPresenter.initialize();
     }

    @Override
    public void onClick(MoiveEntitiy Item) {

        if(twoPane) {
            Bundle args = new Bundle();
            args.putSerializable("movie", Item);
            MoivesDetailsFragment fragment = new MoivesDetailsFragment();
            fragment.setArguments(args);
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.content_view, fragment)
                     .commit();
        }else{
            Intent intent=new Intent(this,MoiveDetailsActivity.class);
        intent.putExtra("movie", (Serializable) Item);
        startActivity(intent);
        }
    }


    //
//    @Override
//    public void getMoivesList(List<MoiveEntitiy> moiveList) {
//
//        adapter.setMoivesList(moiveList);
//    }
//
//    @Override
//    public void showloading() {
//        progressBar.setVisibility(View.VISIBLE);
//        recyclerView.setVisibility(View.GONE);
//    }
//
//    @Override
//    public void hideLoading() {
//
//        progressBar.setVisibility(View.GONE);
//        recyclerView.setVisibility(View.VISIBLE);
//    }
//
//    @Override
//    public void onItemCLick() {
//
//    }
//
//    @Override
//    public void onClick(MoiveEntitiy Item) {
//        Intent intent=new Intent(this,MoiveDetailsActivity.class);
//        intent.putExtra("movie", (Serializable) Item);
//        startActivity(intent);
////        Toast.makeText(this, Item.getTitle(), Toast.LENGTH_SHORT).show();
//    }
}
