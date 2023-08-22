package com.workintech.demo.model;

import com.workintech.demo.tax.Taxable;

public class DeveloperFactory {
    public static Developer createDeveloper(Developer developer, Taxable taxable) {
        Developer developer1;
        if (developer.getExperience() == Experience.JUNIOR) {
            developer1 = new JuniorDeveloper(developer.getId(),
                    developer.getName(), developer.getSalary() -
                    developer.getSalary() * taxable.getSimpleTaxRate(), developer.getExperience());
        } else if (developer.getExperience() == Experience.MID) {
            developer1 = new MidDeveloper(developer.getId(),
                    developer.getName(), developer.getSalary() -
                    developer.getSalary() * taxable.getMiddleTaxRate(), developer.getExperience());
        } else if (developer.getExperience() == Experience.SENIOR) {
            developer1 = new SeniorDeveloper(developer.getId(),
                    developer.getName(), developer.getSalary() -
                    developer.getSalary() * taxable.getUpperTaxRate(), developer.getExperience());
        } else {
            developer1 = null;
        }
        return developer1;
    }
}
