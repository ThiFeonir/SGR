package com.ufs.tep.sgr_final.adapters;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.ufs.tep.sgr_final.R;
import com.ufs.tep.sgr_final.database.Mesa;

import java.util.ArrayList;

public class GridViewAdapter extends BaseAdapter {

    ArrayList<Mesa> lista;
    Context mContext;

    LayoutInflater layoutInflater;
    View view;

    public GridViewAdapter(ArrayList<Mesa> lista, Context mContext) {
        this.lista = lista;
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public Object getItem(int position) {
        return lista.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        layoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) {
            view = new View(mContext);
            view = layoutInflater.inflate(R.layout.mesa_item, null);

            TextView mEdtMesa = (TextView) view.findViewById(R.id.mEdtNumMesa);
            ConstraintLayout layout = (ConstraintLayout) view.findViewById(R.id.itemLayout);

            if(lista.get(position).isOcupada())
                layout.setBackgroundResource(R.drawable.occupied);
            else
                layout.setBackgroundResource(R.drawable.free);

            mEdtMesa.setText("M" + lista.get(position).getNumero());
        }
        return view;
    }
}

