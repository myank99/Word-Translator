package com.example.multiscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class Numbers extends AppCompatActivity {
    private MediaPlayer mediaPlayer;


    private MediaPlayer.OnCompletionListener mComplitonListner = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp) {

            releaseMediaPlayer();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);


        //create and setup the audio manger to request audio focus
        final ArrayList<word> numbersList = new ArrayList<word>();//created a number list object

        numbersList.add(new word("One", "Ek",R.drawable.onee,R.raw.one));
        numbersList.add(new word("Two", "Do",R.drawable.two,R.raw.two));
        numbersList.add(new word("Three", "Teen",R.drawable.three,R.raw.three));
        numbersList.add(new word("Four", "Chaar",R.drawable.four,R.raw.four));
        numbersList.add(new word("Five", "Panch",R.drawable.five,R.raw.five));
        numbersList.add(new word("Six", "Cheh",R.drawable.six,R.raw.six));
        numbersList.add(new word("Seven", "Saat",R.drawable.seven,R.raw.seven));
        numbersList.add(new word("Eight", "Aath",R.drawable.eight,R.raw.eight));
        numbersList.add(new word("Nine", "Nau",R.drawable.nine,R.raw.nine));
        numbersList.add(new word("Ten", "Das",R.drawable.ten,R.raw.ten));

        wordAdapter adapter = new wordAdapter(this , numbersList);

        ListView list = (ListView) findViewById(R.id.list);

        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                word w = numbersList.get(position);
                //here we are releasing resources so that if we tap on another audio
                //while one audio is playing then we another gets played and the first
                /// one gets imiditly stopped
                releaseMediaPlayer();
                // Request audio focus for playback

                //intitializing and starting the audio
                mediaPlayer = MediaPlayer.create(Numbers.this,w.getmAudioId());
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(mComplitonListner);
            }
        });
    }
    //here we are stopping the media that is being played if the app is shut down
    //withot it being copmpleted it haults the audio then and there
    //here we have used the concept of activity life cycle
    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }

    /**
     * Clean up the media player by releasing its resources.
     */
    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mediaPlayer.release();


            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mediaPlayer = null;
        }
    }

}


//        ArrayAdapter<word> itemsAdapter = new ArrayAdapter<word>(this, R.layout.list_item, numbersList);
//
//        ListView listView = (ListView) findViewById(R.id.list);
//
//        listView.setAdapter(itemsAdapter);

//        numbersList.add("One");
//        numbersList.add("Two");
//        numbersList.add("Three");
//        numbersList.add("Four");
//        numbersList.add("Five");
//        numbersList.add("Six");
//        numbersList.add("Seven");
//        numbersList.add("Eight");
//        numbersList.add("Nine");
//        numbersList.add("Ten");

        // using for loop to print the data
        //LinearLayout rootView = (LinearLayout)findViewById(R.id.rootView);
//        for(int i =0;i<=9;i++){
//            TextView wordView = new TextView(this);
//            wordView.setText(numbersList.get(i));
//            rootView.addView(wordView);
//        }
        // Using while loop
        //        int i = 0;
//        while(i!=10){
//        TextView wordView = new TextView(this);
//        wordView.setText(numbersList.get(i));
//        rootView.addView(wordView);
//        i+=1;
//        }
