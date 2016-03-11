package com.l24o.orbistesttask.realm;

import android.support.annotation.NonNull;

import com.l24o.orbistesttask.models.Country;

import java.util.List;

import io.realm.Realm;

/**
 * @author Alexander Popov created on 02.03.2016.
 */
public class RealmHelper {

    public static void save(@NonNull Realm realm, List<Country> countryList) {
        realm.beginTransaction();
        realm.clear(Country.class);
        realm.copyToRealm(countryList);
        realm.commitTransaction();
    }

    @NonNull
    public static List<Country> getAreas(@NonNull Realm realm) {
        return realm.allObjects(Country.class);
    }
}
