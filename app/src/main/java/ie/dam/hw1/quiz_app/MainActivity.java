package ie.dam.hw1.quiz_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import ie.dam.hw1.quiz_app.fragments.Quiz1Fragment;
import ie.dam.hw1.quiz_app.model.Player;

public class MainActivity extends AppCompatActivity {
    public static final String PLAYER_KEY = "player_key";
    private TextInputEditText tietNickname;
    private Button startBtn;

    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialiseComponents();
        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Player newPlayer = createPlayer();
                if (newPlayer == null) {
                    Toast.makeText(getApplicationContext(),
                            R.string.invalid_nickname,
                            Toast.LENGTH_LONG)
                            .show();
                } else {
                    Intent intent = new Intent(getApplicationContext(), QuizActivity.class);
                    intent.putExtra(PLAYER_KEY, newPlayer);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }

    private void initialiseComponents() {
        startBtn = findViewById(R.id.tecsor_andrei_login_btn);
        tietNickname = findViewById(R.id.tecsor_andrei_login_tiet);
    }

    private Player createPlayer() {
        if (tietNickname.getText().toString().matches("")) {
            return null;
        }
        return new Player((tietNickname.getText().toString().trim()));
    }


}