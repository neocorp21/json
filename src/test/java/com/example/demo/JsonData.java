package com.example.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

	public class JsonData {
		 public String readJson() {
		        try {
		            // Cargar el archivo JSON desde el classpath
		            Resource resource = new ClassPathResource("data.json");

		            // Verificar si el recurso existe
		            if (!resource.exists()) {
		                return "Error: El archivo JSON no existe.";
		            }

		            // Leer el contenido del archivo y devolverlo como String
		            try (BufferedReader reader = new BufferedReader(new InputStreamReader(resource.getInputStream()))) {
		                return reader.lines().collect(Collectors.joining(System.lineSeparator()));
		            }
		        } catch (IOException e) {
		            // Manejar cualquier excepción de IO que pueda ocurrir
		            return "Error al leer el archivo JSON: " + e.getMessage();
		        }
		    }
	 

}
