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
 * LinkedBookshelf class adds books to bookshelf using nodes
 * 
 * @author Johnny Palumbo
 */
public class LinkedBookshelf {

  private LinkedNode<Book> front;
  private LinkedNode<Book> back;
  private int size;
  private Attribute sortedBy;

  /**
   * Constructor that sets sortedBy to default ID attribute
   * 
   */
  public LinkedBookshelf() {
    sortedBy = Attribute.ID;
  }

  /**
   * method that returns size of the shelf
   * 
   * @return int size - number of nodes in LinkedBookshelf
   */
  public int size() {

    return this.size;
  }

  /**
   * method that checks that the bookshelf is empty
   * 
   * @return boolean true if empty, false if otherwise
   */
  public boolean isEmpty() {
    return (size == 0);
  }

  /**
   * gets book from each node and prints it in order
   * 
   * @return String str - the completed string of books
   */
  public String toString() {
    String str = "\n";
    LinkedNode<Book> current = front;

    while (current != null) {
      str += current.toString() + "\n";
      current = current.getNext();
    }

    return sortedBy + str;
  }

  /**
   * gets node from shelf at specific index
   * 
   * @param int index - index of node
   * @return LinkedNode<Book> current - node at given index of linked bookshelf
   * @throws IndexOutOfBoundsException if index is less than 0 or greater than size-1
   */
  public LinkedNode<Book> getNode(int index) throws IndexOutOfBoundsException {
    if (index >= size || index < 0)
      throw new IndexOutOfBoundsException("index out of range");

    LinkedNode<Book> current = front;
    int count = 0;

    while (count != index) {
      count++;
      current = current.getNext(); // move the current reference forward
    }

    return current;
  }

  /**
   * gets book from node at specific index, uses getNode()
   * 
   * @param int index - index of data
   * @return getNode(index).getData() at specific node
   * @throws IndexOutOfBoundsException if index is less than 0 or greater than size-1
   */
  public Book get(int index) throws IndexOutOfBoundsException {
    if (index >= size || index < 0)
      throw new IndexOutOfBoundsException("index out of range");

    return getNode(index).getData();

  }

  /**
   * returns front of shelf
   * 
   * @return front.getData() the front of shelf
   */
  public Book getFirst() {

    return front.getData();
  }

  /**
   * returns back of shelf
   * 
   * @return back.getData() the front of shelf
   */
  public Book getLast() {

    return back.getData();
  }

  /**
   * clears the shelf
   * 
   * 
   */
  public void clear() {
    front = null;
    back = null;
    size = 0;
  }

  /**
   * adds book to new Node in shelf
   * 
   * @param toAdd the book added to shelf
   */
  public void appendBook(Book toAdd) {
    LinkedNode<Book> newBook = new LinkedNode<Book>(toAdd);

    if (isEmpty()) {
      front = newBook;
      back = newBook;
    } else {
      back.setNext(newBook);
      back = newBook;
    }
    size++;
  }

  /**
   * adds book to new Node in shelf, although it will search the current shelf and place in the
   * correct spot according to order
   * 
   * @param toAdd the book added to shelf
   */
  public void insertBook(Book toAdd) {
    LinkedNode<Book> newNode = new LinkedNode<Book>(toAdd);
    LinkedNode<Book> sortedCurrent = front;
    int index = 0;
    boolean done = false;

    switch (sortedBy) {
      case ID:
        while (done == false) {
          if (newNode == null) {
            this.appendBook(toAdd);
          }
          if (newNode.getData().ID == sortedCurrent.getData().ID) {
            System.out.print("Error: duplicate ID found");
            break;
          }
          if (newNode.getData().ID < sortedCurrent.getData().ID) {
            if (index == 0) {
              front = newNode;
            } else {
              this.getNode(index - 1).setNext(newNode);
            }
            newNode.setNext(sortedCurrent);
            size++;
            done = true;
          }
          if (newNode.getData().ID > sortedCurrent.getData().ID) {
            index++;
            sortedCurrent = sortedCurrent.getNext();
          }
        }
        break;

      case PAGECOUNT:
        while (done == false) {
          try {
            if (sortedCurrent.getData() == null)
              ;
          } catch (NullPointerException e) {
            this.appendBook(toAdd);
            break;
          }

          if (newNode.getData().getPageCount() < sortedCurrent.getData().getPageCount()) {
            if (index == 0) {
              front = newNode;
            } else {
              this.getNode(index - 1).setNext(newNode);
            }
            newNode.setNext(sortedCurrent);
            size++;
            done = true;
          }
          if (newNode.getData().getPageCount() > sortedCurrent.getData().getPageCount()
              || newNode.getData().getPageCount() == sortedCurrent.getData().getPageCount()) {
            index++;
            sortedCurrent = sortedCurrent.getNext();
          }
        }
        break;

      case AUTHOR:
        while (done == false) {

          try {
            if (sortedCurrent.getData() == null)
              ;
          } catch (NullPointerException e) {
            this.appendBook(toAdd);
            break;
          }


          if (newNode.getData().getAuthor().compareTo(sortedCurrent.getData().getAuthor()) < 0) {
            if (index == 0) {
              front = newNode;
            } else {
              this.getNode(index - 1).setNext(newNode);
            }
            newNode.setNext(sortedCurrent);
            size++;
            done = true;
          }
          if (newNode.getData().getAuthor().compareTo(sortedCurrent.getData().getAuthor()) > 0
              || newNode.getData().getAuthor()
                  .compareTo(sortedCurrent.getData().getAuthor()) == 0) {
            index++;
            sortedCurrent = sortedCurrent.getNext();
          }
        }
        break;

      case TITLE:
        while (done == false) {

          try {
            if (sortedCurrent.getData() == null)
              ;
          } catch (NullPointerException e) {
            this.appendBook(toAdd);
            break;
          }

          if (newNode.getData().getTitle().compareTo(sortedCurrent.getData().getTitle()) < 0) {
            if (index == 0) {
              front = newNode;
            } else {
              this.getNode(index - 1).setNext(newNode);
            }
            newNode.setNext(sortedCurrent);
            size++;
            done = true;
          }
          if (newNode.getData().getTitle().compareTo(sortedCurrent.getData().getTitle()) > 0
              || newNode.getData().getTitle().compareTo(sortedCurrent.getData().getTitle()) == 0) {
            index++;
            sortedCurrent = sortedCurrent.getNext();
          }
        }
        break;
    }
  }

  /**
   * sorts books in shelf based on Attribute
   * 
   * @param LinkedBookshelf b - linked bookshelf to sort
   * @param Attribute sortedBy - attribute in which to sort bookshelf by
   */
  public static void sort(LinkedBookshelf b, Attribute sortedBy) {
    if (b.size() < 2)
      return;

    LinkedBookshelf sorted = new LinkedBookshelf();
    sorted.appendBook(b.get(0));
    sorted.sortedBy = sortedBy;
    b.sortedBy = sortedBy;


    for (int i = 1; i < b.size(); i++) {
      // System.out.println("Sorted: \n" + sorted.toString() + "\nAdding: " + b.get(i).toString());
      sorted.insertBook(b.get(i));
    }

    b.front = sorted.front;
    b.back = sorted.back;
  }

}
