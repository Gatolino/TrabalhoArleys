package fja.edu.com.artbahia.Util;

import fja.edu.com.artbahia.Repositories.ObraService;
import fja.edu.com.artbahia.Repositories.UsuarioService;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class RetrofitConfig {
    private final String baseUrl = "http://192.168.0.3:50386/";
    private final Retrofit retrofit;

    public RetrofitConfig() {
        this.retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(JacksonConverterFactory.create())
                .build();
    }

    public UsuarioService UsuarioService() {
        return this.retrofit.create(UsuarioService.class);
    }

    public ObraService ObraService() {
        return this.retrofit.create(ObraService.class);
    }
}
