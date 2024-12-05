package linkedin.boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloFrankController {

  @Autowired
  private GreetingService service;

  @GetMapping("/")
  public String get() {
    return this.service.hello();
  }

}
