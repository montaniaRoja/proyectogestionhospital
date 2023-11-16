package com.example.application.model;

import com.example.application.data.Historial;
import com.example.application.data.HistorialResponse;
import com.example.application.data.Paciente;
import com.example.application.data.PacientesResponse;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface DatabaseRepository {
	
	@Headers({
	    "Accept: application/json",
	    "User-Agent: Retrofit-Sample-App"
	})
	@GET("/pls/apex/adolfouth/hospital/pacientes")
	Call<PacientesResponse> consultarPacientes();
	
	
	@Headers({
	    "Accept: application/json",
	    "User-Agent: Retrofit-Sample-App"
	})
	@POST("/pls/apex/adolfouth/hospital/pacientes")
	Call<ResponseBody> crearPacientes(@Body Paciente nuevo);


	@Headers({
	    "Accept: application/json",
	    "User-Agent: Retrofit-Sample-App"
	})
	@GET("/pls/apex/adolfouth/hospital/historial")
	Call<HistorialResponse> consultarHistorial();


	@Headers({
	    "Accept: application/json",
	    "User-Agent: Retrofit-Sample-App"
	})
	@POST("/pls/apex/adolfouth/hospital/historial")
	Call<ResponseBody> crearHistorial(@Body Historial historial);

}
