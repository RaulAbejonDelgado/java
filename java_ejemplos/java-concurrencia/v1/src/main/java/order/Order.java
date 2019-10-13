package order;

import java.security.SecureRandom;
import java.text.NumberFormat;
import java.time.Duration;

import java.time.Instant;
import java.util.Arrays;

public class Order {

    public static void main(String[] args) {

        SecureRandom generator = new SecureRandom();

        int[] array1 = generator.ints(15_000_000).toArray();
        int[] array2 = new int[array1.length];
        System.arraycopy(array1,0,array2,0,array1.length);

        Instant sortStart = Instant.now();
        Arrays.sort(array1);
        Instant sortEnd = Instant.now();

        long sortTime = Duration.between(sortStart,sortEnd).toMillis();

        System.out.printf("TOTAL miliseconds %d%n%n",sortTime);

        System.out.println("Starting parallel order");

        Instant parallelSortStart = Instant.now();
        Arrays.parallelSort(array2);
        Instant parallelSortEnd = Instant.now();

        long parallelSortTime = Duration.between(parallelSortStart,parallelSortEnd).toMillis();

        System.out.printf("TOTAL miliseconds Parallel way %d%n%n",parallelSortTime);

        String percent = NumberFormat.getPercentInstance().format( sortTime/parallelSortTime) ;

        System.out.printf("Parallel sort is %s faster",percent);




    }



}
