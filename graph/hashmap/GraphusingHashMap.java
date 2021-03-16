package hashmap;

import java.util.*;

public class GraphusingHashMap<K, E> {

	Map <K, List<Node<K,E>>> graph = null;
	
	public GraphusingHashMap() 
	{	
		graph = new HashMap<>();
	}
	
	public boolean addEdge(K v1, K v2, E edgeLabel)
	{
		if(!graph.containsKey(v1))
		{
			graph.put(v1, new LinkedList<>());
		}
		graph.get(v1).add(new Node<K, E>(v1, v2, edgeLabel));
		
		return true;
	}
	
	public boolean addUndirectedEdge(K v1, K v2, E edgeLabel)
	{
		addEdge(v1, v2, edgeLabel);
		addEdge(v2, v1, edgeLabel);
		return true;
	}

	@Override
	public String toString() 
	{
		String result = new String();
		for(K key: graph.keySet())
		{
			result += key + " --> " + graph.get(key) + "\n";
		}
		return result.trim();
	}
	
	public static class Node <K, E>{
		
		K key = null;
		K endNode = null;
		E edgelabel	= null;

		public Node(K key, K endNode, E edgelabel) 
		{
			this.key = key;
			this.endNode = endNode;
			this.edgelabel = edgelabel;
		}

		@Override
		public int hashCode() 
		{
			return key.hashCode();
		}

		@Override
		public boolean equals(Object obj) 
		{
			return key.equals(obj);
		}

		@Override
		public String toString() {
			return "{ key : " + key + ", endNode : " + endNode + ", edgelabel : " + edgelabel + "}";
		}
		
}
}
