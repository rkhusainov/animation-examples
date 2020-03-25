package com.khusainov.rinat.animationdemo.shared_element_transition;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.view.ViewCompat;

import com.khusainov.rinat.animationdemo.R;

public class SharedElementTransitionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_element_transition);

        final ImageView androidImageView = findViewById(R.id.android_image_view);

        androidImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SharedElementTransitionActivity.this, SharedElementTransitionSecondActivity.class);
                ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(
                        SharedElementTransitionActivity.this,
                        androidImageView,
                        ViewCompat.getTransitionName(androidImageView)
                );
                startActivity(intent, options.toBundle());
            }
        });
    }
}
