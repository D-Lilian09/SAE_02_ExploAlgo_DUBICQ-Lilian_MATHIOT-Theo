import java.util.List;
import java.util.ArrayList;
package saealgo;




public class Arc {
    private double poids;
    private String cible;

    public Arc (double p, String s){
        this.poids = p;
        this.cible = s;
    }

    public String getCible(){
        return this.cible;
    }

    public double getPoids(){
        return this.poids;
    }

}