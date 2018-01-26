package com.example.tapos.magitionapplication.adpaters;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.tapos.magitionapplication.R;
import com.example.tapos.magitionapplication.models.Magic;

public class DetailActivity extends AppCompatActivity {

    private Magic mMagic;
    private TextView titleText;
    private TextView detailText;
    private ImageView mImageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Bundle bundle = getIntent().getExtras();
        if (!bundle.isEmpty())
            mMagic = (Magic) bundle.getSerializable("magic");
        initializeViews();

        // toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // add back arrow to toolbar
        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
    }

    private void initializeViews() {
        titleText = findViewById(R.id.magic_title);
        detailText = findViewById(R.id.magic_details);
        mImageView = findViewById(R.id.magic_image);
    }

    @Override
    protected void onResume() {
        super.onResume();
        updateUI();
    }

    private void updateUI() {
        titleText.setText(mMagic.getTitle());
        detailText.setText(mMagic.getDescription());
        Glide.with(this).load(mMagic.getThumbnail()).into(mImageView);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // handle arrow click here
        if (item.getItemId() == android.R.id.home) {
            finish(); // close this activity and return to preview activity (if there is any)
        }

        return super.onOptionsItemSelected(item);
    }
}
