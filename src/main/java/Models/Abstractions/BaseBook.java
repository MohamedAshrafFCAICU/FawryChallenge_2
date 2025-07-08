package Models.Abstractions;

public abstract class BaseBook
{
    private String isbn;

    private String title;

    private String author;

    private int yearOfPublish;

    private double price;


    public BaseBook(String isbn, String title, String author, int yearOfPublish, double price) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.yearOfPublish = yearOfPublish;
        this.price = price;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
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

    public int getYearOfPublish() {
        return yearOfPublish;
    }

    public void setYearOfPublish(int yearOfPublish) {
        this.yearOfPublish = yearOfPublish;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }




    public abstract boolean canBeSold();
    public abstract boolean isAvailable();
    public abstract void processPurchase(int quantity, String email, String address) throws Exception;
}
