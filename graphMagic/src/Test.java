import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Map;

/**
 * Created by torrentglenn on 5/27/15.
 */
public class Test {
    public static void main(String[] args){
        try {
            CommitteeMapper cm = new CommitteeMapper("/Users/torrentglenn/Downloads/planCommittees.txt", "\\n\\n");
            cm.map();


            Graph g = new GraphMaker().makeGraph(cm.committeeMap);
            Colorer c = new Colorer();
            c.color(g.getVertices());

            int i = 0;
            for(Vertex v: g.getVertices()){
                if (v.getColor() > i)
                    i = v.getColor();
            }
            System.out.println(i);
/*
            for(Map.Entry<String, Vertex> entry: g.vertexHashMap.entrySet()){
                System.out.println(entry.getValue().getId());
                System.out.println(entry.getValue().getNeighbors().size());
                System.out.println("*****");
                for(Vertex v: entry.getValue().getNeighbors()){
                    System.out.println("         " + v.getId());
                }
                System.out.println();
            }

/*
            for(Map.Entry entry: cm.committeeMap.entrySet()){
                System.out.println(entry.getKey());
                for(String s:(ArrayList<String>) entry.getValue() ){
                    System.out.println("            " + s);
                }
            }
*/
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
