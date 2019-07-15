package com.java8;

import com.sun.org.apache.regexp.internal.REUtil;

import javax.swing.text.html.Option;
import java.util.Optional;

public class OptionalInAction {

    public static void main(String[] args) {
        String insuranceNameByOptional = getInsuranceNameByOptional(null);
        System.out.println(insuranceNameByOptional);
    }

    private static String getInsuranceNameByOptional(Person person) {

        return Optional.ofNullable(person)
                .map(Person::getCar)
                .map(Car::getInsurance)
                .map(Insurance::getName)
                .orElse("unknow");

    }
}
