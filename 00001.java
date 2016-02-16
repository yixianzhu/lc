//在等号左边！！右边写不写都可以
List<List<Integer>> result = new ArrayList<>();
List<Integer> subList = new LinkedList<Integer>();
//queue也是internface，不能被initialized
Queue<TreeNode> queue = new LinkedList<TreeNode>();

//binary search
public int binarySearch(int[] array,int lo,int hi){
    int n = array[hi];
    while(lo<hi){
        int mid = (lo+hi)/2;
        if(array[mid]==n) hi=mid;
        else lo=mid+1;
    }
    return lo;
}

//++from char to int++
String element = "el5";
int x = Character.getNumericValue(element.charAt(2));
System.out.println("x=" + x);

//++from char to string++
//You can use 
Character.toString(char)//Note that this method simply returns a call to 
//还有
Interger.toString(int)
String.valueOf(char) // which also works.
//As others have noted, string concatenation works as a shortcut as well:
String s = "" + 's';

//StringBuffer:
 return sb.toString();  

//++from string to integer++
int l = Integer.parseInt(s.substring(i, sharp));

///////comparison///////////
// These two have the same value
new String("test").equals("test") // --> true 

// ... but they are not the same object
new String("test") == "test" // --> false 

// ... neither are these
new String("test") == new String("test") // --> false 

// ... but these are because literals are interned by 
// the compiler and thus refer to the same object
"test" == "test" // --> true 

// checks for nulls and calls .equals()
Objects.equals("test", new String("test")) // --> true
Objects.equals(null, "test") // --> false


Integer.MIN_VALUE;
 
 

//method about length
//array:
array.length
//string:
string.length()
//linked list:
linkedlist.size()


//queue method priority queue也是这几个方法
//不能存null
       	Throws exception	Returns special value
Insert    	add(e)            	offer(e)
Remove	    remove()	          poll()
Examine     element()	          peek()

//stack method
boolean	   empty()
E   	   peek()
E   	   pop()
E   	   push(E item)//可以是null
int   	   search(Object o)

//tree
binary search tree != binary tree


//change (append) String 
String character = "a";
String otherString = "helen";
otherString=otherString+character;
System.out.println(otherString);

//String buffer 用法
 StringBuffer sb = new StringBuffer();//命名为sb



 /*Arrays.sort(int[]) in all Java standard library implementations 
 is an example of a comparison-based sort and thus must have worst-case complexity Ω(n log n). 
 In particular, Oracle Java 7 uses a dual-pivot quicksort variant for the integer overloads, 
 which actually has an Ω(n2) worst case.
 */
 Arrays.sort(A);//是Arrays!!
 Arrays.asList(list);
 
 //一些语句
 for(String str:dictionary)
 
 Character.isLetterOrDigit(charxx);
 Character.toLowerCase(charxx);
 HashSet.add(e);
 HashSet.isEmpty();//-->boolean
 HashSet.remove(object);
 HashSet.size();//-->int
 
 HashMap.containsKey(key);
 HashMap.get(key).equals(str);
 HashMap.put(key, value);
 
 
 Hashtable.containsKey(key);
 Hashtable.containsValue(value);
 Hashtable.get(key).equals(str);
 Hashtable.put(key, value);
 Hashtable.remove(key);
 Hashtable.isEmpty();//-->boolean
 Hashtable.size();//-->int
 

queue.isEmpty()

//arraylist 和 linkedlist的方法一样，只是时间复杂度不同--因为are two different implementations of the List interface
LinkedList.get(index);
LinkedList.add(queue.poll().val);
LinkedList.add(int index, E element);
LinkedList.remove(int index);

PriorityQueue.peek();
PriorityQueue.poll();
PriorityQueue.offer(e);
