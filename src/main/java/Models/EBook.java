package Models;

import InventoryManagement.MailService;
import Models.Abstractions.BaseBook;
import Models.Abstractions.IFile;

public class EBook extends BaseBook implements IFile
{
    private String extension;

    public EBook(String isbn, String title, String author, int yearOfPublish, double price, String extension) {
        super(isbn, title, author, yearOfPublish, price);
        this.extension = extension;
    }


    @Override
    public void setExtension(String extension) {
        this.extension = extension;
    }

    @Override
    public String getExtension() {
        return extension;
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
    public void processPurchase(int quantity, String email, String address) throws Exception {
        if (isAvailable())
            MailService.sendMail(this , email);
    }
}
