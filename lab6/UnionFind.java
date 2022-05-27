public class UnionFind {

    private int[] parent;

    /* Creates a UnionFind data structure holding n vertices. Initially, all
       vertices are in disjoint sets. */
    public UnionFind(int n) {
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = -1;
        }
    }

    /* Throws an exception if v1 is not a valid index. */
    private void validate(int vertex) {
        if (vertex < 0 || vertex > parent.length - 1) {
            throw new IllegalArgumentException("Is not a valid index");
        }
    }

    /**
     *  Returns the size of the set v1 belongs to.
     *  find(v1) return root
     *  parent(find(v1)) return -size
     *  */
    public int sizeOf(int v1) {
        return -1 * parent(find(v1));
    }

    /* Returns the parent of v1. If v1 is the root of a tree, returns the
       negative size of the tree for which v1 is the root. */
    public int parent(int v1) {
        return parent[v1];
    }

    /* Returns true if nodes v1 and v2 are connected. */
    public boolean connected(int v1, int v2) {
        return find(v1) == find(v2);
    }

    /* Connects two elements v1 and v2 together. v1 and v2 can be any valid 
       elements, and a union-by-size heuristic is used. If the sizes of the sets
       are equal, tie break by connecting v1's root to v2's root. Unioning a 
       vertex with itself or vertices that are already connected should not 
       change the sets but may alter the internal structure of the data. */
    public void union(int v1, int v2) {
        int root1 = find(v1);
        int root2 = find(v2);
        int size1 = sizeOf(v1);
        int size2 = sizeOf(v2);
        // if root1 = root2 may Path-compression.
        if (root1 == root2) {
            pathCompression(v1, root1);
            pathCompression(v2, root2);
        }
        // else root1 != root2
        // if size1 <= size2 v1 connect to v2
        if (size1 <= size2) {
            // resize v2
            parent[root2] -= size1;
            // v1 connect to v2
            parent[root1] = root2;
            pathCompression(v1, root2);
            pathCompression(v2, root2);
        } else {
            // resize v1
            parent[root1] -= size2;
            // v2 connect to v1
            parent[root2] = root1;
            pathCompression(v1, root1);
            pathCompression(v2, root1);
        }
    }

    //Path-compression
    private void pathCompression(int vertex, int root) {
        while (parent(vertex) >= 0  && parent(vertex) != root) {
            int temp = parent(vertex);
            parent[vertex] = root;
            vertex = parent(vertex);
        }
    }

    /* Returns the root of the set V belongs to. Path-compression is employed
       allowing for fast search-time. */
    public int find(int vertex) {
        validate(vertex);
        while (parent(vertex) >= 0) {
            vertex = parent(vertex);
        }
        return vertex;
    }

}
