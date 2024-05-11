import java.time.LocalDateTime;

public class Note {
    private String name;
    private String text;
    private LocalDateTime time;

    public Note(String name ,String text) {
        this.name = name;
        this.text = text;
        time = LocalDateTime.now();
    }

    public String getName() {
        return name;
    }

    public String getText() {
        return text;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public String toString() {
        return "Title : " + name + "\n" + text;
    }
}
