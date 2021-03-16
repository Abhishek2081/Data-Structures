package list;

import java.util.*;

public class GraphUsingList {

	public static void main(String[] args) {
		Graph gh = new Graph(4);
		gh.addUndirectedEdge(1, 3, 5);
		gh.addUndirectedEdge(2, 0, 7);
		gh.addUndirectedEdge(0, 1, 5);
		gh.addUndirectedEdge(0, 3, 5);
		gh.addUndirectedEdge(1, 2, 6);
		gh.addUndirectedEdge(3, 2, 3);
		gh.DFS(2);
		gh.BFS(2);
		gh.dijkstra(0);
		System.out.println(gh);
		System.out.println(gh.isConnected(0, 2));
		System.out.println(gh.isConnected(3, 3));
		
	}
	
	static class Graph
	{
		List<Edge>[] graph;
		
		Graph(int n) 
		{
			graph = new LinkedList[n];
			for(int i = 0; i < n; i++)
			{
				graph[i] = new LinkedList<>();
			}
		}

		public void addEdge(int u, int v, int w)
		{
			graph[u].add(0,new Edge(v,w));
		}
		
		public void addUndirectedEdge(int u, int v, int w)
		{
			graph[u].add(0,new Edge(v,w));
			graph[v].add(0,new Edge(u,w));
		}
		
		public boolean isConnected(int u, int v)
		{
			for(Edge x: graph[u])
				if(x.v == v)
					return true;
			return false;
		}
		
		public void DFS(int i)
		{
			HashSet <Integer> visited = new HashSet<>();
			Stack<Integer> s = new Stack<>();
			
			s.push(i);
			System.out.print("DFS Search : ");
			while(!s.empty())
			{
				i = s.pop();
				
				if(!visited.contains(i))
				{
					visited.add(i);
//					if(visited.size() != graph.length)
						System.out.print(i + " ");
//					else System.out.print(i);
				}
				
				for(Edge x :graph[i])
				{
					if(!visited.contains(x.v))
						s.add(x.v);
				}
			}
			System.out.println();
		}
		
		public void BFS(int i)
		{
			HashSet <Integer> visited = new HashSet<>();
			Queue<Integer> q = new LinkedList<>();
			
			q.add(i);
			visited.add(i);
			System.out.print("BFS Search : ");
			while(!q.isEmpty())
			{
				i = q.poll();
				System.out.print(i + " ");
				
				Iterator<Edge> itr = graph[i].listIterator();
				while(itr.hasNext())
				{
					int  edgeList = itr.next().v;
					if(!visited.contains(edgeList))
					{
						q.add(edgeList);
						visited.add(edgeList);
					}
				}
			}
			System.out.println();
		}
		
		public void dijkstra(int source)
		{
			Set<Integer> visited = new HashSet<>();
			Queue<Edge> q = new PriorityQueue<>(new Edge());
			int dist [] = new int[graph.length];
			
			for(int i = 0; i < graph.length; i++)
			{
				dist[i] = Integer.MAX_VALUE;
			}
			q.add(new Edge(source, 0));
			dist[source] = 0;
			
			while(visited.size() != graph.length)
			{
				int u = q.remove().v;
				visited.add(u);
				
				for(int i = 0; i < graph[u].size(); i++)
				{
					Edge e = graph[u].get(i);
					
					int newDistance = -1;
					
					if(!visited.contains(e.v))
					{
						newDistance = dist[u] + e.w;
						
						if(newDistance < dist[e.v])
							dist[e.v] = newDistance;
						
						q.add(new Edge(e.v, dist[e.v]));
					}
				}
			}
			System.out.println("Using Dijkistra's Algorithm : ");
			System.out.println("The Shortest Path from Edge : ");
			for(int i = 0; i < dist.length; i++)
			{
				System.out.println(source + " to " + i + " is : " + dist[i]);
			}
		}
		
		@Override
		public String toString() {
			String result = "";				//new String() will work
			for(int i = 0; i < graph.length; i++)
				result += i + " --> " + graph[i] + "\n";
			return result.trim();
		}

		class Edge implements Comparator <Edge>
		{
			int v, w;
			
			public Edge() {
				
			}

			Edge(int v, int w) 
			{
				this.v = v;
				this.w = w;
			}

			@Override
			public String toString() {
				return "(" + v + ", " + w + ")";
			}

			@Override
			public int compare(Edge o1, Edge o2) 
			{
				return o1.w - o2.w;
			}
		}
	}
}
