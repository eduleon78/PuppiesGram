package com.leonestudios.puppiesgram.db;

import android.content.ContentValues;
import android.content.Context;

import com.leonestudios.puppiesgram.R;
import com.leonestudios.puppiesgram.pojo.Contacto;

import java.util.ArrayList;

public class ContructorContactos {

    private static final int LIKE = 1;
    private Context context;

    public ContructorContactos(Context context){
        this.context = context;
    }


    public ArrayList<Contacto> obtenerDatos(){
        /*ArrayList<Contacto> contactos = new ArrayList<>();
        contactos.add(new Contacto("Eduardo Leon", "0424-8587119", "eduleon78@gmail.com", R.drawable.manzanaaa, 5));
        contactos.add(new Contacto("Sonyram Acosta", "0414-7941202", "eduleon78@gmail.com", R.drawable.pina, 3));
        contactos.add(new Contacto("Grecia Santoro", "0412-1968613", "eduleon78@gmail.com", R.drawable.pera, 8));
        contactos.add(new Contacto("Leander Leon", "260412-7947949", "eduleon78@gmail.com", R.drawable.mushroom, 25));
        contactos.add(new Contacto("Christian Leon", "0412-7947949", "eduleon78@gmail.com", R.drawable.rayo, 25));
        contactos.add(new Contacto("Mary Suarez", "0424-8643160", "eduleon78@gmail.com", R.drawable.rayo, 18));
        return contactos;*/

        BaseDatos db = new BaseDatos(context);
        insertarTresContactos(db);
        return db.obtenerTodosLosContactos();


    }

    public void insertarTresContactos(BaseDatos db){
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_NOMBRE, "Eduardo Leon");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_TELEFONO, "04248587119");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_EMAIL, "eduleon78@gmail.com");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_FOTO, R.drawable.rayo);

        db.insertarContacto(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_NOMBRE, "Sonyram Acosta");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_TELEFONO, "04248587119");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_EMAIL, "sonyacosta@gmail.com");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_FOTO, R.drawable.rayo);

        db.insertarContacto(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_NOMBRE, "Grecia Santoro");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_TELEFONO, "04127947949");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_EMAIL, "grecia@gmail.com");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_FOTO, R.drawable.rayo);

        db.insertarContacto(contentValues);

    }

    public void darLikeContacto(Contacto contacto){
        BaseDatos db = new BaseDatos(context);
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_LIKES_CONTACT_ID_CONTACTO, contacto.getId());
        contentValues.put(ConstantesBaseDatos.TABLE_LIKES_CONTACT_NUMERO_LIKES, LIKE);
        db.insertarLikeContacto(contentValues);

    }

    public int obtenerLikesContacto(Contacto contacto){
        BaseDatos db = new BaseDatos(context);
        return db.obtenerLikesContacto(contacto);

    }
}
