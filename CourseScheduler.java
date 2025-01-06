import java.util.*;

public class CourseScheduler {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // Create the adjacency list and in-degree array
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        int[] inDegree = new int[numCourses];

        // Build the graph and populate the in-degree array
        for (int[] prereq : prerequisites) {
            int dest = prereq[0];
            int src = prereq[1];
            graph.get(src).add(dest);
            inDegree[dest]++;
        }
        for(List<Integer> i : graph){
            System.out.println(i);
        }
        // Initialize the queue with all nodes having in-degree of 0
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        int[] topoOrder = new int[numCourses];
        int index = 0;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            topoOrder[index++] = node;

            // Reduce the in-degree of neighboring nodes by 1
            for (int neighbor : graph.get(node)) {
                inDegree[neighbor]--;
                // If in-degree of neighbor becomes 0, add it to the queue
                if (inDegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }

        if (index == numCourses)
            return topoOrder;
        else
            return new int[0];
    }

    public static void main(String[] args) {
        CourseScheduler cs = new CourseScheduler();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of courses:");
        int numCourses = scanner.nextInt();

        System.out.println("Enter the number of prerequisite pairs:");
        int n = scanner.nextInt();
        int[][] prerequisites = new int[n][2];

        System.out.println("Enter each prerequisite pair (format: course prerequisite):");
        for (int i = 0; i < n; i++) {
            prerequisites[i][0] = scanner.nextInt();
            prerequisites[i][1] = scanner.nextInt();
        }
//        int[][] prerequisites = {
//                {5, 2}, {5, 0}, {4, 0}, {4, 1}, {2, 3}, {3, 1}
//        };

        int[] order = cs.findOrder(numCourses, prerequisites);
        if (order.length == 0) {
            System.out.println("No possible course schedule due to a cycle.");
        } else {
            System.out.println("Course schedule: " + Arrays.toString(order));
        }
    }
}
