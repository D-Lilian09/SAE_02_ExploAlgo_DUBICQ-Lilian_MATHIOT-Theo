
package saealgo;
import java.util.List;
import java.util.ArrayList;




public class GrapheListe implements Graphe {

    public List<Noeud> liNoeud = new ArrayList<>();

    /**
     *
     */
    public GrapheListe() {
        this.liNoeud = new ArrayList<>();
    }

    /**
     *
     * @return
     */
    public List<Noeud> recupNoeud(){return this.liNoeud;}

    /**
     *
     * @param n
     * @return
     */
    public Arcs recupAdj(Noeud n) {
        if (n == null) {
            return new Arcs();
        }
        return n.getArcs();
    }

    /**
     *
     * @param sourceId
     * @param cibleId
     * @param poids
     */
    public void addArc(String sourceId, String cibleId, double poids) {
        for (Noeud n : liNoeud) {
            if (n.getIdt().equals(sourceId)) {
                n.getArcs().ajouterArc(new Arc(poids, cibleId));
            }
        }
    }

    /**
     *
     * @param n
     */
    public void addNoeud(Noeud n) {
        this.liNoeud.add(n);
    }

    /**
     *
     * @return
     */
    public String toString() {
        String a = "";
        for (int i = 0; i < this.liNoeud.size(); i++) {
            // Remplacement de ths.liNoeud[i] par .get(i)
            a = a + this.liNoeud.get(i).toString();
        }
        return a;
    }
}