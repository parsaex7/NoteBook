import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        NoteBook noteBook = new NoteBook();
        try {
            while (true) {
                int option = Menu.printMainMenu(scan);
                if (option == 1) {
                    Menu.addNoteMenu(noteBook, scan);
                } else if (option == 2) {

                } else if (option == 3) {
                    Menu.printShowMenu(noteBook, scan);
                } else if (option == 4) {

                } else if (option == 5) {
                    System.out.println("Bye");
                    return;
                }
            }
        } catch (DuplicateNameException e) {
            System.out.println(e.msg);
        }
    }
}
