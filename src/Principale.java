public class Principale{
    public static void main (String Args[]){

        GrapheListe figure1 = new GrapheListe();

        Noeud a = new Noeud("a","A");
        Noeud b = new Noeud("b","B");
        Noeud c = new Noeud("c","C");
        Noeud d = new Noeud("d","D");
        Noeud e = new Noeud("e","E");

        figure1.addNoeud(a);
        figure1.addNoeud(b);
        figure1.addNoeud(c);
        figure1.addNoeud(d);
        figure1.addNoeud(e);

        figure1.addArc("a","b",12);
        figure1.addArc("a","d",87);
        figure1.addArc("b","e",11);
        figure1.addArc("c","a",19);
        figure1.addArc("d","c",10);
        figure1.addArc("d","b",23);
        figure1.addArc("e","d",43);

        System.out.println(figure1.toString());



        
    }

}