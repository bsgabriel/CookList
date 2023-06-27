package br.ucs.cooklist.model;

import android.graphics.Bitmap;
import android.media.Image;

public class Receita {
    private Bitmap imgReceita;
    private String nomeReceita;
    private String desReceita;

    public Bitmap getImgReceita() {
        return imgReceita;
    }

    public void setImgReceita(Bitmap imgReceita) {
        this.imgReceita = imgReceita;
    }

    public String getNomeReceita() {
        return nomeReceita;
    }

    public void setNomeReceita(String nomeReceita) {
        this.nomeReceita = nomeReceita;
    }

    public String getDesReceita() {
        return desReceita;
    }

    public void setDesReceita(String desReceita) {
        this.desReceita = desReceita;
    }
}
