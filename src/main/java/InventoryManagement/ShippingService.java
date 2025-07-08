package InventoryManagement;

import Models.PaperBook;

public  class ShippingService
{
    public static void ship(PaperBook book , int quantity , String address)
    {
        System.out.println("Quantum book store: Shipping " + quantity + " copies of '" +
                book.getTitle() + "' to address: " + address);
    }
}
