
public class UGraphTest {

    public static void main(String[] args) {
        UGraph<Integer> g = new UGraph<>();
        g = new UGraph<Integer>(0);
        g.addVertex(1);
        if(g.addVertex(1)) { // must return false
            System.out.println("Error: addVertex failed!");
        };
        g.addVertex(2);
        g.addEdge(0, 1);
        if(g.addEdge(0, 1)) { // must return false
            System.out.println("Error: addEdge failed!");
        }
        g.addEdge(0, 2);
        System.out.println(g);
        
        // testing contains and removeVertex
        for(int i = 10; i < 20; i++) {
            g.addVertex(i);
        }
        System.out.println(g);
        for(int i = 10; i < 20; i++) {
            if(!g.contains(i)) {
                System.out.println("Error: contains failed!");
            }
            if(!g.removeVertex(i)) {
                System.out.println("Error: removeVertex failed!");
            }
        }
        System.out.println(g);
        // testing adjecent
        if(g.adjacent(1, 2) || g.adjacent(3, 0) || !g.adjacent(0, 1)) {
            System.out.println("Error: adjacent failed!");
        }
        
        // testing addEdge and removeEdge and adjacent
        for(int i = 10; i < 20; i++) {
            g.addVertex(i);
        }
        for(int i = 10; i < 19; i++) {
            if(!g.addEdge(i, i+1)) {
                System.out.println("Error: addEdge failed!");
            }
        }
        System.out.println(g);
        for(int i = 10; i < 19; i++) {
            if(!g.adjacent(i, i+1)) {
                System.out.println("Error: adjacent failed!");
            }
            if(!g.removeEdge(i, i+1)) {
                System.out.println("Error: removeEdge failed!");
            }
        }
        g.clear();
        System.out.println(g);
        
        // testing connected method
        g.addVertex(0);
        g.addVertex(1);
        g.addVertex(2);
        g.addVertex(3);
        g.addVertex(4);
        g.addVertex(5);
        g.addEdge(0,1);
        g.addEdge(1,3);
        g.addEdge(2,3);
        g.addEdge(5,3);
        if(g.connected(4, 1) || g.connected(4, 0) || g.connected(4, 3) || !g.connected(0, 5) || !g.connected(3, 0)) {
            System.out.println("Error: connected failed!");
        }
        g.clear();
        for(int i = 10; i < 20; i++) {
            g.addVertex(i);
        }
        for(int i = 10; i < 19; i++) {
            g.addEdge(i, i+1);
        }
        if(!g.connected(10, 20)) {
            System.out.println("Error: connected failed!");
        }
        System.out.println(g);
    }
}
