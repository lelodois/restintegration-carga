package br.com.lelo.precos.precocarga.consumer;

import javax.annotation.PostConstruct;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.lelo.precos.precocarga.PrecoCargaProperties;
import br.com.lelo.precos.precocarga.commons.ThreadUtils;
import br.com.lelo.precos.precocarga.model.PrecoCarga;
import br.com.lelo.precos.precocarga.topic.TopicEnum;

@Component
public class PrecoCargaPdvConsumer {

	@Autowired
	private PrecoCargaProperties properties;

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@PostConstruct
	public void go() {
		properties.getProperties().put("group.id", this.getClass().getSimpleName());
		String topicName = TopicEnum.TOPIC_PDV.getTopicName();

		new Thread(new Runnable() {
			public void run() {
				try (KafkaConsumer<String, PrecoCarga> consumer = properties.createConsumer(topicName)) {
					consumer.seekToBeginning(consumer.assignment());
					while (true) {

						log.info(PrecoCargaPdvConsumer.class.getSimpleName() + " Looking for message ...");

						for (ConsumerRecord<String, PrecoCarga> record : consumer.poll(10)) {
							log.info("[pdv] item: " + record.value());
						}

						ThreadUtils.silientSleep();
					}
				}
			}
		}).start();
	}
}
