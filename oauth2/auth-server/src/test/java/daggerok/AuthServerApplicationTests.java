package daggerok;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * http --auth $clientId:$secret post /oauth/token?grant_type=password&username=$user&password=$password
 *
 * ie:
 *
 * http --auth admin-app:admin post :9999/uaa/oauth/token\?grant_type=password\&username=user\&password=pass
 * {
 *  "access_token": "0f453ca7-268f-4335-af1e-a29beb336ab1",
 *  "expires_in": 43199,
 *  "refresh_token": "5e5106da-7afb-4f4f-a577-49e295f51557",
 *  "scope": "read write",
 *  "token_type": "bearer"
 * }
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AuthServerApplicationTests {

  @Test
  public void contextLoads() {}
}
