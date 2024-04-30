package app.practice.springbootpractice;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;


@Slf4j
@RestController
public class CachingController {

    @GetMapping("/cache")
    @Cacheable(value="manDuRutSam")
    public Value doCaching() {
        Value name = new Value("name", 1);// just to return a v
        log.info("doCaching() called :: {}", LocalDateTime.now());

        return name;
    }

    @AllArgsConstructor
    @Getter
    private static class Value {
        private String name;
        private int age;
    }
}
