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
 * LinkedBookshelf tester class, tests methods in Linked Bookshelf and Node classes
 * 
 * @author Johnny Palumbo
 */
public class LinkedBookshelfTester {

  /**
   * tests LinkedNode class. Makes use of a constructor, accessor, and mutator
   * 
   * @return boolean bool - true if methods work as excepted, false otherwise
   */
  public static boolean testLinkedNode() {
    Book.resetGenerator();

    boolean bool = false;

    LinkedNode current = new LinkedNode(25);

    try {
      current.getNext().getData();
    } catch (NullPointerException ie) {
      bool = true;
    }

    current = new LinkedNode(70);
    current.setNext(new LinkedNode(50));
    try {
      if (current.getNext().getData() != (Integer) 50)
        return false;
    } catch (NullPointerException e) {
      return false;
    }
    return bool;
  }
  
  /**
   * tests clear() class. making sure it works properly
   * 
   * @return true if method works as excepted, false otherwise
   */
  public static boolean testClear() {
    { //test 1, basic test on clear function
      Book.resetGenerator();

      LinkedBookshelf shelf = new LinkedBookshelf();
      shelf.appendBook(new Book("Title1", 50, "Palumbo", "Johnny"));

      shelf.clear();
      
      try {
        if (!shelf.isEmpty() || shelf.getFirst() != null || shelf.getLast() != null)
          return false;
      } catch (NullPointerException e) {
        return true;
      }
      return false;
    }
  }

  /**
   * tests appendBook() class. making sure it works properly
   * 
   * @return true if method works as excepted, false otherwise
   */
  public static boolean testAddBooks() {
    try {
    { // test 1, testing appendBook with a simple case
      Book.resetGenerator();
      Book book1 = new Book("Title1", 50, "Palumbo", "Johnny");
      Book book2 = new Book("Title2", 75, "Person", "Basic");
      Book book3 = new Book("Title3", 100);
      LinkedBookshelf shelf = new LinkedBookshelf();

      shelf.appendBook(book1);

      Book expected = book1;
      Book actual = shelf.get(0);

      if (!actual.equals(expected)) {
        System.out.println("testAddBooks 1) Error, expected: " + expected + ", actual: " + actual);
        return false;
      }
    }

    { // test 2, testing appendBook on a second index
      Book.resetGenerator();
      Book book1 = new Book("Title1", 50, "Palumbo", "Johnny");
      Book book2 = new Book("Title2", 75, "Person", "Basic");
      Book book3 = new Book("Title3", 100);
      LinkedBookshelf shelf = new LinkedBookshelf();

      shelf.appendBook(book1);
      shelf.appendBook(book2);

      Book expected = book2;
      Book actual = shelf.get(1);

      if (!actual.equals(expected)) {
        System.out.println("testAddBooks 2) Error, expected: " + expected + ", actual: " + actual);
        return false;
      }
    }

   /* { // test 3, testing getNode of a second addition case
      Book.resetGenerator();
      Book book1 = new Book("Title1", 50, "Palumbo", "Johnny");
      Book book2 = new Book("Title2", 75, "Person", "Basic");
      Book book3 = new Book("Title3", 100);
      LinkedBookshelf shelf = new LinkedBookshelf();

      shelf.appendBook(book1);
      shelf.appendBook(book3);

      Book expected = book3;
      Book actual = shelf.getNode(1).getData();

      if (!actual.equals(expected)) {
        System.out.println("testAddBooks 3) Error, expected: " + expected + ", actual: " + actual);
        return false;
      }
    }

    { // test 4, testing getNode of a second addition case
      Book.resetGenerator();
      Book book1 = new Book("Title1", 50, "Palumbo", "Johnny");
      Book book2 = new Book("Title2", 75, "Person", "Basic");
      Book book3 = new Book("Title3", 100);
      LinkedBookshelf shelf = new LinkedBookshelf();

      shelf.appendBook(book1);
      shelf.appendBook(book3);

      Book expected = book3;
      Book actual = shelf.getNode(0).getNext().getData();

      if (!actual.equals(expected)) {
        System.out.println("testAddBooks 4) Error, expected: " + expected + ", actual: " + actual);
        return false;
      }
    }

    { // test 5, testing appendBook on a second index
      Book.resetGenerator();
      Book book1 = new Book("Title1", 50, "Palumbo", "Johnny");
      Book book2 = new Book("Title2", 75, "Person", "Basic");
      Book book3 = new Book("Title3", 100);
      LinkedBookshelf shelf = new LinkedBookshelf();

      shelf.appendBook(book1);
      shelf.appendBook(book2);
      shelf.appendBook(book3);

      Book expected = shelf.getNode(2).getData();
      Book actual = shelf.getLast();

      if (!actual.equals(expected)) {
        System.out.println("testAddBooks 5) Error, expected: " + expected + ", actual: " + actual);
        return false;
      }
    }
    
    { // test 6, testing size
      Book.resetGenerator();
      Book book1 = new Book("Title1", 50, "Palumbo", "Johnny");
      Book book2 = new Book("Title2", 75, "Person", "Basic");
      Book book3 = new Book("Title3", 100);
      LinkedBookshelf shelf = new LinkedBookshelf();

      shelf.appendBook(book1);
      shelf.appendBook(book2);
      shelf.appendBook(book3);

      int expected = 3;
      int actual = shelf.size();

      if (actual != expected) {
        System.out.println("testAddBooks 6) Error, expected: " + expected + ", actual: " + actual);
        return false;
      }
    }*/
    } catch (IndexOutOfBoundsException e) {}
    
    {
      Book.resetGenerator();
      
      LinkedBookshelf shelf = new LinkedBookshelf();
      int priorVal = shelf.size();
      shelf.appendBook(new Book("title", 30, "jon", "p"));
      shelf.appendBook(new Book("title", 30, "jon", "p"));
      
      String result = "ID\n" + shelf.toString();
      if (shelf.size() - priorVal == 2) {
        return true;
      }
      else return false;
    }
    

  }

  /**
   * tests sort() class. making sure it works properly
   * 
   * @return true if method works as excepted, false otherwise
   */
  public static boolean testSortBooks() {
    { // test 1, testing sort by ID
      Book.resetGenerator();
      Book book1 = new Book("Good Omens", 288, "Gaiman", "Neil");
      Book book2 = new Book("FEED", 608, "Grant", "Mira");
      Book book3 = new Book("Snow Crash", 468, "Stephenson", "Neal");
      Book book4 = new Book("2001", 296, "Clarke", "Arthur C");

      LinkedBookshelf shelf = new LinkedBookshelf();

      shelf.appendBook(book4);
      shelf.appendBook(book3);
      shelf.appendBook(book2);
      shelf.appendBook(book1);


      String expected = "ID\n0: \"Good Omens\", Gaiman, Neil (288)\n"
          + "1: \"FEED\", Grant, Mira (608)\n" + "2: \"Snow Crash\", Stephenson, Neal (468)\n"
          + "3: \"2001\", Clarke, Arthur C (296)\n";
      LinkedBookshelf.sort(shelf, Attribute.ID);
      String actual = shelf.toString();

      if (!actual.equals(expected)) {
        System.out.println("testSortBooks 1) Error, expected: " + expected + ", actual: " + actual);
        return false;
      }

    }

    { // test 2, testing sort by page count
      Book.resetGenerator();
      Book book1 = new Book("Good Omens", 288, "Gaiman", "Neil");
      Book book2 = new Book("FEED", 608, "Grant", "Mira");
      Book book3 = new Book("Snow Crash", 468, "Stephenson", "Neal");
      Book book4 = new Book("2001", 296, "Clarke", "Arthur C");

      LinkedBookshelf shelf = new LinkedBookshelf();

      shelf.appendBook(book4);
      shelf.appendBook(book3);
      shelf.appendBook(book2);
      shelf.appendBook(book1);


      String expected = "PAGECOUNT\n0: \"Good Omens\", Gaiman, Neil (288)\n"
          + "3: \"2001\", Clarke, Arthur C (296)\n" + "2: \"Snow Crash\", Stephenson, Neal (468)\n"
          + "1: \"FEED\", Grant, Mira (608)\n";
      LinkedBookshelf.sort(shelf, Attribute.PAGECOUNT);
      String actual = shelf.toString();

      if (!actual.equals(expected)) {
        System.out.println("testSortBooks 2) Error, expected: " + expected + ", actual: " + actual);
        return false;
      }

    }

    { // test 3, testing sort by author
      Book.resetGenerator();
      Book book1 = new Book("Good Omens", 288, "Gaiman", "Neil");
      Book book2 = new Book("FEED", 608, "Grant", "Mira");
      Book book3 = new Book("Snow Crash", 468, "Stephenson", "Neal");
      Book book4 = new Book("2001", 296, "Clarke", "Arthur C");

      LinkedBookshelf shelf = new LinkedBookshelf();

      shelf.appendBook(book4);
      shelf.appendBook(book3);
      shelf.appendBook(book2);
      shelf.appendBook(book1);


      String expected = "AUTHOR\n3: \"2001\", Clarke, Arthur C (296)\n"
          + "0: \"Good Omens\", Gaiman, Neil (288)\n" + "1: \"FEED\", Grant, Mira (608)\n"
          + "2: \"Snow Crash\", Stephenson, Neal (468)\n";
      LinkedBookshelf.sort(shelf, Attribute.AUTHOR);
      String actual = shelf.toString();

      if (!actual.equals(expected)) {
        System.out.println("testSortBooks 3) Error, expected: " + expected + ", actual: " + actual);
        return false;
      }

    }

    { // test 4, testing sort by title
      Book.resetGenerator();
      Book book1 = new Book("Good Omens", 288, "Gaiman", "Neil");
      Book book2 = new Book("FEED", 608, "Grant", "Mira");
      Book book3 = new Book("Snow Crash", 468, "Stephenson", "Neal");
      Book book4 = new Book("2001", 296, "Clarke", "Arthur C");

      LinkedBookshelf shelf = new LinkedBookshelf();

      shelf.appendBook(book4);
      shelf.appendBook(book3);
      shelf.appendBook(book2);
      shelf.appendBook(book1);


      String expected = "TITLE\n3: \"2001\", Clarke, Arthur C (296)\n"
          + "1: \"FEED\", Grant, Mira (608)\n" + "0: \"Good Omens\", Gaiman, Neil (288)\n"
          + "2: \"Snow Crash\", Stephenson, Neal (468)\n";
      LinkedBookshelf.sort(shelf, Attribute.TITLE);
      String actual = shelf.toString();

      if (!actual.equals(expected)) {
        System.out.println("testSortBooks 4) Error, expected: " + expected + ", actual: " + actual);
        return false;
      }
    }
    return true;
  }

  /**
   * runs all the tests, returning true if all pass
   * 
   * @return true if method works as excepted, false otherwise
   */
  public static boolean runAllTests() {

    if (!testLinkedNode()) {
      return false;
    } else if (!testClear()) {
      return false;
    } else if (!testAddBooks()) {
      return false;
    } else if (!testSortBooks()) {
      return false;
    } else
      System.out.println("All tests passed");
    return true;
  }

  /**
   * main method calls runAllTests() class
   * 
   * @param args unused
   */
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    runAllTests();
  }

}
