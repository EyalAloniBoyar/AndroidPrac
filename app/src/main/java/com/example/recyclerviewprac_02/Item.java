package com.example.recyclerviewprac_02;

public class Item {
    private String name;

    private String description;

    private int image;

    private String keyId;

    public void setKeyId(String keyId) {
        this.keyId = keyId;
    }

    public Item(int image, String description, String name) {
        this.image = image;
        this.description = description;
        this.name = name;
    }

    public String getKeyId() {
        return keyId;
    }

    public Item() {}
    public int getImage() {
        return image;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
