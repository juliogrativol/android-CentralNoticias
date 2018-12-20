package com.njinformatica.centralnoticias;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.njinformatica.centralnoticias.modelo.Noticia;

public class DetalheNoticiaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_noticia);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if(toolbar != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        Intent myIntent = getIntent(); // gets the previously created intent
        Noticia noticia = (Noticia) myIntent.getSerializableExtra("noticia");

        TextView tituloText = findViewById(R.id.text_titulo_content);
        TextView informativoText = findViewById(R.id.text_informativo_content);
        TextView noticiaText = findViewById(R.id.text_noticia_content);
        TextView dataText = findViewById(R.id.text_data_content);
        TextView autorText = findViewById(R.id.text_autor_content);
        
        tituloText.setText(noticia.getTitulo());
        informativoText.setText(noticia.getInformativo());
        noticiaText.setText(noticia.getNoticia());
        dataText.setText(noticia.getData());
        autorText.setText(noticia.getAutor());
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}