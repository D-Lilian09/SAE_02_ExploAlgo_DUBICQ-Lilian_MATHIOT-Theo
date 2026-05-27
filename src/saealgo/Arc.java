package saealgo;
import java.util.List;
import java.util.ArrayList;


public class Arc {
    private double poids;
    private String cible;

    /**
     *
     * @param p
     * @param s
     */
    public Arc (double p, String s){
        this.poids = p;
        this.cible = s;
    }

    /**
     *
     * @return
     */
    public String getCible(){
        return this.cible;
    }

    /**
     *
     * @return
     */
    public double getPoids(){
        return this.poids;
    }

}