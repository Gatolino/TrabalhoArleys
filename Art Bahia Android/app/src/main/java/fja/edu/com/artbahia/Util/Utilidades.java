package fja.edu.com.artbahia.Util;

import android.app.AlertDialog;
import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import fja.edu.com.artbahia.R;

public class Utilidades {

    public static String GetString(EditText editText){
        return editText.getText().toString();
    }

    public static String GetString(Cursor cursor, String columnName){
        return cursor.getString(cursor.getColumnIndex(columnName));
    }

    public static int GetInt(Cursor cursor, String columnName){
        return cursor.getInt(cursor.getColumnIndex(columnName));
    }

    public static boolean GetBool(CheckBox checkBox){
        return checkBox.isChecked();
    }

    public static String GetCategoria(int codigo){
        switch (codigo){
            case 0: return "Quadro";
            case 1: return "Escultura";
            case 2: return "Fotografia";
            case 3: return "Grafitti";
            default: return "Indefinido";
        }
    }

    public static void Alerta(Context context, String mensagem){
        Alerta(context, mensagem, null);
    }

    public static void Alerta(Context context, String mensagem, View viewToFocus){
        AlertDialog.Builder alertBuilder = new AlertDialog.Builder(context);

        alertBuilder.setTitle(R.string.app_name);
        alertBuilder.setMessage(mensagem);
        alertBuilder.setPositiveButton("Ok",null);
        alertBuilder.show();

        if(viewToFocus != null)
            viewToFocus.requestFocus();
    }
}
