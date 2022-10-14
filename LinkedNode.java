//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: Linked Sorting
// Course: CS 300 Spring 2022
//
// Author: Johnny Palumbo
// Email: jdpalumbo2@wisc.edu
// Lecturer: Michelle Jensen
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name: na
// Partner Email: na
// Partner Lecturer's Name: na
//
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
// ___ Write-up states that pair programming is allowed for this assignment.
// ___ We have both read and understand the course Pair Programming Policy.
// ___ We have registered our team prior to the team registration deadline.
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Persons: none
// Online Sources: none
//
///////////////////////////////////////////////////////////////////////////////

/**
 * LinkedNode<T> class that creates nodes to store books in
 * 
 * @author Johnny Palumbo
 */
public class LinkedNode<T> {
  
  private T data;
  private LinkedNode<T> next;
  
  /**
   * Constructor that sets this node to the given data and sets next to null
   * 
   * @param T data - data stored in the node
   */
  public LinkedNode(T data) {
    this.data = data;
  }
  
  /**
   * Constructor that sets this node to the given data and sets next to given reference
   * 
   * @param T data - data stored in the node
   */
  public LinkedNode(T data, LinkedNode<T> next) {
    this.data = data;
    this.next = next;
  }
  
  /**
   * method that returns next node
   * 
   * @return this.next - next node in the list
   */
  public LinkedNode<T> getNext() {
    return this.next;
  }
  
  /**
   * gets data in the node
   * 
   * @return this.data - the data stored in node
   */
  public T getData() {
    return this.data;
  }
  
  /**
   * returns the node's data in the form of a string
   * 
   * @return data.toString() - the string form of data
   */
  public String toString() {
     return data.toString();
  }
  
  /**
   * sets next node to given node
   * 
   * @param next - node to be set as next
   */
  public void setNext(LinkedNode<T> next) {
    this.next = next;
  }
}
