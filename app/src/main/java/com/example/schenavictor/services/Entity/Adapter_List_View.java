package com.example.schenavictor.services.Entity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.schenavictor.services.R;

import java.util.List;

/**
 * Created by 2015102617 on 03/04/2017.
 */
public class Adapter_List_View extends BaseAdapter {
    private List<Cadastro> listaCadastros;
    private LayoutInflater inflater;
    private Context context;

    public Adapter_List_View(Context context)
    {
        listaCadastros = new CadastroDAO().listar(context);
        this.context = context;
    }
    @Override
    public int getCount() {
        return listaCadastros.size();
    }

    @Override
    public Object getItem(int position) {
        return listaCadastros.get(position);
    }

    @Override
    public long getItemId(int position) {
        return listaCadastros.get(position).getId();
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        if(inflater==null)
            inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if(view==null)
            view=inflater.inflate(R.layout.listviewcadastro,null);


        TextView editTextId = (TextView) view.findViewById(R.id.textViewID);
        TextView editTextNome=(TextView) view.findViewById(R.id.textViewNOME);
        TextView editTextTelefone=(TextView) view.findViewById(R.id.textViewTELEFONE);
        TextView editTextSenha=(TextView) view.findViewById(R.id.textViewSENHA);
        TextView editTextDataCriacao=(TextView) view.findViewById(R.id.textViewDATACRIACAO);

        Cadastro umCadastro = listaCadastros.get(position);
        editTextId.setText(umCadastro.getId()+"");
        editTextNome.setText(umCadastro.getNome());
        editTextTelefone.setText(umCadastro.getTelefone());
        editTextSenha.setText(umCadastro.getSenha());
        editTextDataCriacao.setText(umCadastro.getDatacriacao());

        return view;
    }
}
