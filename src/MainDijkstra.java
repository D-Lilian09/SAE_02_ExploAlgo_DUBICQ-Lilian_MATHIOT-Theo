import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
package saealgo;

public class MainDijkstra{
    public static void main (String Args[]) {

        GrapheListe figure1 = new GrapheListe();

        Noeud a = new Noeud("a", "A");
        Noeud b = new Noeud("b", "B");
        Noeud c = new Noeud("c", "C");
        Noeud d = new Noeud("d", "D");
        Noeud e = new Noeud("e", "E");

        figure1.addNoeud(a);
        figure1.addNoeud(b);
        figure1.addNoeud(c);
        figure1.addNoeud(d);
        figure1.addNoeud(e);

        figure1.addArc("a", "b", 12);
        figure1.addArc("a", "d", 87);
        figure1.addArc("b", "e", 11);
        figure1.addArc("c", "a", 19);
        figure1.addArc("d", "c", 10);
        figure1.addArc("d", "b", 23);
        figure1.addArc("e", "d", 43);

        Dijkstra algo = new Dijkstra();
        Valeurs resultats = algo.resoudre(figure1, "a");

        System.out.println("--- Résultats de Dijkstra ---");
        System.out.println(resultats.toString());

        System.out.println("--- Reconstruction du chemin vers E ---");
        System.out.println(reconstruireChemin(resultats, "e"));
    }

    public static String reconstruireChemin(Valeurs vls, String dest) {
        List<String> chemin = new ArrayList<>();
        String courant = dest;

        while (courant != null) {
            chemin.add(courant.toUpperCase());
            courant = vls.getParent(courant);
        }

        Collections.reverse(chemin);

        if (chemin.isEmpty() || (chemin.size() == 1 && vls.getValeur(dest) == Double.MAX_VALUE)) {
            return "Aucun chemin trouvé.";
        }

        return String.join(" -> ", chemin) + " (Poids total : " + vls.getValeur(dest) + ")";
    }


}