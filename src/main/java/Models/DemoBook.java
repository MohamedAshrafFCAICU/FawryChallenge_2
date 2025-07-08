package Models;

import Models.Abstractions.BaseBook;

public class DemoBook extends BaseBook
{
    public DemoBook(String isbn, String title, String author, int yearOfPublish, double price) {
        super(isbn, title, author, yearOfPublish, price);
    }

    @Override
    public boolean canBeSold() {
        return false;
    }

    @Override
    public boolean isAvailable() {
        return false;
    }

    @Override
    public void processPurchase(int quantity, String email, String address) throws Exception {
        System.out.println("This Book is not for sale");
    }
}
