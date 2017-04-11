package com.example.schenavictor.services.Entity;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.schenavictor.services.DAO.Conexao;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 2015102617 on 29/03/2017.
 */
public class CadastroDAO {

    public void inserir(Context context, Cadastro cadastro){
        ContentValues values = new ContentValues();
        values.put("nome",cadastro.getNome());
        values.put("telefoone",cadastro.getTelefone());
        values.put("senha",cadastro.getSenha());
        values.put("datacriacao",cadastro.getDatacriacao());
        Conexao cnx = new Conexao(context);

        SQLiteDatabase db =cnx.getWritableDatabase();
        long id = db.insert("cadastro", null, values);
        Log.d("Cadastrou mizeravi",cadastro.toString());
        db.close();
    }
    public List<Cadastro> listar(Context context){
        Conexao conexao = new Conexao(context);
        SQLiteDatabase db = conexao.getReadableDatabase();
        String selectQuery = "SELECT * FROM cadastro";
        Cursor cursor = db.rawQuery(selectQuery, null);
        ArrayList<Cadastro> ListaCadastro = new ArrayList<>();

        if (cursor.moveToFirst()) {
            do {
                Cadastro cadastro= new Cadastro();
                cadastro.setId(cursor.getInt(0));
                cadastro.setNome(cursor.getString(1));
                cadastro.setTelefone(cursor.getString(2));
                cadastro.setSenha(cursor.getString(3));
                cadastro.setDatacriacao(cursor.getString(4));
                ListaCadastro.add(cadastro);
                Log.d("MEUAPP", cadastro.toString());
            } while (cursor.moveToNext());
            db.close();
        }
        return ListaCadastro;
    }
    public ArrayList<Cadastro> pesquisarId(Context context,String nome)
    {
        Conexao conexao = new Conexao(context);
        SQLiteDatabase db = conexao.getReadableDatabase();
        String selectQuery = "SELECT cadastro.id,cadastro.nome,cadastro.telefoone,cadastro.senha,cadastro.datacriacao FROM cadastro where nome = "+nome;
        Cursor cursor=db.rawQuery(selectQuery,null);
        ArrayList<Cadastro> ListaCadastro = new ArrayList<>();

        if (cursor.moveToFirst()) {
            do {
                Cadastro umcadastro = new Cadastro();
                umcadastro.setId(cursor.getInt(0));
                umcadastro.setNome(cursor.getString(1));
                umcadastro.setSenha(cursor.getString(2));
                umcadastro.setTelefone(cursor.getString(3));
                umcadastro.setDatacriacao(cursor.getString(4));
                ListaCadastro.add(umcadastro);
                Log.d("MEUAPP", umcadastro.toString());
            } while (cursor.moveToNext());
            db.close();
        }
        return ListaCadastro;
    }

}
