package com.njinformatica.centralnoticias.dto;

import com.njinformatica.centralnoticias.modelo.Noticia;

/**
 * Created by jthomaz on 20/12/2018.
 */

public class ListaNoticiasDTO {

    private Noticia[] noticias;

    public Noticia[] getNoticias() {
        return noticias;
    }

    public void setNoticias(Noticia[] noticias) {
        this.noticias = noticias;
    }
}
