package com.example.myrandomngame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    // NOTE : i used the first Clicklistner on startbutton via XML File just to show you both ways
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void startaGame(View view) {

        //TODO Elmente aus View in Vars schreiben
        Button startgame = (Button) findViewById(R.id.startbutton);
        Button lsg1 = (Button) findViewById(R.id.button1);
        Button lsg2 = (Button) findViewById(R.id.button2);
        Button lsg3 = (Button) findViewById(R.id.button3);
        Button lsg4 = (Button) findViewById(R.id.button4);
        TextView myText = (TextView) findViewById(R.id.textfeld);

        // TODO Countdowntimer

        CountDownTimer mytimer = new CountDownTimer(30000, 1000) {

            public void onTick(long millisUntilFinished) {
                myText.setText("seconds remaining: " + millisUntilFinished / 1000); //TODO mTextField erstellen
            }

            public void onFinish() {
                myText.setText("done! your are to slow");
                lsg1.setText("xxx");
                lsg2.setText("xxx");
                lsg3.setText("xxx");
                lsg4.setText("xxx");
            }
        };

        mytimer.start();

        // TODO generate radnom Numbers and calculate AVG and distanze rand to AVG
        List <Integer> arrayWithNumbers =  new ArrayList<Integer>();
        int avg = 0 ;
        for (int i = 0 ; i <=3 ;i++){
            // fill random numbers
            int aNumber = new Random().nextInt(61);
            Log.i("RandomNumber = " , String.valueOf(aNumber));
            arrayWithNumbers.add(aNumber);
            //
            avg += arrayWithNumbers.get(i);
        }

        // divide
        avg = avg / 4;  // TODO ?  SizeOf? Lenght?

        Log.i("Avarage: ", String.valueOf(avg));

        // Find winning number  (distance AVG to number )
        int winning = 61;
        int won = 0;
        for (int i = 0 ; i <=3 ;i++){
            int distance = Math.abs(avg- arrayWithNumbers.get(i));
            if (distance < winning){
                winning = distance;
                won = arrayWithNumbers.get(i);
            }
        }
        Log.i("Winning Number" , String.valueOf(won));

        // set Buttonstext with generatet numbers
        lsg1.setText(String.valueOf(arrayWithNumbers.get(0)));
        lsg2.setText(String.valueOf(arrayWithNumbers.get(1)));
        lsg3.setText(String.valueOf(arrayWithNumbers.get(2)));
        lsg4.setText(String.valueOf(arrayWithNumbers.get(3)));

        // TODO  Generate Eventlistener on Buttons1-4
        int finalWon = won;
        lsg1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               if (Integer.valueOf((String) lsg1.getText()) == finalWon){
                   // timer stop
                   mytimer.cancel();
                   myText.setText(" You Won ! Good Guess");
               }
               else {
                   myText.setText(" Fool  ! you dont like numbers?");
                   mytimer.cancel();
               }
            }
        });
        lsg2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Integer.valueOf((String) lsg2.getText()) == finalWon){
                    // timer stop
                    mytimer.cancel();
                    myText.setText(" You Won ! Good Guess");
                }
                else {
                    myText.setText(" Fool  ! you dont like numbers?");
                    mytimer.cancel();
                }
            }
        });
        lsg3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Integer.valueOf((String) lsg3.getText()) == finalWon){
                    // timer stop
                    mytimer.cancel();
                    myText.setText(" You Won ! Good Guess");
                }
                else {
                    myText.setText(" Fool  ! you dont like numbers?");
                    mytimer.cancel();
                }
            }
        });
        lsg4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Integer.valueOf((String) lsg4.getText()) == finalWon){
                    // timer stop
                    mytimer.cancel();
                    myText.setText(" You Won ! Good Guess");
                }
                else {
                    myText.setText(" Fool  ! you dont like numbers?");
                    mytimer.cancel();
                }
            }
        });


        }

    }