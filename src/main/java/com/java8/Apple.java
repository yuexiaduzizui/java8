package com.java8;

public class Apple {

    private String color;

    private Long  wegiht;

    public String getColor() {
        return color;
    }

    public Long getWegiht() {
        return wegiht;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setWegiht(Long wegiht) {
        this.wegiht = wegiht;
    }

    public Apple(String color, Long wegiht) {
        this.color = color;
        this.wegiht = wegiht;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "color='" + color + '\'' +
                ", wegiht=" + wegiht +
                '}';
    }
}
