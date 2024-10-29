package javacax;

import java.util.Iterator;

public class PrimesGenerator implements Iterator<Integer> {
    private int count;
    private int currentNumber;

    public PrimesGenerator(int count) {
        this.count = count;
        this.currentNumber = 2; // Начинаем с первого простого числа
    }

    @Override
    public boolean hasNext() {
        return count > 0;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new java.util.NoSuchElementException();
        }

        int prime = findNextPrime();
        count--;
        return prime;
    }

    private int findNextPrime() {
        while (true) {
            if (isPrime(currentNumber)) {
                return currentNumber;
            }
            currentNumber++;
        }
    }

    private boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}