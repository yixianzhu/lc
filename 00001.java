
//++from char to int++
String element = "el5";
int x = Character.getNumericValue(element.charAt(2));
System.out.println("x=" + x);

//++from char to string++
//You can use 
Character.toString(char)//Note that this method simply returns a call to 
String.valueOf(char) // which also works.
//As others have noted, string concatenation works as a shortcut as well:
String s = "" + 's';

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
