package com.JeffDziad.classes.policies;

import com.JeffDziad.classes.models.Sale;
import com.JeffDziad.interfaces.IShippingPolicy;

public class FreeShippingPolicy implements IShippingPolicy {
    @Override
    public String getTitle() {
        return "Free Shipping Policy";
    }

    @Override
    public void applyShippingPolicy(Sale sale) {
        sale.setSaleShipping(0);
    }
}
