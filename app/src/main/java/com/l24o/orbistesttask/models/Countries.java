package com.l24o.orbistesttask.models;

import io.realm.RealmList;
import io.realm.RealmObject;

/**
 * Created by chuff on 11.03.2016.
 */
public class Countries extends RealmObject {

    private RealmList<Country> countries;

    public RealmList<Country> getCountries() {
        return countries;
    }

    public void setCountries(RealmList<Country> countries) {
        this.countries = countries;
    }
}
