
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Appointment {

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setDtf(DateTimeFormatter dtf) {
        this.dtf = dtf;
    }

    private LocalDateTime date;
    private String text;

    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy - HH.mm");

    public Appointment(LocalDateTime date, String text) {
        this.date = date;

        this.text = text;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return String.format("%s  --> %s", dtf.format(date), text);
    }
}
