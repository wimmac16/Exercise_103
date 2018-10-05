
import java.time.LocalDate;
import java.time.LocalTime;

public class Appointment {

    private LocalDate date;
    private LocalTime time;
    private String text;

    public Appointment(LocalDate date, LocalTime time, String text) {
        this.date = date;
        this.time = time;
        this.text = text;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getTime() {
        return time;
    }

    public String getText() {
        return text;
    }
    
    @Override
    public String toString(){
        return String.format("%s - %s --> %s", date,time,text);
    }
}
