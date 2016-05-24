package ca.mbg.gh.issues;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AutoStartTestApplicationTests {

	@Autowired
	private ConfigurableApplicationContext applicationContext;

	@Test
	public void lifecycleIsRunningByDefault() {
		SimpleLifecycle simpleLifecycle = applicationContext.getBean(SimpleLifecycle.class);
		assertTrue(simpleLifecycle.isRunning());
	}

	@Test
	public void lifecycleIsRunningIfContextIsStarted() {
		SimpleLifecycle simpleLifecycle = applicationContext.getBean(SimpleLifecycle.class);
		applicationContext.start();
		assertTrue(simpleLifecycle.isRunning());
	}
}
