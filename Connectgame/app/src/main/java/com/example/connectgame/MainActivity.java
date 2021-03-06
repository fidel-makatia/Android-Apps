package com.example.connectgame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int activePlayer=0;
    int[] gameState={2,2,2,2,2,2,2,2,2};
    int [][] winningPos={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    boolean gameActive=true;
    //0 is yellow 1 is red, 2: empty state



    public void dropin(View view) {
        ImageView counter = (ImageView) view;



        int tappedCounter = Integer.parseInt(counter.getTag().toString());
        if (gameState[tappedCounter] == 2 && gameActive==true) {


            gameState[tappedCounter] = activePlayer;
            counter.setTranslationY(-1500);
            if (activePlayer == 0) {
                counter.setImageResource(R.drawable.yellow);
                activePlayer = 1;

            } else {
                counter.setImageResource(R.drawable.red);
                activePlayer = 0;
            }

            counter.animate().translationYBy(1500).rotation(3600).setDuration(300);
            for (int[] winning : winningPos) {
                if (gameState[winning[0]] == gameState[winning[1]] && gameState[winning[1]] == gameState[winning[2]] && gameState[winning[0]] != 2) {
                    //Somene has won
                    String winner = "";
                    if (activePlayer == 1) {
                        winner = "Yellow";
                        gameActive=false;
                    } else {
                        winner = "Red";
                        gameActive=false;
                    }
                    Toast.makeText(this, winner + " has won", Toast.LENGTH_SHORT).show();
                    Button playagain=(Button) findViewById(R.id.PlayAgainbutton);
                    TextView winnertext=(TextView) findViewById(R.id.winnertextView);

                    winnertext.setText(winner + " has won");
                    winnertext.setVisibility(View.VISIBLE);
                    playagain.setVisibility(View.VISIBLE);

                }
            }

        }
    }
    public  void playAgain(View view){

        Button playagain=(Button) findViewById(R.id.PlayAgainbutton);
        TextView winnertext=(TextView) findViewById(R.id.winnertextView);


        winnertext.setVisibility(View.INVISIBLE);
        playagain.setVisibility(View.INVISIBLE);

      GridLayout gridLayout=(GridLayout) findViewById(R.id.gridView1);
        //GridView gridLayout=(GridView) findViewById(R.id.gridView1);
        for(int i=0; i<gridLayout.getChildCount();i++)
        {
            ImageView counter=(ImageView) gridLayout.getChildAt(i);
            counter.setImageDrawable(null);
        }



//         for(int i=0;i<gameState.length;i++)
//         {
//             gameState[i]=2;
//         }

        gameActive=true;
        activePlayer=0;

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}