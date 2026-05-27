import java.util.ArrayList;
import java.util.List;

public class Dijkstra {

    public Valeurs resoudre(Graphe g, String depart) {

        List<Noeud> q = new ArrayList<>();
        List<Noeud> tousLesNoeuds = g.recupNoeud();
        Noeud noeudDepart = null;

        for (Noeud v : tousLesNoeuds) {
            v.setValeur(Double.POSITIVE_INFINITY);
            v.setParent(null);
            q.add(v);
            if (v.getIdt().equals(depart)) noeudDepart = v;
        }

        if (noeudDepart != null) {
            noeudDepart.setValeur(0);}

        while (!q.isEmpty()) {
            Noeud u = trouverMin(q);
            q.remove(u);

            for (Arc arc : u.getArcs().getLiArc()) {
                Noeud v = chercherNoeud(tousLesNoeuds, arc.getCible());

                if (v != null && q.contains(v)) {
                    double d = u.getValeur() + arc.getPoids();
                    if (d < v.getValeur()) { // Si d < v.valeur
                        v.setValeur(d);      // v.valeur <- d
                        v.setParent(u);      // v.parent <- u
                    }
                }
            }
        }

        return new Valeurs(tousLesNoeuds);
    }

    private Noeud trouverMin(List<Noeud> q) {
        Noeud min = q.get(0);
        for (Noeud n : q) {
            if (n.getValeur() < min.getValeur()) min = n;
        }
        return min;
    }

    private Noeud chercherNoeud(List<Noeud> liste, String id) {
        for (Noeud n : liste) {
            if (n.getIdt().equals(id)) return n;
        }
        return null;
    }
}

