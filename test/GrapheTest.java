package saealgo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

class GrapheTest {

    @Test
    void testCreationNoeudEtArc() {
        Noeud n = new Noeud("A", "Sommet A");
        assertEquals("A", n.getIdt());
        assertEquals("Sommet A", n.getNom());

        Arc a = new Arc(10.5, "B");
        assertEquals(10.5, a.getPoids());
        assertEquals("B", a.getCible());
    }

    @Test
    void testAjoutNoeudEtArcDansGraphe() {
        GrapheListe graphe = new GrapheListe();

        Noeud n1 = new Noeud("A", "Source");
        graphe.addNoeud(n1);
        assertEquals(1, graphe.recupNoeud().size());

        graphe.addArc("A", "B", 5.0);
        Arcs adj = graphe.recupAdj(n1);
        assertEquals(1, adj.getLiArc().size());
        assertEquals("B", adj.getLiArc().get(0).getCible());
    }

    @Test
    void testDijkstraCheminLePlusCourt() {
        GrapheListe g = new GrapheListe();
        g.addNoeud(new Noeud("A", "Arret A"));
        g.addNoeud(new Noeud("B", "Arret B"));
        g.addNoeud(new Noeud("C", "Arret C"));

        g.addArc("A", "B", 1.0);
        g.addArc("B", "C", 1.0);
        g.addArc("A", "C", 5.0);

        Dijkstra algo = new Dijkstra();
        Valeurs res = algo.resoudre(g, "A");

        List<String> chemin = res.calculerChemin("C");

        assertEquals(2.0, res.getValeur("C"));
        assertEquals(3, chemin.size()); // A -> B -> C
    }

    @Test
    void testBellmanFordCheminLePlusCourt() {
        GrapheListe g = new GrapheListe();
        g.addNoeud(new Noeud("A", "Arret A"));
        g.addNoeud(new Noeud("B", "Arret B"));
        g.addNoeud(new Noeud("C", "Arret C"));

        g.addArc("A", "B", 10.0);
        g.addArc("B", "C", 5.0);
        g.addArc("A", "C", 20.0);

        BellmanFord algo = new BellmanFord();
        Valeurs res = algo.resoudre(g, "A");

        assertEquals(15.0, res.getValeur("C"));
        assertEquals("B", res.getParent("C"));
    }
}
