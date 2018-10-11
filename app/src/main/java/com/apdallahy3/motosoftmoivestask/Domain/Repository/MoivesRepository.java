package com.apdallahy3.motosoftmoivestask.Domain.Repository;

import com.apdallahy3.motosoftmoivestask.Data.Entities.MoiveEntitiy;

import java.util.List;

import io.reactivex.Observable;

public interface MoivesRepository {
    Observable<List<MoiveEntitiy>> moives();
}
