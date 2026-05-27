import java.util.List;
import java.util.ArrayList;




public class GrapheListe implements Graphe {

    public List<Noeud> liNoeud = new ArrayList<>();
    public GrapheListe() {
        this.liNoeud = new ArrayList<>();
    }

    @Override
    public List<Noeud> recupNoeud(){return this.liNoeud;}

    public Arcs recupAdj(Noeud n) {
        if (n == null) {
            return new Arcs();
        }
        return n.getArcs();
    }

    public void addArc(String sourceId, String cibleId, double poids) {
        for (Noeud n : liNoeud) {
            if (n.getIdt().equals(sourceId)) {
                n.getArcs().ajouterArc(new Arc(poids, cibleId));
            }
        }
    }

    public void addNoeud(Noeud n) {
        this.liNoeud.add(n);
    }

}