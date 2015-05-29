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
    public Graph BFcolor(Graph g){
        int bestColoring = 0;
        Graph outGraph = null;
        ArrayList<ArrayList<Vertex>> vertexSeqs = new ArrayList<ArrayList<Vertex>>();
        vertexSeqs = Permutation.permutations(g.getVertices());

        for(ArrayList<Vertex> vlist: vertexSeqs){
            color(vlist);
            Graph colorG = new Graph(vlist);
          //  System.out.println(colorG.getNumColors());
            if(bestColoring == 0 || colorG.getNumColors() < bestColoring){
                bestColoring = colorG.getNumColors();
                outGraph = colorG;
            }
        }

        return outGraph;
    }

    public Graph bigRandomColor(Graph g, long attempts){
        int bestColoring = 0;
        Graph outGraph = null;
        Graph gColor;
        for(long i = 0; i < attempts ; i++){

            gColor = new Graph(randomColor(g.getVertices()));
           // System.out.println(gColor.getNumColors());
            if(bestColoring == 0 || gColor.getNumColors() < bestColoring){
                bestColoring = gColor.getNumColors();
                outGraph = gColor;
            }
        }

        return outGraph;
    }

    public ArrayList<Vertex> randomColor(ArrayList<Vertex> verts){
        Random r = new Random();
        ArrayList<Vertex> outList = new ArrayList<Vertex>();
        int m = verts.size();
        for(int i = 0; i < m; i++){
            outList.add(verts.remove(r.nextInt(verts.size())));
        }

        color(outList);

        return outList;
    }
}
