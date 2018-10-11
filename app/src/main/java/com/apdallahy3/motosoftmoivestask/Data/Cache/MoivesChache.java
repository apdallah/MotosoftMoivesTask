package com.apdallahy3.motosoftmoivestask.Data.Cache;

import com.apdallahy3.motosoftmoivestask.Data.Entities.MoiveEntitiy;

import java.util.List;

public interface MoivesChache {
    void putMoives(List<MoiveEntitiy> moiveEntitiys);
    List<MoiveEntitiy> getMoives( );
}
