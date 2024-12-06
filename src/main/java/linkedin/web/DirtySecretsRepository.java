package linkedin.web;

import java.util.*;

import org.springframework.stereotype.Repository;

@Repository
public class DirtySecretsRepository {

  private Map<String, DirtySecret> secrets = new TreeMap<>();

  public DirtySecretsRepository() {
    var secret = new DirtySecret();
    secret.setId("test-123");
    secret.setName("Doug");
    secret.setSecret("Ex Alcoholic");
    this.secrets.put(secret.getId(), secret);

    secret.setId("test-12");
    secret.setName("Ilse");
    secret.setSecret("Loves rotten meat");
    this.secrets.put(secret.getId(), secret);
  }

  public Optional<DirtySecret> getById(String id) {
    if (!this.secrets.containsKey(id)) {
      return Optional.empty();
    }
    return Optional.of(this.secrets.get(id));
  }

  public DirtySecret save(DirtySecret secret) {
    String id = "test-999";
    secret.setId(id);
    this.secrets.put(id, secret);

    return this.secrets.get(id);
  }

  public int count() {
    return this.secrets.size();
  }

}
