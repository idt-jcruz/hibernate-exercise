package com.mstar.training.json;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jackson.JsonComponent;
import org.springframework.boot.jackson.JsonObjectDeserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.mstar.training.beans.Inmate;
import com.mstar.training.repository.InmateRepository;

@JsonComponent
public class InmateJsonDeserializer extends JsonObjectDeserializer<Inmate> {

	@Autowired
	private InmateRepository repository;

	@Override
	protected Inmate deserializeObject(JsonParser jsonParser, DeserializationContext context, ObjectCodec codec, JsonNode tree) throws IOException {

		String name = tree.asText();
		
		List<Inmate> matches = repository.findByName( name );
		
		if( matches.isEmpty() )
			throw new IOException( "No such inmate! Name? " + name );
			
		return matches.get( 0 );
	}

}
