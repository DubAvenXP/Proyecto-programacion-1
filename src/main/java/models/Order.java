/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.ArrayList;

/**
 *
 * @author dubavenxp
 */
public class Order {
    private int id;
    private Client client;
    private int sellerId;
    private double total;
    private String deliveryDate;
    private String purchaseStatus;
    private String description;
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
    
    
    
    /**
     * @return the buyer
     */
    public Client getClient() {
        return client;
    }

    /**
     * @param buyer the buyer to set
     */
    public void setClient(Client client) {
        this.client = client;
    }

    /**
     * @return the sellerId
     */
    public int getSellerId() {
        return sellerId;
    }

    /**
     * @param sellerId the sellerId to set
     */
    public void setSellerId(int sellerId) {
        this.sellerId = sellerId;
    }

    /**
     * @return the total
     */
    public double getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(double total) {
        this.total = total;
    }

    /**
     * @return the deliveryDate
     */
    public String getDeliveryDate() {
        return deliveryDate;
    }

    /**
     * @param deliveryDate the deliveryDate to set
     */
    public void setDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    /**
     * @return the purchaseStatus
     */
    public String getPurchaseStatus() {
        return purchaseStatus;
    }

    /**
     * @param purchaseStatus the purchaseStatus to set
     */
    public void setPurchaseStatus(String purchaseStatus) {
        this.purchaseStatus = purchaseStatus;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }
}
