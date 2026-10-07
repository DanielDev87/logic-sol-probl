package com.danieldev.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(properties = "game.console=false")
class DemoApplicationTests {

	@Test
	void contextLoads() {
	}

}
