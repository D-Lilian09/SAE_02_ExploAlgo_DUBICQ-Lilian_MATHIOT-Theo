
package saealgo;
import java.util.List;
import java.util.ArrayList;




public class Arcs {
    private List<Arc> LiArc = new ArrayList<>();

    /**
     *
     */
    public Arcs() {
        this.LiArc = new ArrayList<>();
    }

    /**
     *
     * @return
     */
    public List<Arc> getLiArc() {
        return LiArc;
    }

    /**
     *
     * @param a
     */
    public void ajouterArc(Arc a) {
        this.LiArc.add(a);
    }
}