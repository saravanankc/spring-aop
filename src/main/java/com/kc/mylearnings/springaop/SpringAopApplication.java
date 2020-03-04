package com.kc.mylearnings.springaop;

import com.kc.mylearnings.springaop.business.Business1;
import com.kc.mylearnings.springaop.business.Business2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringAopApplication implements CommandLineRunner {

	Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	@Autowired
	Business1 business1;

	@Autowired
	Business2 business2;

	public static void main(String[] args) {
	 	ApplicationContext applicationContext = SpringApplication.run(SpringAopApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		LOGGER.info("1. " + business1.calculateSomething());
		LOGGER.info("2. " + business2.calculateSomething());
	}
}
