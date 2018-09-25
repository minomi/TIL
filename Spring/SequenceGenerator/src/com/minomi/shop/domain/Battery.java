package com.minomi.shop.domain;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2018. 9. 23..
 */
public class Battery extends Product {
    private boolean rechargeable;

    public Battery() {
        super();
    }

    public Battery(String name, double price) {
        super(name, price);
    }

    public boolean isRechargeable() {
        return rechargeable;
    }

    public void setRechargeable(boolean rechargeable) {
        this.rechargeable = rechargeable;
    }
}
