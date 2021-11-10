package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import  android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity{

    //declare variables
    Button trueBTN;
    Button falseBTN;
    int score;
    Button finishedBTN;
    TextView questionTV;
    Question q1;
    Question q2;
    Question q3;
    Question q4;
    Question q5;

    @Override
  protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);

      //initialize our variables & infinite our UI elements
        trueBTN = (Button) findViewById(R.id.trueBTN);
        falseBTN = (Button) findViewById(R.id.falseBTN);
        finishedBTN = (Button) findViewById(R.id.finishedBTN);
        questionTV = (TextView) findViewById(R.id.questionTV);
        score = 0;

        q1 = new Question("Icecram is made with milk and flour", false );
        q2 = new Question("Dogs like IceCream", true);
        q3 = new Question("IceCream can support the sun", false);
        q4 = new Question("strawberry IceCream is color pink", true);
        q5 = new Question("kids can eat IceCream", true);

        //set true button onClickListener
        trueBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = getApplicationContext();
                CharSequence text = "WRONG";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();




            }
        });
        falseBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = getApplicationContext();
                CharSequence text = "RIGHT";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();

                score = score + 1;


            }
        });
        finishedBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(MainActivity.this, ScoreActivity.class);
                myIntent.putExtra("score", score);
                startActivity(myIntent);
            }
        });


  }

}
