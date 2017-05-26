package daggerok;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.TimeZone;

/**
 * http --auth $clientId:$secret post /oauth/token?grant_type=password&username=$user&password=$password
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
 * 2. check token:
 *
 * http --auth $clientId:$secret post /oauth/check_token\?token=$access_token
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
 * 3. refresh token
 *
 * http --auth $clientId:$secret post /oauth/token\?grant_type=refresh_token\&refresh_token=5e5106da-7afb-4f4f-a577-49e295f51557
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
 * 4. client credentials
 *
 * http --auth $clientId:$secret post /oauth/token\?grant_type=client_credentials
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
 * 5. code (use browser)
 *
 * http://auth-server/oauth/authorize?response_type=code&client_id=&clientId&redirect_uri=$redirectUrl
 *
 * ie:
 *
 * http://localhost:9999/uaa/oauth/authorize?response_type=code&client_id=admin-app&redirect_uri=http://example.com
 *
 * <html>
 *   <body>
 *     <h1>OAuth Approval</h1>
 *     <p>Do you authorize 'admin-app' to access your protected resources?</p>
 *     <form id='confirmationForm' name='confirmationForm' action='/uaa/oauth/authorize' method='post'>
 *       <input name='user_oauth_approval' value='true' type='hidden'/>
 *       <ul>
 *         <li>
 *           <div class='form-group'>scope.read:
 *            <input type='radio' name='scope.read' value='true'>Approve</input>
 *            <input type='radio' name='scope.read' value='false' checked>Deny</input>
 *           </div>
 *         </li>
 *         <li>
 *           <div class='form-group'>scope.write:
 *            <input type='radio' name='scope.write' value='true'>Approve</input>
 *            <input type='radio' name='scope.write' value='false' checked>Deny</input>
 *           </div>
 *         </li>
 *       </ul>
 *       <label>
 *         <input name='authorize' value='Authorize' type='submit'/>
 *       </label>
 *     </form>
 *   </body>
 * </html>
 *
 * choose scope and click approve, it will redirect you to
 * http://example.com/?code=1fYSVu
 *
 * then application on exmaple.com should prepare request:
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
 * done.
 *
 * basic auth (oauth is not using):
 *
 * HTTPie:
 *
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
