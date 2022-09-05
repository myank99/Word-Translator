package com.example.multiscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyMembers extends AppCompatActivity {
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
        setContentView(R.layout.activity_family_members);
        ArrayList<word> fMList = new ArrayList<word>();//created a number list object

        fMList.add(new word("Dad", "Papa ",R.raw.dad));
        fMList.add(new word("Mom", "Mummy ",R.raw.mom));
        fMList.add(new word("Elder Sister", "Badi Behan ",R.raw.esister));
        fMList.add(new word("Younger Sister", "Choti Behan ",R.raw.ysister));
        fMList.add(new word("Brother", "Bhai ",R.raw.brother));
        fMList.add(new word("Uncle", "Chacha ",R.raw.chacha));
        fMList.add(new word("Grandmother", "Dadi ",R.raw.dadi));
        fMList.add(new word("Grandfather", "Dada ",R.raw.dada));
        fMList.add(new word("Aunt", "Chahchi ",R.raw.chachi));


        wordAdapter adapter = new wordAdapter(this , fMList);

        ListView list = (ListView) findViewById(R.id.list);

        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                word w = fMList.get(position);
                //here we are releasing resources so that if we tap on another audio
                //while one audio is playing then we another gets played and the first
                /// one gets imiditly stopped
                releaseMediaPlayer();
                //here the start is intialized
                mediaPlayer = MediaPlayer.create(FamilyMembers.this,w.getmAudioId());
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