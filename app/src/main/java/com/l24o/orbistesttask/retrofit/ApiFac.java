package com.l24o.orbistesttask.retrofit;

import android.support.annotation.NonNull;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import io.realm.RealmObject;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * @author Alexander Popov created on 01.03.2016.
 */
public class ApiFac {

    private static final Gson GSON = new GsonBuilder()
            .setExclusionStrategies(new ExclusionStrategy() {
                @Override
                public boolean shouldSkipField(FieldAttributes f) {
                    return f.getDeclaringClass().equals(RealmObject.class);
                }

                @Override
                public boolean shouldSkipClass(Class<?> clazz) {
                    return false;
                }
            })
            .create();

    @NonNull
    public static AreaService getAreaService() {
        return getRetrofit().create(AreaService.class);
    }

    @NonNull
    private static Retrofit getRetrofit() {
        return new Retrofit.Builder()
                .baseUrl("http://1240.github.io")
                .addConverterFactory(GsonConverterFactory.create(GSON))
                .build();
    }

}
