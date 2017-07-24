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
import com.mstar.training.beans.Officer;
import com.mstar.training.repository.OfficerRepository;

@JsonComponent
public class OfficerJsonDeserializer extends JsonObjectDeserializer<Officer> {

	@Autowired
	private OfficerRepository repository;
	
	@Override
	protected Officer deserializeObject(JsonParser jsonParser, DeserializationContext context, ObjectCodec codec, JsonNode tree) throws IOException {

		String name = tree.asText();
		
		List<Officer> matches = repository.findByName(name);
		
		if( matches.isEmpty() )
			throw new IOException( "No such project. Name? " + name );
		
		return matches.get( 0 );
	}

}
