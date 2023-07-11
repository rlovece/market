package com.ruth.market.domain;

import java.time.LocalDateTime;
import java.util.List;

public class Purchase {

    ///region Atributos
    private int purchaseId;
    private String clientId;
    private LocalDateTime date;
    private String paymetMethod;
    private String comment;
    private String state;
    private List<PurchaseItem> items;

    ///endregion

    ///region Getters and Setters

    public int getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(int purchaseId) {
        this.purchaseId = purchaseId;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getPaymetMethod() {
        return paymetMethod;
    }

    public void setPaymetMethod(String paymetMethod) {
        this.paymetMethod = paymetMethod;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public List<PurchaseItem> getItems() {
        return items;
    }

    public void setItems(List<PurchaseItem> items) {
        this.items = items;
    }

    ///endregions
}
