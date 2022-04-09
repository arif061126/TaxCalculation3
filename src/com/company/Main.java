package com.company;

import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;
import java.util.Scanner;

/**
 * To solve this problem: what is needed:
 * 1) To print out receipt which contain:
 * - different products with name, category, price, quantity and tax
 * 2) Calculation of sales tax according to category
 * 3) Calculation of price according to category
 * 4) Calculation of total price
 */


public class Main {



    public static void main(String[] args) {

        //for currency formatter
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        /*Currency currency = formatter.getCurrency();
        String symbol = currency.getSymbol(Locale.GERMANY);
        System.out.println(symbol);*/


        Scanner scanner = new Scanner(System.in);

        final PriceTaxCalcService priceTaxCalcService = new PriceTaxCalcService();



        final Receipt receipt = new Receipt();

        int selectedProductId = 0;

        //looping through the shopping cart: till end of shopping
        while (selectedProductId <PriceTaxCalcService.DEFAULT_PRODUCTS.size()) {
            //Error handling with try catch block
            try {
                // User input
                System.out.println();
                System.out.println("Please select the items from the following list:");

                /*Selection*/
                PriceTaxCalcService.showProductSelection();

                //to complete shopping:
                System.out.println("Press " + (PriceTaxCalcService.DEFAULT_PRODUCTS.size() + 1) + " or greater digit to complete your shopping.\n\t\t----  ");

                //for select product from the product list by product id
                System.out.println("Enter product Id: ");
                selectedProductId = Integer.parseInt(scanner.nextLine());//commit

                //to end up shopping:
                if (selectedProductId > PriceTaxCalcService.DEFAULT_PRODUCTS.size()) {
                    break;
                }


                //selected product by id
                Product selectedProduct = PriceTaxCalcService.DEFAULT_PRODUCTS.get(selectedProductId);

                //Modified product
                Product modProduct = (Product) selectedProduct.clone();

                // for input product quantity:
                System.out.println("Enter product quantity: ");
                int selectedProductQuantity = Integer.parseInt(scanner.nextLine());//commit

                //setting selected product quantity
                modProduct.setProductQuantity(selectedProductQuantity);

                //selectedProduct.calculateProductPrice();
                priceTaxCalcService.setProduct(modProduct);

                //calculate price for the selected product
                // adds all selected product to a temp list

                //adds temp list to receipt to the list of receipt
                receipt.getProducts().add(priceTaxCalcService.getProduct());


            } catch (Exception e) {
                //printing out error message
                System.out.println(e.getMessage() + ", you are getting error!");
                //printing out type of error
                System.out.println("Error type: " + e.getClass());
                //printing out feedback message
                System.out.println("Something went wrong. Please Try again!");
                System.out.println();
            }
        }

        //printing the receipt
        System.out.println();
        System.out.println("<<<<<<<<< YOUR RECEIPT >>>>>>>>>");
        System.out.println();
        receipt.printReceipt();
        //System.out.println("Local " + Locale.getDefault());

    }

}
