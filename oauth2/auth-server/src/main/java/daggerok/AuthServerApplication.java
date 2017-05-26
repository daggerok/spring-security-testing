package daggerok;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.TimeZone;

/**
 * http -pb --auth admin-app:admin post :9999/uaa/oauth/token\?grant_type=password\&username=user\&password=pass   10:58:25
 * {
 *  "access_token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX25hbWUiOiJ1c2VyIiwic2NvcGUiOlsicmVhZCIsIndyaXRlIl0sIm9sb2xvIjoidHJvbG9sbyIsImV4cCI6MTQ5NTgzMDUzMiwiYXV0aG9yaXRpZXMiOlsiUk9MRV9VU0VSIiwiUk9MRV9BQ1RVQVRPUiJdLCJqdGkiOiI4NDI0MTJjZS00YzJiLTQ5MzUtOTJlZC1jZGJlM2FjMmIzZjkiLCJjbGllbnRfaWQiOiJhZG1pbi1hcHAifQ.7QjvPRZHSZgPDUNHTkDQT8nggR_CYs4RSI9lwPpSFmw",
 *  "expires_in": 43199,
 *  "jti": "842412ce-4c2b-4935-92ed-cdbe3ac2b3f9",
 *  "ololo": "trololo",
 *  "refresh_token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX25hbWUiOiJ1c2VyIiwic2NvcGUiOlsicmVhZCIsIndyaXRlIl0sImF0aSI6Ijg0MjQxMmNlLTRjMmItNDkzNS05MmVkLWNkYmUzYWMyYjNmOSIsIm9sb2xvIjoidHJvbG9sbyIsImV4cCI6MTQ5ODM3OTMzMiwiYXV0aG9yaXRpZXMiOlsiUk9MRV9VU0VSIiwiUk9MRV9BQ1RVQVRPUiJdLCJqdGkiOiI3YTVmOWFjZi04NDVjLTQ5NmYtYjlhYi1lZTg3NmY1NDE1ZTIiLCJjbGllbnRfaWQiOiJhZG1pbi1hcHAifQ.d20NFm_pRnC0fm3E6ZSVUjMHJmtiQSEgA3TcCJk5pGA",
 *  "scope": "read write",
 *  "token_type": "bearer"
 * }
 */
@SpringBootApplication
public class AuthServerApplication {

  public static void main(String[] args) {
    TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
    SpringApplication.run(AuthServerApplication.class, args);
  }
}
