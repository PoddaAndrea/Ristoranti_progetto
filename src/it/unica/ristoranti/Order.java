package it.unica.ristoranti;

import it.unica.test.TooMuchPeopleException;

public class Order {

    private String[] una_lista_ordini;
    private static int tot_ordini=0;
    private Ristorante ristorante;
    public Order(String[] una_lista_ordini, Ristorante ristorante){

        tot_ordini+=una_lista_ordini.length;

        if(tot_ordini>ristorante.posti()){
            throw new TooMuchPeopleException();
        }

        this.una_lista_ordini=una_lista_ordini;
        this.ristorante=ristorante;

    }

    public int people(){
        return una_lista_ordini.length;
    }

    public double cost(){
        double tot=0;
        for(String entries: una_lista_ordini){
            tot+=ristorante.menu().costo_cibo(entries);
        }

        return tot;
    }
}
