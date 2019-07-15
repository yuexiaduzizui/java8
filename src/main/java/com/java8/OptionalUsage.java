package com.java8;

import javax.swing.text.html.Option;
import java.util.Optional;

public class OptionalUsage {

    public static void main(String[] args) {
        Optional<Insurance> insuranceOptional = Optional.<Insurance>empty();
//        System.out.println(insuranceOptional.get());

//        Optional<Insurance> optional = Optional.of(new Insurance());
//        System.out.println(optional.get());

//        Optional<Insurance> objectOptional = Optional.ofNullable(null);
//        Insurance insurance = objectOptional.orElseGet(Insurance::new);
//        System.out.println(insurance);

//        objectOptional.orElse(new Insurance());
//        objectOptional.orElseThrow(() -> new RuntimeException("没有值啦啦啦"));
//        objectOptional.orElseThrow(RuntimeException::new);
        Insurance insurance = new Insurance();
        insurance.setName("");
        String unknnow = Optional.ofNullable(insurance.getName()).orElse("UNKNNOW");
        System.out.println(unknnow);
    }
}
