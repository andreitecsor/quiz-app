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
import ie.dam.hw1.quiz_app.model.Player;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Quiz2Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Quiz2Fragment extends Fragment {
    private static String PLAYER_KEY = "000_player";
    private final String ANSWER = getString(R.string.answer_q2);
    private static final Integer QUESTION_NUMBER = 2;

    private TextInputEditText answer;
    private Button submitButton;

    public Quiz2Fragment() {
        // Required empty public constructor
    }

    public static Quiz2Fragment newInstance() {
        Quiz2Fragment fragment = new Quiz2Fragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_quiz2, container, false);
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
        answer = view.findViewById(R.id.tecsor_andrei_fragment_q2_tiet);
        submitButton = view.findViewById(R.id.tecsor_andrei_fragment_q2_btn);
    }


}