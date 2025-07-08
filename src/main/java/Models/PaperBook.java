package Models;

import InventoryManagement.ShippingService;
import Models.Abstractions.BaseBook;
import Models.Abstractions.IHardCopy;

public class PaperBook extends BaseBook implements IHardCopy
{
    private int numberInStock;

    public PaperBook(String isbn, String title, String author, int yearOfPublish, double price, int numberInStock) {
        super(isbn, title, author, yearOfPublish, price);
        this.numberInStock = numberInStock;
    }

    @Override
    public void setNumberInStock(int numberInStock) {
        this.numberInStock = numberInStock;
    }

    @Override
    public int getNumberInStock() {
        return numberInStock;
    }

    @Override
    public boolean canBeSold() {
        return true;
    }

    @Override
    public boolean isAvailable() {
        return true;
    }

    @Override
    public void processPurchase(int quantity, String email, String address) throws Exception
    {
        if(isAvailable())
            ShippingService.ship(this , quantity , address);
    }
}
