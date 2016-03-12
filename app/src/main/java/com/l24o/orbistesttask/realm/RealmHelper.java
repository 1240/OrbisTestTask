package com.l24o.orbistesttask.realm;

import android.support.annotation.NonNull;

import com.l24o.orbistesttask.models.Country;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

/**
 * @author Alexander Popov created on 02.03.2016.
 */
public class RealmHelper {

    public static boolean isEmpty(@NonNull Realm realm) {
        return realm.allObjects(Country.class).isEmpty();
    }

    public static void update(@NonNull Realm realm, String name, boolean b) {
        Country first = realm.where(Country.class)
                .equalTo("countryName", name).findFirst();
        realm.beginTransaction();
        first.setIsChecked(b);
        realm.commitTransaction();
    }

    public static void clear(@NonNull Realm realm) {
        realm.beginTransaction();
        realm.clear(Country.class);
        realm.commitTransaction();
    }

    public static void save(@NonNull Realm realm, List<Country> countryList) {
        realm.beginTransaction();
        realm.clear(Country.class);
        realm.copyToRealm(countryList);
        realm.commitTransaction();
    }

    @NonNull
    public static List<Country> getAreas(@NonNull Realm realm, Boolean byName) {
        RealmResults<Country> result = realm.allObjects(Country.class);
        if (byName)
            result.sort("countryName");
        else
            result.sort("population");
        return result;
    }
}
