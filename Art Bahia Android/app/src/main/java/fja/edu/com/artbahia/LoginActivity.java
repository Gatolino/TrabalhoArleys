package fja.edu.com.artbahia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import fja.edu.com.artbahia.Models.UsuarioDTO;
import fja.edu.com.artbahia.Util.RetrofitConfig;
import retrofit2.Call;
import retrofit2.Callback;

import static fja.edu.com.artbahia.Util.Utilidades.Alerta;
import static fja.edu.com.artbahia.Util.Utilidades.GetString;

public class LoginActivity extends AppCompatActivity {
    public static UsuarioDTO loggedUser;

    private TextView status;
    private EditText username;
    private EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        status = findViewById(R.id.login_status);
        username = findViewById(R.id.login_username);
        password = findViewById(R.id.login_password);
    }

    public void OnLoginClick(View view){
        Call<UsuarioDTO> call = new RetrofitConfig().UsuarioService().Login(GetString(username), GetString(password));
        status.setText("Aguardando...");

        call.enqueue(new Callback<UsuarioDTO>() {
            @Override
            public void onResponse(Call<UsuarioDTO> call, retrofit2.Response<UsuarioDTO> response) {
                loggedUser = response.body();

                if(loggedUser == null || loggedUser.Login.equalsIgnoreCase("invalid"))
                    Alerta(LoginActivity.this, "Usuário ou senha inválidos!");
                else{
                    if(loggedUser.IsArtista)
                        startActivity(new Intent(LoginActivity.this, CadastrarObraActivity.class));
                    else
                        startActivity(new Intent(LoginActivity.this, ListarObrasActivity.class));
                }

                status.setText("...");
            }

            @Override
            public void onFailure(Call<UsuarioDTO> call, Throwable t) {
                status.setText("Retrofit failure: " + t.getMessage());
            }
        });
    }

    public void OnRegisterClick(View view){
        startActivity(new Intent(LoginActivity.this, CadastrarUsuarioActivity.class));
    }
}