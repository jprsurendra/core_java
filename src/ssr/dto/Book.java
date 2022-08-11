package com.ssr.dto;

/*
    new Book("0061964360", "Pride and Prejudice (Teen Classics)", 2009, 9.82, "Softcover", "HarperTeen");
    new Book("0143105426", "Pride and Prejudice (Teen Classics)", 2009, 12.58, "Softcover", "Penguin Classics");
    new Book("0143105426", "Pride and Prejudice (Oxford World's Classics)", 2008, 47.8, "Softcover", "Oxford University Press");
 */
public class Book {
    //public int Id;
    public String ISBN;
    public String title;
    public int year;
    public float price;
    public String authorName;
    public String publisher;

    public Book(){}
    public Book(String ISBN, String title, int year, float price, String authorName, String publisher) {
        this.ISBN = ISBN;
        this.title = title;
        this.year = year;
        this.price = price;
        this.authorName = authorName;
        this.publisher = publisher;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }


    @Override
    public String toString() {
        return "Book {" +
                "ISBN='" + ISBN + '\'' +
                ", title='" + title + '\'' +
                ", year=" + year +
                ", price= $" + price +
                ", authorName='" + authorName + '\'' +
                ", publisher='" + publisher + '\'' +
                '}';
    }
}
