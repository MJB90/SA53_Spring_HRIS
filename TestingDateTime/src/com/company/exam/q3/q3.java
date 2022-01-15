package com.company.exam.q3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class q3 {
    public static List<Product> search(List<Product> products, String cat, Double pr){
        List<Product> newprod = new ArrayList<>();

        for(Product product : products){
            if(product.getCategory().compareTo(cat)==0 && product.getPrice() <=pr){
                newprod.add(product);
            }
        }
        return newprod;
    }

    public static void printByCategory(List<Product> products){
        Map<String, List<Product> > req_prod = products.stream().collect(Collectors.groupingBy(Product::getCategory));

        req_prod.forEach((category,prods)->{
            System.out.println(category);
            prods.stream().sorted((p1, p2)-> {if(p1.getPrice()<p2.getPrice()) return 1; else if(p1.getPrice()>p2.getPrice()) return -1; else return 0;})
                    .limit(2).forEach(System.out::println);
        });
    }
    public static void main(String[] args) {
        Product[] productArr = {
                new Product(1, "Farm Railway Set", "Toy", 75.9),
                new Product(2, "Data Structures", "Book", 75.00),
                new Product(3, "Laptop Desks", "Office", 139.0),
                new Product(4, "Lego City", "Toy", 62.0),
                new Product(5, "Foldable Table", "Office", 47.9),
                new Product(6, "Jigsaw Puzzle", "Toy", 20.0),
                new Product(7, "Java How To Program", "Book", 80.5),
                new Product(8, "ASP.NET Core in Action", "Book", 50.5),
                new Product(9, "Office Chair", "Office", 57.7)
        };
        List<Product> productList = Arrays.asList(productArr);
        List<Product> searchResult = search(productList, "Toy", 62.0);
        System.out.println(searchResult);
        System.out.println(); // New line
        printByCategory(productList);
    }
}
