package com.apdallahy3.motosoftmoivestask.Data.Cache;

import com.apdallahy3.motosoftmoivestask.Data.Entities.MoiveEntitiy;

import java.util.List;

public class MoivesChacheImpl implements MoivesChache {
    List<MoiveEntitiy> moiveEntitiys;
    @Override
    public void putMoives(List<MoiveEntitiy> moiveEntitiys) {
          moiveEntitiys.addAll(moiveEntitiys);
    }

    @Override
    public List<MoiveEntitiy> getMoives() {
        return moiveEntitiys;
    }
}
