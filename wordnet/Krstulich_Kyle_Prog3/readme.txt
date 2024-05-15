/******************************************************************************
 *  Name:Kyle Krstulich
 *
 *  Hours to complete assignment (optional):
 *
 ******************************************************************************/

Programming Assignment 3: WordNet


/******************************************************************************
 *  Describe concisely the data structure(s) you used to store the 
 *  information in synsets.txt. Why did you make this choice?
 *****************************************************************************/

I employed a HashMap to store the data from synsets.txt. The keys represent nouns, while the values are sets of synset IDs, enabling quick retrieval of synsets associated with a specific noun. Additionally, I utilized another HashMap to maintain a reverse mapping: from synset IDs to sets of nouns. This facilitates rapid lookup of nouns linked to a given synset.

/******************************************************************************
 *  Describe concisely the data structure(s) you used to store the 
 *  information in hypernyms.txt. Why did you make this choice?
 *****************************************************************************/

I utilized a Digraph to organize the data from hypernyms.txt. In this representation, nodes correspond to synsets, and edges signify the hypernym relationships among them. This structure enables efficient graph traversal, facilitating the discovery of the shortest common ancestor between any two synsets.

/******************************************************************************
 *  Describe concisely your algorithm to compute the shortest common
 *  ancestor in ShortestCommonAncestor. For each method in the API, what
 *  is the order of growth of the worst-case running time as a function
 *  of the number of vertices V and the number of edges E in the digraph?
 *  For each method, what is the order of growth of the best-case running time?
 *
 *  If you use hashing, you may assume the uniform hashing assumption
 *  so that put() and get() take constant time.
 *
 *  Be careful! If you use something like a BreadthFirstDirectedPaths object, 
 *  don't forget to count the time needed to initialize the marked[],
 *  edgeTo[], and distTo[] arrays.
 *****************************************************************************/

Description:

                                              running time
method                               best case            worst case
------------------------------------------------------------------------
length(int v, int w)                O(1)               O(V + E)

I mean...this should be obvious

ancestor(int v, int w)              O(1)               O(V + E)

In the ShortestCommonAncestor implementation, I determined that the worst-case running time is O(V + E), where V represents the number of vertices and E represents the number of edges in the digraph. Conversely, the best-case running time is either O(1) or O(h), where h denotes the height of the graph, which is at most V.

length(Iterable<Integer> v,    
       Iterable<Integer> w)         O(V + E)           O(V^2 * E)



ancestor(Iterable<Integer> v, 
         Iterable<Integer> w)      O(V + E)            O(V^2 * E)

Reasoning for last two:
Best case: When the input subsets v and w are small with only one element each, the method traverses a single path in the graph, resulting in O(V + E) time complexity.

Worst case: When the input subsets are large and contain many elements, the method must traverse the entire graph for each pair of vertices in the input subsets, resulting in O(V^2 * E) time complexity. This is because for every pair of vertices, the method needs to traverse the graph to find the shortest path, leading to a quadratic time complexity.


/******************************************************************************
 *  Known bugs / limitations.
 *****************************************************************************/


/******************************************************************************
 *  Describe whatever help (if any) that you received.
 *  Don't include readings, lectures, but do include any 
 *  help from people (including course staff, TAs,
 *  classmates, and friends) and attribute them by name.
 *****************************************************************************/
Nate

/******************************************************************************
 *  Describe any serious problems you encountered.                    
 *****************************************************************************/


/******************************************************************************
 *  List any other comments here. Feel free to provide any feedback   
 *  on how much you learned from doing the assignment, and whether    
 *  you enjoyed doing it.                                             
 *****************************************************************************/