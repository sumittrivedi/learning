import java.util.*;

public class LruCache {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}



//Do not edit the class below except for the insertKeyValuePair,
//getValueFromKey, and getMostRecentKey methods. Feel free
//to add new properties and methods to the class.
class Program {
static class LRUCache {
 int maxSize;
 LinkedList cache = null;
 int linkedListSize = 0;
 int insertRetriveCount = 0;

 public LRUCache(int maxSize) {
   this.maxSize = maxSize > 1 ? maxSize : 1;
 }

 public void insertKeyValuePair(String key, int value) {
   insertRetriveCount += 1;
   LinkedList node = new LinkedList();
   node.key = key;
   node.value = value;
   node.recentCallCount = insertRetriveCount;
   if (cache == null) {
     cache = node;
     linkedListSize = 1;
   }
   else if( linkedListSize < maxSize) {
     LinkedList temp = cache;
     while(temp.next != null) {
       temp = temp.next;
     }
     temp.next = node;
     linkedListSize += 1;
   }
   else {
     LinkedList temp = cache;
     while(temp != null) {
       if (getLeastRecentKey().equals(temp.key)) {
         temp.key = key;
         temp.value = vale;
         temp.recentCallCount = insertRetriveCount;
         return;
       }
       temp = temp.next;
     }
   }
 }

 public LRUResult getValueFromKey(String key) {
     LinkedList temp = cache;
     while(temp != null) {
       if (key.equals(temp.key)) {
         return new LRUResult(true, temp.value);
       }
       temp = temp.next;
     }
   return new LRUResult(false, null);
 }

 public String getMostRecentKey() {
   int tempLRU = -1;
   String mostRecentKey = null;
   LinkedList temp = cache;
     while(temp != null) {
       if (temp.recentCallCount > tempLRU) {
         tempLRU = temp.recentCallCount;
         mostRecentKey = temp.key;
       }
       temp = temp.next;
     }
   return mostRecentKey;
 }

 public String getLeastRecentKey() {
   int tempLRU = Integer.MAX_VALUE;
   String leastRecentKey = null;
   LinkedList temp = cache;
     while(temp != null) {
       if (temp.recentCallCount < tempLRU) {
         tempLRU = temp.recentCallCount;
         leastRecentKey = temp.key;
       }
       temp = temp.next;
     }
   return leastRecentKey;
 }
}

static class LRUResult {
 boolean found;
 int value;

 public LRUResult(boolean found, int value) {
   this.found = found;
   this.value = value;
 }
}

class LinkedList {
 public String key;
 public int value;
 public int recentCallCount;
 public LinkedList next = null;

 // public lastNode = null;
 
 // public LinkedList(String key, int value, LinkedList next) {
 //   LinkedList node = new LinkedList();
 //   node.key = key;
 //   node.value = value;
 //   node.next = null;
 //   this.next = next;
 }
}
}

