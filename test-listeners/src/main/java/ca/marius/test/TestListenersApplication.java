package ca.marius.test;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;

@SpringBootApplication
public class TestListenersApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder(TestListenersApplication.class)
				.listeners(event -> {
					if (event instanceof ApplicationEnvironmentPreparedEvent) {
						System.out.println("environment prepared");
					}
				}).child(ChildContext.class).run();
	}

}
