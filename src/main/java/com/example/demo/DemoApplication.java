package com.example.demo;

import io.jaegertracing.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

	@Bean
	public io.opentracing.Tracer initTracer() {
		Configuration.SamplerConfiguration samplerConfig = new Configuration.SamplerConfiguration().withType("const").withParam(1);
		Configuration.ReporterConfiguration reporterConfig = Configuration.ReporterConfiguration.fromEnv().withLogSpans(true);
		return Configuration.fromEnv("service-a").withSampler(samplerConfig).withReporter(reporterConfig).getTracer();
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
