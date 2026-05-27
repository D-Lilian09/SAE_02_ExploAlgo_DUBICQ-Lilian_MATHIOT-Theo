import java.util.List;
import java.util.ArrayList;
package saealgo;




public class Noeud{

    private String idt;
    private String nom;
    private Arcs LiArcs = new Arcs();

    public Noeud(String i, String n){
        this.idt = i;
        this.nom = n;
    }

    public String getIdt() {
        return idt;
    }

    public String getNom() {
        return nom;
    }

    public Arcs getArcs() {
        return LiArcs;
    }

    public String toString(){
        String a = this.nom + " - > ";
        List<Arc> liste = this.LiArcs.getLiArc();

        for (int i = 0; i < liste.size(); i++) {
            Arc currentArc = liste.get(i);
            String nomCible = currentArc.getCible().toUpperCase();

            a = a + nomCible + "(" + (int)currentArc.getPoids() + ") ";
        }
        return a + "\n";
    }

    private double valeur;
    private Noeud parent;

    public double getValeur() { return valeur; }

    public void setValeur(double v) { this.valeur = v; }

    public Noeud getParent() { return parent; }

    public void setParent(Noeud p) { this.parent = p; }
}