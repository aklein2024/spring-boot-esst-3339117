package linkedin.boot;

import org.springframework.stereotype.Service;

@Service
public class HelloFrankService implements GreetingService{
  public String hello() {
    return "Hello, I am Frank";
  }
}
