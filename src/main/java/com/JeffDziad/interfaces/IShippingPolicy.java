package com.JeffDziad.interfaces;

import com.JeffDziad.classes.models.Sale;

public interface IShippingPolicy {
    String getTitle();
    void applyShippingPolicy(Sale sale);
}
