import com.sun.jdi.request.DuplicateRequestException;

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
        System.out.print("Enter Note's Title : ");
        String name = scan.nextLine();
        System.out.println();
        if (noteBook.containNote(name)) {
            throw new DuplicateNameException();
        }
        System.out.println("Enter your Note which ends with (#) :");
        do {
            String tmp = scan.nextLine();
            text = text + "\n" + tmp;
        } while (!text.contains("#"));
        text.replace("#", ".");
        noteBook.addNote(name, text);
        System.out.println("success");
    }

    public static void printShowMenu(NoteBook noteBook, Scanner scan) {
        noteBook.printNoteBook();
        System.out.println();
        System.out.println();
        noteBook.printNoteBook();
        System.out.print("Choose which one you want to read : ");
        int index = scan.nextInt();
        noteBook.printNote(index);
    }
}
