package ie.dam.hw1.quiz_app.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;

import ie.dam.hw1.quiz_app.QuizActivity;
import ie.dam.hw1.quiz_app.R;

public class Quiz1Fragment extends Fragment {
    private final String ANSWER = "GITHUB";
    private static final Integer QUESTION_NUMBER = 1;

    private TextInputEditText answer;
    private Button submitButton;

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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_quiz1, container, false);
        initialiseComponents(view);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String playerAnswer = answer.getText().toString().toUpperCase().trim();
                boolean correctAnswer = false;
                if (playerAnswer.equals(ANSWER)) {
                    correctAnswer = true;
                }
                QuizActivity quizActivity = (QuizActivity) getActivity();
                quizActivity.getPlayerAnswer(QUESTION_NUMBER, correctAnswer);
            }
        });
        return view;
    }


    private void initialiseComponents(View view) {
        answer = view.findViewById(R.id.tecsor_andrei_fragment_q1_tiet);
        submitButton = view.findViewById(R.id.tecsor_andrei_fragment_q1_btn);
    }


}