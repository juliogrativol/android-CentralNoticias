package com.njinformatica.centralnoticias;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.njinformatica.centralnoticias.modelo.Noticia;

import java.util.Random;

public class NovaNoticiaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nova_noticia);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if(toolbar != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        Button okButton = findViewById(R.id.btn_nova_noticia);

        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent output = new Intent();
                Noticia noticia = new Noticia();
                Random rand = new Random();
                int n = rand.nextInt(500) + 1;

                TextView textTitulo = findViewById(R.id.text_titulo);
                TextView textInformativo = findViewById(R.id.text_informativo);
                TextView textAutor = findViewById(R.id.text_autor);
                TextView textNoticia = findViewById(R.id.edit_text_noticia);


                noticia.setId(Integer.valueOf(n).toString());
                noticia.setTitulo(textTitulo.getText().toString());
                noticia.setAutor(textAutor.getText().toString());
                noticia.setData("21/01/1981");
                noticia.setInformativo(textInformativo.getText().toString());
                noticia.setNoticia(textNoticia.getText().toString());

                output.putExtra("NOVA_NOTICIA", noticia);
                setResult(RESULT_OK, output);
                finish();
            }
        });
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
