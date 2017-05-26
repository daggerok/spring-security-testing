package daggerok;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.TimeZone;

/**
 * HTTPie:
 * <p>
 * http --auth user:pass post :9999 username=test
 * http --auth user:pass :9999/
 * <p>
 * cURL:
 * <p>
 * curl --user user:pass localhost:9999 -H'content-type:application/json' -d'{"username":"test"}'
 * curl --user user:pass localhost:9999
 */
@SpringBootApplication
public class AuthServerApplication {

  public static void main(String[] args) {
    TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
    SpringApplication.run(AuthServerApplication.class, args);
  }
}
