package com.leonestudios.puppiesgram.presentador;

import android.content.Context;
import android.telecom.Call;
import android.util.Log;
import android.widget.Toast;

import com.leonestudios.puppiesgram.RestApi.ContactoResponse;
import com.leonestudios.puppiesgram.RestApi.EndpointsApi;
import com.leonestudios.puppiesgram.adapter.ContactoAdaptador;
import com.leonestudios.puppiesgram.adapter.RestApiAdapter;
import com.leonestudios.puppiesgram.db.ContructorContactos;
import com.leonestudios.puppiesgram.pojo.Contacto;
import com.leonestudios.puppiesgram.vista.fragment.IRecyclerViewFragmentView;

import java.util.ArrayList;

import retrofit2.Callback;
import retrofit2.Response;

public class RecyclerViewFragmentPresenter implements IRecyclerViewFragmentPresenter {

    private IRecyclerViewFragmentView iRecyclerViewFragmentView;
    private Context context;
    private ContructorContactos contructorContactos;
    private ArrayList<Contacto> contactos;

    public RecyclerViewFragmentPresenter(IRecyclerViewFragmentView iRecyclerViewFragmentView, Context context){
        this.iRecyclerViewFragmentView = iRecyclerViewFragmentView;
        this.context = context;
        //obtenerContactosBaseDatos();
        obtenerMediosRecientes();

    }

    @Override
    public void obtenerContactosBaseDatos() {
        contructorContactos = new ContructorContactos(context);
        contactos = contructorContactos.obtenerDatos();
        mostrarContactosRV();

    }

    @Override
    public void obtenerMediosRecientes() {
        RestApiAdapter restApiAdapter = new RestApiAdapter();
        EndpointsApi endpointsApi = restApiAdapter.establecerConexionesRestApiInstagram();
        Call contactoResponseCall = endpointsApi.getRecentMedia();

        contactoResponseCall.equals(new Callback<ContactoResponse>() {
            @Override
            public void onResponse(retrofit2.Call<ContactoResponse> call, Response<ContactoResponse> response) {
                ContactoResponse contactoResponse = response .body();
                contactos = contactoResponse.getContactos();
                mostrarContactosRV();

            }

            @Override
            public void onFailure(retrofit2.Call<ContactoResponse> call, Throwable t) {
                Toast.makeText(context, "!Algo pasó en la conexion! Intenta de nuevo", Toast.LENGTH_SHORT).show();
                Log.e("FALLO LA CONEXION", t.toString());

            }
        });

    }

    @Override
    public void mostrarContactosRV() {
        iRecyclerViewFragmentView.inicializarAdaptadorRV(iRecyclerViewFragmentView.crearAdaptador(contactos));
        iRecyclerViewFragmentView.generarGridLayoutVertical();

    }
}
