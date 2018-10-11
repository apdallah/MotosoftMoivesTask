package com.apdallahy3.motosoftmoivestask.Presentation.Presenter;

import android.util.Log;

import com.apdallahy3.motosoftmoivestask.Data.Entities.MoiveEntitiy;
import com.apdallahy3.motosoftmoivestask.Data.Entities.MoiveResponse;
import com.apdallahy3.motosoftmoivestask.Domain.DefaultObserver;
import com.apdallahy3.motosoftmoivestask.Domain.Interactors.GetMoivesList;
import com.apdallahy3.motosoftmoivestask.Presentation.View.MoiveListView;

import java.util.List;

public class MainActivityPresenter implements Presenter{
private MoiveListView moiveListView;
private final GetMoivesList getMoivesList;

    public MainActivityPresenter(GetMoivesList getMoivesList) {
        this.getMoivesList = getMoivesList;
    }
    public void setMoiveListView(MoiveListView moiveListView)
    {
        this.moiveListView=moiveListView;
    }
    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }
    public void initialize(){
        this.showViewLoading();
        this.getMoivesList.excute(new MoivesListObserver(), null);

    }
    private void showViewLoading() {

        this.moiveListView.showloading();
    }

    private void hideViewLoading() {

        this.moiveListView.hideLoading();
    }
    private void showMoiveListInView(List<MoiveEntitiy> moiveEntitiys) {
       // final List<MoiveEntitiy> townshipModelList =
         this.moiveListView.getMoivesList(moiveEntitiys);
     }
    @Override
    public void destroy() {
        this.getMoivesList.dispose();
        this.moiveListView=null;
    }

    private final class MoivesListObserver extends DefaultObserver<MoiveResponse> {

        @Override public void onComplete() {

            MainActivityPresenter.this.hideViewLoading();
        }

        @Override public void onError(Throwable e) {
            e.printStackTrace();
            MainActivityPresenter.this.hideViewLoading();
         }

        @Override public void onNext(MoiveResponse moiveEntitiys) {
            //Log.d("Data2",moiveEntitiys.getResults().size()+"");
            MainActivityPresenter.this.showMoiveListInView(moiveEntitiys.getResults());
        }
    }
}
