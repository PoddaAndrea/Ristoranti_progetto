package it.unica.ristoranti;

import java.util.ArrayList;

public class Ristorante{

    private String nome_ristorante;
    private int numero_coperti;
    private Menu il_menu;

    static ArrayList<Ristorante> lista_dei_ristoranti = new ArrayList<>();

    static int no_rist=0;

    public Ristorante(String nome_ristorante, int numero_coperti, Menu il_menu){
        this.nome_ristorante=nome_ristorante;
        this.numero_coperti=numero_coperti;
        this.il_menu=il_menu;
        no_rist++;

        lista_dei_ristoranti.add(this);
    }

    public static int numeroRistoranti(){
        return no_rist;
    }

    public int posti(){
        return this.numero_coperti;
    }

    public static int totalePosti(){
        return lista_dei_ristoranti.stream()
                .mapToInt(Ristorante::posti)
                .sum();
    }

    public Menu menu(){
        return this.il_menu;
    }

    public String mostExpensive(){
        return this.il_menu.mostExpensive();
    }

    public boolean isInTheMenu(String una_ricetta){

        return this.il_menu.entrySet()
                .stream()
                .filter(menu->menu.getKey().equalsIgnoreCase(una_ricetta))
                .findFirst()
                .isPresent();
    }

    public Order order(String...lista_ordini){
        return new Order(lista_ordini, this);
    }

}
