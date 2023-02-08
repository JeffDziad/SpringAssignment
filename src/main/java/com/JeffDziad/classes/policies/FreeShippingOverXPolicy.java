package com.JeffDziad.classes.policies;

import com.JeffDziad.classes.models.Sale;
import com.JeffDziad.interfaces.IShippingPolicy;

public class FreeShippingOverXPolicy implements IShippingPolicy {

    private float xAmount;
    private float defaultRate;

    public FreeShippingOverXPolicy(float xAmount, float defaultRate) {
        this.xAmount = xAmount;
        this.defaultRate = defaultRate;
    }

    @Override
    public String getTitle() {
        return "Free Shipping Over $" + Float.toString(xAmount);
    }

    @Override
    public void applyShippingPolicy(Sale sale) {
        if(sale.getSalePrice() > xAmount) {
            sale.setSaleShipping(0);
        } else {
            sale.setSaleShipping(defaultRate);
        }
    }
}
