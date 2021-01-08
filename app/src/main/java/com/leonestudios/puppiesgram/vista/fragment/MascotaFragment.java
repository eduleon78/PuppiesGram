package com.leonestudios.puppiesgram.vista.fragment;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.leonestudios.puppiesgram.R;
import com.leonestudios.puppiesgram.adapter.PerfilMascotaAdapter;
import com.leonestudios.puppiesgram.pojo.Mascota;

import java.util.ArrayList;

public class MascotaFragment extends Fragment {

    ArrayList<Mascota> mascotas;
    private RecyclerView listamascotas;
    public PerfilMascotaAdapter adaptadormascota;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public MascotaFragment() {

    }
    public static MascotaFragment newInstance (String mParam1, String mParam2) {
        MascotaFragment fragment = new MascotaFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, mParam1);
        args.putString(ARG_PARAM2, mParam2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null){
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_mascota, container, false);
        listamascotas = (RecyclerView) v.findViewById(R.id.rvMascotas);
        GridLayoutManager llmmascotas = new GridLayoutManager(getActivity(), 3);
        listamascotas.setLayoutManager(llmmascotas);
        iniciarListaMascotas();
        iniciarAdaptador();
        return v;
    }
    public void iniciarAdaptador(){
        adaptadormascota = new PerfilMascotaAdapter(mascotas, getActivity());
        listamascotas.setAdapter(adaptadormascota);
    }
    public void iniciarListaMascotas(){
        mascotas = new ArrayList<Mascota>();
        mascotas.add(new Mascota("Capitan", 2, R.drawable.capitan));
        mascotas.add(new Mascota("George", 4, R.drawable.george));
        mascotas.add(new Mascota("Leon", 5, R.drawable.leon));
        mascotas.add(new Mascota("Pluto", 1, R.drawable.pluto));
        mascotas.add(new Mascota("Tobby", 3, R.drawable.tobby));
    }

}
