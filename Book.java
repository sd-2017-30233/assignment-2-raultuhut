package app;

/**
 * Created by Raul on 4/24/2017.
 */
public class Book {

    String title;
    String author;
    String genre;
    int quantity;
    double price;

    public Book(){}

     public Book( String title,String author,String genre,int quantity,double price){
         this.title=title;
         this.author=author;
         this.genre=genre;
         this.quantity=quantity;
         this.price=price;
     }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
