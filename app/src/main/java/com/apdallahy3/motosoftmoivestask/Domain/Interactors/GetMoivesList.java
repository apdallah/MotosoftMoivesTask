package com.apdallahy3.motosoftmoivestask.Domain.Interactors;

import android.util.Log;

import com.apdallahy3.motosoftmoivestask.Data.DataSource.MoivesCloudDataStore;
import com.apdallahy3.motosoftmoivestask.Data.Entities.MoiveEntitiy;
import com.apdallahy3.motosoftmoivestask.Data.Entities.MoiveResponse;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

public class GetMoivesList extends UseCase<MoiveResponse,Void> {
private final MoivesCloudDataStore moivesCloudDataStore;

    public GetMoivesList(MoivesCloudDataStore moivesCloudDataStore) {
        this.moivesCloudDataStore = moivesCloudDataStore;
    }

    @Override
    Observable<MoiveResponse> bulidUseCasaeObserable(Void notUsed) {
        Observable<MoiveResponse> responseObservable=moivesCloudDataStore.moives();
        responseObservable.doOnNext(new Consumer<MoiveResponse>() {
            @Override
            public void accept(MoiveResponse moiveResponse) throws Exception {
                Log.i("bulidUseCasaeObserable",moiveResponse.getResults().size()+"");

            }
        });

        return moivesCloudDataStore.moives();
    }
}
