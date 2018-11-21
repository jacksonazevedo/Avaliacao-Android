package com.example.jacksonsilva.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

public class Dao extends SQLiteOpenHelper {

    private static final String NOME_BANCO = "banco.db";
    private static final String TABELA = "usuario";
    private static final String ID = "id";
    private static final String LOGIN = "login";
    private static final String SENHA = "senha";
    private static final int VERSAO = 1;

    public Dao(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {

        super(context, NOME_BANCO, null, VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "CREATE TABLE "+TABELA+"("
                + ID + " integer primary key autoincrement,"
                + LOGIN + " text,"
                + SENHA + " text"
                +")";
        sqLiteDatabase.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABELA);
        onCreate(sqLiteDatabase);
    }

    public void inserirUsuario(String login, String senha){
        ContentValues values = new ContentValues();
        values.put("login",login);
        values.put("senha",senha);
        getWritableDatabase().insert("usuario",null,values);
    }

    public boolean autenticar(String login, String senha){
        String sql="SELECT * FROM usuario WHERE login = '"+login+"' AND senha = '"+senha+"' ";
        Cursor cursor = getReadableDatabase().rawQuery(sql,null);
       if (cursor.getCount()==0){
           return false;
       }else{
           return true;
       }

    }
}
