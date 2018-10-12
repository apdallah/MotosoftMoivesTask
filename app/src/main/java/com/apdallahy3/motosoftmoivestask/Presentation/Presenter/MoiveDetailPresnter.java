package com.apdallahy3.motosoftmoivestask.Presentation.Presenter;

import android.util.Log;

import com.apdallahy3.motosoftmoivestask.Data.Entities.MoiveEntitiy;
import com.apdallahy3.motosoftmoivestask.Presentation.View.Interfaces.MoiveView;

public class MoiveDetailPresnter {
    MoiveView moiveView;
    MoiveEntitiy moive;

    public MoiveDetailPresnter(MoiveView moiveView) {
        this.moiveView = moiveView;
    }

    public void setMoive(MoiveEntitiy moive) {
        this.moive = moive;
    }


    public void initalize(){
                 Log.i("Info",this.moive.getTitle());
        this.moiveView.setMoiveTitle(this.moive.getTitle());
        this.moiveView.setMoiveOverview(this.moive.getOverview());
        this.moiveView.setMoivePoster(this.moive.getPosterPath());
        this.moiveView.setMoiveRating(this.moive.getVoteAverage()+"/10");
        this.moiveView.setMoiveReleaseDate(this.moive.getReleaseDate());
    }
}
