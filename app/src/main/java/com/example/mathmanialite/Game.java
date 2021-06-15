package com.example.mathmanialite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class Game extends AppCompatActivity {

    TextView score;
    TextView life;
    TextView time;
    TextView question;

    EditText answer;

    Button ok;
    Button next;
    Random random = new Random();

    int number1;
    int number2;
    int userAnswer;
    int realAnswer;
    int userScore = 0;
    int userLife = 3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        score = findViewById(R.id.textViewScore);
        life = findViewById(R.id.textViewLife);
        time = findViewById(R.id.textViewTime);
        question = findViewById(R.id.textViewQuestion);
        answer = findViewById(R.id.editTextAnswer);
        ok = findViewById(R.id.buttonOk);
        next = findViewById(R.id.buttonNext);

        gameContinue();

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                userAnswer = Integer.valueOf(answer.getText().toString());
                if(userAnswer == realAnswer){

                    userScore = userScore + 10;
                    score.setText("" + userScore);
                    question.setText("Congratulations, Your answer is correct!");

                }else{

                    userLife = userLife - 1;
                    life.setText("" + userLife);
                    question.setText("I'm sorry, Your answer is incorrect!");

                }

            }

    });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                answer.setText("");
                gameContinue();

            }
        });
    }

    public void gameContinue(){

        number1 = random.nextInt(100);
        number2 = random.nextInt(100);

        realAnswer = number1 + number2;

        question.setText(number1 + "+" + number2);

    }
}