import java.util.*;
import java.io.*;

public class myGraph {
    static class Edge {
        int src;
        int dest;
        int wt;

        Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
            this.wt = 0;
        }

        Edge(int src, int dest, int wt) {
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]) {
        for(int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<Edge>();
        }

        // graph[0].add(new Edge(0, 1));
        // graph[0].add(new Edge(0, 2));
        
        // graph[1].add(new Edge(1, 0));
        // graph[1].add(new Edge(1, 3));
        
        // graph[2].add(new Edge(2, 0));
        // graph[2].add(new Edge(2, 4));
                
        // graph[3].add(new Edge(3, 1));
        // graph[3].add(new Edge(3, 4));
        // graph[3].add(new Edge(3, 5));

        // graph[4].add(new Edge(4, 2));
        // graph[4].add(new Edge(4, 3));
        // graph[4].add(new Edge(4, 5));

        // graph[5].add(new Edge(5, 3));
        // graph[5].add(new Edge(5, 4));
        // graph[5].add(new Edge(5, 6));

        // graph[6].add(new Edge(6, 5));




        // graph for checking cycle in directed graph
        graph[0].add(new Edge(0, 2));
        graph[1].add(new Edge(1, 0));
        graph[2].add(new Edge(2, 3));
        graph[3].add(new Edge(3, 0)); //edge causing loop
    }


    // BFS without component
    public static void bfs(ArrayList<Edge> graph[], int x) {
        Queue<Integer> queue = new LinkedList<>();
        boolean visited[] = new boolean[graph.length];

        queue.add(x);
        while(!queue.isEmpty()) {
            int cur = queue.remove();

            if(visited[cur] == false) {
                System.out.print(cur + " ");
                visited[cur] = true;

                for(int i = 0; i < graph[cur].size(); i++) {
                    Edge e = graph[cur].get(i);
                    queue.add(e.dest);
                }
            }
        }
    }

    // BFS with component
    public static void bfs(ArrayList<Edge> graph[], boolean visited[], int start) {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(start);

        while(!queue.isEmpty()) {
            int curr = queue.remove();

            if(visited[curr] == false) {
                System.out.print(curr + " ");
                visited[curr] = true;

                for(int j = 0; j < graph[curr].size(); j++) {
                    Edge e = graph[curr].get(j);
                    queue.add(e.dest);
                }
            }
        }
    }

    public static void dfs(ArrayList<Edge> graph[], boolean visited[], int cur) {
        System.out.print(cur + " ");
        visited[cur] = true;
        
        for(int i = 0; i < graph[cur].size(); i++) {
            Edge e = graph[cur].get(i);

            if(visited[e.dest] == false) {
                dfs(graph, visited, e.dest);
            }
        }
    }

    // All paths from source to target

    // my method - but it doesn't use visited array
    // can be further optimized
    // public static void printAllPath(ArrayList<Edge> graph[], ArrayList<Integer> path, int cur, int dest) {
    //     path.add(cur);

    //     if(cur == dest) {
    //         for(int i = 0; i < path.size(); i++) {
    //             System.out.print(path.get(i) + " ");
    //         }
    //         System.out.println();

    //         path.remove((Integer) cur);
    //         return;
    //     }

    //     for(int i = 0; i < graph[cur].size(); i++) {
    //         Edge e = graph[cur].get(i);

    //         if(!path.contains(e.dest)) {
    //             printAllPath(graph, path, e.dest, dest);
    //         }
    //     }
        
    //     path.remove((Integer) cur);
    // }

    // mycode further optimized
    // public static void printAllPath(ArrayList<Edge> graph[], ArrayList<Integer> path, int cur, int dest) {
    //     if(cur == dest) {
    //         for(int i = 0; i < path.size(); i++) {
    //             System.out.print(path.get(i) + " ");
    //         }
    //         System.out.println(dest);
    //         return;
    //     }

    //     for(int i = 0; i < graph[cur].size(); i++) {
    //         Edge e = graph[cur].get(i);

    //         if(!path.contains(e.dest)) {
    //             path.add(cur);
    //             printAllPath(graph, path, e.dest, dest);
    //             path.remove((Integer) cur);
    //         }
    //     }
    // }

    // code from source
    public static void printAllPath(ArrayList<Edge> graph[], boolean visited[], int cur, String path, int dest) {
        if(cur == dest) {
            System.out.println(path);
            return;
        }

        for(int i = 0; i < graph[cur].size(); i++) {
            Edge e = graph[cur].get(i);

            if(!visited[e.dest]) {
                visited[cur] = true;
                printAllPath(graph, visited, e.dest, path+e.dest+" ", dest);
                visited[cur] = false;
            }
        }
    }

    // Cycle check
    public static boolean isCycleUndirected(ArrayList<Edge> graph[], boolean visited[], int cur, int prev) {
        visited[cur] = true;

        for(int i = 0; i < graph[cur].size(); i++) {
            Edge e = graph[cur].get(i);

            if(visited[e.dest] == true && e.dest != prev) {
                return true;
            } 
            
            if(!visited[e.dest]) {
                if(isCycleUndirected(graph, visited, e.dest, cur)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean isCycleDirected(ArrayList<Edge> graph[], boolean visited[], boolean rec[], int cur) {
        visited[cur] = true;
        rec[cur] = true;

        for(int i = 0; i < graph[cur].size(); i++) {
            Edge e = graph[cur].get(i);

            if(rec[e.dest]) {
                return true;
            }

            if(!visited[e.dest]) {
                if(isCycleDirected(graph, visited, rec, e.dest)) {
                    return true;
                }
            }
        }

        rec[cur] = false;
        return false;
    }


    public static void main(String[] args) {
        int V = 4; // 4 or 7 vertices

        ArrayList<Edge> graph[] = new ArrayList[V];
        boolean visited[] = new boolean[V];
        boolean rec[] = new boolean[V];

        createGraph(graph);
        /*
            1 --- 3
           /      |\
          0       | 5 --- 6
           \      |/
            2 --- 4
        */

        //print 2's neighbour
        // for(int i = 0; i < graph[2].size(); i++) {
        //     Edge e = graph[2].get(i);
        //     System.out.println(e.dest + " " + e.wt);
        // }

        //write this program using non static classes
        // i got this error while trying to do that before
        // Non-static variable cannot be referenced from a static context

        // System.out.println("\n");

        // bfs(graph, visited);

        // for(int i = 0; i < V; i++) {
        //     if(visited[i] == false) {
        //         bfs(graph, visited, i);
        //     }
        // }

        // dfs(graph, visited, 0);
        
        // for(int i = 0; i < V; i++) {
        //     if(visited[i] == false) {
        //         dfs(graph, visited, i);
        //     }
        // }

        // ArrayList<Integer> path = new ArrayList<>();
        // printAllPath(graph, path, 0, 5);

        //printAllPath(graph, visited, 0, "0 ", 5);

        //System.out.println(isCycleUndirected(graph, visited, 0, -1));

        for(int i = 0; i < V; i++) {
            if(!visited[i]) {
                if(isCycleDirected(graph, visited, new boolean[V], 0)) {
                    System.out.println(true);
                    break;
                }
                // will print true if loop exist and
                // nothing if loop doesn't exist
            }
        }
        
    }
}


topological sorting