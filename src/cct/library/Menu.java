/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cct.library;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author GILMAR
 */
public class Menu {
    
    
    private int userOption;
    Scanner op = new Scanner(System.in);
    String user;
    int id;
    boolean authorSelected = false;
    String author;
    Book[] books;

    //
    public void menuOptions() {
        // Welcome message to the user
        System.out.println("------------------------------ ");
        System.out.println("|                             | ");
        System.out.println("|    WELCOM TO CCT LIBRARY    |   ");
        System.out.println("|                             | ");
        System.out.println("------------------------------ ");

        Logic logic = new Logic();
        SetUp setup = new SetUp();
        this.books = setup.createBook();

        //Starting with the do loop because it has to run independently until the user get out the looping
        do {
            //Menu 
            System.out.println("---------Select method-------- ");
            System.out.println(" ");
            System.out.println("0) - Sort books by title");
            System.out.println("1) - Sort books by year");
            System.out.println("2) - Sort books by isbn");
            System.out.println("3) - Sort books by gender");
            if (!authorSelected) {
                System.out.println("4) - Sort by author");
            } else {
                System.out.println("4) - Unselect author " + author);
            }
            System.out.println("5) - Sort by title and author");
            System.out.println("6) - Exit \n");
            

            //Asking the user a choice
            System.out.println("Type in your option by the numbers: ");

            //Scanner to collect the input from the user
            user = op.next();
            // Switch and case used to give the user option 
            switch (user) {
                case "0": {
                    // First option runs the bubble Sort method which will sort the books by title.
                    if (!authorSelected) {
                        int iterations = logic.bubbleSort(books);
                        prettyPrintBooks(books);
                        printIterations(books.length, iterations);
                    } else {
                        Book[] books = booksForAuthor(author);
                        int iterations = logic.bubbleSort(books);
                        prettyPrintBooks(books);
                        printIterations(books.length, iterations);
                    }
                    break;
                }
                case "1": {
                        // Second option runs the Selection Sort method which will sort the books by year.
                    if (!authorSelected) {
                        int iterations = logic.SelectionSort(books);
                        prettyPrintBooks(books);
                        printIterations(books.length, iterations);
                    } else {
                        Book[] books = booksForAuthor(author);
                        int iterations =logic.SelectionSort(books);
                        prettyPrintBooks(books);
                        printIterations(books.length, iterations);
                        System.out.println(" ");
                    }
                    break;
                }
                case "2": {
                    // Third option runs the Insert Sort method which will sort the books by isbn.
                    if (!authorSelected) {
                        int iterations = logic.InsertSort(books);
                        prettyPrintBooks(books);
                        printIterations(books.length, iterations);
                    } else {
                        Book[] books = booksForAuthor(author);
                        int iterations = logic.InsertSort(books);
                        prettyPrintBooks(books);
                        printIterations(books.length, iterations);
                        System.out.println(" ");
                    }
                    break;
                }
                case "3": {
                    // Fourth option runs the Merge Sort method which will sort the books by gender.
                  if (!authorSelected) {
                        logic.sort(books, 0, books.length - 1);
                        prettyPrintBooks(books);
                        printIterations(books.length, logic.getIterations());
                    } else {
                        Book[] books = booksForAuthor(author);
                        logic.sort(books, 0, books.length - 1);
                        prettyPrintBooks(books);
                        System.out.println(" ");
                    }
                    break;


                }
                case "4": {
                // Fifth option runs the Selection Sort method which will sort the books by authors.

                    if (!authorSelected) {
                        System.out.println("------Select author------ ");
                        System.out.println(" ");
                        System.out.println("0) - John Bunyan");
                        System.out.println("1) - Daniel Defoe");
                        System.out.println("2) - Thomas Love Peacock");
                        System.out.println("3) - Jack London");
                        System.out.println("4) - Marcel Proust");
                        System.out.println("5) - Erskine Childers");
                        System.out.println("6) - Ernest Hemingway");
                        System.out.println("7) - William Golding");
                        System.out.println("8) - George Orwell");
                        System.out.println("9) - Louis De Bernieres");
                        int authorNumber = 0;
                        try {
                            authorNumber = op.nextInt();
                            System.out.println("Sorting author: " + setup.author[authorNumber]);
                            System.out.println(" ");
                        } catch (Exception e) {
                            System.out.println("Sorting author: John Bunyan");
                        }
                        author = setup.author[authorNumber];
                    } else {
                        author = null;
                    }
                    authorSelected = !authorSelected;
                    break;
                }
                case "5": {
                 // Sixth option runs the Binary search method which will sort the books by title and author

                    System.out.println("------------------------- ");
                    System.out.println(" ");
                    System.out.println("Enter book and author: ");
                    String line = op.nextLine();
                    line = op.nextLine();
                  
                    Book book = logic.search(books, line);
                    if (book == null) {
                        System.out.println("--------------------------- ");
                        System.out.println(" ");
                        System.out.println("Book not found");
                    } else {
  
                        System.out.println("--------------------------- ");
                        System.out.println(" ");
                        System.out.println("Book found");
        }
                    break;
                }
            }
                    // Exit
        } while (!"6".equals(user));
        }
                

    private Book[] booksForAuthor(String authorName) {
        List<Book> bookList = new ArrayList<>();
        for (Book book : books) {
            if (book.getAuthor().equals(authorName)) {
                bookList.add(book);
            }
        }
        Book[] booksArray = new Book[bookList.size()];
        return bookList.toArray(booksArray);
    }

    private void printIterations(int length, int iterations) {
        System.out.println("Total elements: " + length);
        System.out.println("Total iterations: " + iterations);
    }

    private void prettyPrintBooks(Book[] books) {
        for (Book book : books) {
            System.out.println(book);
        }
    }
      
    
}
