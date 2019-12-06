package com.baxter.jokeview;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class JokerFragment extends Fragment {

    public static final String JOKE_ID = "joke";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_joker, container, false);
        TextView textView = view.findViewById(R.id.joke);

        assert getArguments() != null;
        String joke = getArguments().getString(JOKE_ID);
        textView.setText(joke);

        return view;
    }
}
