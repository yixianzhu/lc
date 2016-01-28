import java.util.*;
class RemoveDuplicates
{

    public static void main(String args[])
    {
    Vector<String> v=new Vector<String>();
    v.add("Gowtham");
    v.add(" Gutha's");
    v.add(" Java");
    v.add("-");
    v.add("demos");
    v.add(".");
    v.add("blogspot");

    // '.' again!
    v.add(".");
    v.add("com ");

    // Gowtham again!
    v.add("gowtham");
        
    System.out.println("Original");

        for(int i=0;i<v.size();i++)
        {
            System.out.print(v.elementAt(i));

        }

    System.out.println("\nAfter removing duplicates");
    removeDuplicates(v);

        for(int i=0;i<v.size();i++)
        {
            System.out.print(v.elementAt(i));
        }
    
    }


    // Applicable for all types of vectors

    public static void removeDuplicates(Vector v)
    {
        for(int i=0;i<v.size();i++)
        {
            for(int j=0;j<v.size();j++)
            {
                    if(i!=j)
                    {
                        if(v.elementAt(i).equals(v.elementAt(j)))
                        {
                        v.removeElementAt(j);
                        }
                    }
            }
        }
    }


    /*
        * Specifically applicable for String is written for equalIgnoreCase
        * The code..
    

        public static void removeDuplicates(Vector<String> v)
        {
            for(int i=0;i<v.size();i++)
            {
                for(int j=0;j<v.size();j++)
                {
                    if(i!=j)
                    {
                        if(v.elementAt(i).equalsIgnoreCase(v.elementAt(j)))
                        {
                        v.removeElementAt(j);
                        }
                    }
            }
        }
    */

}
