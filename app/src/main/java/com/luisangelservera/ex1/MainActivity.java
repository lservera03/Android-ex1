package com.luisangelservera.ex1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.luisangelservera.ex1.business.Question;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TextView questionText;
    private TextView numPointsText;

    private Button trueButton;
    private Button falseButton;
    private Button tryAgainButton;

    private ArrayList<Question> questions = new ArrayList<>();

    private int questionsDone = 0;
    private int points = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadQuestions();

        questionText = (TextView) findViewById(R.id.question_view);
        numPointsText = (TextView) findViewById(R.id.num_points_text);
        trueButton = (Button) findViewById(R.id.true_button);
        falseButton = (Button) findViewById(R.id.false_button);
        tryAgainButton = (Button) findViewById(R.id.try_again_button);

        trueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkQuestion(true);
            }
        });

        falseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkQuestion(false);
            }
        });

        tryAgainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                restart();
            }
        });

        questionText.setText(questions.get(questionsDone).getQuestion());
        numPointsText.setText(String.valueOf(points));
    }

    private void checkQuestion(boolean input) {
        Toast toast;

        if (questions.get(questionsDone).isTrue() == input) {
            toast = Toast.makeText(MainActivity.this, R.string.correct_toast, Toast.LENGTH_SHORT);
            points++;
            numPointsText.setText(String.valueOf(points));
        } else {
            toast = Toast.makeText(MainActivity.this, R.string.incorrect_toast, Toast.LENGTH_SHORT);
        }

        toast.setGravity(Gravity.TOP | Gravity.CENTER, 0, 0);
        toast.show();

        changeQuestion();
    }

    private void changeQuestion() {
        questionsDone++;

        if (questionsDone < questions.size()) {
            questionText.setText(questions.get(questionsDone).getQuestion());
        } else {
            trueButton.setVisibility(View.INVISIBLE);
            falseButton.setVisibility(View.INVISIBLE);
            tryAgainButton.setVisibility(View.VISIBLE);
            questionText.setText(R.string.end_game_text);
        }

    }

    private void loadQuestions() {

        questions.add(new Question(R.string.first_question_text, true));
        questions.add(new Question(R.string.second_question_text, false));
        questions.add(new Question(R.string.third_question_text, false));
        questions.add(new Question(R.string.fourth_question_text, true));
        questions.add(new Question(R.string.fifth_question_text, true));

    }

    private void restart() {
        points = 0;
        questionsDone = 0;

        trueButton.setVisibility(View.VISIBLE);
        falseButton.setVisibility(View.VISIBLE);
        tryAgainButton.setVisibility(View.INVISIBLE);

        questionText.setText(questions.get(questionsDone).getQuestion());
        numPointsText.setText(String.valueOf(points));
    }

}