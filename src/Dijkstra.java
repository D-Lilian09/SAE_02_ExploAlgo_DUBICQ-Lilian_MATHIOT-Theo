import java.util.ArrayList;
import java.util.List;

public class Dijkstra {

    public Valeurs resoudre(Graphe g, String depart) {

        Valeurs resultats = new Valeurs();
        List<Noeud> q = new ArrayList<>();
        List<Noeud> tousLesNoeuds = g.recupNoeud();

        for (Noeud v : tousLesNoeuds) {
            resultats.setValeur(v.getIdt(), Double.MAX_VALUE);
            resultats.setParent(v.getIdt(), null);
            q.add(v);
        }
        resultats.setValeur(depart, 0);

        while (!q.isEmpty()) {

            Noeud u = trouverMin(q, resultats);
            q.remove(u);

            for (Arc arc : u.getArcs().getLiArc()) {
                Noeud v = chercherNoeud(tousLesNoeuds, arc.getCible());
                if (v != null && q.contains(v)) {
                    double d = resultats.getValeur(u.getIdt()) + arc.getPoids();

                    if (d < resultats.getValeur(v.getIdt())) {
                        resultats.setValeur(v.getIdt(), d);
                        resultats.setParent(v.getIdt(), u.getIdt());
                    }
                }
            }
        }
        return resultats;
    }

    private Noeud trouverMin(List<Noeud> q, Valeurs vls) {
        Noeud min = q.get(0);
        for (Noeud n : q) {
            // Comparaison des valeurs stockées dans l'objet Valeurs
            if (vls.getValeur(n.getIdt()) < vls.getValeur(min.getIdt())) {
                min = n;
            }
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

