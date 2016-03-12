package com.l24o.orbistesttask;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.l24o.orbistesttask.models.Country;

import java.util.List;

/**
 * Created by chuff on 11.03.2016.
 */
public class AreaArrayAdapter extends ArrayAdapter<Country> {

    private final List<Country> objects;
    private final Activity context;
    private boolean b = false;

    public AreaArrayAdapter(Activity context, List<Country> objects) {
        super(context, R.layout.listitem, objects);
        this.objects = objects;
        this.context = context;
    }

    public AreaArrayAdapter(Activity context, List<Country> objects, boolean b) {
        super(context, R.layout.listitem, objects);
        this.objects = objects;
        this.context = context;
        this.b = b;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = context.getLayoutInflater();
        View listitem = layoutInflater.inflate(R.layout.listitem, null);
        ViewHolder viewHolder = new ViewHolder();
        viewHolder.name = (TextView) listitem.findViewById(R.id.tvName);
        viewHolder.population = (TextView) listitem.findViewById(R.id.tvPop);
        Country country = objects.get(position);
        viewHolder.name.setText(country.getCountryName());
        viewHolder.population.setText(country.getPopulation());
        if (b)
            if (country.isChecked())
                listitem.setBackgroundColor(context.getResources().getColor(R.color.colorPrimary));
            else
                listitem.setBackgroundColor(context.getResources().getColor(android.R.color.transparent));
        return listitem;
    }

    public class ViewHolder {
        protected TextView name;
        protected TextView population;
    }
}
