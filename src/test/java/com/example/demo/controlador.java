package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
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
		// Llamar al método que utiliza JsonData en tu controlador
		String x = c.hola(result);
           
		
		System.out.print(result);
		System.out.print(x);

	}
}
