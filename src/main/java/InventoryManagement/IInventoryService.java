package InventoryManagement;

import Models.Abstractions.BaseBook;


import java.util.HashSet;
import java.util.Set;


public interface IInventoryService
{
    public boolean isStockFree();

    public void seed();

    public String addBook(BaseBook book);

    public Set<BaseBook> removeAndReturnOutDatedBooks(int yearsOld);

    public String buyBook(String isbn , int quantity , String email ,String address);
}
