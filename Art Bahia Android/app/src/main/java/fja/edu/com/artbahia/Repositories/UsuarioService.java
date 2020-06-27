package fja.edu.com.artbahia.Repositories;

import java.util.List;

import fja.edu.com.artbahia.Models.UsuarioDTO;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface UsuarioService {

    @GET("usuario/GetById/{id}")
    Call<UsuarioDTO> GetById(@Path("id") int id);

    @GET("usuario/GetTodos")
    Call<List<UsuarioDTO>> GetTodos();

    @GET("usuario/Login/{usuario}/{senha}")
    Call<UsuarioDTO> Login(@Path("usuario") String usuario, @Path("senha") String senha);

    @POST("usuario/Create")
    Call<UsuarioDTO> Create(@Body UsuarioDTO usuario);
}
