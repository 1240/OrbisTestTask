package com.l24o.orbistesttask.realm;

import android.support.annotation.NonNull;

import com.l24o.orbistesttask.models.Area;

import java.util.List;

import io.realm.Realm;

/**
 * @author Alexander Popov created on 02.03.2016.
 */
public class RealmHelper {

    public static void save(@NonNull Realm realm, List<Area> areaList) {
        realm.beginTransaction();
        realm.clear(Area.class);
        realm.copyToRealm(areaList);
        realm.commitTransaction();
    }

    @NonNull
    public static List<Area> getAreas(@NonNull Realm realm) {
        return realm.allObjects(Area.class);
    }
}
