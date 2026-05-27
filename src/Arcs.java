import java.util.List;
import java.util.ArrayList;
package saealgo;



public class Arcs {
    private List<Arc> LiArc = new ArrayList<>();

    public Arcs() {
        this.LiArc = new ArrayList<>();
    }

    public List<Arc> getLiArc() {
        return LiArc;
    }

    public void ajouterArc(Arc a) {
        this.LiArc.add(a);
    }
}