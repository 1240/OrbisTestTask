package com.l24o.orbistesttask.retrofit.response;

import android.content.Context;

import com.l24o.orbistesttask.models.Countries;
import com.l24o.orbistesttask.realm.RealmHelper;

import io.realm.Realm;


/**
 * @author Alexander Popov created on 01.03.2016.
 */
public class AreaResponse extends Response {

    @Override
    public void save(Context context) {
        Countries countries = (Countries) getTypedAnswer();
        if (countries != null) {
            if (countries.getCountries() != null)
                RealmHelper.save(Realm.getInstance(context), countries.getCountries());
        }
    }
}
