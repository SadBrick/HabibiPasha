package com.habibipasha.models;



public class Restepti {

    private int id;
    private String name;
    private String image;
    private String opisanie;
    private boolean favorite;
    private String chashka;
    private String tabak;
    private String jidkosti;

    public Restepti(int id, String name, String image, String opisanie, boolean favorite, String chashka, String tabak, String jidkosti) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.opisanie = opisanie;
        this.favorite = favorite;
        this.chashka = chashka;
        this.tabak = tabak;
        this.jidkosti = jidkosti;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }

    public String getOpisanie() {
        return opisanie;
    }

    public boolean isFavorite() {
        return favorite;
    }

    public String getChashka() {
        return chashka;
    }

    public String getTabak() {
        return tabak;
    }

    public String getJidkosti() {
        return jidkosti;
    }

    public void setName(String name) {
        this.name = name;
    }
}
