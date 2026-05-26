public class Noeud extends Arc{

    private String idt;
    private String nom;
    private List<Arc> LiArc = new ArrayList<>();

    public Noeud(String i, String n){
        this.idt = i;
        this.nom = n;
    }
}