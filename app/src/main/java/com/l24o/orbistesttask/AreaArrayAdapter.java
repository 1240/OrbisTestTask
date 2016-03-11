package com.l24o.orbistesttask;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.l24o.orbistesttask.models.Area;

import java.util.List;

/**
 * Created by chuff on 11.03.2016.
 */
public class AreaArrayAdapter extends ArrayAdapter<Area> {

    private final List<Area> objects;
    private final Activity context;

    public AreaArrayAdapter(Activity context, List<Area> objects) {
        super(context, R.layout.listitem, objects);
        this.objects = objects;
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = context.getLayoutInflater();
        View listitem = layoutInflater.inflate(R.layout.listitem, null);
        ViewHolder viewHolder = new ViewHolder();
        viewHolder.name = (TextView)listitem.findViewById(R.id.tvName);
        viewHolder.population = (TextView)listitem.findViewById(R.id.tvPop);
        viewHolder.name.setText(objects.get(position).getCountryName());
        viewHolder.population.setText(objects.get(position).getPopulation());
        return super.getView(position, convertView, parent);
    }

    public class ViewHolder {
        protected TextView name;
        protected TextView population;
    }
}
