
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


//method about length
//array:
array.length
//string:
string.length()
//linked list:
linkedlist.size()


//queue method
       	Throws exception	Returns special value
Insert    	add(e)            	offer(e)
Remove	    remove()	          poll()
Examine     element()	          peek()

//tree
binary search tree != binary tree


//change (append) String 
String character = "a";
String otherString = "helen";
otherString=otherString+character;
System.out.println(otherString);

//String buffer 用法
 StringBuffer sb = new StringBuffer();//命名为sb
 
 //List 不能initiated
 List<String> str = new ArrayList<>();//use ArrayList


 /*Arrays.sort(int[]) in all Java standard library implementations 
 is an example of a comparison-based sort and thus must have worst-case complexity Ω(n log n). 
 In particular, Oracle Java 7 uses a dual-pivot quicksort variant for the integer overloads, 
 which actually has an Ω(n2) worst case.
 */
 Arrays.sort(A);//是Arrays!!
