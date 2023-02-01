package it.unica.ristoranti;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Menu extends HashMap<String, Double> {

    public String mostExpensive(){

        return this.entrySet()
                .stream()
                .max(Comparator.comparing(Map.Entry<String, Double>::getValue))
                .get()
                .getKey();
    }

    public double costo_cibo(String una_ricetta){

        return this.entrySet().stream()
                .filter(menu->menu.getKey().equals(una_ricetta))
                .findFirst()
                .get()
                .getValue();
    }
}
