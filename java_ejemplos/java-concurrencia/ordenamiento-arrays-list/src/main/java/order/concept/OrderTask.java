package order.concept;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class OrderTask implements Runnable {

    private List<Range> list;

    public OrderTask(List<Range> list){
        this.list = new ArrayList<Range>();
        this.list = list;
    }

    public void run() {

        Collections.sort(list, new Comparator<Range>(){

            public int compare(Range o1, Range o2) {
                return String.valueOf(o1.getStart()).compareToIgnoreCase(String.valueOf(o2.getStart()));
            }

        });

    }
}
