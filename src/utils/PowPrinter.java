package utils;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class PowPrinter implements Runnable {

    private final int number;
    private final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("mm:ss:ms");

    public PowPrinter(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.printf("%s - %s: %d ^ %d = %.0f\n",
                    Thread.currentThread().getName(),
                    LocalTime.now().format(dateTimeFormatter),
                    number,
                    i,
                    Math.pow(number, i));
        }
    }
}
