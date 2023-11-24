package br.com.hadryan.tasksbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("file:application.properties")
public class TasksBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(TasksBackendApplication.class, args);
	}

}
