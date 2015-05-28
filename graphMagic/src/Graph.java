import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by torrentglenn on 5/26/15.
 */
public class Graph {
    public HashMap<String, Vertex> vertexHashMap = new HashMap<String, Vertex>();

    public Graph(HashMap<String, Vertex> vhm){
        vertexHashMap = vhm;
    }

    public ArrayList<Vertex> getVertices(){
        ArrayList<Vertex> vlist = new ArrayList<Vertex>();
        for(Map.Entry e: vertexHashMap.entrySet()){
            vlist.add((Vertex)e .getValue());
        }
        return vlist;
    }

    public void addVertex(Vertex v){
        vertexHashMap.put(v.getId(),v);
    }

    public void addVertex(String vID){
        Vertex v = new Vertex(vID);
        vertexHashMap.put(v.getId(),v);
    }




}
