package com.hx.ncccu.n2;

import java.awt.print.Book;
import java.text.Collator;
import java.util.*;

/**
 * @author jxlgcmh
 * @date 2019-12-01 14:44
 * @description
 */
public class Main4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n=input.nextInt();
        List<Book> list =new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            String line = input.nextLine();
            String[] split = line.split(",");
            list.add(new Book(split[0],split[1],Double.parseDouble(split[2])));
        }
        String next = input.next();
        List<Book> result =new ArrayList<>(n);
        for (Book book : list) {
            if (book.getName().contains(next)){
                result.add(book);
            }
        }
        Collections.sort(result,new Book());
        for (Book book : result) {
            System.out.println(book);
        }
    }
    static class Book implements Comparator<Book> {
        Collator collator= Collator.getInstance(java.util.Locale.CHINA);
        private String name;
        private String author;
        private double price;

        public Book()  {
        }

        public Book(String name, String author, double price) {
            this.name = name;
            this.author = author;
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        @Override
        public int compare(Book o1, Book o2) {
            int v =(int) (o1.price - o2.price);
            if (v == 0) {
                return collator.compare(o1, o2);
            }
            return v;
        }

        @Override
        public String toString() {

            return this.getName()+","+this.getAuthor()+","+this.getPrice();
        }
    }


}
