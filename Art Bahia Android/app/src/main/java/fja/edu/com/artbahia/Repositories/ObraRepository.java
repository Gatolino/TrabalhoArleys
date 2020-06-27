package fja.edu.com.artbahia.Repositories;

import android.content.Context;

import fja.edu.com.artbahia.Models.ObraDTO;
import fja.edu.com.artbahia.Util.RetrofitConfig;
import retrofit2.Call;
import retrofit2.Callback;

import static fja.edu.com.artbahia.Util.Utilidades.Alerta;
import static fja.edu.com.artbahia.Util.Utilidades.GetString;

public class ObraRepository extends GenericRepository<ObraDTO> {

    public ObraRepository(Context context) {
        super(context);
    }

    @Override
    public void Save(ObraDTO pessoa){ }

    @Override
    public ObraDTO GetById(int id){
        return  null;
    }

    public static void Curtir(int id){
        Call<ObraDTO> call = new RetrofitConfig().ObraService().Curtir(id);

        call.enqueue(new Callback<ObraDTO>() {
            @Override
            public void onResponse(Call<ObraDTO> call, retrofit2.Response<ObraDTO> response) {
                ObraDTO obra = response.body();
            }

            @Override
            public void onFailure(Call<ObraDTO> call, Throwable t) { }
        });
    }
}
