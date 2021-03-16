package list;

import java.util.*;

public class MinimumSpanTree {
	
	List<Edge> mst[];
	
	public MinimumSpanTree(int n) 
	{
		mst = new LinkedList[n];
		for(int i = 0; i < n; i++)
			mst[i] = new LinkedList<Edge>();
	}
	
	public void addEdge(int u, int v, int w) 
	{
		 mst[u].add(new Edge(u, v, w));
	}
	
	public void addUndirectedEdge(int u, int v, int w) 
	{
		 mst[u].add(new Edge(u, v, w));
		 mst[v].add(new Edge(v, u, w));
	}
	
	public void kruskal()
	{
		Queue <Edge> q = new PriorityQueue<>(Comparator.comparingInt(o -> o.w));
		List <Edge> minimumTree = new LinkedList<>();
		int parent[] = new int[mst.length];
		int totalWeight = 0;
		int V = 0;
		
		for(int i = 0; i < mst.length; i++)
		{
			parent[i] = i;
			for(Edge E: mst[i])
			{
				q.add(E);
				V++;
			}
		}

		while(V-- != 0)
		{
			Edge E = q.remove();
			if(parent[E.u] != parent[E.v])
			{
				minimumTree.add(E);
				totalWeight += E.w;
				
				for(int i = 0; i < mst.length; i++)
				{
					if(parent[i] == parent[E.u])
						parent[i] = parent[E.v];
				}
			}
		}
		System.out.println("Total Weight of Minimum Spanning Tree : " + totalWeight + "\n" + "Graph Edges Of Minimum Spanning Tree are : ");
		for(Edge E:minimumTree)
		{
			System.out.println(E);
		}
	}
	
	public void prim()
	{
		List<Edge> list = new LinkedList<>();
		int parent [] = new int[mst.length];
		boolean visited[] = new boolean[mst.length];
		int key [] = new int[mst.length];
		int V = mst.length - 1;
		int minDistance = Integer.MAX_VALUE;
		
		for(int i = 0; i < mst.length; i++)
		{
			boolean flag = true;
			for(Edge x: mst[i])
			{
				if(x.v == 0)
				{
					flag = false;
					key[i] = x.w;
					break;
				}
			}
			if(flag == true)
				key[i] = Integer.MAX_VALUE;
			parent[i] = 0;
		}
		
		int v = 0, u = 0, minCost = 0;
		while(V-- != 0)
		{
			minDistance = Integer.MAX_VALUE;
			for(int i = 0; i < mst.length; i++)
			{
				if(!visited[i] && key[i] < minDistance)
				{
					v = i;
					minDistance = key[i];
				}
			}
			
			visited[v] = true;
			u = parent[v];
			for(Edge x :mst[u])
			{
				if(x.v == v)
				{
					minCost += x.w;
					list.add(0, x);
					break;
				}
			}
				
			for(int i = 0; i < mst.length; i++)
			{
				if(!visited[i] && key[i] > list.get(0).w)
				{
					key[i] = list.get(0).w;
					parent[i] = v;
				}
			}
		}
		System.out.println("Total Weight of Minimum Spanning Tree : " + minCost + "\n" + "Graph Edges Of Minimum Spanning Tree are : ");
		for(Edge E:list)
		{
			System.out.println(E);
		}
	}

	@Override
	public String toString()
	{
		String result = "";
		
		for(int i = 0; i < mst.length; i++)
			result += i + " : " + mst[i] + "\n"; 
		return result;
	}

	static class Edge
	{
		int u;
		int v;
		int w;
		
		public Edge(int u, int v, int w) 
		{
			this.u = u;
			this.v = v;
			this.w = w;
		}

		@Override
		public String toString() 
		{
			return "(" + u + " --> " + v + ", w = " + w + ")";
		}
	}
}