package daggerok.rest;

import daggerok.SecuredAppApplication;
import lombok.val;
import org.hamcrest.core.Is;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(
    classes = SecuredAppApplication.class,
    webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SecuredResourceTestRestTemplateTest {

  @Autowired
  private TestRestTemplate rest;

  @Test
  public void securedMethod() throws Exception {

    // TestTransaction.flagForRollback();
    // sessionFactory.getCurrentSession().flush();

    val responseEntity = rest.withBasicAuth("user", "password")
                             .getForEntity("/", Map.class);

    assertThat(responseEntity.getStatusCode(), Is.is(HttpStatus.OK));
    assertThat(responseEntity.getBody().get("result"), Is.is("good"));
  }

  @Test
  public void globalErrorHandlerNoSecurity() throws Exception {

    val responseEntity = rest.getForEntity("/", Map.class);

    assertThat(responseEntity.getStatusCode(), Is.is(HttpStatus.UNAUTHORIZED));
  }
}
