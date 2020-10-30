package ie.dam.hw1.quiz_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

import ie.dam.hw1.quiz_app.fragments.Quiz1Fragment;
import ie.dam.hw1.quiz_app.fragments.Quiz2Fragment;
import ie.dam.hw1.quiz_app.fragments.Quiz3Fragment;
import ie.dam.hw1.quiz_app.model.Player;

import static ie.dam.hw1.quiz_app.MainActivity.PLAYER_KEY;

public class QuizActivity extends AppCompatActivity {
    private Fragment currentFragment;
    private TextView question;
    private ProgressBar progressBar;
    private Intent intent;
    private Player player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        intent = getIntent();
        player = (Player) intent.getSerializableExtra(PLAYER_KEY);
        progressBar = findViewById(R.id.tecsor_andrei_quiz_pg);
        question = findViewById(R.id.tecsor_andrei_quiz_tv);
        question.setText(question.getText() + "1");
        System.out.println(player);
        openFragment(savedInstanceState);
    }

    private void openFragment(Bundle savedInstanceState) {
        if (savedInstanceState == null) {
            currentFragment = Quiz1Fragment.newInstance();
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.tecsor_andrei_quiz_frame, currentFragment)
                    .commit();
        }
    }

    public void getPlayerAnswer(Integer quizNumber, boolean answer) {
        player.getAnswers().put(quizNumber, answer);
        System.out.println(player);
        continueQuiz();
        progressBar.setProgress(quizNumber * (100/3));
        if (player.getAnswers().get(3) != null) {
            progressBar.setProgress(100);
            Intent intentResult = new Intent(getApplicationContext(), ResultActivity.class);
            intentResult.putExtra(PLAYER_KEY, player);
            startActivity(intentResult);
        }
    }

    private void continueQuiz() {
        if (player.getAnswers().get(1) != null && player.getAnswers().get(2) == null) {
            currentFragment = Quiz2Fragment.newInstance();
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.tecsor_andrei_quiz_frame, currentFragment)
                    .commit();
            question.setText(question.getText().toString().replace("1","2"));
        } else {
            if (player.getAnswers().get(2) != null) {
                currentFragment = Quiz3Fragment.newInstance();
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.tecsor_andrei_quiz_frame, currentFragment)
                        .commit();
                question.setText(question.getText().toString().replace("2","3"));
            }
        }
    }
}