package my.sb.practice.myminisb.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.List;
import my.sb.practice.myminisb.entity.Candidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

  @Autowired
  private ResourceLoader resourceLoader;

  @Autowired
  private ObjectMapper objectMapper;

  @GetMapping("/candidates")
  public ResponseEntity<List<Candidate>> getCandidates() throws IOException {
    Resource resource = resourceLoader.getResource("classpath:candidates.json");
    List<Candidate> candidates = objectMapper.readValue(
      resource.getInputStream(),
      new TypeReference<List<Candidate>>() {}
    );
    HttpHeaders headers = new HttpHeaders();
    headers.add("Access-Control-Allow-Origin", "*");

    // System.out.println(candidates);
    return new ResponseEntity<>(candidates, headers, HttpStatus.OK);
  }
}
