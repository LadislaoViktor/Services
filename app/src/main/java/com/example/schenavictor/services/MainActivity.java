package com.example.schenavictor.services;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.schenavictor.services.Entity.Cadastro;
import com.example.schenavictor.services.Entity.CadastroDAO;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    EditText id,nome,telefone,senha,datacriacao;
    Button btninserir,btnListar,btnPesquisar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        id = (EditText)findViewById(R.id.editTextid);
        nome = (EditText)findViewById(R.id.editTextNome);
        telefone = (EditText)findViewById(R.id.editTextTelefone);
        senha = (EditText)findViewById(R.id.editTextSenha);
        datacriacao = (EditText)findViewById(R.id.editTextDataCriacao);
        btninserir=(Button)findViewById(R.id.btninserir);
        btnListar=(Button)findViewById(R.id.btnListar);
        btnPesquisar=(Button)findViewById(R.id.btnPesquisar);
        btnListar.setOnClickListener(this);
        btninserir.setOnClickListener(this);
        btnPesquisar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int codigo = v.getId();
        Cadastro cadastro;

        switch (codigo)
        {
            case R.id.btninserir:{
                cadastro =new Cadastro(nome.getText().toString(),telefone.getText().toString(),senha.getText().toString(),datacriacao.getText().toString());
                CadastroDAO cadastros = new CadastroDAO();
                cadastros.inserir(this,cadastro);
            }
                break;
            case R.id.btnListar:{
                Intent activity_Listar = new Intent(this,List.class);
                //outraactivity.putExtra("Resposta",resultadoeditText.getText().toString());
                startActivity(activity_Listar);
            }
            case R.id.btnPesquisar:{
                String Nome =nome.getText().toString();
                ArrayList<Cadastro> cadastroDAO = new CadastroDAO().pesquisarId(this,Nome);
               for(Cadastro pesquisado:cadastroDAO)
               {
                    String.format("Cadastro:{0} {1} {2} {3} {4} ",pesquisado.getId(),pesquisado.getNome(),pesquisado.getSenha(),pesquisado.getTelefone(),pesquisado.getDatacriacao());
               }
            }
        }


    }
}
