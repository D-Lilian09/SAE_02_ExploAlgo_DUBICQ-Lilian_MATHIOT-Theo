package saealgo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LireReseau {

    /**
     * Lit les fichiers du réseau STAN et construit le graphe
     * @param fichier_stations Chemin vers le fichier des noeuds (stan.nodes.txt)
     * @param fichier_connexions Chemin vers le fichier des arcs (stan.edges.txt)
     * @return Le graphe complété
     */
    public static Graphe lire(String fichier_stations, String fichier_connexions) {
        GrapheListe graphe = new GrapheListe();

        try {
            File fNodes = new File(fichier_stations);
            Scanner scannerNodes = new Scanner(fNodes);

            while (scannerNodes.hasNextLine()) {
                String ligne = scannerNodes.nextLine();
                if (!ligne.isEmpty()) {
                    // Format : id;nom
                    String[] colonnes = ligne.split(";");
                    if (colonnes.length >= 2) {
                        String id = colonnes[0];
                        String nom = colonnes[1];
                        graphe.addNoeud(new Noeud(id, nom));
                    }
                }
            }
            scannerNodes.close();

            File fEdges = new File(fichier_connexions);
            Scanner scannerEdges = new Scanner(fEdges);

            while (scannerEdges.hasNextLine()) {
                String ligne = scannerEdges.nextLine();
                if (!ligne.isEmpty()) {

                    String[] colonnes = ligne.split(";");
                    if (colonnes.length >= 3) {
                        String source = colonnes[0];
                        String destination = colonnes[1];
                        double poids = Double.parseDouble(colonnes[2]);
                        graphe.addArc(source, destination, poids);
                    }
                }
            }
            scannerEdges.close();

        } catch (FileNotFoundException e) {
            System.err.println("Erreur : Fichier non trouvé. Vérifiez le chemin du dossier 'data'.");
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("Erreur lors de la lecture du réseau.");
            e.printStackTrace();
        }

        return graphe;
    }
}