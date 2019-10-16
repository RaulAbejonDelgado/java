import order.concept.Range;
import order.concept.OrderTask;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args){

        List<Range> arrayList = new ArrayList<Range>();

        Range r1 = new Range(1,3);
        Range r2 = new Range(8,9);
        Range r3 = new Range(6,7);
        Range r4 = new Range(1,2);
        Range r5 = new Range(3,4);

        arrayList.add(r2);
        arrayList.add(r3);
        arrayList.add(r4);
        arrayList.add(r5);
        arrayList.add(r1);

        for(Range ab : arrayList) {
            System.out.println(ab.getStart() +" : "+ab.getEnd());
        }

//        Collections.sort(arrayList, new Comparator<Range>(){
//
//            public int compare(Range o1, Range o2) {
//                return String.valueOf(o1.getStart()).compareToIgnoreCase(String.valueOf(o2.getStart()));
//            }
//
//        });

        OrderTask orderTask = new OrderTask(arrayList);

        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(orderTask);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for(Range ab : arrayList) {
            System.out.println(ab.getStart() +" : "+ab.getEnd());
        }
    }
}
