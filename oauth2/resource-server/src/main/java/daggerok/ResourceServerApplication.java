package daggerok;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.TimeZone;

/**
 * export token=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX25hbWUiOiJ1c2VyIiwic2NvcGUiOlsicmVhZCIsIndyaXRlIl0sIm9sb2xvIjoidHJvbG9sbyIsImV4cCI6MTQ5NTgzMDUzMiwiYXV0aG9yaXRpZXMiOlsiUk9MRV9VU0VSIiwiUk9MRV9BQ1RVQVRPUiJdLCJqdGkiOiI4NDI0MTJjZS00YzJiLTQ5MzUtOTJlZC1jZGJlM2FjMmIzZjkiLCJjbGllbnRfaWQiOiJhZG1pbi1hcHAifQ.7QjvPRZHSZgPDUNHTkDQT8nggR_CYs4RSI9lwPpSFmw
 *
 * http -pb :8080/ "Authorization: Bearer $token"
 * [
 *  {
 *    "id": 1,
 *    "username": "test"
 *  },
 *  {
 *    "id": 2,
 *    "username": "test1"
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
