package com.example.ryanblakley.makeownapp;

import android.app.ListActivity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class NavigationActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ArrayList<String> options = new ArrayList<String>();

        options.add(getString(R.string.jontron));
        options.add(getString(R.string.overwatch));
        options.add(getString(R.string.memes));
        options.add(getString(R.string.toSpeech));
        options.add(getString(R.string.iFunny));
        options.add(getString(R.string.reddit));
        options.add(getString(R.string.youtube));

        ListAdapter items = new ArrayAdapter<String>(this, R.layout.activity_navigation, R.id.listItem, options);
        setListAdapter(items);

        //for(int i=0 ; i<items.getCount() ; i++){
        //    Object obj = items.getItem(i);
        //}
    }

    protected void onListItemClick(ListView lv, View v, int position, long id){
        Intent intent = new Intent(this, BoardActivity.class);
        Intent intentText = new Intent(this, TextSpeechActivity.class);

        switch(position){
            case 0:
                BoardActivity.setID(position);
                startActivity(intent);
                break;
            case 1:
                BoardActivity.setID(position);
                startActivity(intent);
                break;
            case 2:
                BoardActivity.setID(position);
                startActivity(intent);
                break;
            case 3:
                startActivity(intentText);
                break;
            case 4:
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://ifunny.co/")));
                break;
            case 5:
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.reddit.com/r/MemeEconomy/")));
                break;
            case 6:
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/")));
                break;
            default:
                break;
        }
    }
}
