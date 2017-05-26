package daggerok.client;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.stream.IntStream;

@Configuration
public class TestData {

  @Bean
  public CommandLineRunner init(OauthClientDetailsRepository repository) {

    return args -> IntStream.range(0, 3)
                            .mapToObj(i -> new OauthClientDetails().setClientId("client" + i)
                                                                   .setClientSecret("secret" + i)
                                                                   .setAuthorizedGrantTypes(
                                                                       i % 2 == 0 ? "implicit"
                                                                           : "password,client_credentials,authorization_code,refresh_token")
                                                                   .setScope(i % 2 == 0 ? "read" : "read,write")
                                                                   .setAutoapprove(true))
                            .forEach(repository::save);
  }
}
