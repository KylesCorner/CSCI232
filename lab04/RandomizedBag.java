
/******************************************************************************
 *  Compilation:  javac RandomizedBag.java
 *  Execution:    java RandomizedBag < input.txt
 *  Dependencies: StdIn.java StdOut.java
 *
 *  Stack implementation with a resizing array.
 *
 *  % java ResizingArrayStack < tobe.txt
 *  to be not that or be (2 left on stack)
 *
 ******************************************************************************/

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;

public class RandomizedBag<Item> implements Iterable<Item> {
  private Item[] a; // array of items
  private int n;    // number of elements on stack
  Random rng;

  /**
   * Initializes an empty stack.
   */
  public RandomizedBag() {
    this.a = (Item[]) new Object[2];
    this.n = 0;
    this.rng = new Random();
  }

  /**
   * Is this stack empty?
   */
  public boolean isEmpty() { return this.n == 0; }

  /**
   * Returns the number of items in the stack.
   */
  public int size() { return this.n; }

  /*
   * Resize the underlying array holding the elements
   */
  private void resize(int capacity) {
    Item[] copy = (Item[]) new Object[capacity];
    for (int i = 0; i < n; i++) {
      copy[i] = this.a[i];
    }
    this.a = copy;
  }

  public void put(Item item) {
    if (item == null) {
      throw new IllegalArgumentException("Item cannot be null");
    }
    if (this.n == this.a.length) {
      resize(2 * this.a.length); // Double the capacity when full
    }
    this.a[this.n++] = item;
  }

  /**
   * Removes and returns a random item from the bag
   */
  public Item get() {
    if (isEmpty()) {
      throw new NoSuchElementException("Bag is empty");
    }
    int randomIndex = this.rng.nextInt(this.n); // Choose a random index
    Item item = this.a[randomIndex];
    this.a[randomIndex] =
        this.a[this.n - 1]; // Swap the chosen item with the last one
    this.a[this.n - 1] = null;
    this.n--;

    if (this.n > 0 && this.n == this.a.length / 4) {
      resize(this.a.length / 2);
    }
    return item;
  }

  /**
   * Returns an iterator to this bag that iterates through the items in random
   * order.
   */
  public Iterator<Item> iterator() { return new RandomizedBagIterator(); }

  // an iterator; ours doesn't implement remove() since it's optional
  private class RandomizedBagIterator implements Iterator<Item> {
    private Item itArr[];
    private int count;

    public RandomizedBagIterator() {
      /*
       * do the work here to support
       * (i) multiple independent iterators (i.e. each one initializes its own
       * itArr);
       * - in this constructor, this can take time linear in the size of the bag
       * (ii) constant time next() and hasnext() calls.
       */
      itArr = (Item[]) new Object[n];
      count = 0;

      for (int index = 0; index < n; index++) {
        itArr[index] = a[index];
      }
      shuffle(itArr);
    }

    public void remove() { throw new UnsupportedOperationException(); }

    public boolean hasNext() { return count < n; }

    public Item next() {
      if (!hasNext())
        throw new NoSuchElementException();
      return itArr[count++];
    }

    private void shuffle(Item[] arr) {
      for (int index = a.length - 1; count > 0; count--) {
        int randomIndex = StdRandom.uniform(index + 1);
        Item temp = itArr[randomIndex];
        itArr[randomIndex] = itArr[index];
        itArr[index] = temp;
      }
    }
  }

  /**
   * Unit tests the RandomizeBag data type.
   */
  public static void main(String[] args) {
    RandomizedBag<String> bag = new RandomizedBag<String>();
    while (!StdIn.isEmpty()) {
      String item = StdIn.readString();
      if (!item.equals("-"))
        bag.put(item);
      else if (!bag.isEmpty())
        StdOut.print(bag.get() + " ");
    }
    StdOut.println("(" + bag.size() + " left on bag)");

    Iterator<String> itr1 = bag.iterator();
    if (!bag.isEmpty())
      bag.get(); // test removal of one
    Iterator<String> itr2 = bag.iterator();

    StdOut.println(
        "Here's what was left before removing one (in random order):");
    while (itr1.hasNext()) {
      String s = itr1.next();
      StdOut.println(s + " ");
    }
    StdOut.println("");

    StdOut.println(
        "Here's what was left after removing one (in random order):");
    while (itr2.hasNext()) {
      String s = itr2.next();
      StdOut.println(s + " ");
    }
    StdOut.println("");

    StdOut.println(
        "I sure hope the second one is missing one entry, and in a different order.");
  }
}
