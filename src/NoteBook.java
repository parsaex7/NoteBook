import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class NoteBook {
    public HashMap<String, Note> notes;

    public NoteBook () {
        notes = new HashMap<>();
    }

    public void addNote(String name, String text) {
        Note note = new Note(name, text);
        notes.put(name, note);
    }

    public void removeNote(String name) {
        notes.remove(name);
    }

    public void removeNote(int index) {
        int i = 0;
        for (Note note : notes.values()) {
            if (i == index - 1) {
                notes.remove(note.getName());
                return;
            }
            i++;
        }
    }


    public void printNote(int index) {
        int i = 1;
        for (Note note : notes.values()) {
            if (i == index) {
                System.out.println(note);
            }
        }
    }

    public boolean containNote(String name) {
        return notes.containsKey(name);
    }

    public void printNoteBook() {
        int i = 1;
        System.out.println("There is " + notes.size() + " Notes in this NoteBook");
        for (Note note : notes.values()) {
            System.out.print(i + " -> ");
            System.out.print(note);
            System.out.println("\t\t\t\t" + note.getTime());
            i++;
        }
    }
}
