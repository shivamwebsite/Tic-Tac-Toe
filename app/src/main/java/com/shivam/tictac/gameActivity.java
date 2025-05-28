package com.shivam.tictac;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class gameActivity extends AppCompatActivity {

    String message1="";
    String message2="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        Intent intent = getIntent();
        message1 = intent.getStringExtra(MainActivity.MSG1);
        message2 = intent.getStringExtra(MainActivity.MSG2);

        // Set text inside textview to message
//        TextView textView1 = findViewById(R.id.textView2);
//        textView1.setText(message1);
//        TextView textView2 = findViewById(R.id.textView3);
//        textView2.setText(message2);
    }

    boolean gameactive=true;
    int activeplayer=0;
    int [] gamestate={2,2,2,2,2,2,2,2,2};
    String winstr;
    int i=0;
    int [][] winpositions={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};


    public void playerTap(View view){

        i=i+1;
        ImageView img=(ImageView) view;
//        if(!gameactive)
//        {
//            gamereset(view);
//        }
        if(gameactive) {
            int tapedimage = Integer.parseInt(img.getTag().toString());
            if (gamestate[tapedimage] == 2) {
                gamestate[tapedimage] = activeplayer;
                img.setTranslationY(-1000f);
                if (activeplayer == 0) {
                    img.setImageResource(R.drawable.cross);
                    activeplayer = 1;
                    TextView status = findViewById(R.id.status);
                    status.setText(message2 +"  Turn - Tap to play");
                } else {
                    img.setImageResource(R.drawable.zero);
                    activeplayer = 0;
                    TextView status = findViewById(R.id.status);
                    status.setText(message1 +"  Turn - Tap to play");
                }
                img.animate().translationYBy(1000f).setDuration(300);
            }
            for (int[] winposition : winpositions) {
                if (gamestate[winposition[0]] == gamestate[winposition[1]] &&
                        gamestate[winposition[1]] == gamestate[winposition[2]] &&
                        gamestate[winposition[0]] != 2) {
                    gameactive = false;
                    if (gamestate[winposition[0]] == 0) {
                        winstr = message1 +" has won";
                    } else {
                        winstr = message2 +" has won";
                    }
                    TextView status = findViewById(R.id.status);
                    status.setText(winstr);
                }
            }
            if(i==9 && gameactive==true){
                TextView status = findViewById(R.id.status);
                status.setText("Match Draw..");
            }
        }
    }
    public void gamereset(View view)
    {
        gameactive=true;
        activeplayer=0;
        gamestate= new int[]{2, 2, 2, 2, 2, 2, 2, 2, 2};
        ((ImageView)findViewById(R.id.imageView0)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView1)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView2)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView8)).setImageResource(0);
    }
    public void reset(View view)
    {

        gameactive=true;
        activeplayer=0;
        i=0;
        TextView status = findViewById(R.id.status);
        status.setText(message1 + "  Start The Game !!\n");
        gamestate= new int[]{2, 2, 2, 2, 2, 2, 2, 2, 2};
        ((ImageView)findViewById(R.id.imageView0)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView1)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView2)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView8)).setImageResource(0);
    }

}