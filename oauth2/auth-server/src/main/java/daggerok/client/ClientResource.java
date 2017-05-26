package daggerok.client;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@Slf4j
@RestController
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ClientResource {

  final OauthClientDetailsRepository repository;

  @GetMapping
  public List<OauthClientDetails> get() {
    return repository.findAll();
  }

  @PostMapping
  @Transactional
  @ResponseStatus(CREATED)
  public void post(@RequestBody @Validated final OauthClientDetails oauthClientDetails) {
    repository.save(oauthClientDetails);
  }
}
