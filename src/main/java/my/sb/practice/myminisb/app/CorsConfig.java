package my.sb.practice.myminisb.app;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

  @Override
  public void addCorsMappings(CorsRegistry registry) {
    registry
      .addMapping("/**")
      .allowedOrigins("*") // Update with your React app's origin
      // .allowedOrigins("http://localhost:3000") // Update with your React app's origin
      .allowedMethods("GET", "POST", "PUT", "DELETE")
      .allowedHeaders("*");
  }
}
