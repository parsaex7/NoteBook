import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        NoteBook noteBook = new NoteBook();
        while (true) {
            try {
                int option = Menu.printMainMenu(scan);
                if (option == 1) {
                    Menu.addNoteMenu(noteBook, scan);
                } else if (option == 2) {
                    Menu.removeNoteMenu(noteBook, scan);
                } else if (option == 3) {
                    Menu.printShowMenu(noteBook, scan);
                } else if (option == 4) {
                    Menu.printExportMenu(noteBook, scan);
                } else if (option == 5) {
                    System.out.println("Bye");
                    return;
                }
            } catch (DuplicateNameException | NotFoundException e) {
                System.out.println(e.getMessage());
            } catch (EmptyNoteBookException e) {
                System.out.println("Empty NoteBook, try another command");
            } catch (IOException e) {
                System.out.println("attempt for open invalid file!");
            }
        }
    }
}
