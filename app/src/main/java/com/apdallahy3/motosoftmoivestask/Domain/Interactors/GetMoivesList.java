package com.apdallahy3.motosoftmoivestask.Domain.Interactors;

import com.apdallahy3.motosoftmoivestask.Data.DataSource.MoivesCloudDataStore;
import com.apdallahy3.motosoftmoivestask.Data.Entities.MoiveEntitiy;
import com.apdallahy3.motosoftmoivestask.Data.Entities.MoiveResponse;

import java.util.List;

import io.reactivex.Observable;

public class GetMoivesList extends UseCase<MoiveResponse,Void> {
private final MoivesCloudDataStore moivesCloudDataStore;

    public GetMoivesList(MoivesCloudDataStore moivesCloudDataStore) {
        this.moivesCloudDataStore = moivesCloudDataStore;
    }

    @Override
    Observable<MoiveResponse> bulidUseCasaeObserable(Void notUsed) {

        return moivesCloudDataStore.moives();
    }
}
