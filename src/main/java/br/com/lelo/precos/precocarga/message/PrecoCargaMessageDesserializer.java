package br.com.lelo.precos.precocarga.message;

import java.util.Map;

import org.apache.kafka.common.serialization.Deserializer;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.lelo.precos.precocarga.model.PrecoCarga;

public class PrecoCargaMessageDesserializer implements Deserializer<PrecoCarga> {

	private ObjectMapper objectMapper = new ObjectMapper();

	@Override
	public void configure(Map<String, ?> configs, boolean isKey) {
	}

	@Override
	public PrecoCarga deserialize(String arg0, byte[] arg1) {
		try {
			return objectMapper.readValue(arg1, PrecoCarga.class);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void close() {
	}

}
