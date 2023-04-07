public class Main {
    public static void main(String[] args) {
            Grafo grafo = new Grafo();
    
            Nodo a = new Nodo(1);
            Nodo b = new Nodo(2);
            Nodo c = new Nodo(3);
            Nodo d = new Nodo(4);
            Nodo e = new Nodo(5);
    
            grafo.aggiungiNodo(a);
            grafo.aggiungiNodo(b);
            grafo.aggiungiNodo(c);
            grafo.aggiungiNodo(d);
            grafo.aggiungiNodo(e);
    
            grafo.aggiungiLink(new Link(a, b, 5));
            grafo.aggiungiLink(new Link(a, c, 2));
            grafo.aggiungiLink(new Link(b, c, 1));
            grafo.aggiungiLink(new Link(b, d, 3));
            grafo.aggiungiLink(new Link(c, d, 4));
            grafo.aggiungiLink(new Link(c, e, 6));
            grafo.aggiungiLink(new Link(d, e, 1));
    
            Grafo.dijkstra(grafo, a);
    
            for (Nodo nodo : grafo.getNodi())
                System.out.println("Nodo " + nodo.getId() + " distanza: " + nodo.getDistanza());
    }
}
