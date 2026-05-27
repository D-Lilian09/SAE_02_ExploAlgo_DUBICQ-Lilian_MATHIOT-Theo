import java.util.List;
import java.util.ArrayList;



public class Noeud{

    private String idt;
    private String nom;
    private Arcs LiArcs = new Arcs();
    private double valeur;
    private Noeud parent;

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

    public double getValeur() { return valeur; }

    public void setValeur(double v) { this.valeur = v; }

    public Noeud getParent() { return parent; }
    
    public void setParent(Noeud p) { this.parent = p; }
}