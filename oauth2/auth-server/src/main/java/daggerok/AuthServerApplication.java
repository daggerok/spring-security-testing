package daggerok;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.TimeZone;

/**
 * http -pb --auth admin-app:admin post :9999/uaa/oauth/token\?grant_type=password\&username=user\&password=pass   10:58:25
 * {
 *  "access_token": "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX25hbWUiOiJ1c2VyIiwic2NvcGUiOlsicmVhZCIsIndyaXRlIl0sIm9sb2xvIjoidHJvbG9sbyIsImV4cCI6MTQ5NTgyODcxMywiYXV0aG9yaXRpZXMiOlsiUk9MRV9VU0VSIiwiUk9MRV9BQ1RVQVRPUiJdLCJqdGkiOiJmOTFkY2IzOS01ZmZjLTRmNjAtOWFlMC05NDE1NTE5NTM3MzYiLCJjbGllbnRfaWQiOiJhZG1pbi1hcHAifQ.ZsNqblvPd3I3I5z7dvH4EU0Jx17E6kaEAuamhC5I4yUcyw5CNK-HO_Tc7a1N8ABSZkt3hQ_C9H4pl7JTuvqUbsd_WIpv-sZKhET4MbthGpvI7BzXbQmdkHMvrwS7xoYABMOLlIshNivSJxQQpsTYv4dxPRUoQSVStNJGJacrmRLSvaczIHITRDpMPEpTd9Ga6LNSf1H-yCS0Wdjf5ExlDrqQaVC83_pnB8iJJKCPFAxDtO3uNgf1lAIwtMzQd3adbIuhMZ_6xc8OydxbTVuNKYvT-8f3kWKxM7K2q28fqmBuluf4ZsuZNtsmwKEHy0w8IfCu56VgR2hyGw2NTWppAA",
 *  "expires_in": 43199,
 *  "jti": "f91dcb39-5ffc-4f60-9ae0-941551953736",
 *  "ololo": "trololo",
 *  "refresh_token": "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX25hbWUiOiJ1c2VyIiwic2NvcGUiOlsicmVhZCIsIndyaXRlIl0sImF0aSI6ImY5MWRjYjM5LTVmZmMtNGY2MC05YWUwLTk0MTU1MTk1MzczNiIsIm9sb2xvIjoidHJvbG9sbyIsImV4cCI6MTQ5ODM3NzUxMywiYXV0aG9yaXRpZXMiOlsiUk9MRV9VU0VSIiwiUk9MRV9BQ1RVQVRPUiJdLCJqdGkiOiIwNDViZjZiOS0zNzI4LTQ3NzMtOTFkYy1iNTY3NThjZjlkM2YiLCJjbGllbnRfaWQiOiJhZG1pbi1hcHAifQ.HQoNejEsM7Dw8szoYplJg1pdFw6sIVrjTmwYwtZ1pW_tk4CHT_xibNJn6gdLlXynByCCKABkFekZzaXMne3DM_5Hf-l3uaLSq4T9t1_bs7S2N3TJG1YGEiGtKTOVxgaZTx2x79dQZhoiPGczM85wM9X3O8b9JOv9FLK3F5OVoM623oTilBSx7SACBPIEPwldlC2XlLC3mh5BrcNi8055FSFSUlXmBTXsRFdBlTbE4QqdQvcx1INVMWhxK5-huilvGGLghNRMBwBdGEvt1-OeQRlFIL8ru3qihb_uioxxOFU2eSii8N8jU6LDoStSDHdJK9oK2Ju_e4-BWGUv_JiD8A",
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
