package msh_TETR.my_work.tetr_by_msh;

import android.content.pm.ActivityInfo;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import msh_TETR.my_work.tetr_by_msh.R;

public class FieldActivity extends AppCompatActivity {

    public static FieldActivity fieldActivity;
    public static Field gameField;

    private ConstraintLayout constraintLayout;
    public TextView pointView;

    private float startX;
    private float startY;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_field);

        fieldActivity = FieldActivity.this;

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        gameField = new Field();


        pointView = (TextView)findViewById(R.id.textView);
        pointView.setText("Очки: 0");
        constraintLayout = (ConstraintLayout)findViewById(R.id.constraintLayout);
        constraintLayout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(!gameField.gameOver)
                {
                    switch (event.getAction())
                    {
                        case MotionEvent.ACTION_DOWN:
                            startX = event.getX();
                            startY = event.getY();
                            break;
                        case MotionEvent.ACTION_MOVE:
                            break;
                        case MotionEvent.ACTION_UP:
                            chooseSwipe(event.getX(), event.getY());
                            break;
                    }
                }
                return true;
            }
        });
    }

    @Override
    protected void onStop()
    {
        gameField.isInterrupt = true;
        super.onStop();
    }

    @Override
    protected void onStart()
    {
        gameField.isInterrupt = false;
        super.onStart();
    }

    @Override
    protected void onPause()
    {
        gameField.isInterrupt = true;
        super.onPause();
    }

    @Override
    protected void onResume()
    {
        gameField.isInterrupt = false;
        super.onResume();
    }

    @Override
    protected void onRestart()
    {
        gameField.isInterrupt = false;
        super.onRestart();
    }

    @Override
    protected void onDestroy()
    {
        gameField.thread.interrupt();
        super.onDestroy();
    }

    private void chooseSwipe(float finishX, float finishY) {

        if(!gameField.changeFigure && !gameField.currentFigureFirstShow)
        {
            if(startX == finishX && startY == finishY)
                gameField.currentFigure.turnFigure();
            else
            {
                float angle = (finishY - startY)/Math.abs(finishX - startX);

                if(angle > Math.sqrt(3) && Math.sqrt(Math.pow(finishX - startX, 2) + Math.pow(finishY - startY, 2)) > 70)
                    gameField.currentFigure.toDown();
                else
                {
                    angle = Math.abs(finishY - startY)/(finishX - startX);
                    if(angle <= Math.sqrt(3) && angle >= -Math.sqrt(3))
                        gameField.currentFigure.sideSwipe(finishX - startX);
                }
            }
        }
    }

}
