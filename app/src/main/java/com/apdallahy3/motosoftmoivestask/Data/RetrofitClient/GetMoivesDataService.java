package com.apdallahy3.motosoftmoivestask.Data.RetrofitClient;

import com.apdallahy3.motosoftmoivestask.Data.Entities.MoiveEntitiy;
import com.apdallahy3.motosoftmoivestask.Data.Entities.MoiveResponse;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GetMoivesDataService {

    @GET("discover/movie?sort_by=popularity.desc")
    @SerializedName("results")
    Observable<MoiveResponse> getMoives(@Query("api_key") String API_KEY);

}
