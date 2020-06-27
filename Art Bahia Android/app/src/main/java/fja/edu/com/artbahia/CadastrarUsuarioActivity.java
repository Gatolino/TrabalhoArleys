package fja.edu.com.artbahia;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import fja.edu.com.artbahia.Models.UsuarioDTO;
import fja.edu.com.artbahia.Util.RetrofitConfig;
import retrofit2.Call;
import retrofit2.Callback;

import static fja.edu.com.artbahia.Util.Utilidades.Alerta;
import static fja.edu.com.artbahia.Util.Utilidades.GetBool;
import static fja.edu.com.artbahia.Util.Utilidades.GetString;

public class CadastrarUsuarioActivity extends AppCompatActivity {
    private TextView status;
    private EditText username;
    private EditText password;
    private EditText name;
    private CheckBox isArtist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_usuario);

        status = findViewById(R.id.register_status);
        username = findViewById(R.id.register_username);
        password = findViewById(R.id.register_password);
        name = findViewById(R.id.register_name);
        isArtist = findViewById(R.id.register_isArtist);

        status.setText("");
    }

    public void OnSaveClick(View view){
        UsuarioDTO usuario = new UsuarioDTO();
        usuario.Login = GetString(username);
        usuario.Senha = GetString(password);
        usuario.Nome = GetString(name);
        usuario.IsArtista = GetBool(isArtist);

        Call<UsuarioDTO> call = new RetrofitConfig().UsuarioService().Create(usuario);
        status.setText("Enviando...");

        call.enqueue(new Callback<UsuarioDTO>() {
            @Override
            public void onResponse(Call<UsuarioDTO> call, retrofit2.Response<UsuarioDTO> response) {
                UsuarioDTO usuario = response.body();

                if(usuario == null || usuario.Id == 0)
                    Alerta(CadastrarUsuarioActivity.this, "Falha ao fazer realizar cadastro.");
                else
                    finish();
            }

            @Override
            public void onFailure(Call<UsuarioDTO> call, Throwable t) {
                Alerta(CadastrarUsuarioActivity.this, "Retrofit failure: " + t.getMessage());
            }
        });
    }
}