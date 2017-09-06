package com.example.hp.miwok;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        //number intent
        TextView numbertextView=(TextView)findViewById(R.id.numbers);
        numbertextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Numberintent=new Intent(view.getContext(),NumbersActivity.class);
                startActivity(Numberintent);
            }
        });
        //family intent
        TextView familytextView=(TextView)findViewById(R.id.family);
        familytextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent familyintent=new Intent(view.getContext(),FamilyActivity.class);
                startActivity(familyintent);
            }
        });
        //color intent
        TextView colortextView=(TextView)findViewById(R.id.colors);
        colortextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent colorintent=new Intent(view.getContext(),ColorsActivity.class);
                startActivity(colorintent);
            }
        });
        //phrase intent
        TextView phrasetextView=(TextView)findViewById(R.id.phrases);
        phrasetextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent phraseintent=new Intent(view.getContext(),PhraseActivity.class);
                startActivity(phraseintent);
            }
        });
    }
    //////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
