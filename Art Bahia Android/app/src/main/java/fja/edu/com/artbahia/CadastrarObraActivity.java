package fja.edu.com.artbahia;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

import fja.edu.com.artbahia.Models.ObraDTO;
import fja.edu.com.artbahia.Util.RetrofitConfig;
import retrofit2.Call;
import retrofit2.Callback;
import static fja.edu.com.artbahia.Util.Utilidades.Alerta;
import static fja.edu.com.artbahia.Util.Utilidades.GetString;

public class CadastrarObraActivity extends AppCompatActivity {
    private EditText title;
    private TextView status;
    private RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_obra);

        title = findViewById(R.id.registerObra_Titulo);
        radioGroup = findViewById(R.id.registerObra_group_tipos);
        status = findViewById(R.id.registerObra_status);
    }

    public void OnSaveClick(View view){
        View selectedRadio = radioGroup.findViewById(radioGroup.getCheckedRadioButtonId());
        int seletecRadioId = radioGroup.indexOfChild(selectedRadio);

        ObraDTO obra = new ObraDTO();
        obra.Titulo = GetString(title);
        obra.Tipo  = seletecRadioId;
        obra.IdUsuario = LoginActivity.loggedUser.Id;

        Call<ObraDTO> call = new RetrofitConfig().ObraService().Create(obra);
        status.setText("Enviando...");

        call.enqueue(new Callback<ObraDTO>() {
            @Override
            public void onResponse(Call<ObraDTO> call, retrofit2.Response<ObraDTO> response) {
                ObraDTO obra = response.body();

                if(obra == null || obra.Id == 0)
                    Alerta(CadastrarObraActivity.this, "Falha ao fazer realizar cadastro.");
                else
                    Alerta(CadastrarObraActivity.this, "Obra cadastrada com sucesso!");

                status.setText("");
            }

            @Override
            public void onFailure(Call<ObraDTO> call, Throwable t) {
                Alerta(CadastrarObraActivity.this, "Retrofit failure: " + t.getMessage());
            }
        });
    }
}