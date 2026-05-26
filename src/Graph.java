public interface Graph {

    List<Noeud> LiNoeud = new ArrayList<>();

    public Graph() {
        this.LiNoeud = new ArrayList<>();
    }
    public Noeud recupNoeud();
    public Arcs recupAdj(Noeud n);



}