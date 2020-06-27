package fja.edu.com.artbahia.Repositories;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import java.util.ArrayList;
import java.util.List;
import fja.edu.com.artbahia.Models.UsuarioDTO;
import static fja.edu.com.artbahia.Util.Utilidades.*;

public class UsuarioRepository extends GenericRepository<UsuarioDTO> {

    public UsuarioRepository(Context context) {
        super(context);
    }

    @Override
    public void Save(UsuarioDTO pessoa){
        /*
        sqliteUtil.GetDBConnection().insert("Pessoa",null,
                CarregarContentVaue(pessoa));

         */
    }

    @Override
    public UsuarioDTO GetById(int id){
        /*String sql = "SELECT * FROM Pessoa WHERE idPessoa=" + Integer.toString(id);
        Cursor cursor = sqliteUtil.GetDBConnection().rawQuery(sql,null);
        cursor.moveToFirst();

        UsuarioDTO pessoa = CarregarPessoa(cursor);
        cursor.close();

        return pessoa;*/

        return null;
    }
/*
    private UsuarioDTO CarregarPessoa(Cursor cursor){
        UsuarioDTO pessoa = new UsuarioDTO(
                GetInt(cursor, "idPessoa"),
                GetString(cursor, "nomePessoa"),
                "",
                GetString(cursor,"dsNome"),
                false
        );

        //pessoa.setEndereco(GetString(cursor,"dsEndereco"));
        //pessoa.setSexo(GetString(cursor,"flSexo"));
        //pessoa.setEstadocivil(cursor.getString(cursor.getColumnIndex("flEstadoCivil")));
        //pessoa.setAtivo(cursor.getString(cursor.getColumnIndex("flAtivo")));

        return pessoa;
    }

    public List<UsuarioDTO> getTodos(){
        List<UsuarioDTO> pessoas = new ArrayList<>();
        String sql = "SELECT * FROM Pessoa";

        Cursor cursor = sqliteUtil.GetDBConnection().rawQuery(sql,null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            pessoas.add(CarregarPessoa(cursor));
            cursor.moveToNext();
        }
        cursor.close();

        return pessoas;
    }

    private ContentValues CarregarContentVaue(UsuarioDTO pessoa){
        ContentValues contentValues = new ContentValues();

        contentValues.put("dsNome", pessoa.Nome);
        //contentValues.put("dsEndereco", pessoa.Endereco);
        //contentValues.put("flSexo", pessoa.Sexo());
        //contentValues.put("dtNascimento", pessoa.getDatanascimento());
        //contentValues.put("flEstadoCivil", pessoa.getEstadocivil());
        //contentValues.put("flAtivo", pessoa.getAtivo());

        return contentValues;
    }

    public void atualizar(UsuarioDTO pessoa){
        sqliteUtil.GetDBConnection().update("Pessoa",
                CarregarContentVaue(pessoa),
                "idPessoa=?",
                new String[]{ Integer.toString(pessoa.Id) });
    }

    public Integer excluir(int codigo){
        return sqliteUtil.GetDBConnection().delete("Pessoa","idPessoa=?",
                new String[]{Integer.toString(codigo)});
    }

 */
}
