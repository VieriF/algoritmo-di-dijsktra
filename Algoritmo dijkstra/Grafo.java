import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Grafo{
    private LinkedList<Nodo> nodi;
    private LinkedList<Link> link;

    public Grafo() {
        this.nodi = new LinkedList<>();
        this.link = new LinkedList<>();
    }

    public void aggiungiNodo(Nodo nodo) {

        nodi.add(nodo);

    }

    public Nodo getNodo(int id) {

        for (Nodo nodo : nodi) {
            if (nodo.getId() == id) {
                return nodo;
            }
        }
        return null;

    }

    public void aggiungiLink(Link link) {
        Nodo partenza = link.getPartenza();
        partenza.addLink(link);
        link.add(link);
    }

    public LinkedList<Nodo> getNodi() {
        return nodi;
    }

    public LinkedList<Link> getLinks() {
        return link;
    }

    public static void dijkstra(Grafo grafo, Nodo sorgente) {
        sorgente.setDistanza(0);

        PriorityQueue<Nodo> coda = new PriorityQueue<>(Comparator.comparingInt(Nodo::getDistanza));
        coda.add(sorgente);

        while (!coda.isEmpty()) {
            Nodo nodoCorrente = coda.poll();
            nodoCorrente.setVisitato(true);

            for (Link link : nodoCorrente.getLinks()) {
                Nodo nodoDestinazione = link.getDestinazione();

                if (!nodoDestinazione.isVisitato()) {
                    int nuovaDistanza = nodoCorrente.getDistanza() + link.getPeso();

                    if (nuovaDistanza < nodoDestinazione.getDistanza()) {
                        coda.remove(nodoDestinazione);
                        nodoDestinazione.setDistanza(nuovaDistanza);
                        nodoDestinazione.setVisitato(true);
                        coda.add(nodoDestinazione);
                    }
                }
            }
        }
    }
}
