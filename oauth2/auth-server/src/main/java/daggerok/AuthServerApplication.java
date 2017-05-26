package daggerok;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.TimeZone;

/**
 *
 * 1. password:
 *
 * post /oauth/token?grant_type=password&username=$username&password=$password
 *
 * ie:
 *
 * http --auth admin-app:admin post :9999/uaa/oauth/token\?grant_type=password\&username=user\&password=pass
 * {
 *  "access_token": "ad269b9d-e366-4107-a3a3-a0e9af74e214",
 *  "expires_in": 43199,
 *  "refresh_token": "5e5106da-7afb-4f4f-a577-49e295f51557",
 *  "scope": "read write",
 *  "token_type": "bearer"
 * }
 *
 *
 * 2. check token:
 *
 * post /oauth/check_token?token=$access_token
 *
 * ie:
 *
 * http --auth admin-app:admin post :9999/uaa/oauth/check_token\?token=ad269b9d-e366-4107-a3a3-a0e9af74e214
 *
 * {
 *  "authorities": [
 *    "ROLE_USER",
 *    "ROLE_ACTUATOR"
 *  ],
 *  "client_id": "admin-app",
 *  "exp": 1495807797,
 *  "scope": [
 *    "read",
 *    "write"
 *  ],
 *  "user_name": "user"
 * }
 *
 *
 * 3. refresh token:
 *
 * post /oauth/token?grant_type=refresh_token&refresh_token=$refreshToken
 *
 * ie:
 *
 * http --auth admin-app:admin post :9999/uaa/oauth/token\?grant_type=refresh_token\&refresh_token=5e5106da-7afb-4f4f-a577-49e295f51557
 *
 * {
 *  "access_token": "ef7d67b8-add1-4fa8-b2d3-ede7a72c7a5d",
 *  "expires_in": 43199,
 *  "refresh_token": "5e5106da-7afb-4f4f-a577-49e295f51557",
 *  "scope": "read write",
 *  "token_type": "bearer"
 * }
 *
 *
 * 4. client credentials:
 *
 * post /oauth/token?grant_type=client_credentials
 *
 * ie:
 *
 * http --auth admin-app:admin post :9999/uaa/oauth/token\?grant_type=client_credentials
 *
 * {
 *  "access_token": "5d356e7a-187b-4fc2-a559-3ce6aee5e4e1",
 *  "expires_in": 43199,
 *  "scope": "read write",
 *  "token_type": "bearer"
 * }
 *
 *
 * 5. code (use browser):
 *
 * browser http://$authServerHost/oauth/authorize?response_type=code&client_id=$clientId&redirect_uri=$redirectUrl
 *
 * ie:
 *
 * firefox http://localhost:9999/uaa/oauth/authorize?response_type=code&client_id=admin-app&redirect_uri=http://example.com
 *
 * choose scope read
 * click approve
 *
 * it will redirect you to:
 * http://example.com/?code=1fYSVu
 *
 * then application on example.com should prepare request:
 *
 * post /oauth/token?grant_type=authorization_code&code=$code&redirect_uri=$redirectUri&client_id=$clientId
 *
 * ie:
 *
 * http --auth admin-app:admin post :9999/uaa/oauth/token\?grant_type=authorization_code\&code=1fYSVu\&redirect_uri=http://example.com\&client_id=admin-app
 *
 * {
 *  "access_token": "93b4ba2a-384f-47d6-9093-32bda8ff033c",
 *  "expires_in": 43199,
 *  "refresh_token": "6cd61fac-4701-4b5b-9a2e-320b72102bf3",
 *  "scope": "read",
 *  "token_type": "bearer"
 * }
 *
 *
 * 6. implicit:
 *
 * browser http://$authServerHost/oauth/authorize?response_type=token&client_id=$clientId&state=$optionalState&redirect_uri=$redirectUri
 *
 * ie:
 *
 * firefox http://localhost:9999/uaa/oauth/authorize?response_type=token&client_id=admin-app&state=xyz&redirect_uri=http://example.com
 *
 * choose read scope
 * click approve
 *
 * you will be redirected to:
 * http://example.com/#access_token=bc423e9c-b145-4c66-b08c-a829c8251644&token_type=bearer&state=xyz&expires_in=43199&scope=read
 *
 * ie:
 *
 * {
 *   "access_token": "bc423e9c-b145-4c66-b08c-a829c8251644"
 *   "token_type": "bearer"
 *   "state": "xyz"
 *   "expires_in": "43199"
 *   "scope": "read"
 * }
 *
 *
 * 7. password
 *
 * post /oauth/token?grant_type=password&username=$username&password=$password
 *
 * ie:
 *
 * http --auth admin-app:admin post :9999/uaa/oauth/token\?grant_type=password\&username=user\&password=pass
 *
 * {
 *  "access_token": "91b88c40-bb73-4a3d-b7dd-f565211a6f47",
 *  "expires_in": 43199,
 *  "refresh_token": "b5b27853-aeb1-4edb-96f1-1da00e9d5adc",
 *  "scope": "read write",
 *  "token_type": "bearer"
 * }
 *
 *
 * read more:
 * https://tools.ietf.org/html/rfc6749#section-4
 *
 */
@SpringBootApplication
public class AuthServerApplication {

  public static void main(String[] args) {
    TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
    SpringApplication.run(AuthServerApplication.class, args);
  }
}
