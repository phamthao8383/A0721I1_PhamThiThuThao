package ss4_lop_va_doi_tuong_java.bai_tap;

public class StopWatch {
    private Long startTime;
    private Long endTime;
    private Long elapsedTime;

    public StopWatch(){};
    public Long getStartTime() {
        return startTime;
    }

    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }

    public Long getEndTime() {
        return endTime;
    }

    public void setEndTime(Long endTime) {
        this.endTime = endTime;
    }

    public Long getElapsedTime() {
        return elapsedTime;
    }

    public void setElapsedTime(Long elapsedTime) {
        this.elapsedTime = elapsedTime;
    }

    public static void main(String[] args) {
        StopWatch stopWatch=new StopWatch();

    }
}
