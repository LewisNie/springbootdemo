package com.example.demo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Method;

@RestController
@ConfigurationProperties(prefix = "demo")
public class DemoController {
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    @RequestMapping(value = "/sayHello" ,method = RequestMethod.POST)
    public ResponseEntity<CreateDemoResponse> sayHello(@RequestBody CreateDemoRequest request){
        System.out.print(request);
        CreateDemoResponse response = new CreateDemoResponse();
        response.setEmail(request.getEmail());
        response.setId(1);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(){
        return "hello"+this.name;
    }

}
