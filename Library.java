import java.util.ArrayList;
import java.util.List;

public class Library {
    String bookAvaible;

    List<String> bookAvaibleList = new ArrayList<>();// Creamos una lista para agregar solo los títulos.
    List<Book> bookList = new ArrayList<>(); // Creamos una lista para agregar la información de cada libro.

    public void listBookAdd(String title, String author, int publicationYear, int numberPages, String ISBN) {
        if (ISBN.length() != 13) { // Los ISBN de los libros tienen 13 caracteres.
            Console.writeLine("El ISBN del libro tiene un número incorrecto de caracteres.");
        } else if (ISBN.length() == 13) {
            boolean alreadyAdded = false; // Variable para indicar si el libro ya fue agregado
            for (int i = 0; i < bookAvaibleList.size(); i++) {
                if (ISBN.equals(bookAvaibleList.get(i))) {
                    Console.writeLine("El libro ya se encuentra agregado.");
                    alreadyAdded = true; // Indicamos que el libro ya fue agregado
                    break; // Salimos del bucle si encontramos el ISBN en la lista
                }
            }
            if (!alreadyAdded) { // Si el libro no ha sido agregado todavía
                bookAvaibleList.add(ISBN); // Agrega el ISBN del libro al listado de libros disponibles.
                Console.writeLine("El libro se agregó con éxito.");
                bookList.add(new Book(title, author, publicationYear, numberPages, ISBN));
            }
        }
    }

    public void borrowBook(String ISBN) {
        boolean booksAvaible;// Confirma que un libro esta disponible.
        boolean booksAvaible1;// Confirma que la biblioteca tenga un libro.
        booksAvaible1 = bookList.contains(ISBN);// Revisa si se tiene o no el libro en la biblioteca.
        booksAvaible = bookAvaibleList.contains(ISBN);// Revisa si se encuentra o no el libro.
        if (booksAvaible) {
            bookAvaibleList.remove(ISBN);// Retiramos al primer libro que encuentre con ese ISBN.
            Console.writeLine("El libro fue prestado con exito.");
        } else if (!booksAvaible1) {
            Console.writeLine("El libro no se encuentra disponible en la biblioteca.");
        } else {
            Console.writeLine("El libro se encuentra prestado, busca otros libros.");
        }

    }

    public void returnBook(String ISBN) {
        for (int i = 0; i < bookAvaibleList.size(); i++) {
            if (bookAvaibleList.get(i) == null) {// Revisa si el conjunto esta vació.
                bookAvaibleList.set(i, ISBN);// Agregamos el ISBN en la posición que se encuentre vacía.
                Console.writeLine("El libro fue devuelto con éxito.");
                return; // Terminamos el método después de agregar el ISBN vacío
            }
        }
        Console.writeLine("No hay posiciones vacías para devolver el libro.");
    }
    

    public void deleteBook(String ISBN) {// Elimina el ISBN de la biblioteca.
        boolean booksAvaible1;// Confirma que la biblioteca tenga un libro.
        booksAvaible1 = bookAvaibleList.contains(ISBN);// Revisa si se tiene o no el libro en la biblioteca.
        if (!booksAvaible1) {
            Console.writeLine("El libro fue eliminado con exito.");
        }
    }

    public void returnListBooks() {
        // Imprimir ISBNs de libros disponibles
        Console.writeLine("Lista de ISBN de libros disponibles:");
        for (String ISBN : bookAvaibleList) {
            Console.writeLine(ISBN);
        }

        // Imprimir detalles de libros en bookList
        Console.writeLine("");
        Console.writeLine("Lista de los libros en posesión de la biblioteca y sus detalles:");
        for (Book libro : bookList) {
            Console.writeLine("Título: " + libro.getTitle());
            Console.writeLine("Autor: " + libro.getAuthor());
            Console.writeLine("Año de publicación: " + libro.getPublicationYear());
            Console.writeLine("Número de páginas: " + libro.getNumberPages());
            Console.writeLine("ISBN: " + libro.getISBN());
            Console.writeLine(); // Agregar una línea en blanco entre cada libro
        }
    }

    public String getBookAvaible() {
        return bookAvaible;
    }

    public void setBookAvaible(String bookAvaible) {
        this.bookAvaible = bookAvaible;
    }
}
