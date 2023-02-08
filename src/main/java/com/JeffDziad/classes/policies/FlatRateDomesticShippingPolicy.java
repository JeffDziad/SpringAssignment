package com.JeffDziad.classes.policies;

import com.JeffDziad.classes.models.Sale;
import com.JeffDziad.interfaces.IShippingPolicy;

import java.util.Objects;

public class FlatRateDomesticShippingPolicy implements IShippingPolicy {
    private float domesticRate;
    private float nonDomesticRate;
    private String domesticLocation;

    public FlatRateDomesticShippingPolicy(float domesticRate, float nonDomesticRate, String domesticLocation) {
        this.domesticRate = domesticRate;
        this.nonDomesticRate = nonDomesticRate;
        this.domesticLocation = domesticLocation;
    }

    @Override
    public String getTitle() {
        return String.format("Flat Rate (%f) Domestic Shipping");
    }

    @Override
    public void applyShippingPolicy(Sale sale) {
        if(Objects.equals(sale.getLocation(), domesticLocation)) {
            sale.setSaleShipping(domesticRate);
        } else {
            sale.setSaleShipping(nonDomesticRate);
        }
    }
}
