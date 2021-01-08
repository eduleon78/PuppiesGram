package com.leonestudios.puppiesgram.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.leonestudios.puppiesgram.R;
import com.leonestudios.puppiesgram.pojo.Mascota;

import java.util.ArrayList;

public class PerfilMascotaAdapter extends RecyclerView.Adapter<PerfilMascotaAdapter.PerfilMascotaViewHolder> {

    ArrayList<Mascota> mascotas;
    Activity activity;
    public Mascota mascota;

    public PerfilMascotaAdapter(ArrayList<Mascota> mascotas, Activity activity){
        this.mascotas = mascotas;
        this.activity = activity;
    }

    @NonNull
    @Override
    public PerfilMascotaAdapter.PerfilMascotaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_perfilmascota, parent, false);
        return new PerfilMascotaAdapter.PerfilMascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final PerfilMascotaViewHolder holder, int position) {
        final Mascota mascota = mascotas.get(position);
        holder.imgFoto.setImageResource(mascota.getFoto());
        holder.tvRating.setText(mascota.getRating() + "");
        holder.btnLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int rating = mascota.getRating();
                mascota.setRating( ++rating);
                holder.tvRating.setText(String.valueOf(rating));
                Toast.makeText(activity, "Diste like a " + mascota.getNombre() + "Rating: " + mascota.getRating(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {

        return mascotas.size();
    }
    public static class PerfilMascotaViewHolder extends RecyclerView.ViewHolder{
        private ImageView imgFoto;
        private ImageButton btnLike;
        private TextView tvRating;
        public PerfilMascotaViewHolder(@NonNull View itemView){
            super(itemView);
            imgFoto = (ImageView) itemView.findViewById(R.id.imgFotoCVM);
            btnLike = (ImageButton) itemView.findViewById(R.id.btnLikeCVM);
            tvRating = (TextView) itemView.findViewById(R.id.tvRatingCVM);
        }

    }
}
