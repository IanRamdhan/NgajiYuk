package com.fryanramzkhar.ngajiyuk;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecycleSurah extends AppCompatActivity {

    @BindView(R.id.myRecycleView)
    RecyclerView myRecycleView;

    String[] namaSurah,detailSurah,remarksSurah;
    int[] gambarNgaji;
    int[] suaraSurah;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_surah);
        ButterKnife.bind(this);

        namaSurah = getResources().getStringArray(R.array.nama_surat);
        detailSurah = getResources().getStringArray(R.array.isi_surat);
        gambarNgaji = new int[]{R.drawable.lambang};
        suaraSurah = new int[]{R.raw.naba,R.raw.naziat,R.raw.abasa,R.raw.takwir,R.raw.infithar,R.raw.muthaffifin,R.raw.insyiqaq,R.raw.buruj,R.raw.thaariq,R.raw.alaa,R.raw.ghasiyyah,R.raw.fajr,R.raw.balad,R.raw.syams,R.raw.lail,R.raw.duhaa,R.raw.insyirah,R.raw.tiin,R.raw.alaq,R.raw.qadr,R.raw.bayyinah,R.raw.zalzalah,R.raw.adiyat,R.raw.qariah,R.raw.takatsur,R.raw.asr,R.raw.humazah,R.raw.fiil,R.raw.quraisy,R.raw.maun,R.raw.kautsar,R.raw.kafiruun,R.raw.nasr,R.raw.lahab,R.raw.ikhlas,R.raw.falaq,R.raw.naas};
        remarksSurah = getResources().getStringArray(R.array.remarks_surat);


        AdapterSurah adapter = new AdapterSurah(RecycleSurah.this,gambarNgaji,namaSurah,detailSurah,remarksSurah,suaraSurah);
        myRecycleView.setHasFixedSize(true);
        myRecycleView.setLayoutManager(new LinearLayoutManager(RecycleSurah.this));
        myRecycleView.setAdapter(adapter);

    }
}
