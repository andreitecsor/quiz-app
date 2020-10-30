package ie.dam.hw1.quiz_app.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ie.dam.hw1.quiz_app.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Quiz1Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Quiz1Fragment extends Fragment {


    public Quiz1Fragment() {
        // Required empty public constructor
    }


    public static Quiz1Fragment newInstance() {
        Quiz1Fragment fragment = new Quiz1Fragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_quiz1, container, false);
    }
}