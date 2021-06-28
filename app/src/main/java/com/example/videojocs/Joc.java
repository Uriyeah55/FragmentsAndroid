package com.example.videojocs;


import java.io.Serializable;

public class Joc implements Serializable {

    private String nom;
    private int jugadors;
    private int imatge;

    public Joc (String nom, int jugadors, int imatge)
    {
        this.nom = nom;
        this.jugadors = jugadors;
        this.imatge = imatge;
    }

    public String getNom()
    {
        return nom;
    }

    public int getJugadors()
    {
        return jugadors;
    }

    public int getImatge()
    {
        return imatge;
    }

}
