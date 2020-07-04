package cct.library;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author GILMAR
 */
public class SetUp {

    Random random = new Random();
    // Creating an array of authors.
    String[] author = {"John Bunyan", "Daniel Defoe", "Thomas Love Peacock", "Benjamin Disraeli", "Emily Bronte", "Charlotte Bronte",
        "Nathaniel Hawthorne", "Herman Melville", "Gustave Flaubert", "Wilkie Collins"};
    //Creating an array of genre.
    String[] genre = {"drama", "horror", "romance", "thriller", "comedy"};
    //Creating an arry of usedIsbns of which will be used to compare if the Isbns whether exists or not.
    int[] usedIsbns = new int[500];
    ArrayList list = new ArrayList<>();
    //Method used to read the title from a text file.

    public ArrayList<String> readTitle() {

        String nextWord = "a";
        try {

            BufferedReader listOfTitles = new BufferedReader(new FileReader("titles.txt"));

            String str;
            while ((str = listOfTitles.readLine()) != null) {
                list.add(str);
            }

        } catch (IOException e) {
            System.out.println("File Access Error.");
            System.exit(1);

        }
        return list;
    }
    // Generating the Isbn randomly

    public int generateUniqueIsbn() {
        int randomIsbn = random.nextInt(10000);

        while (!isIsbnUnique(randomIsbn)) {
            randomIsbn = random.nextInt(10000);

        }
        
        return randomIsbn;
    }

    // A boolean method created to verify whether there Isbn duplicated.
    public boolean isIsbnUnique(int randomIsbn) {
        for (int isbn : usedIsbns) {
            if (isbn == randomIsbn) {
                return false;
            }
        }
        return true;
    }
     // Generating the year randomly
    public int randomYear() {
        return random.nextInt(2019 - 1950) + 1950;
    }
     // Generating the author randomly
    private String randomAuthor() {
        return author[random.nextInt(10)];
    }
     // Generating the genre randomly
    private String randomGenre() {
        return genre[random.nextInt(5)];
    }

    public Book[]createBook() {
        ArrayList<Book> books = new ArrayList<>();
        

        for (int i = 0; i < 500; i++) {
            Book singleBook = new Book();
            singleBook.setTitle(readTitle().get(i));
            singleBook.setAuthor(randomAuthor());
            singleBook.setGenre(randomGenre());
            singleBook.setYear(randomYear());
            singleBook.setIsbn(generateUniqueIsbn());
            books.add(singleBook);
            

        }//Converter to an array
        Book[] booksArray = new Book[books.size()];
        return books.toArray(booksArray);
     
    }
  
   
}

