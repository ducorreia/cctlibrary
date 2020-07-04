/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cct.library;

import java.util.ArrayList;

/**
 *
 * @author GILMAR
 */
public class Logic {
    SetUp setup = new SetUp();
    // The int iterations was determined to quantify de number of iterations of which option in the program executes.
    //Based on it, there will be possible to verify which method would be faster in each situation of sort.
    int iterations;

    public int bubbleSort(Book books[]) {
       int iterations = 0;
        int n = books.length;
        for (int i = 0; i < n - 1; i++)
            for (int j = 0; j < n - i - 1; j++) {
                iterations++;
                if (books[j].getTitle().compareTo(books[j + 1].getTitle()) > 0) {
                    Book temp = books[j];
                    books[j] = books[j + 1];
                    books[j + 1] = temp;
                }
            }
            return iterations;
    }
     

    public int SelectionSort (Book[] books) {
        int iterations = 0;
        int n = books.length;
        // One by one move boundary of unsorted subarray
        for (int i = 0; i < n - 1; i++) {
            // Find the minimum element in unsorted array
            int min_idx = i;
            for (int j = i + 1; j < n; j++) {
                iterations++;
                if (books[j].getYear() < books[min_idx].getYear()) {
                    min_idx = j;
                }
            }
            Book temp = books[min_idx];
            books[min_idx] = books[i];
            books[i] = temp;
        }
        return iterations;
    }
     public int InsertSort(Book[] books) {
        {
            int n = books.length;
            int iterations = 0;
            for (int i = 1; i < n; ++i) {
                iterations++;
                Book key = books[i];
                int j = i - 1;

            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
                while (j >= 0 && books[j].getIsbn() > key.getIsbn()) {
                    iterations++;
                    books[j + 1] = books[j];
                    j = j - 1;
                }
                books[j + 1] = key;
            }
            return iterations;
        }
    }
      

   public void mergeSort(Book[] books, int l, int m, int r) {
        // Find sizes of two subarrays to be merged

        int n1 = m - l + 1;
        int n2 = r - m;

        /* Create temp arrays */
        Book L[] = new Book[n1];
        Book R[] = new Book[n2];

        /*Copy data to temp arrays*/
        for (int i = 0; i < n1; ++i) {
            iterations++;
            L[i] = books[l + i];
        }
        for (int j = 0; j < n2; ++j) {
            iterations++;
            R[j] = books[m + 1 + j];
        }
        /* Merge the temp arrays */

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarry array
        int k = l;
        while (i < n1 && j < n2) {
            iterations++;
            if (L[i].getGenre().compareTo(R[j].getGenre()) < 0) {
                books[k] = L[i];
                i++;
            } else {
                books[k] = R[j];
                j++;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            iterations++;
            books[k] = L[i];
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < n2) {
            iterations++;
            books[k] = R[j];
            j++;
            k++;
        }
    }

    // Main function that sorts arr[l..r] using
    
   public void sort(Book[] books, int l, int r) {
        if (l < r) {
            // Find the middle point
            int m = (l + r) / 2;

            // Sort first and second halves
            sort(books, l, m);
            sort(books, m + 1, r);

            // Merge the sorted halves
         //   merge(books, l, m, r);
        }
    }

    public int getIterations() {
        return iterations;
    }
    //Binary search
    
     public Book search(Book[] books, String titleAndAuthor) {
        sortBooks(books);
        return binarySearch(books, titleAndAuthor);
    }

    private Book binarySearch(Book[] books, String titleAndAuthor) {
        int l = 0, r = books.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;

            // Check if x is present at mid
            if ((books[m].getTitle() + " " + books[m].getAuthor()).compareTo(titleAndAuthor) == 0)
                return books[m];

            // If x greater, ignore left half
            if ((books[m].getTitle() + " " + books[m].getAuthor()).compareTo(titleAndAuthor) < 0)
                l = m + 1;

                // If x is smaller, ignore right half
            else
                r = m - 1;
        }

        // if we reach here, then element was
        // not present
        return null;
    }

    private void sortBooks(Book[] books) {
        for (int i = 0; i < books.length - 1; i++) {
            for (int j = i + 1; j < books.length; j++) {
                if ((books[i].getTitle() + " " + books[i].getAuthor()).compareTo(books[j].getTitle() + " " + books[j].getAuthor()) > 0) {
                    Book temp = books[j];
                    books[j] = books[i];
                    books[i] = temp;
                }
            }
        }
    }
}


