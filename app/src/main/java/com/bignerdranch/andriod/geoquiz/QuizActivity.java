package com.bignerdranch.andriod.geoquiz;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity {
    private Button mTrueButton;
    private Button mFalseButton;

    //    private ImageButton mNextButton;
//    private ImageButton mPreButton;
    private Button mNextButton;
    private Button mPreButton;
    private TextView mQestionTextView;
    private int mCurrentIndex = 0;
    private Question[] mQuestionBank = new Question[]{
            new Question(R.string.question_oceans, true),
            new Question(R.string.question_afica, false),
            new Question(R.string.question_americas, true),
            new Question(R.string.question_text, false)
    };
    private static final String TAG = "QuizActivity";

    private void updataQuestion() {
        int question = mQuestionBank[mCurrentIndex].getTextResId();
        mQestionTextView.setText(question);
    }

    private void checkQuestion(boolean userPressTrue) {
        boolean answerisTrue = mQuestionBank[mCurrentIndex].isAnswerTrue();
        int messageResId = 0;
        if (answerisTrue == userPressTrue) {
            messageResId = R.string.true_toast;
        } else {
            messageResId = R.string.false_toast;
        }
        Toast.makeText(this, messageResId, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "onStart() called");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "onPause() called");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "onResume called");
    }
    @Override
    public void onStop(){
        super.onStop();
        Log.d(TAG,"onStop called");
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy called");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        Log.d(TAG, "onCreate(Buddle) called");

        mQestionTextView = (TextView) findViewById(R.id.question_text_view);
        updataQuestion();

        mTrueButton = (Button) findViewById(R.id.true_button);
        mFalseButton = (Button) findViewById(R.id.false_button);
        mNextButton = (Button) findViewById(R.id.next_button);
        mPreButton = (Button) findViewById(R.id.pre_button);
//        mNextButton = (ImageButton) findViewById(R.id.next_button);
//        mPreButton = (ImageButton) findViewById(R.id.pre_button);
        mTrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(QuizActivity.this, R.string.true_toast, Toast.LENGTH_SHORT).show();
                checkQuestion(true);
            }
        });
        mFalseButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //Toast.makeText(QuizActivity.this, R.string.false_toast, Toast.LENGTH_SHORT).show();
                checkQuestion(false);
            }
        });
        mNextButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mCurrentIndex = (mCurrentIndex + 1) % mQuestionBank.length;
                updataQuestion();

            }
        });
        mPreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*
                 * %取余数操作，左边小于右边，取左边，左边大于右边，取余数
                 * */
                mCurrentIndex = (mCurrentIndex + mQuestionBank.length - 1) % mQuestionBank.length;
                updataQuestion();
            }
        });
        mQestionTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*
                 * %取余数操作，左边小于右边，取左边，左边大于右边，取余数
                 * */
                mCurrentIndex = (mCurrentIndex + 1) % mQuestionBank.length;
                updataQuestion();
            }
        });

    }
}
