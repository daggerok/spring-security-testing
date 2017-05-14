package daggerok;

import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@Slf4j
@TestConfiguration
public class TestRestTemplateConfig {

  @Bean
  public RestTemplate restTemplate() {
    val restTemplate = new RestTemplate();
    restTemplate.setErrorHandler(defaultResponseErrorHandler());
    return restTemplate;
  }

  @Bean
  public DefaultResponseErrorHandler defaultResponseErrorHandler() {
    return new DefaultResponseErrorHandler() {
      @Override
      public void handleError(final ClientHttpResponse response) throws IOException {
        log.error("err: {}", response.getStatusText());
      }
    };
  }
}
