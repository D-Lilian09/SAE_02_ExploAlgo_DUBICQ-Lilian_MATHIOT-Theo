package saealgo;
import java.util.List;

public class BellmanFord {

    /**
     *
     * @param g
     * @param depart
     * @return
     */
    public Valeurs resoudre(Graphe g, String depart) {
        Valeurs resultats = new Valeurs();
        List<Noeud> tousLesNoeuds = g.recupNoeud();
        for (int i = 0; i < tousLesNoeuds.size(); i = i + 1) {
            Noeud v = tousLesNoeuds.get(i);
            resultats.setValeur(v.getIdt(), Double.MAX_VALUE);
            resultats.setParent(v.getIdt(), null);
        }
        resultats.setValeur(depart, 0.0);
        boolean valeurModifiee = true;
        while (valeurModifiee == true) {
            valeurModifiee = false;
            for (int i = 0; i < tousLesNoeuds.size(); i = i + 1) {
                Noeud x = tousLesNoeuds.get(i);
                double valeurX = resultats.getValeur(x.getIdt());
                if (valeurX != Double.MAX_VALUE) {
                    List<Arc> tousLesArcs = x.getArcs().getLiArc();
                    for (int j = 0; j < tousLesArcs.size(); j = j + 1) {
                        Arc arc = tousLesArcs.get(j);
                        String nomN = arc.getCible();
                        double poidsArc = arc.getPoids();
                        double nouvelleEstimation = valeurX + poidsArc;
                        double ancienneValeurN = resultats.getValeur(nomN);
                        if (nouvelleEstimation < ancienneValeurN) {
                            resultats.setValeur(nomN, nouvelleEstimation);
                            resultats.setParent(nomN, x.getIdt());
                            valeurModifiee = true;
                        }
                    }
                }
            }
        }

        return resultats;
    }
}