package dev.timothy.aoc.aoc2025.first;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

@Slf4j
public class First {
    public static int determineSolution(int start, int highestValue) throws IOException, URISyntaxException {
        int totalNums = highestValue + 1;
        final int[] current = new int[1];
        final int[] occurrenceOfZero = {0};
        Path path = Paths.get(First.class.getClassLoader()
                .getResource("static/input.txt").toURI());
        current[0] = start;
        Stream<String> lines = Files.lines(path);
        lines.forEach(line ->

        {
            log.debug("------------------------------------------------");
            int moves = Integer.parseInt(line.substring(1));
            log.debug("# of Moves: {}", moves);
            moves = determineDirection(line, moves);
            log.debug("Moves: {}", moves);
            int pos = moves + current[0];
            log.debug("Pos: {}", pos);
            calculateTurn(pos, current, totalNums);
            log.debug("Current: {}", current[0]);
            if (current[0] == 0) {
                occurrenceOfZero[0]++;
            }
        });

        lines.close();
        return occurrenceOfZero[0];
    }

    private static int determineDirection(String line, int moves) {
        boolean negative = line.charAt(0) == 'L';
        log.debug("Negative? {}", negative);
        moves = negative ? moves * -1 : moves;
        return moves;
    }

    private static void calculateTurn(int pos, int[] current, int totalNums) {
        if (pos >= 0) {
            current[0] = (pos % totalNums);
        } else if (pos >= -totalNums) {
            current[0] = pos + totalNums;
        } else {
            current[0] = (pos % totalNums);
        }
        if (current[0] < 0) current[0] = current[0] + totalNums;
    }
}
