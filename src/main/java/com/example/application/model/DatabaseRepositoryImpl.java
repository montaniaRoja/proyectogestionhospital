package com.example.application.model;

import java.io.IOException;

import com.example.application.data.PacientesResponse;

import retrofit2.Call;
import retrofit2.Response;

public class DatabaseRepositoryImpl {
	
	private static DatabaseRepositoryImpl INSTANCE;
	private static DatabaseClient client;
	
	private DatabaseRepositoryImpl(String url, Long timeout) {
		client=new DatabaseClient(url, timeout);
	}
	
	public static DatabaseRepositoryImpl getInstance(String url, Long timeout) {
		if(INSTANCE==null) {
			synchronized (DatabaseRepositoryImpl.class) {
				if(INSTANCE==null) {
					INSTANCE=new DatabaseRepositoryImpl(url, timeout);
				}
			}
		}
		return INSTANCE;
	}
	
	public PacientesResponse consultarPacientes() throws IOException {
		Call<PacientesResponse> call=client.getDatabase().consultarPacientes();
		Response<PacientesResponse> response=call.execute();
		if(response.isSuccessful()) {
			return response.body();
		}else {
			return null;
		}
	}
	
}
