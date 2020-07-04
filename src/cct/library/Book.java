package cct.library;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author GILMAR
 */
public class Book {

    private String title;
    private String author;
    private String genre;
    private int year;
    private int isbn;
    

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }


    public String toString() {
        return "---------------Book---------------" + "\nTitle: " + this.title + "\nAuthor: " + author + "\nGenre: " + this.genre + "\nYear: " + this.year + "\nISBN: " + this.isbn ;
    }
}
