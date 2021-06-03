/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sellerViews;

import java.util.ArrayList;
import main.Product;

/**
 *
 * @author dubavenxp
 */
public class ProductToOrder {
    private ArrayList<Product> productsToOrder =  new ArrayList<Product>();

    /**
     * @return the productsToOrder
     */
    public ArrayList<Product> getProductsToOrder() {
        return productsToOrder;
    }

    /**
     * @param productsToOrder the productsToOrder to set
     */
    public void addProductsToOrder(Product product) {
        productsToOrder.add(product);
    }
    
    
}
