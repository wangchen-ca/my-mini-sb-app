package my.sb.practice.myminisb.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "my.sb.practice.myminisb.controller")
public class MyMiniSbApp {

  public static void main(String[] args) {
    SpringApplication.run(MyMiniSbApp.class, args);
  }
}
