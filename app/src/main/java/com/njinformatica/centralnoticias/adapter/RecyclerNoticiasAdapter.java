package com.njinformatica.centralnoticias.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.njinformatica.centralnoticias.R;
import com.njinformatica.centralnoticias.contract.ClickRecyclerView_Interface;
import com.njinformatica.centralnoticias.modelo.Noticia;

import java.util.List;

/**
 * Created by jthomaz on 18/12/2018.
 */

public class RecyclerNoticiasAdapter extends RecyclerView.Adapter<RecyclerNoticiasAdapter.RecyclerNoticiasViewHolder> {

    public static ClickRecyclerView_Interface clickRecyclerViewInterface;
    Context ctx;
    private List<Noticia> noticias;

    public RecyclerNoticiasAdapter(Context ctx, List<Noticia> list, ClickRecyclerView_Interface clickRecyclerViewInterface) {
        this.ctx = ctx;
        this.noticias = list;
        this.clickRecyclerViewInterface = clickRecyclerViewInterface;
    }

    @Override
    public RecyclerNoticiasViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.noticias_list, viewGroup, false);
        return new RecyclerNoticiasViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(RecyclerNoticiasViewHolder viewHolder, int i) {
        Noticia noticia = noticias.get(i);

        viewHolder.viewTitulo.setText(noticia.getTitulo());
        viewHolder.viewAutor.setText(noticia.getAutor());
    }

    @Override
    public int getItemCount() {
        return noticias.size();
    }


    protected class RecyclerNoticiasViewHolder extends RecyclerView.ViewHolder {

        protected TextView viewTitulo;
        protected TextView viewAutor;

        public RecyclerNoticiasViewHolder(final View itemView) {
            super(itemView);

            viewTitulo = (TextView) itemView.findViewById(R.id.textview_titulo);
            viewAutor = (TextView) itemView.findViewById(R.id.textview_autor);

            //Setup the click listener
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    clickRecyclerViewInterface.onCustomClick(noticias.get(getLayoutPosition()));
                }
            });
        }
    }
}
