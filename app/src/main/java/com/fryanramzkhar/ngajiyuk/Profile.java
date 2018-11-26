package com.fryanramzkhar.ngajiyuk;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Profile extends AppCompatActivity {

    @BindView(R.id.fb)
    Button fb;
    @BindView(R.id.ig)
    Button ig;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        ButterKnife.bind(this);


    }

    @OnClick({R.id.fb, R.id.ig})
    public void onViewClicked(View view) {
        Intent implicit;
        switch (view.getId()) {
            case R.id.fb:
                implicit = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/ian.ramdhan.7"));
                startActivity(implicit);
                break;
            case R.id.ig:
                implicit = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/fkrnsyah30_/?hl=id"));
                startActivity(implicit);
                break;
        }
    }
}
