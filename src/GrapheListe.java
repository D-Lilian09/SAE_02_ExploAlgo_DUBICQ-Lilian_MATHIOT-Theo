public class GrapheListe implements Graph {

    public Graph() {
        this.LiNoeud = new ArrayList<>();
    }

    public List<Noeud> recupNoeud{return this.LiNoeud}


    public ListeAdjacence recupAdj(String noeud) {
        Noeud n = this.noeuds.get(noeud);
        if (n == null) {
            return new ListeAdjacence();
        }
        return n.getLiArcs();
    }




}