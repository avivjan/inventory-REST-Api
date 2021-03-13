package com.example.jobinterviewexercise.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Item {
    @Id
    @Column(name = "itemNo", nullable = false)
    private Long itemNo;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "amount", nullable = false)
    private int amount;

    @Column(name = "inventoryCode", nullable = false)
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
