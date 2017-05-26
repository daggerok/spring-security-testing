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

  final ClientRepository clientRepository;

  @GetMapping
  public List<Client> get() {
    return clientRepository.findAll();
  }

  @PostMapping
  @Transactional
  @ResponseStatus(CREATED)
  public void post(@RequestBody @Validated final Client client) {

    clientRepository.save(
        clientRepository.findFirstByUsername(client.username)
                        .map(c -> c.setUsername(client.username))
                        .orElse(client));
  }
}
