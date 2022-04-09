package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 * ProductTaxCalculation service calculate sales tax for a given product
 */
public class PriceTaxCalcService  {
    /**
     * Single product: to work with
     */
    private Product product;

    //Statically fixed products are added
    static final List<Product> DEFAULT_PRODUCTS = new ArrayList<>();

    //adding products to list
    static {
        DEFAULT_PRODUCTS.add(new Product(0, "book", ProductCategory.Basic, 12.49, 1));
        DEFAULT_PRODUCTS.add(new Product(1, "music CD", ProductCategory.Luxury, 14.99, 1));
        DEFAULT_PRODUCTS.add(new Product(2, "chocolate bar", ProductCategory.Basic, 0.85, 1));
        DEFAULT_PRODUCTS.add(new Product(3, "imported box of chocolates", ProductCategory.ImportedBasic, 10.00, 1));
        DEFAULT_PRODUCTS.add(new Product(4, "imported bottle of perfume", ProductCategory.ImportedLuxury, 47.50, 1));
        DEFAULT_PRODUCTS.add(new Product(5, "imported bottle of perfume", ProductCategory.ImportedLuxury, 27.99, 1));
        DEFAULT_PRODUCTS.add(new Product(6, "bottle of perfume", ProductCategory.Luxury, 18.99, 1));
        DEFAULT_PRODUCTS.add(new Product(7, "packet of headache pills", ProductCategory.Basic, 9.75, 1));
        DEFAULT_PRODUCTS.add(new Product(8, "box of imported chocolates", ProductCategory.ImportedBasic, 11.25, 1));
    }

    public PriceTaxCalcService() {}

    /**
     * calculates tax according to {@link Product#getProductCategory()}
     */
    public void calculateTax() {
        switch (product.getProductCategory()) {
            case Basic:
                product.setProductTax(0.0);
                break;
            case Luxury:
                product.setProductTax(product.getProductPrice() * product.getProductQuantity() * 0.10);
                break;
            case ImportedBasic:
                product.setProductTax(product.getProductPrice() * product.getProductQuantity() * 0.05);
                break;
            case ImportedLuxury:
                product.setProductTax(product.getProductPrice() * product.getProductQuantity() * 0.15);
                break;
            default:
                System.out.println("Out of category....");
        }
    }

    /**
     * Calculates product priice (tax incl)
     *
     */

    public void calculateProductPrice( ) {
        //first to calculate product tax: call calculateTax() method
        calculateTax();

        //calculate price:
        product.setProductPrice((product.getProductPrice() * product.getProductQuantity()) + product.getProductTax());
    }



    public Product getProduct() {
       return this.product;
    }

    /**
     * process product price
     * @param product sets the given product with new values
     */
    public void setProduct(Product product) {
        this.product = product;
        this.calculateProductPrice();
    }

    /**
     * Show console selection options for user
     */
    public static void showProductSelection() {

        for (Product product : DEFAULT_PRODUCTS) {
            System.out.println("Press " + product.getProductId() + " : to select " + product.getProductName() + " > unit price: " + product.getProductPrice() );
        }
    }


}