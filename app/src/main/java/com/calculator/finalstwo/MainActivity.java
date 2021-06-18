package com.calculator.finalstwo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    String[] songs, desc, moreInfo;
    String line, entireFile;
    int[] images = {R.drawable.girlslikeyou, R.drawable.harder, R.drawable.whatlovers,
                    R.drawable.wontgohome, R.drawable.payphone, R.drawable.intentions, R.drawable.bohemian};

    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        songs = getResources().getStringArray(R.array.songs);
        moreInfo = getResources().getStringArray(R.array.moreinfo);
        //desc = getResources().getStringArray(R.array.description);

        //intialize desc[] below using the buffer
        desc = new String[]{getLyrics(R.raw.girlslikeyoulyrics), getLyrics(R.raw.hardertobreath),
                            getLyrics(R.raw.whatloversdo), getLyrics(R.raw.wontgohome),
                            getLyrics(R.raw.payphone), getLyrics(R.raw.intentions), getLyrics(R.raw.bohemian)};


        MyAdapter myAdapter = new MyAdapter(this, songs, desc,images, moreInfo);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private String getLyrics(int file) {
        //lines below is from stackoverflow
        InputStream is = getResources().openRawResource(file);
        BufferedReader br = new BufferedReader(new InputStreamReader(is));

        entireFile = "";
        try {
            while((line = br.readLine()) != null) { // <--------- place readLine() inside loop
                entireFile += (line + "\n"); // <---------- add each line to entireFile
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        String result = entireFile;

        return result;
    }
}