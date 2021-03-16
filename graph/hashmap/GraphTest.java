package hashmap;

public class GraphTest {

	public static void main(String[] args) {
		GraphusingHashMap <String, String> gh = new GraphusingHashMap<>();
		
		gh.addEdge("Pune", "Mumbai", "Near");
		gh.addEdge("Pune", "Nagpur", "Far");
		gh.addEdge("Delhi", "Noida", "Near");
		gh.addEdge("Nashik", "Thane", "Side");
		
		gh.addUndirectedEdge("Bangalore", "Hyderabad", "IT Hubs");
		System.out.println(gh);
	}
}
