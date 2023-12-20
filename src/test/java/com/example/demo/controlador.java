package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.control.controlJson;

@SpringBootTest
public class controlador {

	@InjectMocks
	private controlJson c;
	 @InjectMocks
	private JsonData jsonData;
 
	@Test
	public void testControllerReadsJsonData() {
		// Configurar el comportamiento del mock JsonData
		String result = jsonData.readJson();
		MyDto dto=	jsonData.fromJsonString(result);
		
		// Llamar al método que utiliza JsonData en tu controlador
		String x = c.hola(result);
           
		
		System.out.print(result);
		System.out.print(x);
		System.out.print(dto.toString());
		 

	}
	 
	
	  
	  
	@Test
	public void cont ()   {
		System.out.print(jsonData.convertirJsonAUsuarioDTO()); 
 

	}
}
