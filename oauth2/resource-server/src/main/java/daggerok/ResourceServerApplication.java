package daggerok;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.TimeZone;

/**
 * 1:
 * http --auth admin-app:admin post :9999/uaa/oauth/token\?grant_type=password\&username=user\&password=pass       08:40:34
 * {
 *  "access_token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX25hbWUiOiJ1c2VyIiwic2NvcGUiOlsicmVhZCIsIndyaXRlIl0sIm9sb2xvIjoidHJvbG9sbyIsImV4cCI6MTQ5NTgyMDQ5MywiYXV0aG9yaXRpZXMiOlsiUk9MRV9VU0VSIiwiUk9MRV9BQ1RVQVRPUiJdLCJqdGkiOiIxNmQxNDEwZS02ODM0LTRjNTEtOGJjNS1lYWEzMjlmNzkzZjMiLCJjbGllbnRfaWQiOiJhZG1pbi1hcHAifQ.5H2JeKzQA24j9i-9CL5jfiy2tbduEtv3g3XqmpLjG0M",
 *  "expires_in": 43199,
 *  "jti": "16d1410e-6834-4c51-8bc5-eaa329f793f3",
 *  "ololo": "trololo",
 *  "refresh_token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX25hbWUiOiJ1c2VyIiwic2NvcGUiOlsicmVhZCIsIndyaXRlIl0sImF0aSI6IjE2ZDE0MTBlLTY4MzQtNGM1MS04YmM1LWVhYTMyOWY3OTNmMyIsIm9sb2xvIjoidHJvbG9sbyIsImV4cCI6MTQ5ODM2OTI5MywiYXV0aG9yaXRpZXMiOlsiUk9MRV9VU0VSIiwiUk9MRV9BQ1RVQVRPUiJdLCJqdGkiOiI4NTdhMmRlNC02ZWQ4LTRkNmMtOTM5Mi0yNmEwZTA2ODAwZjMiLCJjbGllbnRfaWQiOiJhZG1pbi1hcHAifQ.gaO1Cum5aeomt-KJtrPwAnCuXzJr-5ZDW7NB5lbizx4",
 *  "scope": "read write",
 *  "token_type": "bearer"
 * }
 *
 * 2:
 * export token=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX25hbWUiOiJ1c2VyIiwic2NvcGUiOlsicmVhZCIsIndyaXRlIl0sIm9sb2xvIjoidHJvbG9sbyIsImV4cCI6MTQ5NTgyMDQ5MywiYXV0aG9yaXRpZXMiOlsiUk9MRV9VU0VSIiwiUk9MRV9BQ1RVQVRPUiJdLCJqdGkiOiIxNmQxNDEwZS02ODM0LTRjNTEtOGJjNS1lYWEzMjlmNzkzZjMiLCJjbGllbnRfaWQiOiJhZG1pbi1hcHAifQ.5H2JeKzQA24j9i-9CL5jfiy2tbduEtv3g3XqmpLjG0M
 *
 * 3:
 * http -pb post :8080/ username=test "Authorization: Bearer $token"
 * http -pb :8080/ "Authorization: Bearer $token"
 * [
 *  {
 *    "id": 1,
 *    "username": "test"
 *  }
 * ]
 */
@SpringBootApplication
public class ResourceServerApplication {

  public static void main(String[] args) {
    TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
    SpringApplication.run(ResourceServerApplication.class, args);
  }
}
