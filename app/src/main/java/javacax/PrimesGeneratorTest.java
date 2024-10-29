package javacax;

public class PrimesGeneratorTest {
    public static void main(String[] args) {
        int N = 10; // Количество простых чисел, которое нужно вывести
        PrimesGenerator primesGenerator = new PrimesGenerator(N);

        System.out.println("Простые числа в прямом порядке:");
        while (primesGenerator.hasNext()) {
            System.out.print(primesGenerator.next() + " ");
        }

        System.out.println("\nПростые числа в обратном порядке:");
        while (primesGenerator.hasNext()) {
            System.out.print(primesGenerator.next() + " ");
        }
    }
}