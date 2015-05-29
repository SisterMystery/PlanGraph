import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by torrentglenn on 5/27/15.
 */
public class Test {

    public static void main(String[] args){
        try {
            CommitteeMapper cm = new CommitteeMapper(args[0], "\\n\\n");
            cm.map();


            Graph g = new GraphMaker().makeGraph(cm.committeeMap);
            Colorer c = new Colorer();
            // c.randomColor(g.getVertices());
            //g = c.BFcolor(g);
            g = c.bigRandomColor(g, Long.parseLong(args[1]));
            System.out.println(g.getNumColors());
            System.out.println();

            HashMap<Integer, ArrayList<Vertex>> m = new HashMap<Integer, ArrayList<Vertex>>();

            for(Vertex v: g.getVertices()){
                if (!m.containsKey(v.getColor())){
                    m.put(v.getColor(),new ArrayList<Vertex>());
                }
                m.get(v.getColor()).add(v);
            }

            for(Map.Entry<Integer,ArrayList<Vertex>> e: m.entrySet()){
                System.out.println(e.getKey());
                for (Vertex v: e.getValue()){
                    System.out.println("         " + v.getId());
                }
            }


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

*//*
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
