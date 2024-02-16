/******************************************************************************
 *  Name:     
 *
 *  Hours to complete assignment (optional):
 *
 ******************************************************************************/

Programming Assignment 1: Percolation


/******************************************************************************
 *  Describe how you implemented Percolation.java. How did you check
 *  whether the system percolates? This should be something like 3-5 sentences.
 *****************************************************************************/

Every time a cell opens, check the surrounding cells to check if they are also open.
If they are then link their nodes. There are 2 extra nodes for the top and bottom
respectively. When a node opens on the top row it connects with the top node, likewise
if a cell on the bottom opens then connect to the bottom node. To check if the system
percolates run connected(top node, bottom node)


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

(keep T constant; n doubles)

 n          time (seconds)
------------------------------
N = 100
T = 50
Mean = 0.5932779999999999
Standard Dev = 0.01534924434755067
95% confidence interval = 0.5890234065324168 / 0.5975325934675829
Elapsed Time = 0.575 seconds

N = 200
T = 50
Mean = 0.5920084999999999
Standard Dev = 0.012024457018162302
95% confidence interval = 0.5886754905617295 / 0.5953415094382704
Elapsed Time = 8.392 seconds

N = 400
T = 50
Mean = 0.5928676249999999
Standard Dev = 0.006739693412842087
95% confidence interval = 0.590999477297187 / 0.5947357727028127
Elapsed Time = 129.114 seconds




(keep n constant; T doubles)

 T          time (seconds)
------------------------------
N = 100
T = 50
Mean = 0.5914499999999999
Standard Dev = 0.018022868126638565
95% confidence interval = 0.5864543158306393 / 0.5964456841693605
Elapsed Time = 0.573 seconds

N = 100
T = 100
Mean = 0.5953780000000001
Standard Dev = 0.01512888454165566
95% confidence interval = 0.5924127386298356 / 0.5983432613701646
Elapsed Time = 1.139 seconds

N = 100
T = 200
Mean = 0.5915645000000002
Standard Dev = 0.016198789884389293
95% confidence interval = 0.5893194622618437 / 0.5938095377381566
Elapsed Time = 2.237 seconds

N = 100
T = 400
Mean = 0.59253275
Standard Dev = 0.016006699801452976
95% confidence interval = 0.5909640934194577 / 0.5941014065805424
Elapsed Time = 4.487 seconds




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

The worst case scenario for quick find union is O(N^2). When running a doubling N test
N doubles every test turning the algorithm from O(N^2) to O(N^4). You also do T amount
of tests so the final runtime of the algorithm is O(TN^4)

I confirmed this by taking lg(time(2N)/time(N)). The resulting answer was roughly 4.
I did the same conformation with T. lg(time(2T)/time(T)). The answer is roughly 1.




/******************************************************************************
 *  Repeat the previous three questions, but using WeightedQuickUnionUF
 *  (instead of QuickFindUF).
 *****************************************************************************/

(keep T constant; n doubles)

 n          time (seconds)
------------------------------

N = 500
T = 500
Mean = 0.5926037440000003
Standard Dev = 0.004916161188582842
95% confidence interval = 0.5921728234722444 / 0.5930346645277561
Elapsed Time = 7.079 seconds

N = 1000
T = 500
Mean = 0.5928936120000008
Standard Dev = 0.0030460616435865288
95% confidence interval = 0.5926266129247711 / 0.5931606110752304
Elapsed Time = 52.971 seconds

N = 2000
T = 500
Mean = 0.5927869999999997
Standard Dev = 0.0017446745293684019
95% confidence interval = 0.5926340725348256 / 0.5929399274651739
Elapsed Time = 481.654 seconds



(keep n constant; T doubles)

 T          time (seconds)
------------------------------

N = 500
T = 500
Mean = 0.5925762639999995
Standard Dev = 0.0051286716545499746
95% confidence interval = 0.5921267161086086 / 0.5930258118913905
Elapsed Time = 7.092 seconds

N = 500
T = 1000
Mean = 0.5928355799999995
Standard Dev = 0.004861356849895104
95% confidence interval = 0.5925342699807747 / 0.5931368900192242
Elapsed Time = 14.123 seconds

N = 500
T = 2000
Mean = 0.5926540259999994
Standard Dev = 0.004871382977490139
95% confidence interval = 0.5924405282277502 / 0.5928675237722486
Elapsed Time = 28.241 seconds

N = 500
T = 4000
Mean = 0.5927674410000011
Standard Dev = 0.005037415876140896
95% confidence interval = 0.5926113298646382 / 0.5929235521353641
Elapsed Time = 56.989 seconds



Run time estimate:

Sense the worst time complexity for weighted quick union find is O(lgN)







 
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
 *  you enjoyed (or hated) doing it.                                             
 *****************************************************************************/

