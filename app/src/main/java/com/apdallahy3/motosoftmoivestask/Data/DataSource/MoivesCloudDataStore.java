package com.apdallahy3.motosoftmoivestask.Data.DataSource;

import android.util.Log;

import com.apdallahy3.motosoftmoivestask.Data.Cache.MoivesChache;
import com.apdallahy3.motosoftmoivestask.Data.Entities.MoiveEntitiy;
import com.apdallahy3.motosoftmoivestask.Data.Entities.MoiveResponse;
import com.apdallahy3.motosoftmoivestask.Data.RetrofitClient.APIClient;
import com.apdallahy3.motosoftmoivestask.Data.RetrofitClient.GetMoivesDataService;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

public class MoivesCloudDataStore implements MoivesDataStore{

    private final MoivesChache moivesChache ;
    public MoivesCloudDataStore(MoivesChache moivesChache) {
        this.moivesChache = moivesChache;
    }

    @Override
    public Observable<MoiveResponse> moives() {
         GetMoivesDataService getMoivesDataService=APIClient.getRetrofit().create(GetMoivesDataService.class);

        return getMoivesDataService.getMoives("08980860fff5f4434c80dc7b767c8a7e").doOnNext(new Consumer<MoiveResponse>() {
            @Override
            public void accept(MoiveResponse moiveResponses) throws Exception {

                moivesChache.putMoives(moiveResponses.getResults());
            }
        });
//
//         return getMoivesDataService.getMoives("08980860fff5f4434c80dc7b767c8a7e").doOnNext(new Consumer<List<MoiveEntitiy>>() {
//            @Override
//            public void accept(List<MoiveEntitiy> moiveEntitiys) throws Exception {
//                 moivesChache.putMoives(moiveEntitiys);
//            }
//        });


     }
}
