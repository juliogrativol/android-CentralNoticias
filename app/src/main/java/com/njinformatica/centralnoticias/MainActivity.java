package com.njinformatica.centralnoticias;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.njinformatica.centralnoticias.adapter.RecyclerNoticiasAdapter;
import com.njinformatica.centralnoticias.contract.ClickRecyclerView_Interface;
import com.njinformatica.centralnoticias.modelo.Noticia;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ClickRecyclerView_Interface {

    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    RecyclerNoticiasAdapter adapter;
    private List<Noticia> noticias = new ArrayList<>();
    private FloatingActionButton floatingActionButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /*
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        */

        setaRecyclerView();
        setaButtons();
        listenersButtons();

        Noticia noticia;

        noticia = new Noticia();
        noticia.setTitulo("titulo 1");
        noticia.setAutor("jthomaz");
        noticias.add(noticia);

        noticia = new Noticia();
        noticia.setTitulo("titulo 2");
        noticia.setAutor("jthomaz");
        noticias.add(noticia);

        noticia = new Noticia();
        noticia.setTitulo("titulo 3s");
        noticia.setAutor("jthomaz");
        noticias.add(noticia);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void setaRecyclerView(){

        //Aqui é instanciado o Recyclerview
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_recyclerteste);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        adapter = new RecyclerNoticiasAdapter(this, noticias, this);
        mRecyclerView.setAdapter(adapter);
    }

    /**
     * Aqui é o método onde trata o clique em um item da lista
     */
    @Override
    public void onCustomClick(Object object) {
        Toast.makeText(this, ((Noticia) object).getAutor(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDeleteNoticiaClick(Object object) {
        Noticia noticia = (Noticia) object;
        Toast.makeText(this, "delete acionado para a noticia " +noticia.getTitulo(), Toast.LENGTH_SHORT).show();
    }

    public void setaButtons(){
        floatingActionButton = (FloatingActionButton) findViewById(R.id.fab_fabteste);
    }

    /**
     * Chama os listeners para os botões
     */
    public void listenersButtons() {

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Noticia noticia = new Noticia();
                noticia.setTitulo("título da notícia");
                noticia.setAutor("jthomaz");

                noticias.add(noticia);
                adapter.notifyDataSetChanged();
            }
        });
    }
}
