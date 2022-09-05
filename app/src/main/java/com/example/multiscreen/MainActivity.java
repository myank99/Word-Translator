package com.example.multiscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //find the view that shows number category
        TextView numbers = (TextView)findViewById(R.id.numbers);
        //set a click listener on that view
        numbers.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent numbersIntent = new Intent(MainActivity.this, Numbers.class);
                startActivity(numbersIntent);
            }
        });

        //find the view that shows family members category
        TextView familyMembers = (TextView)findViewById(R.id.familyMember);
        //set a click listener on that view
        familyMembers.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent familyMembersIntent = new Intent(MainActivity.this, FamilyMembers.class);
                startActivity(familyMembersIntent);
            }
        });
        //find the view that shows color category
        TextView color = (TextView)findViewById(R.id.color);
        //set a click listener on that view
        color.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent colorsIntent = new Intent(MainActivity.this, Colors.class);
                startActivity(colorsIntent);
            }
        });
        //find the view that shows phrase category
        TextView phrase = (TextView)findViewById(R.id.phrase);
        //set a click listener on that view
        phrase.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent phraseIntent = new Intent(MainActivity.this, Phrases.class);
                startActivity(phraseIntent);
            }
        });

    }


}
// another way off click intent with xml above is using click listener
//        public void openNumber(View view){
//            Intent i = new Intent(this , Numbers.class);
//            startActivity(i);
//  }