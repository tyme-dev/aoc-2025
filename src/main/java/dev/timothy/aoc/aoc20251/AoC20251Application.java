package dev.timothy.aoc.aoc20251;

import dev.timothy.aoc.aoc2025.first.First;
import lombok.extern.slf4j.Slf4j;
import org.jspecify.annotations.NullMarked;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

@Slf4j
@SpringBootApplication
public class AoC20251Application implements CommandLineRunner {
    First first;

    public static void main(String[] args) {
        SpringApplication.run(AoC20251Application.class, args);
    }

    @NullMarked
    @Override
    public void run(String... args) throws Exception {
        log.info("First Solution: {}", First.determineSolution(50, 99));

    }

}
