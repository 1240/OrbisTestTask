package com.l24o.orbistesttask.retrofit.response;

import android.content.Context;

import com.l24o.orbistesttask.models.Area;
import com.l24o.orbistesttask.realm.RealmHelper;

import java.util.List;

import io.realm.Realm;


/**
 * @author Alexander Popov created on 01.03.2016.
 */
public class AreaResponse extends Response {

    @Override
    public void save(Context context) {
        List<Area> areas = (List<Area>) getTypedAnswer();
        if (areas != null) {
            RealmHelper.save(Realm.getInstance(context), areas);
        }
    }
}
