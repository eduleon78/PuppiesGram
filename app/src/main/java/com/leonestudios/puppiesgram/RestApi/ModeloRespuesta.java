package com.leonestudios.puppiesgram.RestApi;

public class ModeloRespuesta {
    private String id;
    private String token;

    public ModeloRespuesta(String id, String token) {
        this.id = id;
        this.token = token;
    }

    public ModeloRespuesta() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
