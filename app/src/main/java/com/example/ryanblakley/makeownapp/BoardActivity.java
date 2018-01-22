package com.example.ryanblakley.makeownapp;

import android.app.ListActivity;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BoardActivity extends ListActivity {

    private static int ID = 2;

    public static int getID() {
        return ID;
    }

    public static void setID(int _ID) {
        ID = _ID;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        switch (this.ID) {
            case 0:
                launchJonTron();
                break;
            case 1:
                launchOverwatch();
                break;
            case 2:
                launchMemes();
                break;
            default:
                launchMemes();
                break;
        }
    }

    public void launchJonTron() {
        List<String> options = new ArrayList<String>();
        options = Arrays.asList(getResources().getStringArray(R.array.JT));

        ListAdapter items = new ArrayAdapter<String>(this, R.layout.activity_board, R.id.listItem, options);
        setListAdapter(items);
    }

    public void launchOverwatch() {
        List<String> options = new ArrayList<String>();
        options = Arrays.asList(getResources().getStringArray(R.array.OW));

        ListAdapter items = new ArrayAdapter<String>(this, R.layout.activity_board, R.id.listItem, options);
        setListAdapter(items);
    }

    public void launchMemes() {
        List<String> options = new ArrayList<String>();
        options = Arrays.asList(getResources().getStringArray(R.array.M));

        ListAdapter items = new ArrayAdapter<String>(this, R.layout.activity_board, R.id.listItem, options);
        setListAdapter(items);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK)) {
            setID(2);
            finish();
        }
        return super.onKeyDown(keyCode, event);
    }

    protected void onListItemClick(ListView lv, View v, int position, long id) {
        Intent intent = new Intent(this, BoardActivity.class);
        Intent intentText = new Intent(this, TextSpeechActivity.class);
        MediaPlayer mp = new MediaPlayer();

        if (mp.isPlaying()) {
            mp.stop();
        }


        try {
            mp.reset();

            switch (position) {
                case 0:
                    if (getID() == 0) {
                        //do jontron
                        mp = MediaPlayer.create(this,R.raw.jontronfavorite);
                    } else if (getID() == 1) {
                        //do overwatch
                        mp = MediaPlayer.create(this,R.raw.overwatchboop);
                    } else {
                        //do meme
                        mp = MediaPlayer.create(this,R.raw.mememissed);
                    }
                    break;
                case 1:
                    if (getID() == 0) {
                        //do jontron
                        mp = MediaPlayer.create(this,R.raw.jontronfree);
                    } else if (getID() == 1) {
                        //do overwatch
                        mp = MediaPlayer.create(this,R.raw.overwatchhealing);
                    } else {
                        //do meme
                        mp = MediaPlayer.create(this,R.raw.memenani);
                    }
                    break;
                case 2:
                    if (getID() == 0) {
                        //do jontron
                        mp = MediaPlayer.create(this,R.raw.jontrongetit);
                    } else if (getID() == 1) {
                        //do overwatch
                        mp = MediaPlayer.create(this,R.raw.overwatchcurious);
                    } else {
                        //do meme
                        mp = MediaPlayer.create(this,R.raw.memeohno);
                    }
                    break;
                case 3:
                    if (getID() == 0) {
                        //do jontron
                        mp = MediaPlayer.create(this,R.raw.jontronscary);
                    } else if (getID() == 1) {
                        //do overwatch
                        mp = MediaPlayer.create(this,R.raw.overwatchhithere);
                    } else {
                        //do meme
                        mp = MediaPlayer.create(this,R.raw.memeora);
                    }
                    break;
                case 4:
                    if (getID() == 0) {
                        //do jontron
                        mp = MediaPlayer.create(this,R.raw.jontronten);
                    } else if (getID() == 1) {
                        //do overwatch
                        mp = MediaPlayer.create(this,R.raw.overwatchpeanutbutter);
                    } else {
                        //do meme
                        mp = MediaPlayer.create(this,R.raw.memepregante);
                    }
                    break;
                default:
                    if (getID() == 0) {
                        //do jontron
                        mp = MediaPlayer.create(this,R.raw.jontronfavorite);
                    } else if (getID() == 1) {
                        //do overwatch
                        mp = MediaPlayer.create(this,R.raw.overwatchboop);
                    } else {
                        //do meme
                        mp = MediaPlayer.create(this,R.raw.mememissed);
                    }
                    break;
            }

            mp.start();

        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
