package msh_TETR.my_work.tetr_by_msh;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import msh_TETR.my_work.tetr_by_msh.R;

public class MainActivity extends AppCompatActivity {

    private Button startPlayButton;
    private Button termfOfGameButton;
    private Button aboutDevelopersButton;
    private Button exitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        startPlayButton = (Button) findViewById(R.id.button1);
        termfOfGameButton = (Button) findViewById(R.id.button2);
        aboutDevelopersButton = (Button) findViewById(R.id.button3);
        exitButton = (Button) findViewById(R.id.button4);

        System.out.print("EEEEEEEEEEEEEEEEEEEEEEEEEEEE");

        startPlayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(".FieldActivity");
                startActivity(intent);
            }
        });

        termfOfGameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(".TermsRulesOfGameActivity");
                startActivity(intent);
            }
        });

        aboutDevelopersButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(".AboutDevelopersActivity");
                startActivity(intent);
            }
        });

        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
