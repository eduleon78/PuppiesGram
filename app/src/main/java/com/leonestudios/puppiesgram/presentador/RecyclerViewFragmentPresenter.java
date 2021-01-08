package com.leonestudios.puppiesgram.presentador;

import android.content.Context;

import com.leonestudios.puppiesgram.adapter.ContactoAdaptador;
import com.leonestudios.puppiesgram.db.ContructorContactos;
import com.leonestudios.puppiesgram.pojo.Contacto;
import com.leonestudios.puppiesgram.vista.fragment.IRecyclerViewFragmentView;

import java.util.ArrayList;

public class RecyclerViewFragmentPresenter implements IRecyclerViewFragmentPresenter {

    private IRecyclerViewFragmentView iRecyclerViewFragmentView;
    private Context context;
    private ContructorContactos contructorContactos;
    private ArrayList<Contacto> contactos;

    public RecyclerViewFragmentPresenter(IRecyclerViewFragmentView iRecyclerViewFragmentView, Context context){
        this.iRecyclerViewFragmentView = iRecyclerViewFragmentView;
        this.context = context;
        obtenerContactosBaseDatos();

    }

    @Override
    public void obtenerContactosBaseDatos() {
        contructorContactos = new ContructorContactos(context);
        contactos = contructorContactos.obtenerDatos();
        mostrarContactosRV();

    }

    @Override
    public void mostrarContactosRV() {
        iRecyclerViewFragmentView.inicializarAdaptadorRV(iRecyclerViewFragmentView.crearAdaptador(contactos));
        iRecyclerViewFragmentView.generarLinearLayoutVertical();

    }
}
