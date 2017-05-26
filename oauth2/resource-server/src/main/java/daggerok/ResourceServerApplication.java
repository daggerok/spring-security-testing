package daggerok;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.TimeZone;

/**
 * export token=ODcxMywiYXV0aG9yaXRpZXMiOlsiUk9MRV9VU0VSIiwiUk9MRV9BQ1RVQVRPUiJdLCJqdGkiOiJmOTFkY2IzOS01ZmZjLTRmNjAtOWFlMC05NDE1NTE5NTM3MzYiLCJjbGllbnRfaWQiOiJhZG1pbi1hcHAifQ.ZsNqblvPd3I3I5z7dvH4EU0Jx17E6kaEAuamhC5I4yUcyw5CNK-HO_Tc7a1N8ABSZkt3hQ_C9H4pl7JTuvqUbsd_WIpv-sZKhET4MbthGpvI7BzXbQmdkHMvrwS7xoYABMOLlIshNivSJxQQpsTYv4dxPRUoQSVStNJGJacrmRLSvaczIHITRDpMPEpTd9Ga6LNSf1H-yCS0Wdjf5ExlDrqQaVC83_pnB8iJJKCPFAxDtO3uNgf1lAIwtMzQd3adbIuhMZ_6xc8OydxbTVuNKYvT-8f3kWKxM7K2q28fqmBuluf4ZsuZNtsmwKEHy0w8IfCu56VgR2hyGw2NTWppAA
 *
 * http -pb :8080/ "Authorization: Bearer $token"                                                                  10:59:45
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
