public class Book {
    String tittle;
    String author;
    int publicationYear;
    int numberPages;
    String ISBN;
    //tittle
    public String getTitle(){
        return tittle;
    }

    public void setTitle(String tittle){
        this.tittle = tittle;
    }

    //autor
    public String getAuthor(){
        return author;
    }

    public void setAuthor(String autor){
        this.author = autor;
    }

    //id
    public String getISBN(){
        return ISBN;
    }

    public void setISBN(String ISBN){
        this.ISBN = ISBN;
    }

    //numberpages
    public int getNumberPages(){
        return numberPages;
    }

    public void setNumberPages(int numberPages){
        this.numberPages = numberPages;
    }

    //publicationyear
    public int getPublicationYear(){
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear){
        this.publicationYear = publicationYear;
    }

    public Book(String title, String author, int publicationYear, int numberPages, String ISBN){//Usaramos este metodo para
        //crear la lista dinamica que guarde la información de los libros.
        this.tittle= title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.numberPages = numberPages;
        this.ISBN = ISBN;
    }

    public String toString(){
        return "Book [title:" + tittle + ", author:" + author + ", publicationYear:" + publicationYear + ", numberPages:" + "]";
    }
}
