package com.leonestudios.puppiesgram.vista.fragment;

import com.leonestudios.puppiesgram.adapter.ContactoAdaptador;
import com.leonestudios.puppiesgram.pojo.Contacto;

import java.util.ArrayList;

public interface IRecyclerViewFragmentView {

    public void generarLinearLayoutVertical();

    public ContactoAdaptador crearAdaptador(ArrayList<Contacto> contactos);

    public void inicializarAdaptadorRV(ContactoAdaptador adaptador);
}
