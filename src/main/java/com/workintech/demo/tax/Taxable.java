package com.workintech.demo.tax;

import org.springframework.stereotype.Component;
public interface Taxable {

    double getSimpleTaxRate();
    double getMiddleTaxRate();
    double getUpperTaxRate();
}
