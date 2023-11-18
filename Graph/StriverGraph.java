import java.util.*;

@SuppressWarnings("unchecked")
public class StriverGraph
{
	public static ArrayList<Integer>[] readGraph() {
	    Scanner s = new Scanner(System.in);
	    
	    // System.out.print("Enter the no. of nodes and edges: ");
	    int n = s.nextInt();
	    int m = s.nextInt();
	    
		ArrayList<Integer> graph[] = new ArrayList[n+1];
		for(int i = 0; i < n+1; i++) {
		    graph[i] = new ArrayList<Integer>();
		}
		
		// System.out.println("Enter the edges: ");
		
		int a, b;
		for(int i = 0; i < m; i++) {
		    a = s.nextInt();
		    b = s.nextInt();
		    graph[a].add(b);
		    graph[b].add(a);
		}

		return graph;

		/*
		for(int i = 0; i < n+1; i++) {
		    System.out.print(i + " -> ");
		    for(int j = 0; j < graph[i].size(); j++) {
		        System.out.print(graph[i].get(j) + ", ");
		    }
		    System.out.println();
		}
		*/
	}

	public static ArrayList<Integer> bfs(ArrayList<Integer>[] graph, int start) {
		ArrayList<Integer> res = new ArrayList<>();
		boolean visited[] = new boolean[graph.length];
		Queue<Integer> q = new LinkedList<>();

		visited[start] = true;
		q.add(start);

		while(q.size() > 0) {
			int cur = q.remove();
			res.add(cur);

			for(int i : graph[cur]) {
				if(visited[i] == false) {
					visited[i] = true;
					q.add(i);
				}
			}
		}
		return res;
	}

	public static ArrayList<Integer> dfsImplementation(ArrayList<Integer>[] graph, boolean visited[], ArrayList<Integer> res, int start) {
		visited[start] = true;
		res.add(start);

		for(int i : graph[start]) {
			if(visited[i] == false) {
				dfsImplementation(graph, visited, res, i);
			}
		}

		return res;
	}

	public static ArrayList<Integer> dfs(ArrayList<Integer>[] graph, int start) {
		boolean visited[] = new boolean[graph.length];
		ArrayList<Integer> res = new ArrayList<>();

		dfsImplementation(graph, visited, res, start);

		return res;
	}

	public static void main(String[] args) {
		ArrayList<Integer>[] graph = readGraph();

		ArrayList<Integer> data = bfs(graph, 1);

		for(int i : data) {
			System.out.print(i + " ");
		}

		// ArrayList<Integer> data = dfs(graph, 2);

		// for(int i : data) {
		// 	System.out.print(i + " ");
		// }
	}
}
