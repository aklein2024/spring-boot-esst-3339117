package linkedin.boot;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class HelloSusiService implements GreetingService{
  public String hello() {
    return "I am Susi and pleased to say helo to you";
  }
}
