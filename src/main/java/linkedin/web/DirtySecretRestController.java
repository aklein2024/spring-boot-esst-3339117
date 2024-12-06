package linkedin.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/dirty-secrets")
public class DirtySecretRestController {

  private DirtySecretsRepository repository;

  public DirtySecretRestController(DirtySecretsRepository repository) {
    this.repository = repository;
  }

  @GetMapping("/{id}")
  public Optional<DirtySecret> getSecret(@PathVariable String id) {
    return this.repository.getById(id);
  }

  @GetMapping("/count")
  public int count() {
    return this.repository.count();
  }

  @PostMapping()
  public DirtySecret post(@RequestBody DirtySecret secret) {
      return this.repository.save(secret);
  }
  
}
