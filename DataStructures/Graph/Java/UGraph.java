import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;
import java.util.List;
import java.util.Map;

/**
 * @summary: simple implementation of an undirected graph  
 * @author: Kayhan Dehghani
 **/
public class UGraph<T> {
	private List<Vertex<T>> vertices;

	public UGraph() {
		vertices = new ArrayList<>();
	}
	
	public UGraph(T id) {
		// graph having 1 vertex with id = id
		vertices = new ArrayList<>();
		vertices.add(new Vertex(id));
	}

	public boolean contains(T id) {
		for(Vertex v : vertices) {
			if(v.id == id) return true;
		}
		return false;
	}

	private Vertex<T> get(T id) {
		for(Vertex v : vertices) {
			if(v.id == id) return v;
		}
		return null;
	}

	// tests whether there is an edge from the vertex x to the vertex y
	public boolean adjacent(T id1, T id2) {
		// check if vertices exist
		Vertex v1 = this.get(id1);
		Vertex v2 = this.get(id2);
		if(v1 == null || v2 == null) return false;
		// check if edge exist
		return v1.isNeighbor(id2);
	}

	// tests whether there is a route between two vertices
	public boolean connected(T id1, T id2) {
		// check if vertices exist
		Vertex v1 = this.get(id1);
		Vertex v2 = this.get(id2);
		if(v1 == null || v2 == null) return false;
		for(Vertex<T> v : vertices) {
			v.status = State.Unvisited;
		}
		Stack<Vertex<T>> hasRoute = new Stack<>();
		hasRoute.push(v1);
		Vertex<T> current;
		Vertex<T> neighbor;
		while(!hasRoute.isEmpty()) {
			current = hasRoute.pop();
			for(T n : current.neighbors) {
				neighbor = this.get(n);
				if(neighbor.status == State.Unvisited) {
					if(neighbor.id == id2) {
						return true; // route has been found
					}
					neighbor.status = State.Visited;
					hasRoute.push(neighbor);
				}
			}
		}
		return false;
	}

	// lists all vertices y such that there is an edge from the vertex id to the vertex y
	// returns null if id doesn't exist in graph
	public List<T> neighbors(T id) {
		// check if vertex exist
		Vertex v = this.get(id);
		return (v == null) ? null : v.neighbors;
	}

	// adds the vertex id, if it is not there
	public boolean addVertex(T id) {
		if(this.contains(id)) return false;
		vertices.add(new Vertex(id));
		return true;
	}

	// removes the vertex id, if it is there
	public boolean removeVertex(T id) {
		if(!this.contains(id)) return false;
		// remove the vertex
		vertices.remove(this.get(id));
		// remove the edges from this vertex if any
		for(Vertex v : vertices) {
			v.removeNeighbor(id);
		}
		return true;
	}

	// adds the edge from the vertex id1 to the vertex id2, if it is not there
	public boolean addEdge(T id1, T id2) {
		Vertex<T> v1 = this.get(id1);
		Vertex<T> v2 = this.get(id2);
		if(v1 == null || v2 == null) return false;
		return v1.addNeighbor(id2) && v2.addNeighbor(id1);
	}

	// removes the edge from the vertex id1 to the vertex id2, if it is there
	public boolean removeEdge(T id1, T id2) {
		Vertex<T> v1 = this.get(id1);
		Vertex<T> v2 = this.get(id2);
		if(v1 == null || v2 == null) return false;
		return v1.removeNeighbor(id2) && v2.removeNeighbor(id1);
	}

	public String toString() {
		StringBuilder resutl =  new StringBuilder("Undiredcted Graph:\n");
		for(Vertex<T> v : vertices) {
			resutl.append(" neighbors of vertex " + v.id + ":  ");
			for(T id : v.neighbors) {
				resutl.append( id + ", ");
			}
			resutl.append("\n");
		}
		return resutl.toString();
	}

	public void clear() {
		vertices.clear();
	}
}

class Vertex<T> {
	T id; // unique value representing the vertex
	List<T> neighbors;
	State status; // only used for finding route between vertices

	Vertex(T id) {
		neighbors = new ArrayList<>();
		this.id = id;
	}

	public boolean removeNeighbor(T id) {
		if(neighbors.contains(id)) {
			neighbors.remove(id);
			return true;
		} else {
			return false;
		}
	}

	public boolean addNeighbor(T id) {
		if(!neighbors.contains(id)) {
			neighbors.add(id);
			return true;
		} else {
			return false;
		}
	}

	public boolean isNeighbor(T id) {
		return neighbors.contains(id);
	}

}
enum State {
	Unvisited, Visited;
}
