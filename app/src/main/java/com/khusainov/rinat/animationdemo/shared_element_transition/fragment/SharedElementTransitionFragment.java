package com.khusainov.rinat.animationdemo.shared_element_transition.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;

import com.khusainov.rinat.animationdemo.R;

public class SharedElementTransitionFragment extends Fragment {

    public static SharedElementTransitionFragment newInstance() {

        return new SharedElementTransitionFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_shared_element_transition, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final ImageView dragonImageView = view.findViewById(R.id.dragon_image_view);
        dragonImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getFragmentManager()
                        .beginTransaction()
                        .addSharedElement(dragonImageView,
                                ViewCompat.getTransitionName(dragonImageView))
                        .addToBackStack(null)
                        .replace(R.id.container, SharedElementTransitionSecondFragment.newInstance())
                        .commit();
            }
        });
    }
}
