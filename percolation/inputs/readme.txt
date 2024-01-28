/******************************************************************************
 *  Name:     
 *  NetID:    
 *
 *  Hours to complete assignment (optional):
 *
 ******************************************************************************/

Programming Assignment 1: Percolation


/******************************************************************************
 *  Describe how you implemented Percolation.java. How did you check
 *  whether the system percolates? This should be something like 3-5 sentences.
 *****************************************************************************/



/******************************************************************************
 *  Perform computational experiments to estimate the running time of
 *  PercolationStats.java for values values of n and T when implementing
 *  Percolation.java with QuickFindUF.java.
 *
 *  To do so, fill in the two tables below. Each table must have at least
 *  4 data points, ranging in time from around 0.1 seconds to at most a few
 *  minutes. Do not include data points that takes less than 0.1 seconds.
 *  Each data point should be double the size of the preceding data point
 *****************************************************************************/

(keep T constant)

 n          time (seconds)
------------------------------
...
...
...
...
...


(keep n constant)

 T          time (seconds)
------------------------------
...
...
...
...
...


/******************************************************************************
 *  Using the empirical data from the above two tables, give an estimate
 *  of the running time of PercolationStats.java as function of both n and 
 *  T, using asymptotic notation, like:
 *
 *       O( n^5.0 * T^1.5 )
 *
 *  Recall that with asymptotic notation, you are interested in the
 *  growth rate of run time as input sizes grow - you drop lower-order
 *  terms and constant factors. In class, we've discussed a way to 
 *  estimate polynomial factors from empirical run times.
 *
 *  How does this estimate compare to the theoretical run time growth
 *  rate, according to analysis of your code?
 *
 *****************************************************************************/

Running time as a function of n and T:  O(   )

Compared to theory:

/******************************************************************************
 *  Repeat the previous two questions, but using WeightedQuickUnionUF
 *  (instead of QuickFindUF).
 *****************************************************************************/

(keep T constant)

 n         time (seconds)
------------------------------
...
...
...
...
...


(keep n constant)

 T          time (seconds)
------------------------------
...
...
...
...
...


Running time as a function of n and T:  O(   )

Compared to theory:


/**********************************************************************
 *  How much memory (in bytes) does a Percolation object (which uses
 *  WeightedQuickUnionUF.java) use to store an n-by-n grid? Use the
 *  64-bit memory cost model from Section 1.4 of the textbook and use
 *  tilde notation to simplify your answer. Briefly justify your
 *  answers.
 *
 *  Include the memory for all referenced objects (deep memory).
 **********************************************************************/








 
/******************************************************************************
 *  Known bugs / limitations.
 *****************************************************************************/




/******************************************************************************
 *  Describe whatever help (if any) that you received.
 *  Don't include readings, lectures, and precepts, but do
 *  include any help from people (including course staff, TA,
 *  classmates, and friends) and attribute them by name.
 *****************************************************************************/


/******************************************************************************
 *  Describe any serious problems you encountered.                    
 *****************************************************************************/




/******************************************************************************
 *  List any other comments here. Feel free to provide any feedback   
 *  on how much you learned from doing the assignment, and whether    
 *  you enjoyed doing it.                                             
 *****************************************************************************/


