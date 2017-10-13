package com.ufs.tep.sgr_final.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.ufs.tep.sgr_final.R;
import com.ufs.tep.sgr_final.database.Pedido;

import java.util.ArrayList;

public class PedidoAdapter extends ArrayAdapter<Pedido> {
    private final Context context;
    private final ArrayList<Pedido> pedidos;

    public PedidoAdapter(Context context, ArrayList<Pedido> pedidos) {
        super(context, R.layout.pedido_item, pedidos);
        this.context = context;
        this.pedidos = pedidos;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.pedido_item, parent, false);

        TextView lblNomeProduto = (TextView) rowView.findViewById(R.id.lblNomeProduto);
        TextView lblQuantidade  = (TextView) rowView.findViewById(R.id.lblQuantidade);
        TextView lblUsuario     = (TextView) rowView.findViewById(R.id.lblUsuario);
        TextView lblTotal       = (TextView) rowView.findViewById(R.id.lblPrecoTotal);

        Pedido p = pedidos.get(position);

        lblNomeProduto.setText(p.getNome());
        lblQuantidade.setText(String.valueOf("Qtd.: " + p.getQuantidade()));
        lblTotal.setText(String.valueOf( "Total: " + p.getPreco() * p.getQuantidade()));

        return rowView;
    }
}
