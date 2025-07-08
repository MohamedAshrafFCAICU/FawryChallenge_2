package Fawry;

import InventoryManagement.IInventoryService;
import InventoryManagement.InventoryService;
import Models.Abstractions.BaseBook;
import Models.EBook;
import Models.PaperBook;

import java.util.Set;


public class Main {
    public static void main(String[] args)
    {
        System.out.println("===============================================");
        System.out.println("QUANTUM BOOKSTORE - INVENTORY MANAGEMENT SYSTEM");
        System.out.println("===============================================\n");


        InventoryService inventoryService = new InventoryService();
        if(inventoryService.isStockFree())
            inventoryService.seed();

        System.out.println();
        System.out.println("TEST 3: Adding New Books Manually");


        PaperBook newPaperBook = new PaperBook("978-1234567890", "Test Paper Book",
                "Test Author", 2023, 29.99, 50);
        System.out.println(inventoryService.addBook(newPaperBook));


        EBook newEBook = new EBook("978-0987654321", "Test EBook",
                "Digital Author", 2023, 19.99, "PDF");
        System.out.println(inventoryService.addBook(newEBook));

        // Try to add duplicate book
        System.out.println("Trying to add duplicate book:");
        System.out.println(inventoryService.addBook(newPaperBook));

        // Try to add book with invalid price
        System.out.println("Trying to add book with negative price:");
        PaperBook invalidPriceBook = new PaperBook("978-1111111111", "Invalid Price Book",
                "Author", 2023, -10.00, 10);
        System.out.println(inventoryService.addBook(invalidPriceBook));

        // Try to add book with invalid year
        System.out.println("Trying to add book with future year:");
        PaperBook invalidYearBook = new PaperBook("978-2222222222", "Future Book",
                "Author", 2026, 25.00, 10);
        System.out.println(inventoryService.addBook(invalidYearBook));
        System.out.println();

        // Test 4: Buy Paper Books
        System.out.println("TEST 4: Buying Paper Books");

        // Check stock before purchase
        System.out.println(inventoryService.checkStock("978-0134685991"));

        // Buy Effective Java - successful purchase
        System.out.println("Buying 2 copies of Effective Java:");
        System.out.println(inventoryService.buyBook("978-0134685991", 2,
                "customer@email.com", "123 Main St, City"));

        // Check stock after purchase
        System.out.println(inventoryService.checkStock("978-0134685991"));

        // Try to buy more than available stock
        System.out.println("\nTrying to buy 100 copies of Clean Code:");
        System.out.println(inventoryService.buyBook("978-0132350884", 100,
                "bulk@email.com", "456 Oak Ave"));
        System.out.println();

        // Test 5: Buy EBooks
        System.out.println("TEST 5: Buying EBooks");

        // Check ebook availability
        System.out.println(inventoryService.checkStock("978-1491950296"));

        // Buy ebook
        System.out.println("Buying 5 copies of Building Microservices (EBook):");
        System.out.println(inventoryService.buyBook("978-1491950296", 5,
                "ebook.lover@email.com", "Not needed"));

        // Buy multiple ebooks (should always work)
        System.out.println("\nBuying 1000 copies of Python Tricks (EBook):");
        System.out.println(inventoryService.buyBook("978-1492051138", 1000,
                "bulk.ebook@email.com", "Digital delivery"));
        System.out.println();

        // Test 6: Try to buy Demo/Showcase Books
        System.out.println("TEST 6: Trying to Buy Demo/Showcase Books");
        System.out.println(inventoryService.checkStock("978-0747532699"));
        System.out.println("Trying to buy Harry Potter First Edition:");
        System.out.println(inventoryService.buyBook("978-0747532699", 1,
                "collector@email.com", "789 Collector Lane"));
        System.out.println();

        // Test 7: Invalid Purchase Attempts
        System.out.println("TEST 7: Invalid Purchase Attempts");

        // Invalid ISBN
        System.out.println("Trying to buy with null ISBN:");
        System.out.println(inventoryService.buyBook(null, 1,
                "test@email.com", "Address"));

        // Non-existent book
        System.out.println("\nTrying to buy non-existent book:");
        System.out.println(inventoryService.buyBook("978-9999999999", 1,
                "test@email.com", "Address"));

        // Invalid email
        System.out.println("\nTrying to buy with invalid email:");
        System.out.println(inventoryService.buyBook("978-0134685991", 1,
                "invalid-email", "Address"));

        // Invalid quantity
        System.out.println("\nTrying to buy with negative quantity:");
        System.out.println(inventoryService.buyBook("978-0134685991", -5,
                "test@email.com", "Address"));

        // Empty address
        System.out.println("\nTrying to buy with empty address:");
        System.out.println(inventoryService.buyBook("978-0134685991", 1,
                "test@email.com", ""));
        System.out.println();

        // Test 8: Remove Outdated Books
        System.out.println("TEST 8: Removing Outdated Books");
        System.out.println("Removing books older than 20 years:");
        Set<BaseBook> outdatedBooks = inventoryService.removeAndReturnOutDatedBooks(20);
        System.out.println("Number of books removed: " + outdatedBooks.size());
        System.out.println("Removed books:");
        for (BaseBook book : outdatedBooks) {
            System.out.println("  - " + book.getTitle() + " (" + book.getYearOfPublish() + ")");
        }
        System.out.println();

        // Test 9: Complex Purchase Scenario
        System.out.println("TEST 9: Complex Purchase Scenario");

        // Buy all remaining stock of a book
        System.out.println(inventoryService.checkStock("978-0804137382")); // Essentialism
        System.out.println("Buying all remaining copies of Essentialism:");
        System.out.println(inventoryService.buyBook("978-0804137382", 18,
                "bulk.buyer@email.com", "Warehouse Address"));
        System.out.println(inventoryService.checkStock("978-0804137382"));

        // Try to buy from empty stock
        System.out.println("\nTrying to buy from empty stock:");
        System.out.println(inventoryService.buyBook("978-0804137382", 1,
                "late.buyer@email.com", "Too Late Street"));
        System.out.println();

        // Test 10: Stock Status Report
        System.out.println("TEST 10: Stock Status Report for Various Books");
        String[] isbnsToCheck = {
                "978-0547928227",
                "978-1491910771",
                "978-0486280615",
                "978-1234567890",
                "978-0987654321"
        };

        for (String isbn : isbnsToCheck) {
            System.out.println(inventoryService.checkStock(isbn));
        }

        System.out.println("\n===============================================");
        System.out.println("ALL TESTS COMPLETED");
        System.out.println("===============================================");
    }
}