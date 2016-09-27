package edu.orangecoastcollege.cs273.ocmusicevents;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class EventListActivity extends ListActivity {

    private ListView titleListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_event_list);

        titleListView = (ListView) findViewById(R.id.eventListView);
        setListAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, MusicEvent.titles));

    }


    @Override
    protected void onListItemClick(ListView l, View v, int pos, long id)
    {
        String title = MusicEvent.titles[pos];
        String details = MusicEvent.details[pos];

        Intent detailsIntent = new Intent(this, EventDetailsActivity.class);
        detailsIntent.putExtra("Title", title);
        detailsIntent.putExtra("Details", details);

        startActivity(detailsIntent);
    }
}
