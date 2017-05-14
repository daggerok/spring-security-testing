package daggerok.rest;

import daggerok.SecuredAppApplication;
import daggerok.TestRestTemplateConfig;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.apache.tomcat.util.codec.binary.Base64;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.StandardCharsets;
import java.util.Map;

import static java.lang.String.format;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpStatus.UNAUTHORIZED;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(
    webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
    classes = { SecuredAppApplication.class, TestRestTemplateConfig.class })
public class SecuredResourceRestTemplateTest {

  @LocalServerPort
  Integer port;

  @Autowired
  RestTemplate rest;

  @Test
  public void securedMethod() throws Exception {

    val responseEntity = rest.exchange(path(), GET, new HttpEntity<>(new HttpHeaders() {{
      val plainText = "user:password";
      val plainBytes = plainText.getBytes(StandardCharsets.UTF_8);
      val encodedBytes = Base64.encodeBase64(plainBytes);
      val authHeader = format("Basic %s", new String(encodedBytes));
      set("Authorization", authHeader);
    }}), Map.class);

    assertThat(responseEntity.getStatusCode(), is(HttpStatus.OK));
    assertThat(responseEntity.getBody().get("result"), is("good"));
  }

  @Test
  public void globalErrorHandlerNoSecurity() throws Exception {

    val responseEntity = rest.exchange(path(), GET, null, Map.class);

    assertThat(responseEntity.getStatusCode(), is(UNAUTHORIZED));
    assertThat(responseEntity.getBody().get("error"), is(UNAUTHORIZED.getReasonPhrase()));
  }

  private String path() {
    return format("http://localhost:%d/", port);
  }
}
