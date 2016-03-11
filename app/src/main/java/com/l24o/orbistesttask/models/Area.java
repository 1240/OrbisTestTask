package com.l24o.orbistesttask.models;

import io.realm.RealmObject;
import io.realm.annotations.Ignore;

/**
 * Created by chuff on 10.03.2016.
 */
public class Area extends RealmObject {

    private String population;
    private String countryName;

    @Ignore
    private boolean isChecked;

    public boolean isChecked() {
        return isChecked;
    }

    public void setIsChecked(boolean isChecked) {
        this.isChecked = isChecked;
    }

    public String getPopulation() {
        return population;
    }

    public void setPopulation(String population) {
        this.population = population;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }
}
