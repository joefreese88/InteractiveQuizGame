/*
*
* File: SingleAnswer.java
* Author: Joseph Donald Freese
* Created: August 2016
* Description: An interactive quiz game that tests the users knowledge on Marvel Studios movies
*
*/

package net.androidbootcamp.interactivequizgame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

// This class displays the layout that will show all questions and perform tasks based on the users input
public class SingleAnswer extends AppCompatActivity {

    // the answers in this array are the true answers and will be compared with the users actual answers to calculate final results
    String[] correctAnswers = {"13", "Doctor Strange ", "6 ", "The Amazing Spiderman ", "Mjolnir ", "Daredevil ", "7", "Steve Rogers ", "Hawkeye ", "Ronan "};

    ArrayList<String> userAnswers = new ArrayList<>();  // users answers will be stored in this list

    // an array that holds explanations on why the other answers are wrong, or why the chosen answer is correct
    String[] explanations = {"There are 13 MCU movies total. There are three Iron Man movies, three Captain America movies, two Thor movies, two Avengers movies, as well as, Guardians of the Galaxy," +
            " Antman, and The Incredible Hulk.","Doctor Strange comes out in November 2016, Iron Man 4 is unknown, Thor: Ragnarok and Guardians 2 come out in 2017.",
            "There are 6 stones. Mind stone, power stone, reality stone, space stone, time stone, and soul stone. Only four have actually been seen in the movies.", "The Amazing Spiderman 1 and 2 were " +
            "standalone movies not connected to any MCU movies.", "Odin and Sif are characters, and there is nothing named Avenger, except the team The Avengers.", "Daredevil " +
            "has his own TV series where the story connects to the MCU movies, but Daredevil has never showed up in an actual MCU movie.", "Iron Man appears in three Iron Man movies, " +
            "two Avengers movies, Captain America: Civil War, and appears in The Incredible Hulk in a post-credits scene.", "Peter Parker is Spiderman, Johnny Blaze is " +
            "Ghost Rider, and John Rogers is not a character.", "Hawkeye was on Captain America's team.", "Loki and Malekith were Thor's villains, and Yellowjacket was Antman's villain."};

    String combineString = "";     // combines all the string explanations together to be passed to the next activity

    // declare radio group and radio buttons
    RadioGroup questionGroup;
    RadioButton radioButtonOne;
    RadioButton radioButtonTwo;
    RadioButton radioButtonThree;
    RadioButton radioButtonFour;

    // declare buttons, edit texts, and text views
    Button next;
    Button submit;
    EditText numberEntry;
    TextView questionNumber;
    TextView questionText;

    int questionCount = 1;  // keeps track of the question the user is on
    int score = 0;  // keeps track of users score
    String selected = "";   // keeps track of the currently selected answer

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_answer);

        // set the buttons and textviews
        next = (Button) findViewById(R.id.next_Btn);
        submit = (Button) findViewById(R.id.Submit_btn);
        numberEntry = (EditText) findViewById(R.id.enterNumber_txt);
        questionNumber = (TextView) findViewById(R.id.number_txt);
        questionText = (TextView) findViewById(R.id.Question_txt);

        // set the radio buttons and radio group
        radioButtonOne = (RadioButton) findViewById(R.id.answerOne_radioBtn);
        radioButtonTwo = (RadioButton) findViewById(R.id.answerTwo_radioBtn);
        radioButtonThree = (RadioButton) findViewById(R.id.answerThree_radioBtn);
        radioButtonFour = (RadioButton) findViewById(R.id.answerFour_radioBtn);
        questionGroup=(RadioGroup)findViewById(R.id.radioGroup);

        // display the first question and make sure only the edit text is displayed so the user can input their answer
        if (questionCount == 1)
        {
            questionText.setText("How many MCU movies are their as of August 2016?");
            radioButtonOne.setVisibility(View.INVISIBLE);
            radioButtonTwo.setVisibility(View.INVISIBLE);
            radioButtonThree.setVisibility(View.INVISIBLE);
            radioButtonFour.setVisibility(View.INVISIBLE);
            radioButtonOne.setHeight(2);
            radioButtonTwo.setHeight(2);
            radioButtonThree.setHeight(2);
            radioButtonFour.setHeight(2);
        }

        // sets the selected answer to the string 'selected' and eventually stores it into the arrayList
        questionGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int i) {
                RadioButton rb = (RadioButton) group.findViewById(i);
                if (null !=rb && i > -1) {
                    selected = rb.getText().toString();
                }
            }
        });

        // when the next button is clicked, the selected user answer is added to the arrayList, and the next question is displayed
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    switch (questionCount) {
                            case 1:

                                // if nothing is input, then a message displays telling the user to input a number before continuing
                                if (numberEntry.getText().toString().isEmpty())
                                {
                                    Toast.makeText(SingleAnswer.this, "Please input a number!", Toast.LENGTH_SHORT).show();
                                }

                                // add to ArrayList and continue to next question
                                else {
                                    userAnswers.add(numberEntry.getText().toString());
                                    numberEntry.setText("");

                                    questionCount++;    // set the count to 2

                                    radioButtonOne.setVisibility(View.VISIBLE);
                                    radioButtonTwo.setVisibility(View.VISIBLE);
                                    radioButtonThree.setVisibility(View.VISIBLE);
                                    radioButtonFour.setVisibility(View.VISIBLE);
                                    numberEntry.setVisibility(View.INVISIBLE);


                                    radioButtonOne.setHeight(32);
                                    radioButtonTwo.setHeight(32);
                                    radioButtonThree.setHeight(32);
                                    radioButtonFour.setHeight(32);

                                    questionText.setText("What is the next MCU movie set for release in 2016?");
                                    questionNumber.setText("" + questionCount);
                                    radioButtonOne.setText("Iron Man 4 ");
                                    radioButtonTwo.setText("Doctor Strange ");
                                    radioButtonThree.setText("Thor:Ragnarok ");
                                    radioButtonFour.setText("Guardians of the Galaxy 2 ");
                                }
                                break;

                            case 2:

                                // if no choice is selected, display a message so the user knows to answer before continuing
                                if (selected.isEmpty())
                                {
                                    Toast.makeText(SingleAnswer.this, "Please make a selection!", Toast.LENGTH_SHORT).show();
                                }

                                // add to ArrayList and continue to next question
                                else {
                                    clearAndDisplay();  // add the first selected answer to the arrayList and clear the checkmark

                                    questionCount++;    // set the count to 2

                                    questionText.setText("How many infinity stones are there?");
                                    questionNumber.setText("" + questionCount);
                                    radioButtonOne.setText("6 ");
                                    radioButtonTwo.setText("3 ");
                                    radioButtonThree.setText("100 ");
                                    radioButtonFour.setText("20 ");
                                }
                                break;

                            case 3:

                                // if no choice is selected, display a message so the user knows to answer before continuing
                                if (selected.isEmpty())
                                {
                                    Toast.makeText(SingleAnswer.this, "Please make a selection!", Toast.LENGTH_SHORT).show();
                                }

                                // add to ArrayList and continue to next question
                                else {
                                    clearAndDisplay();  // add the second selected answer to the arrayList and clear checkmark

                                    questionCount++;    // set the count to 3

                                    questionText.setText("What Movie is not a part of the MCU?");
                                    questionNumber.setText("" + questionCount);
                                    radioButtonOne.setText("The Incredible Hulk ");
                                    radioButtonTwo.setText("Guardians of the Galaxy ");
                                    radioButtonThree.setText("The Amazing Spiderman ");
                                    radioButtonFour.setText("Antman ");
                                }

                                break;

                            case 4:

                                // if no choice is selected, display a message so the user knows to answer before continuing
                                if (selected.isEmpty())
                                {
                                    Toast.makeText(SingleAnswer.this, "Please make a selection!", Toast.LENGTH_SHORT).show();
                                }

                                // add to ArrayList and continue to next question
                                else {
                                    clearAndDisplay();
                                    questionCount++;    // set the count to 3

                                    questionText.setText("What is the name of Thor's hammer?");
                                    questionNumber.setText("" + questionCount);
                                    radioButtonOne.setText("Sif ");
                                    radioButtonTwo.setText("Mjolnir ");
                                    radioButtonThree.setText("Odin ");
                                    radioButtonFour.setText("Avenger ");
                                }

                                break;

                            case 5:

                                // if no choice is selected, display a message so the user knows to answer before continuing
                                if (selected.isEmpty())
                                {
                                    Toast.makeText(SingleAnswer.this, "Please make a selection!", Toast.LENGTH_SHORT).show();
                                }

                                // add to ArrayList and continue to next question
                                else {
                                    clearAndDisplay();

                                    questionCount++;    // set the count to 3

                                    questionText.setText("What character has not appeared in any MCU movie?");
                                    questionNumber.setText("" + questionCount);
                                    radioButtonOne.setText("Spiderman ");
                                    radioButtonTwo.setText("War Machine ");
                                    radioButtonThree.setText("Black Panther ");
                                    radioButtonFour.setText("Daredevil ");
                                }

                                break;

                            case 6:

                                // if no choice is selected, display a message so the user knows to answer before continuing
                                if (selected.isEmpty())
                                {
                                    Toast.makeText(SingleAnswer.this, "Please make a selection!", Toast.LENGTH_SHORT).show();
                                }

                                // add to ArrayList and continue to next question
                                else {
                                    clearAndDisplay();
                                    questionCount++;    // set the count to 3

                                    questionText.setText("How many MCU movies has Iron Man appeared in?");
                                    questionNumber.setText("" + questionCount);
                                    radioButtonOne.setVisibility(View.INVISIBLE);
                                    radioButtonTwo.setVisibility(View.INVISIBLE);
                                    radioButtonThree.setVisibility(View.INVISIBLE);
                                    radioButtonFour.setVisibility(View.INVISIBLE);
                                    numberEntry.setVisibility(View.VISIBLE);

                                    radioButtonOne.setHeight(2);
                                    radioButtonTwo.setHeight(2);
                                    radioButtonThree.setHeight(2);
                                    radioButtonFour.setHeight(2);
                                }

                                break;

                            case 7:

                                // if nothing is input, then a message displays telling the user to input a number before continuing
                                if (numberEntry.getText().toString().isEmpty())
                                {
                                    Toast.makeText(SingleAnswer.this, "Please input a number!", Toast.LENGTH_SHORT).show();
                                }

                                // add to ArrayList and continue to next question
                                else {
                                    questionCount++;

                                    userAnswers.add(numberEntry.getText().toString());
                                    numberEntry.setText("");

                                    radioButtonOne.setVisibility(View.VISIBLE);
                                    radioButtonTwo.setVisibility(View.VISIBLE);
                                    radioButtonThree.setVisibility(View.VISIBLE);
                                    radioButtonFour.setVisibility(View.VISIBLE);

                                    radioButtonOne.setHeight(32);
                                    radioButtonTwo.setHeight(32);
                                    radioButtonThree.setHeight(32);
                                    radioButtonFour.setHeight(32);

                                    numberEntry.setVisibility(View.INVISIBLE);
                                    questionText.setText("What is Captain America's real name?");
                                    questionNumber.setText("" + questionCount);
                                    radioButtonOne.setText("John Rogers ");
                                    radioButtonTwo.setText("Johnny Blaze ");
                                    radioButtonThree.setText("Peter Parker ");
                                    radioButtonFour.setText("Steve Rogers ");
                                }

                                break;

                            case 8:

                                // if no choice is selected, display a message so the user knows to answer before continuing
                                if (selected.isEmpty())
                                {
                                    Toast.makeText(SingleAnswer.this, "Please make a selection!", Toast.LENGTH_SHORT).show();
                                }

                                // add to ArrayList and continue to next question
                                else {
                                    clearAndDisplay();
                                    questionCount++;
                                    questionText.setText("In Captain America: Civil War, what character was not on Iron Mans Team?");
                                    questionNumber.setText("" + questionCount);
                                    radioButtonOne.setText("Hawkeye ");
                                    radioButtonTwo.setText("Black Widow ");
                                    radioButtonThree.setText("War Machine ");
                                    radioButtonFour.setText("Vision ");
                                }
                                break;

                            case 9:

                                // if no choice is selected, display a message so the user knows to answer before continuing
                                if (selected.isEmpty())
                                {
                                    Toast.makeText(SingleAnswer.this, "Please make a selection!", Toast.LENGTH_SHORT).show();
                                }

                                // add to ArrayList and continue to next question
                                else {
                                    clearAndDisplay();
                                    questionCount++;
                                    questionText.setText("Who was the main villain in Guardians of the Galaxy?");
                                    questionNumber.setText("" + questionCount);
                                    radioButtonOne.setText("Yellowjacket ");
                                    radioButtonTwo.setText("Loki ");
                                    radioButtonThree.setText("Ronan ");
                                    radioButtonFour.setText("Malekith ");
                                    next.setVisibility(View.INVISIBLE);
                                    submit.setVisibility(View.VISIBLE);
                                }

                                break;
                        }
                    }
        });

        // click the submit and view results button to go to final screen and display results
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // if no answer to the final question is selected, then display the message so the user can select an answer
                if (selected.isEmpty())
                {
                    Toast.makeText(SingleAnswer.this, "Please make a selection!", Toast.LENGTH_SHORT).show();
                }

                // call the clearAndDisplay() method, then the checkAnswers() method then store the final string and score in an intent to be passed to the Results Activity
                else {
                    clearAndDisplay();

                    checkAnswers();


                    Intent intent = new Intent(SingleAnswer.this, ResultsActivity.class);
                    intent.putExtra("combine_String", combineString);
                    intent.putExtra("final_score", score);
                    startActivity(intent);
                }
            }
        });
    }

    // a quick void method to clear the checkmark from the radio button, add the users answer, and reset the selected answer to null
    public void clearAndDisplay()
    {
        questionGroup.clearCheck();
        userAnswers.add(selected);
        selected = "";
    }

    // a method to compare the user answers with actual answers
    public void checkAnswers()
    {
        // for loop to loop through all users answers and the actual answers
        for (int i = 0; i < 10; i++)
        {
            int addOne = i + 1; // stores the question number to add to the string

            // if the users answer matches the actual answer, then 10 points are added to the score and no explanation is displayed
            if (correctAnswers[i].equals(userAnswers.get(i)))
            {
                combineString = combineString + "Question " + addOne +": CORRECT - 10/10\n\n";
                score = score + 10;
            }

            // otherwise that answer was incorrect. No points are added and an explanation will be displayed for that question in the final results
            else
            {
                combineString = combineString + "Question " + addOne +": INCORRECT - 0/10\n\n" + explanations[i]+"\n\n";
            }
        }
    }
}
