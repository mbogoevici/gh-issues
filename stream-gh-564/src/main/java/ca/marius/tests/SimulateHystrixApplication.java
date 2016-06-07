package ca.marius.tests;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.support.MessageBuilder;

@SpringBootApplication
@EnableBinding(Source.class)
public class SimulateHystrixApplication {

	@Autowired
	HystrixChannels hystrixChannels;

	@Autowired
	Source source;

	public static void main(String[] args) {
		SpringApplication.run(SimulateHystrixApplication.class, args);
	}

	@InboundChannelAdapter(Source.OUTPUT)
	public String poll() {
		hystrixChannels.hystrixOutput()
				.send(MessageBuilder.withPayload("hystrixData " + new Date().toString()).build());
		return "regularData " + new Date().toString();
	}

}
