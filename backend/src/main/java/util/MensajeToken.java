package util;

import javax.json.Json;
import javax.json.JsonObject;

public class MensajeToken {
	
	public static JsonObject crear(String mensaje){
		
		return Json.createObjectBuilder().add("token", mensaje).build();
		
	}

}