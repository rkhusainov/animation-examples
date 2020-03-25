package com.khusainov.rinat.animationdemo.shared_element_transition;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.khusainov.rinat.animationdemo.R;
import com.khusainov.rinat.animationdemo.shared_element_transition.fragment.SharedElementTransitionFragment;

public class SharedElementFragmentContainerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_element_fragment_container);

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.container, SharedElementTransitionFragment.newInstance())
                .commit();
    }
}
