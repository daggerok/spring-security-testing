package daggerok;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.restdocs.mockmvc.MockMvcRestDocumentation;
import org.springframework.restdocs.mockmvc.RestDocumentationResultHandler;

@TestConfiguration
public class TestRestDocsConfig {

  @Bean
  public RestDocumentationResultHandler restDocumentation() {
    return MockMvcRestDocumentation.document("{method-name}");
  }
}
