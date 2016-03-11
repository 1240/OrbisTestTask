package com.l24o.orbistesttask.retrofit.loaders;

import android.content.Context;
import android.os.CountDownTimer;

import com.l24o.orbistesttask.models.Countries;
import com.l24o.orbistesttask.models.Country;
import com.l24o.orbistesttask.retrofit.ApiFac;
import com.l24o.orbistesttask.retrofit.AreaService;
import com.l24o.orbistesttask.retrofit.response.AreaResponse;
import com.l24o.orbistesttask.retrofit.response.RequestResult;
import com.l24o.orbistesttask.retrofit.response.Response;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;

/**
 * @author Alexander Popov created on 01.03.2016.
 */
public class OrbisLoader extends BaseLoader {

    public OrbisLoader(Context context) {
        super(context);
    }

    @Override
    protected Response apiCall() throws IOException {
        AreaService service = ApiFac.getAreaService();
        Call<Countries> call = service.areas();
        Countries countries = call.execute().body();
        return new AreaResponse()
                .setRequestResult(RequestResult.SUCCESS)
                .setAnswer(countries);
    }
}