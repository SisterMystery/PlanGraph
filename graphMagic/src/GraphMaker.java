import java.util.*;

/**
 * Created by torrentglenn on 5/27/15.
 */
public class GraphMaker {
    public Graph makeGraph(HashMap<String,ArrayList<String>> Cmap){
        Set<String> sharedElems = new HashSet<String>();
        HashMap<String, Vertex> vertices = new HashMap<String, Vertex>();

        for(Map.Entry<String,ArrayList<String>> entry: Cmap.entrySet()){
            vertices.put(entry.getKey(), new Vertex(entry.getKey()));
            for(String s: entry.getValue()){
                sharedElems.add(s.trim());
            }
        }
        HashMap<String,ArrayList<String>> FtoS = new HashMap<String, ArrayList<String>>();

        for(String element: sharedElems){
         //   System.out.println(element);
            ArrayList<Vertex> connectedVs = new ArrayList<Vertex>();
            FtoS.put(element, new ArrayList<String>());// to delete
            for(Map.Entry<String,ArrayList<String>> entry: Cmap.entrySet()){
                if(entry.getValue().contains(element)){
                    FtoS.get(element).add(entry.getKey());//TO DELETE
                    connectedVs.add(vertices.get(entry.getKey()));
                }
            }

            for(Vertex v: connectedVs){
                for(Vertex subv: connectedVs){
                    v.addNeighbor(subv);
                }
            }

        }


/*
        for(Map.Entry<String, ArrayList<String>> entry: FtoS.entrySet()){
            System.out.println(entry.getKey());
            System.out.println(entry.getValue().size());
            for(String s: entry.getValue() ){
                System.out.println("            " + s);
            }
        }
*/
        return new Graph(vertices);
    }
}
