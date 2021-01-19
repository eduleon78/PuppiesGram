package com.leonestudios.puppiesgram.RestApi;

import com.leonestudios.puppiesgram.pojo.Contacto;

import java.util.ArrayList;

public class ContactoResponse {
    ArrayList<Contacto> contactos;

    public ArrayList<Contacto> getContactos() {
        return contactos;
    }
    public void setContactos(ArrayList<Contacto> contactos) {
        this.contactos = contactos;
    }
}
