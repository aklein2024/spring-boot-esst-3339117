package linkedin.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class DirtySecretsRestController {

  private DirtySecretsRepository repository;

  public DirtySecretsRestController(DirtySecretsRepository repository) {
    this.repository = repository;
  }

  @GetMapping("/{id}")
  public DirtySecret getById(@PathVariable String id) {
    return this.repository.getById(id).orElseThrow();
  }

  @PostMapping
  public DirtySecret post(@RequestBody DirtySecret secret) {
    return this.repository.save(secret);
  }

}