package my.sb.practice.myminisb.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import my.sb.practice.myminisb.entity.Candidate;

import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

  @Autowired
  private ResourceLoader resourceLoader;

  @Autowired
  private ObjectMapper objectMapper;

  @GetMapping("/candidates")
  public List<Candidate> getCandidates() throws IOException {
    Resource resource = resourceLoader.getResource("classpath:candidates.json");
    List<Candidate> candidates = objectMapper.readValue(
      resource.getInputStream(),
      new TypeReference<List<Candidate>>() {}
    );
    return candidates;
  }

}
