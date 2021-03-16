package list;

public class MSTTest {

	public static void main(String[] args) 
	{
		MinimumSpanTree gh = new MinimumSpanTree(4);
		gh.addEdge(1, 3, 5);
		gh.addEdge(2, 0, 7);
		gh.addEdge(0, 1, 5);
		gh.addEdge(0, 3, 5);
		gh.addEdge(1, 2, 6);
		gh.addEdge(3, 2, 3);
		
//		gh.addUndirectedEdge(1, 3, 5);
//		gh.addUndirectedEdge(2, 0, 7);
//		gh.addUndirectedEdge(0, 1, 5);
//		gh.addUndirectedEdge(0, 3, 5);
//		gh.addUndirectedEdge(1, 2, 6);
//		gh.addUndirectedEdge(3, 2, 3);
		
		System.out.println("Graph is : \n" + gh);
		gh.kruskal();
//		gh.prim();
	}

}
