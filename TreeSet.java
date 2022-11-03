package com.epam.learning;
import java.util.*;

class TreeSet {
  public static void main(String args[]) {
      Set<Laptop> treeSet = new java.util.TreeSet<>();
//      treeSet.add(4);
//      treeSet.add(12);
//      treeSet.add(3);
//      treeSet.add(18);
      treeSet.add(new Laptop(12300, "Intel", "8GB"));
      treeSet.add(new Laptop(1872300, "AMD", "2GB"));
      treeSet.add(new Laptop(123200, "Intel", "16GB"));
      treeSet.add(new Laptop(1845300, "AMD", "4GB"));
      treeSet.forEach(x -> System.out.println(x.getPrice()));
//      treeSet.forEach(x -> System.out.println(x));

  }
}
