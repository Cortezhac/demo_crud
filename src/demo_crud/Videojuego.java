/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo_crud;

/**
 *
 * @author JCH
 */
public class Videojuego {
    //Atributos
    private int idvideojuego;
    private String nomvideojuego;
    private String tipovideojuego;
    private String companiavideojuego;

    //Get y Set del id
    public int getIdvideojuego() {
        return idvideojuego;
    }

    public void setIdvideojuego(int idvideojuego) {
        this.idvideojuego = idvideojuego;
    }

    //Get y Set del nombre
    public String getNomvideojuego() {
        return nomvideojuego;
    }

    public void setNomvideojuego(String nomvideojuego) {
        this.nomvideojuego = nomvideojuego;
    }

    //Get y Set del tipo
    public String getTipovideojuego() {
        return tipovideojuego;
    }

    public void setTipovideojuego(String tipovideojuego) {
        this.tipovideojuego = tipovideojuego;
    }

    //Get y Set del compañia
    public String getCompaniavideojuego() {
        return companiavideojuego;
    }

    public void setCompaniavideojuego(String companiavideojuego) {
        this.companiavideojuego = companiavideojuego;
    }
}
