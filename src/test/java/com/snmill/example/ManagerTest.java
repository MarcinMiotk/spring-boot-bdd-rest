package com.snmill.example;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ManagerTest {

    @LocalServerPort
    private int port;

    @Test
    public void testInfo() {
        String expResult = "Hello World!";
        RestTemplate template = new RestTemplate();
        ResponseEntity<String> result = template.getForEntity("http://localhost:" + port + "/", String.class);
        assertEquals(expResult, result.getBody());
    }

}
