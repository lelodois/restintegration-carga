package br.com.lelo.precos.precocarga;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.annotation.PostConstruct;

import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import br.com.lelo.precos.precocarga.message.PrecoCargaMessageDesserializer;
import br.com.lelo.precos.precocarga.message.PrecoCargaMessageSerializer;
import br.com.lelo.precos.precocarga.model.PrecoCarga;

@Component
public class PrecoCargaProperties {

	private Properties properties = new Properties();

	@Value("${myproperties.kafka.url}")
	private String servers;

	@PostConstruct
	public void inicializar() {
		properties.put("bootstrap.servers", servers);
		properties.put("key.serializer", StringSerializer.class.getCanonicalName());
		properties.put("key.deserializer", StringDeserializer.class.getCanonicalName());

		properties.put("value.serializer", PrecoCargaMessageSerializer.class.getCanonicalName());
		properties.put("value.deserializer", PrecoCargaMessageDesserializer.class.getCanonicalName());
	}

	public final Properties getProperties() {
		return properties;
	}

	public final KafkaConsumer<String, PrecoCarga> createConsumer(String topicName) {
		List<String> topics = new ArrayList<String>();
		topics.add(topicName);
		KafkaConsumer<String, PrecoCarga> consumer = new KafkaConsumer<String, PrecoCarga>(properties);
		consumer.subscribe(topics);
		return consumer;
	}

}
