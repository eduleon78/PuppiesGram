package com.leonestudios.puppiesgram.vista.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.leonestudios.puppiesgram.pojo.Mascota;
import com.leonestudios.puppiesgram.adapter.MascotaAdapter;
import com.leonestudios.puppiesgram.R;
import com.leonestudios.puppiesgram.adapter.PerfilMascotaAdapter;

import java.util.ArrayList;

public class MascotasFragment extends Fragment {

    ArrayList<Mascota> mascotas;
    private RecyclerView listamascotas;
    public MascotaAdapter adaptadormascota;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_mascotas, container, false);

        listamascotas = (RecyclerView) v.findViewById(R.id.rvMascotas);
        LinearLayoutManager llmmascotas = new LinearLayoutManager(getActivity());
        llmmascotas.setOrientation(LinearLayoutManager.VERTICAL);
        listamascotas.setLayoutManager(llmmascotas);
        inicializarListaMascota();
        inicializarAdaptador();
        return v;
    }
    public void inicializarAdaptador(){
        adaptadormascota = new MascotaAdapter(mascotas, getActivity());
        listamascotas.setAdapter(adaptadormascota);
    }

    public void inicializarListaMascota(){
        mascotas = new ArrayList<Mascota>();
        mascotas.add(new Mascota("Capitan", 2, R.drawable.capitan));
        mascotas.add(new Mascota("George", 2, R.drawable.george));
        mascotas.add(new Mascota("Leon", 2, R.drawable.leon));
        mascotas.add(new Mascota("Pluto", 2, R.drawable.pluto));
        mascotas.add(new Mascota("Tobby", 2, R.drawable.tobby));
    }
}
