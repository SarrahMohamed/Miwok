package com.example.hp.miwok;

import android.content.Context;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Build;
import android.provider.UserDictionary;
import android.support.annotation.RequiresApi;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {
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
        setContentView(R.layout.activity_numbers);
        final ArrayList<Word> numberArrayList = new ArrayList<Word>();
        numberArrayList.add(new Word("lutti", "one", R.drawable.one, R.raw.number_one));
        numberArrayList.add(new Word("otiiko", "two", R.drawable.two, R.raw.number_two));
        numberArrayList.add(new Word("tolookosu", "three", R.drawable.three, R.raw.number_three));
        numberArrayList.add(new Word("oyyisa", "four", R.drawable.four, R.raw.number_four));
        numberArrayList.add(new Word("massokka", "five", R.drawable.five, R.raw.number_five));
        numberArrayList.add(new Word("temmokka", "six", R.drawable.six, R.raw.number_six));
        numberArrayList.add(new Word("kenekaku", "seven", R.drawable.seven, R.raw.number_seven));
        numberArrayList.add(new Word("kawinta", "eight", R.drawable.eight, R.raw.number_eight));
        numberArrayList.add(new Word("wo’e", "nine", R.drawable.nine, R.raw.number_nine));
        numberArrayList.add(new Word("na’aacha", "ten", R.drawable.ten, R.raw.number_ten));
        WordAdapter adapter = new WordAdapter(this, numberArrayList, R.color.category_numbers);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Word word = numberArrayList.get(position);
                releaseMediaPlayer();
                mediaPlayer = MediaPlayer.create(NumbersActivity.this, word.getAudioResourceId());
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(mCompletionListener);
            }
        });

    }

    @Override
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
