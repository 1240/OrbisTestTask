package com.l24o.orbistesttask.retrofit;

import com.l24o.orbistesttask.models.Area;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * @author Alexander Popov created on 01.03.2016.
 */
public interface AreaService {

    @GET("/test.json")
    Call<List<Area>> areas();

}