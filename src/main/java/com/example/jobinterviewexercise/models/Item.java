package com.example.jobinterviewexercise.models;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.util.Objects;

@Entity
@ApiModel(description = "This model represents an item in the inventory")
@Table(name = "ITEM")
public class Item
{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "itemNo", nullable = false)
    @ApiModelProperty(notes = "This property represents the item no. of the item")
    private Long itemNo;

    @Column(name = "name", nullable = false)
    @ApiModelProperty(notes = "This property represents the name of the item")
    private String name;

    @Column(name = "amount", nullable = false)
    @ApiModelProperty(notes = "This property represents the existing amount of the item")
    private int amount;

    @Column(name = "inventoryCode", nullable = false)
    @ApiModelProperty(notes = "This property represents the inventory code of the item")
    private Long inventoryCode;


    public Long getItemNo() {
        return itemNo;
    }

    public void setItemNo(Long itemNo) {
        this.itemNo = itemNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Long getInventoryCode() {
        return inventoryCode;
    }

    public void setInventoryCode(Long inventoryCode) {
        this.inventoryCode = inventoryCode;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Item)) return false;
        Item that = (Item) o;
        return getItemNo().equals(that.getItemNo()) &&
                Objects.equals(getName(), that.getName()) &&
                Objects.equals(getAmount(), that.getAmount()) &&
                Objects.equals(getInventoryCode(), that.getInventoryCode());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getItemNo());
    }
}
