import com.sun.jdi.request.DuplicateRequestException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Menu {
    public static int printMainMenu(Scanner scan) {
        System.out.println("1 -> Add Note");
        System.out.println("2 -> Remove Note");
        System.out.println("3 -> Show notes");
        System.out.println("4 -> Export Note");
        System.out.println("5 -> Exit");
        System.out.print("Choose an option : ");
        return scan.nextInt();
    }

    public static void addNoteMenu(NoteBook noteBook, Scanner scan) throws DuplicateNameException {
        String text = "";
        System.out.print("Enter Note's Title (if you want to back to main menu enter 0): ");
        scan.nextLine();
        String name = scan.nextLine();
        if (name.equals("0")) {
            return;
        }
        System.out.println();
        if (noteBook.containNote(name)) {
            throw new DuplicateNameException();
        }
        System.out.println("Enter your Note which ends with (#) :");
        do {
            String tmp = scan.nextLine();
            text = text + "\n" + tmp;
        } while (!text.contains("#"));
        text = text.split("#")[0];
        noteBook.addNote(name, text);
        System.out.println("success");
        System.out.println(name);
    }


    public static void removeNoteMenu(NoteBook noteBook, Scanner scan) throws NotFoundException, EmptyNoteBookException{
        System.out.println();
        if (noteBook.notes.isEmpty()) {
            throw new EmptyNoteBookException();
        }
        noteBook.printNoteBook();
        System.out.println();
        System.out.print("Choose which one to remove (if you want to back to main menu enter 0): ");
        int index = scan.nextInt();
        if (index == 0) {
            return;
        }
        if (index > noteBook.notes.size()) {
            throw new NotFoundException();
        }
        noteBook.removeNote(index);
        System.out.println();
        System.out.println("success");
    }

    public static void printShowMenu(NoteBook noteBook, Scanner scan) throws NotFoundException, EmptyNoteBookException {
        System.out.println();
        noteBook.printNoteBook();
        if (noteBook.notes.isEmpty()) {
            throw new EmptyNoteBookException();
        }
        System.out.println();
        System.out.print("Choose which one you want to read (if you want to back to main menu enter 0): ");
        int index = scan.nextInt();
        if (index == 0) {
            return;
        }
        if (index > noteBook.notes.size()) {
            throw new NotFoundException();
        }
        noteBook.printNote(index);
    }

    public static void printExportMenu(NoteBook noteBook, Scanner scan) throws EmptyNoteBookException, IOException, NotFoundException {
        System.out.println();
        noteBook.printNoteBook();
        if (noteBook.notes.isEmpty()) {
            throw new EmptyNoteBookException();
        }
        System.out.println();
        System.out.println("Choose which file you want to save : ");
        int index = scan.nextInt();
        if (index > noteBook.notes.size()) {
            throw new NotFoundException();
        }
        int i = 1;
        Note mainNote = null;
        for (Note note : noteBook.notes.values()) {
            if (i == index) {
                mainNote = note;
            }
        }
        if (mainNote == null) {
            throw new NotFoundException();
        }
        String filePath = "./export/";
        filePath = filePath + mainNote.getName() + ".txt";
        File txtFile = new File(filePath);
        txtFile.createNewFile();
        FileWriter fileWriter = new FileWriter(txtFile);
        fileWriter.write(mainNote.getText());
        System.out.println("note successfully added to file named " + mainNote.getName() + " in export directory");
        fileWriter.close();
    }
}
