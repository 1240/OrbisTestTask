package com.l24o.orbistesttask;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.l24o.orbistesttask.models.Country;
import com.l24o.orbistesttask.realm.RealmHelper;
import com.l24o.orbistesttask.retrofit.ApiFac;
import com.l24o.orbistesttask.retrofit.AreaService;

import java.io.IOException;
import java.util.List;

import io.realm.Realm;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.BufferedSink;

public class Main2Activity extends AppCompatActivity {

    private AreaArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ListView listView = (ListView) findViewById(R.id.listView2);
        final List<Country> areas = RealmHelper.getAreas(Realm.getInstance(this), false);
        adapter = new AreaArrayAdapter(this, areas, true);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Country country = areas.get(position);
                boolean b = !country.isChecked();
                RealmHelper.update(Realm.getInstance(Main2Activity.this), country.getCountryName(), b);
                adapter.notifyDataSetChanged();
            }
        });
        listView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.action_name:
                startActivity(new Intent(this, MainActivity.class));
                break;
            case R.id.action_population:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void send(final View view) {
        new AsyncTask<Boolean, Boolean, Boolean>() {
            @Override
            protected Boolean doInBackground(Boolean... params) {
                List<Country> areasForSend = RealmHelper.getAreasForSend(Realm.getInstance(Main2Activity.this));
                try {
                    AreaService areaService = ApiFac.getAreaService();
                    areaService.postCheckedObjects(areasForSend);
                } catch (Exception e) {
                    return false;
                }
                return true;
            }

            @Override
            protected void onPostExecute(Boolean aBoolean) {
                if (aBoolean) {
                    Snackbar.make(view, "success", Snackbar.LENGTH_LONG).show();
                } else {
                    Snackbar.make(view, "failed", Snackbar.LENGTH_LONG).show();
                }
                super.onPostExecute(aBoolean);
            }
        }.execute();
    }
}
