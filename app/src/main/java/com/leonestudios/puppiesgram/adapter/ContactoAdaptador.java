package com.leonestudios.puppiesgram.adapter;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.leonestudios.puppiesgram.DetalleContactoActivity;
import com.leonestudios.puppiesgram.R;
import com.leonestudios.puppiesgram.db.ContructorContactos;
import com.leonestudios.puppiesgram.pojo.Contacto;

import java.util.ArrayList;

public class ContactoAdaptador extends RecyclerView.Adapter<ContactoAdaptador.ContactoViewHolder>{

    ArrayList<Contacto> contactos;
    Activity activity;
    public Contacto contac;


    public ContactoAdaptador(ArrayList<Contacto> contactos, Activity activity){
        this.contactos = contactos;
        this.activity  = activity;
    }

    @NonNull
    @Override
    public ContactoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_contacto, parent, false);
        return new ContactoViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final ContactoViewHolder contactoViewHolder, int position) {
        final Contacto contacto = contactos.get(position);
        contactoViewHolder.imgFoto.setImageResource(contacto.getFoto());
        contactoViewHolder.tvNombreCV.setText(contacto.getNombre());
        contactoViewHolder.tvTelefonoCV.setText(contacto.getTelefono());
        contactoViewHolder.tvLikes.setText(String.valueOf(contacto.getLikes()) + "Likes");
        contactoViewHolder.imgFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(activity, contacto.getNombre(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(activity, DetalleContactoActivity.class);
                contac = new Contacto(contacto.getNombre(), contacto.getTelefono(), contacto.getEmail(), contacto.getFoto(), contacto.getLikes());
                intent.putExtra("mycontact", contac);
                activity.startActivity(intent);
            }
        });
        contactoViewHolder.btnLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(activity, "Diste like a " + contacto.getNombre(),
                        Toast.LENGTH_SHORT).show();

                ContructorContactos constructorContactos = new ContructorContactos(activity);
                constructorContactos.darLikeContacto(contacto);
                contactoViewHolder.tvLikes.setText(constructorContactos.obtenerLikesContacto(contacto));
            }
        });
    }

    @Override
    public int getItemCount() {
        return contactos.size();
    }

    public static class ContactoViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgFoto;
        private TextView tvNombreCV;
        private TextView tvTelefonoCV;
        private ImageButton btnLike;
        private TextView tvLikes;

        public ContactoViewHolder(@NonNull View itemView) {
            super(itemView);

            imgFoto             = (ImageView) itemView.findViewById(R.id.imgFoto);
            tvNombreCV          = (TextView) itemView.findViewById(R.id.tvNombreCV);
            tvTelefonoCV        = (TextView) itemView.findViewById(R.id.tvTelefonoCV);
            btnLike             = (ImageButton) itemView.findViewById(R.id.btnLike);
            tvLikes             = (TextView) itemView.findViewById(R.id.tvLikes);
        }
    }


}
