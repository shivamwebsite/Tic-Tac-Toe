package com.shivam.tictac;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public static final String MSG1 = "com.shivam.tictac.player1";
    public static final String MSG2 = "com.shivam.tictac.player2";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void start(View view){
        // We will handle the click on the button here
        //Build an Intent to open another activity
        Intent intent = new Intent(this, gameActivity.class);
        EditText editText1 = findViewById(R.id.editText1);
        EditText editText2 = findViewById(R.id.editText2);
        String message1 = editText1.getText().toString();
        String message2 = editText2.getText().toString();
        intent.putExtra(MSG1, message1);
        intent.putExtra(MSG2, message2);
        startActivity(intent);

    }
}