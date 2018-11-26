package com.fryanramzkhar.ngajiyuk;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class AdapterSurah extends RecyclerView.Adapter<AdapterSurah.ViewHolder>{
    Context context;
    int[] gambarNgaji;
    int[] suaraSurah;
    String[] namaSurah,detailSurah,remarksSurah;

    public AdapterSurah(Context context, int[] gambarNgaji, String[] namaSurah, String[] detailSurah, String[] remarksSurah, int[] suaraSurah) {
        this.context = context;
        this.gambarNgaji = gambarNgaji;
        this.namaSurah = namaSurah;
        this.detailSurah = detailSurah;
        this.suaraSurah = suaraSurah;
        this.remarksSurah = remarksSurah;
    }
    @NonNull
    @Override
    public AdapterSurah.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_ngaji,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterSurah.ViewHolder viewHolder, final int i) {
        viewHolder.txtNamaSurah.setText(namaSurah[i]);
        viewHolder.txtRemarks.setText(remarksSurah[i]);
        Glide.with(context).load(gambarNgaji[0]).into(viewHolder.imgNgaji);


        viewHolder.btnBaca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pindah = new Intent(context, DetailSurah.class);
                pindah.putExtra("ns",namaSurah[i]);
                pindah.putExtra("ds",detailSurah[i]);
                pindah.putExtra("gs", gambarNgaji[0]);
                pindah.putExtra("ss", suaraSurah[i]);
                context.startActivity(pindah);
            }
        });

    }

    @Override
    public int getItemCount() {
        return namaSurah.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtNamaSurah;
        TextView txtRemarks;
        ImageView imgNgaji;
        Button btnBaca;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            btnBaca = itemView.findViewById(R.id.btn_set_baca);
            txtNamaSurah = itemView.findViewById(R.id.tv_item_name);
            imgNgaji = itemView.findViewById(R.id.tv_item_photo);
            txtRemarks = itemView.findViewById(R.id.tv_item_remarks);
        }
    }
}
