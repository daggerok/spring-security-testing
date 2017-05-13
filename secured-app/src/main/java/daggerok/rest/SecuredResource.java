package daggerok.rest;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@RestController
public class SecuredResource {

  @GetMapping
  public Map<String, Object> securedMethod() {
    return Collections.singletonMap("response", "OK");
  }

  @ExceptionHandler(Throwable.class)
  public Map<String, Object> globalErrorHandler(Throwable throwable) {
    return Collections.singletonMap("error", throwable.getMessage());
  }
}
