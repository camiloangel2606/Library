import java.util.function.LongBinaryOperator;

public class Main {
    private Library library = new Library();

    public void showMenu() {
        int option = 0, numberPages = 0, publicationYear = 0;
        String ISBN = "", title = "", author = "";

        do {
            Console.writeLine("MENU PRINCIPAL.");
            Console.writeLine();
            Console.writeLine("(1) Agregar un libro, (2) Prestar un libro, (3) Devoler un libro, (4) Imprimir los ISBN disponibles");
            Console.writeLine("y los detalles de TODOS los libros que tiene la biblioteca, (5) Elimina un libro de la biblioteca.");
            Console.writeLine();
            Console.writeLine("(9) Salir.");
            Console.writeLine();
            Console.writeLine("Ingrese una opción y presione [ENTER].");
            option = Integer.parseInt(Console.readLine());

            if(option == 1){
            Console.writeLine("Ingresa el título del libro.");
            title = Console.readLine();

            Console.writeLine("Ingresa el autor del libro.");
            author = Console.readLine();

            Console.writeLine("Ingresa el año de publicación del libro.");
            publicationYear = Integer.parseInt(Console.readLine());

            Console.writeLine("Ingresa el número de paginas del libro.");
            numberPages = Integer.parseInt(Console.readLine());

            Console.writeLine("Ingresa el ISBN del libro.");
            ISBN = Console.readLine();

            library.listBookAdd(title, author, publicationYear, numberPages, ISBN);

            }else if(option == 2){
            Console.writeLine("Ingresa el ISBN del libro.");
            ISBN = Console.readLine();
            library.borrowBook(ISBN);

            }else if(option == 3){
            Console.writeLine("Ingresa el ISBN del libro.");
            ISBN = Console.readLine();
            library.returnBook(ISBN);

            }else if(option == 4){
            library.returnListBooks();

            }else if(option == 5){
            Console.writeLine("Ingresa el ISBN del libro.");
            ISBN = Console.readLine();
            library.deleteBook(ISBN);
            }

        } while (option != 9);
    }

    public static void main(String[] args) {
        new Main().showMenu();
    }
}