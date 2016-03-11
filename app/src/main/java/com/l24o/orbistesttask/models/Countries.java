package com.l24o.orbistesttask.models;

import io.realm.RealmList;
import io.realm.RealmObject;

/**
 * Created by chuff on 11.03.2016.
 */
public class Countries extends RealmObject {

    private RealmList<Country> country;

    public RealmList<Country> getCountry() {
        return country;
    }

    public void setCountry(RealmList<Country> country) {
        this.country = country;
    }
}
