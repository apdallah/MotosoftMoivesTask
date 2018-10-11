package com.apdallahy3.motosoftmoivestask.Data.DataSource;

import com.apdallahy3.motosoftmoivestask.Data.Entities.MoiveEntitiy;
import com.apdallahy3.motosoftmoivestask.Data.Entities.MoiveResponse;

import java.util.List;

import io.reactivex.Observable;

public interface MoivesDataStore {
Observable<MoiveResponse> moives();
}
