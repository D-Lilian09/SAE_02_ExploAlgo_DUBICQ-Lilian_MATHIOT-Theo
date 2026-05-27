package saealgo;
import java.util.List;
import java.util.ArrayList;





public class Noeud{

    private String idt;
    private String nom;
    private Arcs LiArcs = new Arcs();

    /**
     *
     * @param i
     * @param n
     */
    public Noeud(String i, String n){
        this.idt = i;
        this.nom = n;
    }

    /**
     *
     * @return
     */
    public String getIdt() {
        return idt;
    }

    /**
     *
     * @return
     */
    public String getNom() {
        return nom;
    }

    /**
     *
     * @return
     */
    public Arcs getArcs() {
        return LiArcs;
    }


    /**
     *
     * @return
     */
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

    /**
     *
     * @return
     */
    public double getValeur() { return valeur; }

    /**
     *
     * @param v
     */
    public void setValeur(double v) { this.valeur = v; }

    /**
     *
     * @return
     */
    public Noeud getParent() { return parent; }

    /**
     *
     * @param p
     */
    public void setParent(Noeud p) { this.parent = p; }
}