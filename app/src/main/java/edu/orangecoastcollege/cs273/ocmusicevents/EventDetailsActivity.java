package edu.orangecoastcollege.cs273.ocmusicevents;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

public class EventDetailsActivity extends AppCompatActivity {

    private TextView titleTextView;
    private TextView detailsTextView;
    private ImageView artistImageView;

    // In order to use AssetManager, need to know Context;
    private Context context = (Context) this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_details);

        titleTextView = (TextView) findViewById(R.id.titleTextView);
        detailsTextView = (TextView) findViewById(R.id.detailsTextView);
        artistImageView = (ImageView) findViewById(R.id.artistImageView) ;

        Intent intentFromEventListActivity = getIntent();

        String titleText = intentFromEventListActivity.getStringExtra("Title");
        String detailsText = intentFromEventListActivity.getStringExtra("Details");
        String imageFileName = titleText.replace(" ","") + ".jpeg";

        titleTextView.setText(titleText.toString());
        detailsTextView.setText(detailsText.toString());

        // Load the image from Assets folder
        AssetManager am = context.getAssets();

        // Try to load image file
        try {
            InputStream stream = am.open(imageFileName);
            Drawable image = Drawable.createFromStream(stream, titleText);
            artistImageView.setImageDrawable(image);
        }
        catch (IOException ex) {
            Log.e("", "" + imageFileName + ex);
        }
    }
}
