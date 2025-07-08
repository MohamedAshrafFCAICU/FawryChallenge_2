package InventoryManagement;

import Models.EBook;

import javax.swing.*;

public class MailService
{
    public static void sendMail(EBook book , String email)
    {
        System.out.println("Quantum book store: Emailing "  +
                book.getTitle() + "' (" + book.getExtension() + ") to: " + email);
    }
}
