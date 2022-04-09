package com.company;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * receipt contains list of shopping products, total tax and price
 */

public class Receipt {


    private List<Product> products = new ArrayList<>();
    private double totalTax = 0.0;
    private double totalProductPrice = 0.0;

    //for currency formatter
    NumberFormat formatter = NumberFormat.getCurrencyInstance();

    /**
     * Print reciepts
     */
    public void printReceipt(){
        for(Product p:products){
            System.out.println( p.getProductQuantity() != 0 ? p.getProductQuantity() + " " + p.getProductName() + " at " + formatter.format(p.getProductPrice()) : "Product Quantity can not be 0!");

            //listing total tax according to product category:
            totalTax += p.getProductTax();

            //listing total price according to product category:
            totalProductPrice += p.getProductPrice();
        }
        System.out.println();
        System.out.println("------------------------------------------");
        //print out product tax according to product category
        System.out.println("Sales Tax: "+formatter.format(totalTax));

        //print out product tax according to product category
        System.out.println("Total: "+formatter.format(totalProductPrice));
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }


}
