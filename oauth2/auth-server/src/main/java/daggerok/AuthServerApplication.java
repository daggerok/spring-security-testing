package daggerok;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * HTTPie:
 * <p>
 * http --auth user:pass :9999/
 * http --auth user:pass post :9999 username=test
 * <p>
 * cURL:
 * <p>
 * curl --user user:pass localhost:9999 -H'content-type:application/json' -d'{"username":"test"}'
 * curl --user user:pass localhost:9999
 */
@SpringBootApplication
public class AuthServerApplication {

  public static void main(String[] args) {
    SpringApplication.run(AuthServerApplication.class, args);
  }
}
