package com.example.hp.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {
    MediaPlayer mediaPlayer;
    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            // Now that the sound file has finished playing, release the media player resources.
            releaseMediaPlayer();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_family);
        final ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("father", "әpә", R.drawable.father, R.raw.family_father));
        words.add(new Word("mother", "әṭa", R.drawable.mother, R.raw.family_mother));
        words.add(new Word("son", "angsi", R.drawable.son, R.raw.family_son));
        words.add(new Word("daughter", "tune", R.drawable.daughter, R.raw.family_daughter));
        words.add(new Word("older brother", "taachi", R.drawable.olderbrother, R.raw.family_older_brother));
        words.add(new Word("younger brother", "chalitti", R.drawable.youngerbrother, R.raw.family_younger_brother));
        words.add(new Word("older sister", "teṭe", R.drawable.oldersister, R.raw.family_older_sister));
        words.add(new Word("younger sister", "kolliti", R.drawable.youngesister, R.raw.family_younger_sister));
        words.add(new Word("grandmother ", "ama", R.drawable.grandmother, R.raw.family_grandmother));
        words.add(new Word("grandfather", "paapa", R.drawable.grandfather, R.raw.family_grandfather));
        WordAdapter adapter = new WordAdapter(this, words, R.color.category_family);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Word word = words.get(position);
                releaseMediaPlayer();
                mediaPlayer = MediaPlayer.create(FamilyActivity.this, word.getAudioResourceId());
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(mCompletionListener);
            }

        });
    }

    protected void onStop() {
        super.onStop();
        // When the activity is stopped, release the media player resources because we won't
        // be playing any more sounds.
        releaseMediaPlayer();
    }

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
