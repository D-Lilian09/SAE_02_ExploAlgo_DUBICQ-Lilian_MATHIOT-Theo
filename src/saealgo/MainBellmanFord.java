package saealgo;

import java.util.List;

public class MainBellmanFord {
    public static void main(String[] args) {
        if (args.length < 2) return;

        String idDepart = extraireId(args[0]);
        String idArrivee = extraireId(args[1]);

        Graphe g = LireReseau.lire("STAN.GTFS/stan.nodes.txt", "STAN.GTFS/stan.edges.txt");

        BellmanFord algo = new BellmanFord();
        Valeurs resultats = algo.resoudre(g, idDepart);

        List<String> chemin = resultats.calculerChemin(idArrivee);

        if (!chemin.isEmpty()) {
            System.out.println(String.join(";", chemin));
        } else {
            System.out.println();
        }
    }

    private static String extraireId(String arg) {
        if (arg.contains("[") && arg.contains("]")) {
            return arg.substring(arg.lastIndexOf("[") + 1, arg.lastIndexOf("]"));
        }
        return arg;
    }
}