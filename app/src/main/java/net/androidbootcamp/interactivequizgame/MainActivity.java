/*
*
* File: MainActivity.java
* Author: Joseph Donald Freese
* Created: August 2016
* Description: The programs startup activity. This class displays the layout
*              showing the quiz rules and gives user the option to start the quiz.
*
*/

package net.androidbootcamp.interactivequizgame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    // declare button
    Button start;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // initialize button to the 'Start Quiz' button
        start = (Button) findViewById(R.id.btnStartQuiz);

        // when the user clicks the "Start Quiz" button, the quiz starts in the SingleAnswer.java class
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SingleAnswer.class);
                startActivity(intent);
            }
        });
    }
}
