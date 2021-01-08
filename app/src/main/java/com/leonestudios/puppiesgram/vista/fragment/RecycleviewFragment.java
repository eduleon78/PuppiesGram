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

import com.leonestudios.puppiesgram.R;
import com.leonestudios.puppiesgram.adapter.ContactoAdaptador;
import com.leonestudios.puppiesgram.pojo.Contacto;
import com.leonestudios.puppiesgram.presentador.IRecyclerViewFragmentPresenter;
import com.leonestudios.puppiesgram.presentador.RecyclerViewFragmentPresenter;

import java.util.ArrayList;

public class RecycleviewFragment extends Fragment implements IRecyclerViewFragmentView{
    private ArrayList<Contacto> Contactos;
    private RecyclerView rvContactos;
    private IRecyclerViewFragmentPresenter presenter;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        /*return super.onCreateView(inflater, container, savedInstanceState);*/
        View v = inflater.inflate(R.layout.fragment_recycleview, container, false);

        rvContactos = (RecyclerView) v.findViewById(R.id.rvContactos);
        presenter = new RecyclerViewFragmentPresenter(this, getContext());
        return v;
    }

    /*
    public void inicializarListaContactos(){
        contactos = new ArrayList<Contacto>();
        contactos.add(new Contacto("Eduardo Leon", "0424-8587119", "eduleon78@gmail.com", R.drawable.rayo));
        contactos.add(new Contacto("Sonyram Acosta", "0414-7941202", "eduleon78@gmail.com", R.drawable.rayo));
        contactos.add(new Contacto("Grecia Santoro", "0412-1968613", "eduleon78@gmail.com", R.drawable.rayo));
        contactos.add(new Contacto("Leander Leon", "260412-7947949", "eduleon78@gmail.com", R.drawable.rayo));
        contactos.add(new Contacto("Christian Leon", "0412-7947949", "eduleon78@gmail.com", R.drawable.rayo));
        contactos.add(new Contacto("Mary Suarez", "0424-8643160", "eduleon78@gmail.com", R.drawable.rayo));


    }*/

    //listo
    @Override
    public void generarLinearLayoutVertical() {
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rvContactos.setLayoutManager(llm);

    }

    @Override
    public ContactoAdaptador crearAdaptador(ArrayList<Contacto> contactos) {
        ContactoAdaptador adaptador = new ContactoAdaptador(contactos, getActivity() );
        return adaptador;
    }

    @Override
    public void inicializarAdaptadorRV(ContactoAdaptador adaptador) {
        rvContactos.setAdapter(adaptador);

    }
}
