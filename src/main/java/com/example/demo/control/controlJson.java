package com.example.demo.control;

import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class controlJson {

	@PostMapping("/producto/X")
	public String hola(@RequestBody String data) {
	    try {
	        // Intentar crear un JSONObject desde la cadena de entrada
	        JSONObject jsonObject = new JSONObject(data);

	        // Validar si los campos necesarios están presentes
	        if (jsonObject.has("name") && jsonObject.has("age") && jsonObject.has("address")) {
	            // Obtener los valores del JSON original
	            String name = jsonObject.getString("name");
	            String age = String.valueOf(jsonObject.getInt("age"));
	            JSONObject addressObject = jsonObject.getJSONObject("address");

	            // Validar si el campo "street" está presente en el objeto "address"
	            if (addressObject.has("street")) {
	                String street = addressObject.getString("street");

	                // Crear un nuevo JSONObject con los valores extraídos
	                JSONObject nuevoJsonObject = new JSONObject();
	                nuevoJsonObject.put("nombre", name);
	                nuevoJsonObject.put("edad", age);
	                nuevoJsonObject.put("calle", street);

	                return nuevoJsonObject.toString();
	            } else {
	                return "Error: Falta el campo 'street' en 'address'";
	            }
	        } else {
	            return "Error: Faltan campos obligatorios en el JSON";
	        }
	    } catch (Exception e) {
	        System.err.println("Error al procesar la solicitud: " + e.getMessage());
	        return e.getMessage();
	    }
	 }
}
