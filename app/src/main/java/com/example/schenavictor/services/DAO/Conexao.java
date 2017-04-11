package com.example.schenavictor.services.DAO;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
/**
 * Created by 2015102617 on 29/03/2017.
 */

    public class Conexao extends SQLiteOpenHelper {

        private final static String BASE = "cadastro";
        private final static int VERSAO=1;

        public Conexao(Context context){
            super(context,BASE,null,VERSAO);
        }


        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase) {
            String CRIA_TABELA_CADASTRO = "create table cadastro("+
                    "id integer primary key autoincrement,"+
                    "nome text,"+
                    "telefoone text," +
                    "senha text,"+
                    "datacriacao text)";
            sqLiteDatabase.execSQL(CRIA_TABELA_CADASTRO);
        }

        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        }
    }

