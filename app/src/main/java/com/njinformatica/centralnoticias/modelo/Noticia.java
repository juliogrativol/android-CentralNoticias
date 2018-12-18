package com.njinformatica.centralnoticias.modelo;

/**
 * Created by jthomaz on 18/12/2018.
 */

public class Noticia {

    private String autor;
    private String data;
    private String informativo;
    private String noticia;
    private String titulo;

    public Noticia(){

    }

    public Noticia(String autor, String data, String informativo, String noticia, String titulo) {
        this.autor = autor;
        this.data = data;
        this.informativo = informativo;
        this.noticia = noticia;
        this.titulo = titulo;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getInformativo() {
        return informativo;
    }

    public void setInformativo(String informativo) {
        this.informativo = informativo;
    }

    public String getNoticia() {
        return noticia;

    }

    public void setNoticia(String noticia) {
        this.noticia = noticia;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }
}