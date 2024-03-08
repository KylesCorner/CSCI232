/******************************************************************************
 *  Name: Kyle Krstulich
 *
 *  Hours to complete assignment (optional):
 *
 ******************************************************************************/

Programming Assignment 2: Autocomplete


/******************************************************************************
 *  Describe how your firstIndexOf() method in BinarySearchDeluxe.java
 *  finds the first index of a key that equals the search key.
 *****************************************************************************/

The method continously splts an array in half, by checking if the middle value's prefix matches the key.
If the value is greater than the key, ignore the greater half. If the value is less then the key, ignore the smaller half.
If the value matches the key, then decriment the middle index until you find the first value that matches the key.
else return -1



/******************************************************************************
 *  What is the order of growth of the number of compares (in the
 *  worst case) that each of the operations in the Autocomplete
 *  data type make, as a function of the number of terms n and the
 *  number of matching terms m?  (Big-Oh notation)
 *
 *  Recall that with order-of-growth notation, you should discard
 *  leading coefficients and lower-order terms, e.g., m^2 + m log n.
 *****************************************************************************/

constructor: O(n log n)

allMatches(): O(n log n)

numberOfMatches(): O(n)




/******************************************************************************
 *  Known bugs / limitations.
 *****************************************************************************/
 doesnt support uppercase letters.

/******************************************************************************
 *  Describe whatever help (if any) that you received.
 *  Don't include readings or lectures, but do include
 *  any help from people (including course staff, lab TAs,
 *  classmates, and friends) and attribute them by name.
 *
 *  Also include any resources (including the web) that you may
 *  may have used in creating your design.
 *****************************************************************************/
https://www.geeksforgeeks.org/binary-search/

Ingrid and Colin helped me on this assignment.

/******************************************************************************
 *  Describe any serious problems you encountered.
 *****************************************************************************/

The comparator took me a while to figure out.




/******************************************************************************
 *  List any other comments here. Feel free to provide any feedback
 *  on how much you learned from doing the assignment, and whether
 *  you enjoyed doing it.
 *****************************************************************************/

This project was a good time.

