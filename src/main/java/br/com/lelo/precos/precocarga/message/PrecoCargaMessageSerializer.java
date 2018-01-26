package br.com.lelo.precos.precocarga.message;

import java.util.Map;

import org.apache.kafka.common.serialization.Serializer;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.lelo.precos.precocarga.model.PrecoCarga;

public class PrecoCargaMessageSerializer implements Serializer<PrecoCarga> {

	private ObjectMapper objectMapper = new ObjectMapper();

	@Override
	public void configure(Map<String, ?> configs, boolean isKey) {
	}

	@Override
	public byte[] serialize(String topic, PrecoCarga data) {
		try {
			return objectMapper.writeValueAsString(data).getBytes();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void close() {
	}

}
