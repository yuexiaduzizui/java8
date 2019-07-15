package com.java8;

import com.sun.org.apache.regexp.internal.REUtil;
import sun.security.jca.GetInstance;

public class MyNullPointerException {

    public static void main(String[] args) {
        String insuranceName = getInsuranceName(new Person());

    }

    private static String getInsuranceNameByDeepDoubts(Person person) {
        if (null != person) {
            Car car = person.getCar();
            if (null != car) {
                Insurance insurance = car.getInsurance();
                if (null != insurance) {
                    String name = insurance.getName();
                    return name;
                }
            }
        }
        return "UNKNOW";
    }

    private static  String getInsuranceNameByMultExit(Person person) {

        final String defaultValue = "UNKNOW";
        if (null == person) {
            return defaultValue;
        }
        Car car = person.getCar();
        if (null == car) {
            return defaultValue;
        }
        Insurance insurance = car.getInsurance();
        if (null == insurance) {
            return defaultValue;
        }
        return  insurance.getName();
    }

    private static String getInsuranceName(Person person) {
        return person.getCar().getInsurance().getName();
    }
}
