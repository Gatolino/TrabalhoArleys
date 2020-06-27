package fja.edu.com.artbahia;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import java.util.List;
import fja.edu.com.artbahia.Models.ObraDTO;
import fja.edu.com.artbahia.Util.ObraAdapter;
import fja.edu.com.artbahia.Util.RetrofitConfig;
import retrofit2.Call;
import retrofit2.Callback;
import static fja.edu.com.artbahia.Util.Utilidades.Alerta;

public class ListarObrasActivity extends AppCompatActivity {
    private ListView listObras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_obras);

        listObras = this.findViewById(R.id.listarObra_List);

        LoadObras();
    }

    public void LoadObras(){
        Call<List<ObraDTO>> call = new RetrofitConfig().ObraService().GetTodos();

        call.enqueue(new Callback<List<ObraDTO>>() {
            @Override
            public void onResponse(Call<List<ObraDTO>> call, retrofit2.Response<List<ObraDTO>> response) {
                List<ObraDTO> obras = response.body();

                if(obras == null || obras.size() == 0)
                    Alerta(ListarObrasActivity.this, "Nenhuma obra encontrada!");
                else
                    listObras.setAdapter(new ObraAdapter(ListarObrasActivity.this, obras));
            }

            @Override
            public void onFailure(Call<List<ObraDTO>> call, Throwable t) {
                Alerta(ListarObrasActivity.this, "Retrofit failure: " + t.getMessage());
            }
        });
    }
}