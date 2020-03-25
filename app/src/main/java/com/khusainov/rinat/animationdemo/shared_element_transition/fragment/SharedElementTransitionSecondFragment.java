package com.khusainov.rinat.animationdemo.shared_element_transition.fragment;

import android.os.Bundle;
import android.transition.TransitionInflater;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.khusainov.rinat.animationdemo.R;

public class SharedElementTransitionSecondFragment extends Fragment {

    public static SharedElementTransitionSecondFragment newInstance() {
        return new SharedElementTransitionSecondFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setSharedElementEnterTransition(TransitionInflater
                .from(getContext())
                .inflateTransition(android.R.transition.move));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_shared_element_transition_second, container, false);
    }
}
