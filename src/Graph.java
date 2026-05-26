public interface Graph {

    List<Noeud> LiNoeud = new ArrayList<>();

    public Graph();
    public List<Noeud> recupNoeud();
    public Arcs recupAdj(Noeud n);



}