package saealgo;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.List;

public class MainTransport {
    public static void main(String[] args) {
        if (args.length < 2) return;

        String idDepart = extraireId(args[0]);
        String idArrivee = extraireId(args[1]);

        Graphe g = LireReseau.lire("STAN.GTFS/stan.nodes.txt", "STAN.GTFS/stan.edges.txt");

        // --- TEST DIJKSTRA ---
        Dijkstra d = new Dijkstra();
        long debutD = System.nanoTime();
        Valeurs resD = d.resoudre(g, idDepart);
        long finD = System.nanoTime();

        // --- TEST BELLMAN-FORD ---
        BellmanFord bf = new BellmanFord();
        long debutBF = System.nanoTime();
        Valeurs resBF = bf.resoudre(g, idDepart);
        long finBF = System.nanoTime();

        List<String> chemin = resD.calculerChemin(idArrivee);
        if (!chemin.isEmpty()) {
            System.out.println(String.join(";", chemin));
        } else {
            System.out.println();
        }

        try (FileWriter fw = new FileWriter("resultats_perf.log", true);
             PrintWriter pw = new PrintWriter(fw)) {

            pw.println("========== TEST DU " + new java.util.Date() + " ==========");
            pw.println("Départ  : " + idDepart);
            pw.println("Arrivée : " + idArrivee);
            pw.println("Temps Dijkstra      : " + (finD - debutD) / 1_000_000.0 + " ms");
            pw.println("Temps Bellman-Ford : " + (finBF - debutBF) / 1_000_000.0 + " ms");
            pw.println("--------------------------------------------------\n");


            System.err.println("Résultats enregistrés dans resultats_perf.log");
        } catch (IOException e) {
            System.err.println("Erreur écriture log : " + e.getMessage());
        }
    }

    private static String extraireId(String arg) {
        if (arg.contains("[") && arg.contains("]")) {
            return arg.substring(arg.lastIndexOf("[") + 1, arg.lastIndexOf("]"));
        }
        return arg;
    }
}
