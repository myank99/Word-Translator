package com.example.multiscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class Phrases extends AppCompatActivity {
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
        setContentView(R.layout.activity_phrases);

        ArrayList<word> phraseList = new ArrayList<word>();//created a number list object

        phraseList.add(new word("Capital punishment", "Maut Ki Saja",R.raw.p1));
        phraseList.add(new word(" Close shave", "Baal Baal Bachana",R.raw.p2));
        phraseList.add(new word("Dead of light", "Adhik Raat Ko",R.raw.p3));
        phraseList.add(new word("Done to death", "Maar Daalna",R.raw.p4));
        phraseList.add(new word("Fall to one's lot", "Nasseb M Hoona",R.raw.p5));
        phraseList.add(new word("Gain ground", "Dhire Dhire Pragati Karna",R.raw.p6));
        phraseList.add(new word("Get even with", "Badla Lena",R.raw.p7));
        phraseList.add(new word("Get through with", "Kaam Pura Karna",R.raw.p8));
        phraseList.add(new word("Give a peace of mind", "Kosna",R.raw.p9));


        wordAdapter adapter = new wordAdapter(this , phraseList);

        ListView list = (ListView) findViewById(R.id.list);

        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                word w = phraseList.get(position);
                releaseMediaPlayer();
                mediaPlayer = MediaPlayer.create(Phrases.this,w.getmAudioId());
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