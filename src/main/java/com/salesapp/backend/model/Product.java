package com.salesapp.backend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
public class Product {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    @Size(min = 1, max = 200)
    @Column(length = 200)
    private String title;

    @Size(min = 1, max = 10000)
    @Column(length = 10000)
    private String description;

    @NotNull
    @Min(1)
    @Column(name = "unit_cost")
    private Float unitCost;

    @Past
    @Column(name = "purchase_date")
    @Temporal(TemporalType.DATE)
    private Date purchaseDate;

    private Integer quantity;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "profile_type")
    private ProfileType profileType;

    // ======================================
    // =            Constructors            =
    // ======================================

    public Product(){
    }

    public Product(String title, String description, Float unitCost, Date purchaseDate, Integer quantity,
                   String imageUrl, ProfileType profileType) {
        this.title = title;
        this.description = description;
        this.unitCost = unitCost;
        this.purchaseDate = purchaseDate;
        this.quantity = quantity;
        this.imageUrl = imageUrl;
        this.profileType = profileType;
    }


    // ======================================
    // =        Getters and Setters         =
    // ======================================


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Float getUnitCost() {
        return unitCost;
    }

    public void setUnitCost(Float unitCost) {
        this.unitCost = unitCost;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public ProfileType getProfileType() {
        return profileType;
    }

    public void setProfileType(ProfileType profileType) {
        this.profileType = profileType;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", unitCost=" + unitCost +
                ", purchaseDate=" + purchaseDate +
                ", quantity=" + quantity +
                ", imageUrl='" + imageUrl + '\'' +
                ", profileType=" + profileType +
                '}';
    }
}
