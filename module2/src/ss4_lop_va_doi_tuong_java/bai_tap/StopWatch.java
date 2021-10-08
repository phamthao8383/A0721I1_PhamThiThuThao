package ss4_lop_va_doi_tuong_java.bai_tap;

import java.time.LocalTime;
import java.util.Arrays;

public class StopWatch {
    private LocalTime startTime;
    private LocalTime endTime;

    public StopWatch() {
        this.startTime = java.time.LocalTime.now();

    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void start() {
        this.startTime = java.time.LocalTime.now();
    }

    public void stop() {
        this.endTime = java.time.LocalTime.now();
    }

    public String getElapsedTime() {
        return endTime.getHour() - startTime.getHour() + " : " + (endTime.getMinute() - startTime.getMinute()) + " : " + (endTime.getSecond() - startTime.getSecond()) + " : " + (endTime.getNano() - startTime.getNano());
    }

    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();

        int[] array = new int[100000];
        stopWatch.start();
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 100000);

        }
        Arrays.sort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i] + " ");
        }
        stopWatch.stop();
        System.out.println("Thoi gian thuc thi cua thuat toan sap xep "
                + "la " + stopWatch.getElapsedTime() + " ms");
    }
}



