package skeleton;

import com.snmill.example.Application;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import static org.junit.Assert.assertEquals;
import org.junit.runner.RunWith;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ContextConfiguration(classes = {Application.class})
public class Stepdefs {

    @LocalServerPort
    private int port;

    private RestTemplate template;
    private ResponseEntity<String> responseEntity;

    @Given("^WebContext$")
    public void webcontext() throws Throwable {
        template = new RestTemplate();
    }

    @When("^URL \"([^\"]*)\" is called$")
    public void url_is_called(String url) throws Throwable {
        responseEntity = template.getForEntity("http://localhost:" + port + url, String.class);
    }

    @Then("^\"([^\"]*)\" body is returned$")
    public void body_is_returned(String expected) throws Throwable {
        assertEquals(expected, responseEntity.getBody());
    }
}
