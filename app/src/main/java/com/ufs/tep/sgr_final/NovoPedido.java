package com.ufs.tep.sgr_final;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class NovoPedido extends Fragment implements View.OnClickListener {

    private ImageButton btMenos, btMais;
    private Button btAdicionar;
    private TextView txtQuantidade;
    private int mesa;

    public NovoPedido() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_novo_pedido, container, false);

        btMais = (ImageButton) view.findViewById(R.id.btMais);
        btMenos = (ImageButton) view.findViewById(R.id.btMenos);
        btAdicionar = (Button) view.findViewById(R.id.btAdicionar);
        txtQuantidade = (TextView) view.findViewById(R.id.txtQuantidade);

        btMais.setOnClickListener(this);
        btMenos.setOnClickListener(this);
        btAdicionar.setOnClickListener(this);

        Bundle b = getArguments();
        mesa = b.getInt("mesa");

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btMais:
                txtQuantidade.setText(String.valueOf(Integer.parseInt(txtQuantidade.getText().toString()) + 1));
                break;
            case R.id.btMenos:
                if (Integer.parseInt(txtQuantidade.getText().toString()) > 1)
                    txtQuantidade.setText(String.valueOf(Integer.parseInt(txtQuantidade.getText().toString()) - 1));
                break;
            case R.id.btAdicionar:
                Utils.cleanBackStack();
                Utils.backToStart();

                Bundle b = new Bundle();
                b.putInt("mesa",mesa);
                Utils.openFragment(getFragmentManager(), new ListaPedido(), b);
                break;
        }
    }
}
