package com.example.application.model;

import com.example.application.data.PacientesResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface DatabaseRepository {
	
	@Headers({
	    "Accept: application/json",
	    "User-Agent: Retrofit-Sample-App"
	})
	@GET("/pls/apex/adolfouth/hospital/pacientes")
	Call<PacientesResponse> consultarPacientes();

}
