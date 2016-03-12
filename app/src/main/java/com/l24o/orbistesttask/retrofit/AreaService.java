package com.l24o.orbistesttask.retrofit;

import com.l24o.orbistesttask.models.Countries;
import com.l24o.orbistesttask.models.Country;
import com.l24o.orbistesttask.retrofit.response.Response;

import java.util.List;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * @author Alexander Popov created on 01.03.2016.
 */
public interface AreaService {

    @GET("/test.json")
    Call<Countries> areas();

    @POST("/test")
    Response postCheckedObjects(@Body List<Country> body);


}
