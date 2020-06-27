package fja.edu.com.artbahia.Util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class SQLiteUtil extends SQLiteOpenHelper {
    private static final String NOME_BANCO = "Cadastro.db";
    private static final  int VERSAO = 1;

    public SQLiteUtil(@Nullable Context context) {
        super(context, NOME_BANCO, null, VERSAO);
    }

    public SQLiteDatabase GetDBConnection(){
        return this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        StringBuilder sql = new StringBuilder();
        sql.append("CREATE TABLE Pessoa (");
        sql.append(" idPessoa      INTEGER PRIMARY KEY AUTOINCREMENT, ");
        sql.append(" dsNome        TEXT NOT NULL, ");
        sql.append(" dsEndereco    TEXT NOT NULL, ");
        sql.append(" flSexo        TEXT NOT NULL, ");
        sql.append(" dtNascimento  TEXT NOT NULL, ");
        sql.append(" flEstadoCivil TEXT NOT NULL, ");
        sql.append(" flAtivo       TEXT NOT NULL) ");

        db.execSQL(sql.toString());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Pessoa");
        onCreate(db);
    }
}
