package com.njinformatica.centralnoticias;

import android.content.Intent;
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
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

public class MainActivity extends AppCompatActivity implements ClickRecyclerView_Interface {

    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    RecyclerNoticiasAdapter adapter;
    private List<Noticia> noticias = new ArrayList<>();
    private FloatingActionButton floatingActionButton;

    public static final int ACTIVITY_CONSTANT = 55;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        setaRecyclerView();
        setaButtons();
        listenersButtons();

        Noticia noticia;

        noticia = new Noticia();
        noticia.setId("xcv1");
        noticia.setTitulo("Novos carros lançados");
        noticia.setAutor("jthomaz");
        noticias.add(noticia);

        noticia = new Noticia();
        noticia.setId("xc55");
        noticia.setTitulo("Bolsa subiu");
        noticia.setAutor("jthomaz");
        noticias.add(noticia);

        noticia = new Noticia();
        noticia.setId("xc87");
        noticia.setTitulo("Empresas de TI avançam no mercado");
        noticia.setAutor("jthomaz");
        noticias.add(noticia);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            Intent intent = new Intent(this, AboutActivity.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }

    public void setaRecyclerView(){

        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_recyclerteste);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        adapter = new RecyclerNoticiasAdapter(this, noticias, this);
        mRecyclerView.setAdapter(adapter);
    }

    @Override
    public void onCustomClick(Object object) {
        Intent intent = new Intent(this, DetalheNoticiaActivity.class);
        startActivityForResult(intent, ACTIVITY_CONSTANT);
    }

    @Override
    public void onDeleteNoticiaClick(Object object) {
        Noticia noticia;
        Iterator itr = noticias.iterator();
        while (itr.hasNext())
        {
            noticia = (Noticia)itr.next();
            if (noticia.getId().equalsIgnoreCase(((Noticia) object).getId())) {
                itr.remove();
                break;
            }
        }

        adapter.notifyDataSetChanged();

        Toast.makeText(this, "Notícia removida com sucesso!", Toast.LENGTH_SHORT).show();
    }

    public void setaButtons(){
        floatingActionButton = (FloatingActionButton) findViewById(R.id.fab_fabteste);
    }

    public void listenersButtons() {

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(v.getContext(), NovaNoticiaActivity.class);
                startActivity(intent);

                /*
                UUID uuid = UUID.randomUUID();
                String myRandom = uuid.toString();

                Noticia noticia = new Noticia();
                noticia.setId(myRandom.substring(0,4));
                noticia.setTitulo("título da notícia");
                noticia.setAutor("jthomaz");

                noticias.add(noticia);
                adapter.notifyDataSetChanged();
                */
            }
        });
    }
}
