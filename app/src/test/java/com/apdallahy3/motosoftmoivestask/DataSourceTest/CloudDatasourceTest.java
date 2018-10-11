package com.apdallahy3.motosoftmoivestask.DataSourceTest;


import android.util.Log;

import com.apdallahy3.motosoftmoivestask.Data.Cache.MoivesChache;
import com.apdallahy3.motosoftmoivestask.Data.DataSource.MoivesCloudDataStore;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
public class CloudDatasourceTest {

private MoivesCloudDataStore moivesCloudDataStore;

@Mock
    MoivesChache moivesChache;
@Before
public void setup(){
    moivesCloudDataStore=new MoivesCloudDataStore(moivesChache);
}
@Test
    public void testGetAllMoivesData(){
    System.out.println(moivesCloudDataStore.moives().count());
 }
}
