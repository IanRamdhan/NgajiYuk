package com.fryanramzkhar.ngajiyuk;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailSurah extends AppCompatActivity {

    @BindView(R.id.txtSurah)
    TextView txtSurah;
    Boolean start = false;
    MediaPlayer mPlayer;
    Uri uri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_surah);
        ButterKnife.bind(this);

        txtSurah.setText(getIntent().getStringExtra("ds"));

        Toolbar toolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        Intent pindah;

        switch (item.getItemId()) {
            case R.id.profile:
                pindah = new Intent(this, Profile.class);
                startActivity(pindah);
                break;
            case R.id.about:
                pindah = new Intent(this, About.class);
                startActivity(pindah);
                break;
            case R.id.play:
                if (start != true) {
                    uri = Uri.parse("android.resource://" + getPackageName() + "/" + getIntent().getIntExtra("ss", 0));
                    mPlayer = new MediaPlayer();
//                    mPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
                    try {
                        mPlayer.setDataSource(this, uri);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    try {
                        mPlayer.prepare();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    mPlayer.start();
                    start = true;
                    Toast.makeText(this, "Playing Murattal", Toast.LENGTH_SHORT).show();
                }

                break;
            case R.id.stop:
                mPlayer.stop();
                start = false;
                Toast.makeText(this, "Stop Murattal", Toast.LENGTH_SHORT).show();
                break;

        }
        return super.onOptionsItemSelected(item);
    }
}
