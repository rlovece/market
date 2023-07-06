package com.ruth.market.domain;

public class Product {

    ///region Atributos
    private int prudctId;

    private String name;

    private int categoryId;

    private double price;

    private int stock;

    private boolean active;

    private Category category;

    /// NO incluímos el codigo de barra

    ///endregion

    ///region Getters y Setters

    public int getPrudctId() {
        return prudctId;
    }

    public void setPrudctId(int prudctId) {
        this.prudctId = prudctId;
    }

    ///endregion
}
