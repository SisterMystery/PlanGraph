import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 * Created by torrentglenn on 5/28/15.
 */
public class Colorer {

    public void color(ArrayList<Vertex> verts){
        //ArrayList<Vertex> verts = g.getVertices();
        for (Vertex v : verts){
            int c = 1;
           // System.out.println("pre-cc");
            ArrayList<Integer> colors = new ArrayList<Integer>();

                for (Vertex neighbor : v.getNeighbors()) {
                    colors.add(neighbor.getColor());
                }

                for (int i = 0; i < colors.size(); i++){
                    if(c == colors.get(i)){
                        c++;
                        i = 0;
                    }
                }


           // System.out.println(c);
            v.setColor(c);
        }
    }


    public void BFcolor(ArrayList<Vertex> verts){
        Random r = new Random();
        return;
    }
}
