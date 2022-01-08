package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.CharacterPickerDialog;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = (TextView)findViewById(R.id.text);
        //Create a list of colors in the color resource in file colors.xml
        int[] projectColors = getResources().getIntArray(R.array.projectColors);


        //User can tap a button to change the text color of the label
        findViewById(R.id.changeTextColorButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int randomColor = projectColors[new Random().nextInt(projectColors.length)];
                //change the text color of the label
//                textView.setTextColor(getResources().getColor(R.color.red));
                textView.setTextColor(randomColor);
            }
        });

        //User can tap a button to change the color of the background view
        findViewById(R.id.changeViewColorButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int randomColor = projectColors[new Random().nextInt(projectColors.length)];
//                findViewById(R.id.parent).setBackgroundColor(getResources().getColor(R.color.light_purple));
                findViewById(R.id.parent).setBackgroundColor(randomColor);
            }
        });


        //User can tap on the background view to reset all views to default settings

        findViewById(R.id.parent).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 1. Reset the text to "Hello from Trang!" id - @id/text
                textView.setText("Hello from Trang!");
                // 2. Reset the text color
                //      original color = black, text id - @id/text
                textView.setTextColor(getResources().getColor(R.color.black));
                // 3. Reset the background color
                //      original color = R.color.mint
                findViewById(R.id.parent).setBackgroundColor(getResources().getColor(R.color.teal));
            }
        });



        //User can tap a button to change the text string of the label - Android is Awesome!
        //User can tap the “Change text string” button to update the label with the text from the text field
        findViewById(R.id.changeTextButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Update the label with the text from the text field
                String userEnteredText = ((EditText)findViewById(R.id.editText)).getText().toString();

                //If the text field is empty, update label with default text string (Android is Awesome!)
                if (userEnteredText.isEmpty()){
                    textView.setText("Android is Awesome!");
                }
                else {
                    textView.setText(userEnteredText);
                }

                ((EditText) findViewById(R.id.editText)).setText("");

            }
        });


    }
}