package InventoryManagement;

import Models.Abstractions.BaseBook;
import Models.DemoBook;
import Models.EBook;
import Models.PaperBook;

import javax.management.InstanceAlreadyExistsException;
import javax.naming.directory.InvalidAttributeValueException;
import java.time.Year;
import java.util.*;

public class InventoryService implements IInventoryService
{
    private HashMap<String , BaseBook> availableBooks;

    public InventoryService() {
        this.availableBooks = new HashMap<>();
    }

    @Override
    public boolean isStockFree()
    {
        return availableBooks.size() ==  0;
    }

    @Override
    public void seed()
    {

        // Paper Books - Technical
        addBook(new PaperBook("978-0134685991", "Effective Java", "Joshua Bloch",
                2018, 54.99, 35));
        addBook(new PaperBook("978-0135957059", "The Pragmatic Programmer",
                "David Thomas, Andrew Hunt", 2019, 49.95, 42));
        addBook(new PaperBook("978-0132350884", "Clean Code", "Robert C. Martin",
                2008, 44.99, 58));
        addBook(new PaperBook("978-0596009205", "Head First Java",
                "Kathy Sierra, Bert Bates", 2005, 47.50, 23));
        addBook(new PaperBook("978-1492056355", "Designing Data-Intensive Applications",
                "Martin Kleppmann", 2017, 59.99, 31));

        // Paper Books - Fiction
        addBook(new PaperBook("978-0547928227", "The Hobbit", "J.R.R. Tolkien",
                2012, 14.99, 125));
        addBook(new PaperBook("978-0439023528", "The Hunger Games", "Suzanne Collins",
                2010, 17.99, 87));
        addBook(new PaperBook("978-0061120084", "To Kill a Mockingbird", "Harper Lee",
                2006, 15.99, 64));
        addBook(new PaperBook("978-0385737951", "The Maze Runner", "James Dashner",
                2010, 16.99, 52));
        addBook(new PaperBook("978-0316769174", "The Catcher in the Rye", "J.D. Salinger",
                1991, 13.99, 38));

        // Paper Books - Business & Self-Help
        addBook(new PaperBook("978-0066620992", "Good to Great", "Jim Collins",
                2001, 27.99, 29));
        addBook(new PaperBook("978-1501111109", "The 7 Habits of Highly Effective People",
                "Stephen R. Covey", 2020, 28.00, 45));
        addBook(new PaperBook("978-0804137382", "Essentialism", "Greg McKeown",
                2014, 24.00, 18));

        // EBooks - Technical
        addBook(new EBook("978-1491950296", "Building Microservices", "Sam Newman",
                2015, 39.99, "PDF"));
        addBook(new EBook("978-1492032632", "Kafka: The Definitive Guide",
                "Neha Narkhede, Gwen Shapira", 2017, 45.99, "PDF"));
        addBook(new EBook("978-1491910771", "Learning React", "Alex Banks, Eve Porcello",
                2020, 35.99, "EPUB"));
        addBook(new EBook("978-1492051138", "Python Tricks", "Dan Bader",
                2017, 29.99, "PDF"));
        addBook(new EBook("978-1617294136", "Spring in Action", "Craig Walls",
                2018, 44.99, "PDF"));
        addBook(new EBook("978-1593279509", "Eloquent JavaScript", "Marijn Haverbeke",
                2018, 31.95, "EPUB"));

        // EBooks - Fiction
        addBook(new EBook("978-0345803481", "Fifty Shades of Grey", "E.L. James",
                2012, 9.99, "EPUB"));
        addBook(new EBook("978-1501175466", "It", "Stephen King",
                2016, 14.99, "EPUB"));
        addBook(new EBook("978-0062024039", "Divergent", "Veronica Roth",
                2011, 12.99, "MOBI"));
        addBook(new EBook("978-0307588364", "Gone Girl", "Gillian Flynn",
                2012, 14.99, "EPUB"));

        // EBooks - Science & History
        addBook(new EBook("978-0553380163", "A Brief History of Time", "Stephen Hawking",
                1998, 13.99, "PDF"));
        addBook(new EBook("978-0375508325", "Guns, Germs, and Steel", "Jared Diamond",
                1999, 14.95, "EPUB"));
        addBook(new EBook("978-0393609394", "Sapiens", "Yuval Noah Harari",
                2015, 24.99, "PDF"));

        // Showcase Books (Rare/Collectible/Display Only)
        addBook(new DemoBook("978-0747532699", "Harry Potter and the Philosopher's Stone (First Edition)",
                "J.K. Rowling", 1997, 2500.00));
        addBook(new DemoBook("978-0684801520", "The Great Gatsby (First Edition Replica)",
                "F. Scott Fitzgerald", 1925, 1200.00));
        addBook(new DemoBook("978-0140177398", "Of Mice and Men (Signed Edition)",
                "John Steinbeck", 1937, 3500.00));
        addBook(new DemoBook("978-0486280615", "The Picture of Dorian Gray (Illustrated Collector's Edition)",
                "Oscar Wilde", 1890, 450.00));
        addBook(new DemoBook("978-0394800011", "The Cat in the Hat (First Edition)",
                "Dr. Seuss", 1957, 850.00));

        // Recent Bestsellers - Mixed
        addBook(new PaperBook("978-1250301697", "The Silent Patient", "Alex Michaelides",
                2019, 16.99, 76));
        addBook(new EBook("978-0525559474", "The Midnight Library", "Matt Haig",
                2020, 13.99, "EPUB"));
        addBook(new PaperBook("978-1984801258", "Where the Crawdads Sing", "Delia Owens",
                2018, 18.00, 94));
        addBook(new EBook("978-0735224292", "Little Fires Everywhere", "Celeste Ng",
                2017, 12.99, "MOBI"));

        // Additional Paper Books
        addBook(new PaperBook("978-0441013593", "Dune", "Frank Herbert",
                2005, 15.95, 48));
        addBook(new PaperBook("978-0062316110", "Becoming", "Michelle Obama",
                2018, 32.50, 67));
        addBook(new PaperBook("978-1476746586", "All the Light We Cannot See", "Anthony Doerr",
                2014, 16.99, 41));
        addBook(new PaperBook("978-0385490818", "The Handmaid's Tale", "Margaret Atwood",
                1998, 15.95, 55));
        addBook(new PaperBook("978-0143127550", "The Girl on the Train", "Paula Hawkins",
                2015, 15.95, 33));

        // Additional EBooks
        addBook(new EBook("978-0062457714", "The Subtle Art of Not Giving a F*ck", "Mark Manson",
                2016, 12.99, "EPUB"));
        addBook(new EBook("978-1501139154", "Leonardo da Vinci", "Walter Isaacson",
                2017, 17.99, "PDF"));
        addBook(new EBook("978-0804172448", "Unbroken", "Laura Hillenbrand",
                2014, 14.99, "MOBI"));

        System.out.println("Quantum book store: Seeding complete. Added " + availableBooks.size() + " books to inventory.");
    }

    @Override
    public String addBook(BaseBook book)
    {
        try {
            if (book == null)
                throw new NullPointerException("Book cannot be null.");

            if (isBookAlreadyExists(book.getIsbn()))
                throw new InstanceAlreadyExistsException("The book already exists.");

            if (!isValidPrice(book.getPrice()))
                throw new InvalidAttributeValueException("The price is invalid.");

            // FIX: Changed from book.getPrice() to book.getYearOfPublish()
            if (!isValidYear(book.getYearOfPublish()))
                throw new InvalidAttributeValueException("The year is invalid.");

            availableBooks.put(book.getIsbn(), book);

            return "Quantum book store: The book added to the inventory.";

        } catch (Exception e) {
            return "Quantum book store: Error - " + e.getMessage();
        }
    }

    @Override
    public Set<BaseBook> removeAndReturnOutDatedBooks(int yearsOld)
    {
        Set<BaseBook> outDatedBooks = new HashSet<>();

        Iterator<HashMap.Entry<String, BaseBook>> iterator = availableBooks.entrySet().iterator();

        while (iterator.hasNext()) {
            HashMap.Entry<String, BaseBook> entry = iterator.next();
            BaseBook book = entry.getValue();

            if (isOutDatedBook(book.getYearOfPublish(), yearsOld)) {
                outDatedBooks.add(book);
                iterator.remove();
                System.out.println("Quantum book store: Removed outdated book - " + book.getTitle());
            }
        }

        return outDatedBooks;
    }

    @Override
    public String buyBook(String isbn, int quantity, String email, String address)
    {
        try {

            if (isbn == null || isbn.isEmpty())
                throw new NullPointerException("Book ISBN cannot be null.");

            if (!isValidEmailFormat(email))
                throw new InvalidAttributeValueException("The email is invalid.");

            if (address == null || address.trim().isEmpty())
                throw new InvalidAttributeValueException("The address is invalid.");

            if (!isValidQuantity(quantity))
                throw new InvalidAttributeValueException("The quantity is invalid.");


            BaseBook book = availableBooks.get(isbn);
            if (book == null)
                throw new ClassNotFoundException("Book not found.");

            if (!book.isAvailable())
                throw new Exception("Book is not available for sale.");

            double totalAmount = book.getPrice() * quantity;


            if (book instanceof PaperBook) {
                PaperBook paperBook = (PaperBook) book;

                if (!isAvailableBookQuantity(paperBook.getNumberInStock(), quantity))
                    throw new InvalidAttributeValueException("Insufficient stock. Available copies: " +
                            paperBook.getNumberInStock());


                int newStock = paperBook.getNumberInStock() - quantity;
                paperBook.setNumberInStock(newStock);


                book.processPurchase(quantity, email, address);

                return "Quantum book store: Purchase successful - " + quantity + " copies of '" +
                        book.getTitle() + "' for $" + totalAmount + ". Remaining stock: " + newStock;

            } else if (book instanceof EBook) {

                book.processPurchase(quantity, email, address);

                return "Quantum book store: Purchase successful - " + quantity + " copies of '" +
                        book.getTitle() + "' (EBook) for $" + totalAmount;

            } else if (book instanceof DemoBook) {
                throw new Exception("Demo/Showcase books are not for sale.");
            }

            return "Quantum book store: Purchase completed.";

        } catch (Exception e) {
            return "Quantum book store: Error - " + e.getMessage();
        }
    }



    private boolean isBookAlreadyExists(String bookIsbn)
    {
        return availableBooks.containsKey(bookIsbn);
    }

    private boolean isValidPrice(Double price)
    {
        return price != null && price > 0.0;
    }

    private boolean isValidYear(int year)
    {
        int currentYear = Year.now().getValue();
        int earliestReasonableYear = 1440;
        return year >= earliestReasonableYear && year <= currentYear;
    }

    private boolean isOutDatedBook(int bookPublishedYear, int yearsOld)
    {
        int currentYear = Year.now().getValue();
        return currentYear - bookPublishedYear > yearsOld;
    }

    private boolean isValidQuantity(int quantity)
    {
        return quantity > 0;
    }

    private boolean isAvailableBookQuantity(int bookQuantity, int neededQuantity)
    {
        return bookQuantity >= neededQuantity;
    }

    private boolean isValidEmailFormat(String email)
    {
        if (email == null || email.trim().isEmpty()) {
            return false;
        }


        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
        return email.matches(emailRegex);
    }

    public String checkStock(String isbn)
    {
        BaseBook book = availableBooks.get(isbn);
        if (book == null) {
            return "Quantum book store: Book not found.";
        }

        if (book instanceof PaperBook) {
            PaperBook paperBook = (PaperBook) book;
            return "Quantum book store: '" + book.getTitle() + "' - Stock: " +
                    paperBook.getNumberInStock() + " copies";
        } else if (book instanceof EBook) {
            return "Quantum book store: '" + book.getTitle() + "' - EBook (unlimited stock)";
        } else {
            return "Quantum book store: '" + book.getTitle() + "' - Demo book (not for sale)";
        }
    }


}
