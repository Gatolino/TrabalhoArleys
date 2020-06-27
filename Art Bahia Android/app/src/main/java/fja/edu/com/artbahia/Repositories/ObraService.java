package fja.edu.com.artbahia.Repositories;

import java.util.List;
import fja.edu.com.artbahia.Models.ObraDTO;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ObraService {

    @GET("obra")
    Call<List<ObraDTO>> GetTodos();

    @GET("obra/GetById/{id}")
    Call<ObraDTO> GetById(@Path("id") int id);

    @POST("obra/Create")
    Call<ObraDTO> Create(@Body ObraDTO obra);

    @GET("obra/Curtir/{id}")
    Call<ObraDTO> Curtir(@Path("id") int id);
}
