package com.example.multiscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class Colors extends AppCompatActivity {
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
        setContentView(R.layout.activity_colors);



            ArrayList<word> colorsList = new ArrayList<word>();//created a  list object

        colorsList.add(new word("Red", "Laal ",R.drawable.red,R.raw.red));
        colorsList.add(new word("Blue", "Neela ",R.drawable.blue,R.raw.blue));
        colorsList.add(new word("Green", "Haraa ",R.drawable.green,R.raw.green));
        colorsList.add(new word("Yellow", "Peela ",R.drawable.yellow,R.raw.yellow));
        colorsList.add(new word("Black", "Kaala",R.drawable.black,R.raw.black));
        colorsList.add(new word("White", "Safed ",R.drawable.white,R.raw.white));
        colorsList.add(new word("Pink", "Gulabi ",R.drawable.pink,R.raw.pink));
        colorsList.add(new word("Maroon", "Laal ",R.drawable.maroon,R.raw.red));
        colorsList.add(new word("Brown", "Bhura ",R.drawable.brown,R.raw.brown));

            //creating adapter object
        // this word adapter we have created java file of this separately
            wordAdapter adapter = new wordAdapter(this , colorsList);
            // CAsting list view to link java and xml
            ListView list = (ListView) findViewById(R.id.list);
            //calling adapter in list XMl
            list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                word w = colorsList.get(position);
                releaseMediaPlayer();
                mediaPlayer = MediaPlayer.create(Colors.this,w.getmAudioId());
                mediaPlayer.start();
            }
        });
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
