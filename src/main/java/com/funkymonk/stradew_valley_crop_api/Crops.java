package com.funkymonk.stradew_valley_crop_api;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Crops {

    private @Id
    @GeneratedValue Long id;
    private String crop;
    private String seasons;
    private int growthTime;
    private int sellPrice;

    public Crops(String crop, String seasons, int growthTime, int sellPrice) {
        this.crop = crop;
        this.seasons = seasons;
        this.growthTime = growthTime;
        this.sellPrice = sellPrice;
    }

    public Crops() {

    }

    public Crops(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCrop() {
        return crop;
    }

    public void setCrop(String crop) {
        this.crop = crop;
    }

    public String getSeasons() {
        return seasons;
    }

    public void setSeasons(String seasons) {
        this.seasons = seasons;
    }

    public int getGrowthTime() {
        return growthTime;
    }

    public void setGrowthTime(int growthTime) {
        this.growthTime = growthTime;
    }

    public int getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(int sellPrice) {
        this.sellPrice = sellPrice;
    }
    @Override
    public String toString() {
        return "Crops{" +
                "crop='" + crop + '\'' +
                ", seasons='" + seasons + '\'' +
                ", growthTime=" + growthTime +
                ", sellPrice=" + sellPrice +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Crops crops = (Crops) o;
        return crop.equals(crops.crop);
    }

    @Override
    public int hashCode() {
        return crop.hashCode();
    }
}
