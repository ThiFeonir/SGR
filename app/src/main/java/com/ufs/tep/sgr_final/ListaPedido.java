package com.ufs.tep.sgr_final;


import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.ufs.tep.sgr_final.adapters.PedidoAdapter;
import com.ufs.tep.sgr_final.database.Pedido;

import java.util.ArrayList;

public class ListaPedido extends Fragment implements AdapterView.OnItemClickListener, DialogInterface.OnClickListener, View.OnClickListener {
    private ListView lstPedidos;
    private FloatingActionButton fbtAdicionar;
    private ArrayList<Pedido> p;
    private PedidoAdapter pAdapter;
    private int selected, mesa;

    public ListaPedido() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_lista_pedido, container, false);

        Bundle b = getArguments();
        mesa = b.getInt("mesa");

        selected = -1;

        p = new ArrayList();

        p.add(new Pedido(1, "Cerveja 1", 2, 6.5));
        p.add(new Pedido(2, "Cerveja 2", 2, 6.5));
        p.add(new Pedido(3, "Cerveja 3", 2, 6.5));
        p.add(new Pedido(4, "Cerveja 4", 2, 6.5));
        p.add(new Pedido(5, "Cerveja 5", 2, 6.5));

        pAdapter = new PedidoAdapter(this.getContext(), p);

        lstPedidos = (ListView) view.findViewById(R.id.lstPedidos);
        fbtAdicionar = (FloatingActionButton) view.findViewById(R.id.fbtAdicionar);

        lstPedidos.setAdapter(pAdapter);
        lstPedidos.setOnItemClickListener(this);
        fbtAdicionar.setOnClickListener(this);
        return view;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.getContext());

        builder.setTitle("Opções");
        builder.setItems(new CharSequence[]{"Editar", "Remover"}, this);
        builder.show();

        selected = position;
    }

    @Override
    public void onClick(DialogInterface dialog, int which) {
        if (which == 0) {
            Bundle b = new Bundle();
            b.putInt("mesa", mesa);

            Utils.toBack.push(new ListaPedido());
            Utils.fragmentData.push(b);

            b = new Bundle();
            b.putInt("tipo", 0);
            b.putInt("id", p.get(selected).getId());

            Utils.openFragment(getFragmentManager(), new NovoPedido(), b);
        } else
            remover();
    }

    private void remover() {
        p.remove(selected);
        lstPedidos.setAdapter(pAdapter);
    }

    @Override
    public void onClick(View v) {
        Bundle b = new Bundle();
        b.putInt("mesa", mesa);

        Utils.toBack.push(new ListaPedido());
        Utils.fragmentData.push(b);

        b = new Bundle();
        b.putInt("tipo", 1);

        Utils.openFragment(getFragmentManager(), new NovoPedido(), b);
    }
}
