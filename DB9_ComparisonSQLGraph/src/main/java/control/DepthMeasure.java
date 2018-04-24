package control;


import java.util.ArrayList;
import java.util.Collections;


public class DepthMeasure {
    private ArrayList<Double> data;
    private String type;

     public Double getAverage(ArrayList<Double> list){
        Double totaltime = 0.0;
        for (Double dub : list) {
            totaltime += dub;
        }
        return totaltime/20;
    }

    public Double getMedian(ArrayList<Double> list) {
        int middle = list.size()/2;
        middle = middle % 2 == 0? middle - 1 : middle;
        return list.get(middle);
}
}

