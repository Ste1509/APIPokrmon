package com.example.pokedex.API;
import com.example.pokedex.Models.PokemonRespuesta;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
public interface PokeAPIService {

    @GET("pokemon")
    Call<PokemonRespuesta> obtenerListaPokemon();

}
