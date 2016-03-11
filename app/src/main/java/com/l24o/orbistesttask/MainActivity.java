package com.l24o.orbistesttask;

import android.os.Bundle;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.l24o.orbistesttask.realm.RealmHelper;
import com.l24o.orbistesttask.retrofit.loaders.OrbisLoader;
import com.l24o.orbistesttask.retrofit.response.Response;

import io.realm.Realm;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Response> {

    private ListView listView;
    private AreaArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.listView);
        adapter = new AreaArrayAdapter(this, RealmHelper.getAreas(Realm.getInstance(this)));
        listView.setAdapter(adapter);
        getSupportLoaderManager().initLoader(R.id.area_loader, null, this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public Loader<Response> onCreateLoader(int id, Bundle args) {
        switch (id) {
            case R.id.area_loader:
                return new OrbisLoader(this);
            default:
                return null;
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.action_name:
                break;
            case R.id.action_population:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onLoadFinished(Loader<Response> loader, Response data) {
        int id = loader.getId();
        if (id == R.id.area_loader) {
            adapter.notifyDataSetChanged();
        }
        getLoaderManager().destroyLoader(id);
    }

    @Override
    public void onLoaderReset(Loader<Response> loader) {

    }
}
