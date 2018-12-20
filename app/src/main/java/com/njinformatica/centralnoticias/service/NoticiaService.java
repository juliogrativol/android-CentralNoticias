package com.njinformatica.centralnoticias.service;

import android.os.AsyncTask;

import com.google.gson.Gson;
import com.njinformatica.centralnoticias.dto.ListaNoticiasDTO;
import com.njinformatica.centralnoticias.modelo.Noticia;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by macbook on 19/12/2018.
 */

public class NoticiaService extends AsyncTask<Void, Void, ListaNoticiasDTO> {


    @Override
    protected ListaNoticiasDTO doInBackground(Void... voids) {
        HttpURLConnection urlConnection = null;
        BufferedReader reader = null;
        StringBuffer buffer = null;
        ListaNoticiasDTO noticias = null;

        try {
            URL url = new URL("https://3zg1cigkpk.execute-api.us-east-1.amazonaws.com/v1/noticias");
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();

            InputStream inputStream = urlConnection.getInputStream();

            reader = new BufferedReader(new InputStreamReader(inputStream));

            String linha;
            buffer = new StringBuffer();
            while((linha = reader.readLine()) != null) {
                buffer.append(linha);
                buffer.append("\n");
            }

            Gson g = new Gson();
            noticias = g.fromJson(buffer.toString(), ListaNoticiasDTO.class);


        } catch (Exception e) {
            e.printStackTrace();
            if (urlConnection != null) {
                urlConnection.disconnect();
            }

            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }

        return noticias;
    }

    @Override
    protected void onPostExecute(ListaNoticiasDTO listaNoticiasDTO) {
        // Faça alguma coisa com os dados
    }
}
