package com.dog.knowthedog;

public class ModelClass {

    private int imageview;
    private String name;
    private String breed_group;
    private String life_span;
    private String origin;
    private String temperament;

    public String getOrigin() {
        return origin;
    }

    public String getTemperament() {
        return temperament;
    }

    ModelClass(int imageview, String name, String breed_group, String life_span, String origin, String temperament){
        this.imageview = imageview;
        this.name = name;
        this.origin = origin;
        this.temperament = temperament;

        this.breed_group = breed_group;
        this.life_span = life_span;
    }

    public int getImageview() {
        return imageview;
    }

    public String getTextview() {
        return name;
    }

    public String getBreed_group() {
        return breed_group;
    }

    public String getLife_span() {
        return life_span;
    }
}
