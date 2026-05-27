import java.util.List;

public class MainBellmanFord {
    public static void main(String Args[]) {
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

        BellmanFord algo = new BellmanFord();
        Valeurs resultats = algo.resoudre(figure1, "a");

        System.out.println("--- Résultats de Bellman-Ford ---");
        System.out.println(resultats.toString());

        String cible = "e";
        List<String> chemin = resultats.calculerChemin(cible);

        System.out.println("--- Chemin textuel vers " + cible.toUpperCase() + " ---");

        if (chemin.isEmpty() == true) {
            System.out.println("Aucun chemin trouvé.");
        } else {
            for (int i = 0; i < chemin.size(); i = i + 1) {
                System.out.print(chemin.get(i));
                if (i < chemin.size() - 1) {
                    System.out.print(" -> ");
                }
            }
            System.out.println();
            System.out.println("Poids total = " + resultats.getValeur(cible));
        }
    }
}