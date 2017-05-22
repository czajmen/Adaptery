package com.example.kczaja.lab6;

/**
 * Created by kczaja on 12.04.2017.
 */

public class entry {
    public int Logo;
    public String Name;
    public String[] tab;

    public entry(String name, int logo) {
        this.Name = name;
        this.Logo = logo;
    }

    public entry(String name, int logo, String[] tab) {
        this.Name = name;
        this.Logo = logo;
        this.tab = tab;
    }

}
