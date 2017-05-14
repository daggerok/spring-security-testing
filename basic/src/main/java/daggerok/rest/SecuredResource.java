package daggerok.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

import static java.util.Collections.singletonMap;

@RestController
public class SecuredResource {

  @GetMapping("/")
//  @PreAuthorize("authenticated")
  public Map<String, Object> securedMethod() {
    return singletonMap("result", "good");
  }
}
