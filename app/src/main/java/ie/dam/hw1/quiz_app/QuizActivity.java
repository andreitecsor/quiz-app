package ie.dam.hw1.quiz_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

import ie.dam.hw1.quiz_app.fragments.Quiz1Fragment;

public class QuizActivity extends AppCompatActivity {
    private Fragment currentFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        openFragment(savedInstanceState);
    }

    private void openFragment(Bundle savedInstanceState) {
        if(savedInstanceState == null){
            currentFragment = Quiz1Fragment.newInstance();
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.tecsor_andrei_quiz_frame, currentFragment)
                    .commit();
        }
    }
}