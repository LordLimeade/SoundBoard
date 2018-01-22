package com.example.ryanblakley.makeownapp;

import android.content.Intent;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Locale;

public class TextSpeechActivity extends AppCompatActivity implements TextToSpeech.OnInitListener {

    private int MY_DATA_CHECK_CODE = 0;
    private TextToSpeech myTTS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_speech);

        createListeners();


        Intent checkTTSIntent = new Intent();
        checkTTSIntent.setAction(TextToSpeech.Engine.ACTION_CHECK_TTS_DATA);
        startActivityForResult(checkTTSIntent, MY_DATA_CHECK_CODE);
    }

    private void createListeners() {
        Button speakButton = (Button)findViewById(R.id.talk);
        Button defaultOne = findViewById(R.id.defaultOne);
        Button defaultTwo = findViewById(R.id.defaultTwo);
        Button defaultThree = findViewById(R.id.defaultThree);
        Button defaultFour = findViewById(R.id.defaultFour);

        speakButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText enteredText = findViewById(R.id.speak);
                String words = enteredText.getText().toString();

                speakWords(words);
            }
        });


        defaultOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String words = getString(R.string.hello);
                speakWords(words);
            }
        });
        defaultTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String words = getString(R.string.bye);
                speakWords(words);
            }
        });
        defaultThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String words = getString(R.string.yes);
                speakWords(words);
            }
        });
        defaultFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String words = getString(R.string.no);
                speakWords(words);
            }
        });
    }


    public void speakWords(String words){
        //myTTS.speak(words, TextToSpeech.QUEUE_ADD, null);
        myTTS.speak(words, TextToSpeech.QUEUE_ADD, null, null);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == MY_DATA_CHECK_CODE) {
            if (resultCode == TextToSpeech.Engine.CHECK_VOICE_DATA_PASS) {
                myTTS = new TextToSpeech(this, this);
            }
            else {
                Intent installTTSIntent = new Intent();
                installTTSIntent.setAction(TextToSpeech.Engine.ACTION_INSTALL_TTS_DATA);
                startActivity(installTTSIntent);
            }
        }

    }

    public void onInit(int initStatus) {
        if (initStatus == TextToSpeech.SUCCESS) {
            myTTS.setLanguage(Locale.US);
            if(myTTS.isLanguageAvailable(Locale.US)==TextToSpeech.LANG_AVAILABLE) myTTS.setLanguage(Locale.US);
        }
        else if (initStatus == TextToSpeech.ERROR) {
            Toast.makeText(this, "Sorry! Text To Speech failed...", Toast.LENGTH_LONG).show();
        }
    }
}
