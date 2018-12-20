package com.njinformatica.centralnoticias.service;

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by macbook on 19/12/2018.
 */

public class NoticiaService extends AsyncTask<Void, Void, String> {


    @Override
    protected String doInBackground(Void... voids) {
        HttpURLConnection urlConnection = null;
        BufferedReader reader = null;
        StringBuffer buffer = null;

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

        return buffer.toString();
    }

    @Override
    protected void onPostExecute(String dados) {
        // Faça alguma coisa com os dados
    }
}
