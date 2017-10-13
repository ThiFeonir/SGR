package com.ufs.tep.sgr_final;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.ufs.tep.sgr_final.adapters.GridViewAdapter;
import com.ufs.tep.sgr_final.database.Mesa;

import java.util.ArrayList;

public class SelecionarMesa extends Fragment implements AdapterView.OnItemClickListener {

    private ArrayList<Mesa> gridMesas = new ArrayList<>();
    private int mode = 0;

    public SelecionarMesa() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Bundle b = getArguments();
        mode = b.getInt("mode");
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_selecionar_mesa, container, false);

        GridView gridView = (GridView) view.findViewById(R.id.gridView);
        GridViewAdapter adapter = new GridViewAdapter(gridMesas, getContext());
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(this);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();

        gridMesas.add(new Mesa(51, true));
        gridMesas.add(new Mesa(62, false));
        gridMesas.add(new Mesa(43, false));
        gridMesas.add(new Mesa(84, true));
        gridMesas.add(new Mesa(65, true));
        gridMesas.add(new Mesa(96, false));
        gridMesas.add(new Mesa(47, true));
        gridMesas.add(new Mesa(78, false));
        gridMesas.add(new Mesa(89, true));
        gridMesas.add(new Mesa(910, false));
        gridMesas.add(new Mesa(411, true));
        gridMesas.add(new Mesa(112, false));
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Bundle b;

        if (mode == 0) {
            b = new Bundle();
            b.putInt("mode", 0);

            Utils.toBack.push(new SelecionarMesa());
            Utils.fragmentData.push(b);

            b = new Bundle();
            b.putInt("mesa", gridMesas.get((int) id).getNumero());
            b.putInt("tipo", 1);

            Utils.openFragment(getFragmentManager(), new NovoPedido(), b);
        } else {
            b = new Bundle();
            b.putInt("mesa", gridMesas.get((int) id).getNumero());

            Utils.backToStart();
            Utils.openFragment(getFragmentManager(), new ListaPedido(), b);
        }
    }
}
