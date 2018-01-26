package br.com.lelo.precos.precocarga.topic;

public enum TopicEnum {

	TOPIC_PDV, TOPIC_BALANCA, TOPIC_REPLICADOR;

	public final String getTopicName() {
		return this.name().toLowerCase();
	}

}
