package saealgo;

import java.util.List;

public class MainDijkstra {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage: java MainDijkstra <depart> <arrivee>");
            return;
        }
        String idDepart = extraireId(args[0]);
        String idArrivee = extraireId(args[1]);

        Graphe g = LireReseau.lire("STAN.GTFS/stan.nodes.txt", "STAN.GTFS/stan.edges.txt");
        Dijkstra d = new Dijkstra();
        Valeurs resultats = d.resoudre(g, idDepart); // Correction ici
        List<String> chemin = resultats.calculerChemin(idArrivee); // Correction ici

        if (chemin.isEmpty()) {
            System.out.println("");
        } else {
            System.out.println(String.join(";", chemin));
        }


    }

    private static String extraireId(String arg) {
        if (arg.contains("[") && arg.contains("]")) {
            return arg.substring(arg.lastIndexOf("[") + 1, arg.lastIndexOf("]"));
        }
        return arg;
    }
}