package com.example.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonData {
	public static String readJson() {
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
	
	 public static MyDto fromJsonString(String jsonString) {
	        try {
	            ObjectMapper objectMapper = new ObjectMapper();
	            return objectMapper.readValue(jsonString, MyDto.class);
	        } catch (Exception e) {
	            // Manejar la excepción en caso de error al convertir el JSON
	            throw new RuntimeException("Error al convertir JSON a MyDto: " + e.getMessage(), e);
	        }
	    }

	public static MyDto convertirJsonAUsuarioDTO() {
		JSONObject jsonUsuario;
		try {
			jsonUsuario = new JSONObject(readJson());

			MyDto usuarioDTO = new MyDto(null, 0, null);

			usuarioDTO.setName(jsonUsuario.optString("name"));

			/*JSONObject jsonDireccion = jsonUsuario.optJSONObject("direccionUsuario");
			if (jsonDireccion != null) {
				DireccionDTO direccionDTO = new DireccionDTO();
				direccionDTO.setCalle(jsonDireccion.optString("calleUsuario"));
				direccionDTO.setCiudad(jsonDireccion.optString("ciudadUsuario"));
				usuarioDTO.setDireccion(direccionDTO);
			}
			*/

			return usuarioDTO;
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}
}
