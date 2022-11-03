import java.util.*;

class Graph {
  // Do not edit the class below except
  // for the depthFirstSearch method.
  // Feel free to add new properties
  // and methods to the class.
  static class Node {
    String name;
    List<Node> children = new ArrayList<Node>();

    public Node(String name) {
      this.name = name;
    }

    public List<String> depthFirstSearch(List<String> array) {
      return printDepthFirst(this, array);
    }
    
    private List<String> printDepthFirst(Node node, List<String> array) {
    	if(node == null)
    		return array;
    	array.add(node.name);
    	node.children.forEach(x -> printDepthFirst(x, array));
    	return array;
    }

    public List<String> breadthFirstSearch(List<String> array) {
        return printBreadthFirst(this, array);
      }
  		
  		private List<String> printBreadthFirst(Node node, List<String> array) {
        if(node == null) 
        	return array;
  		node.children.forEach(x -> array.add(x.name));
  		node.children.forEach(x -> printBreadthFirst(x, array));
        return array;
      }

    public Node addChild(String name) {
      Node child = new Node(name);
      children.add(child);
      return this;
    }
  }
}
