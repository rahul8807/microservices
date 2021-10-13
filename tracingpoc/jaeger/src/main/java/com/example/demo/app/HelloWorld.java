package com.example.demo.app;

import io.opentracing.Span;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {

    @Autowired
    io.opentracing.Tracer tracer;

    @RequestMapping("/")
    public String helloWorld(){
        Span span = tracer.buildSpan("say-hello").start();
            System.out.println ("Hello World" );
        span.finish();
        return "hello world";
    }

}
