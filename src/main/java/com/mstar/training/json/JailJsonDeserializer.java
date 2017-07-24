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
import com.mstar.training.beans.Jail;
import com.mstar.training.repository.JailRepository;

@JsonComponent
public class JailJsonDeserializer extends JsonObjectDeserializer<Jail> {

	@Autowired
	private JailRepository repository;

	@Override
	protected Jail deserializeObject(JsonParser jsonParser, DeserializationContext context, ObjectCodec codec, JsonNode tree) throws IOException {

		String name = tree.asText();
		
		List<Jail> matches = repository.findByName( name );
		
		if( matches.isEmpty() )
			throw new IOException( "No such Jail! Name? " + name );
			
		return matches.get( 0 );
	}

}
