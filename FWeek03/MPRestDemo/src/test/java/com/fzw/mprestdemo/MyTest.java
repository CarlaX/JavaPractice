package com.fzw.mprestdemo;

import com.fzw.mprestdemo.service.ActuatorService;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.rest.client.RestClientBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

@Slf4j
@SpringBootTest
public class MyTest {

    @Test
    public void test() throws MalformedURLException {
        ActuatorService actuatorService = RestClientBuilder.newBuilder().baseUrl(new URL("http://127.0.0.1:8080")).build(ActuatorService.class);
        Map actuator = actuatorService.shutdown();
        log.info("{}", actuator);
    }
}
