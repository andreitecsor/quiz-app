package ie.dam.hw1.quiz_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import ie.dam.hw1.quiz_app.model.Player;

import static ie.dam.hw1.quiz_app.MainActivity.PLAYER_KEY;

public class ResultActivity extends AppCompatActivity {
    private TextView totalAnswers;
    private TextView bravoMessage;
    private ProgressBar progressBar;
    private Button playAgainBtn;
    private Button newPlayerBtn;
    private Intent intent;
    private Player player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        intent = getIntent();
        player = (Player) intent.getSerializableExtra(PLAYER_KEY);
        initialiseComponents();
        updatePlayerStats(player);
        playAgainBtn.setOnClickListener(playAgain());
        newPlayerBtn.setOnClickListener(createNewPlayer());
    }

    private View.OnClickListener createNewPlayer() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newGame = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(newGame);
                finish();
            }
        };
    }

    private View.OnClickListener playAgain() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newGame = new Intent(getApplicationContext(), QuizActivity.class);
                for (Integer key : player.getAnswers().keySet()) {
                    player.getAnswers().put(key, null);
                }
                newGame.putExtra(PLAYER_KEY, player);
                startActivity(newGame);
                finish();
            }
        };
    }

    private void initialiseComponents() {
        totalAnswers = findViewById(R.id.tecsor_andrei_result_tv);
        progressBar = findViewById(R.id.tecsor_andrei_result_pg);
        progressBar.setProgress(0);
        bravoMessage = findViewById(R.id.tecsor_andrei_result_bravo);
        playAgainBtn = findViewById(R.id.tecsor_andrei_result_btn_play_again);
        newPlayerBtn = findViewById(R.id.tecsor_andrei_result_btn_change_nickname);
    }

    private void updatePlayerStats(Player player) {
        totalAnswers.setText(String.valueOf(totalCorrectAnswers(player)) + "/3");
        String initialMessage = bravoMessage.getText().toString();
        progressBar.setProgress(0);
        bravoMessage.setText(initialMessage.replace("user", player.getNickname()));
        int progress = (totalCorrectAnswers(player) == 3) ? 100 : (totalCorrectAnswers(player) * (100 / 3));
        progressBar.setProgress(progress);
    }

    private int totalCorrectAnswers(Player player) {
        int total = 0;
        for (Integer key : player.getAnswers().keySet()) {
            if (player.getAnswers().get(key) == true) {
                total += 1;
            }
        }
        return total;
    }
}