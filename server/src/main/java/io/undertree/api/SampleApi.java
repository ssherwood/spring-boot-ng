package io.undertree.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;

@RestController
@RequestMapping("/api")
public class SampleApi {

    @GetMapping("timestamp")
    public Instant getTimestamp() {
        return Instant.now();
    }

    @GetMapping("foo")
    public ResponseEntity<String> foo() {
        return ResponseEntity.notFound().build();
    }
}
