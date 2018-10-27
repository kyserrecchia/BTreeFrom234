//Name: Kyle Serrecchia
//Date: 25 Oct 2018
//Info: Turning a 234 Tree into a B-Tree 
//(og tree from 2nd edition Data Structures and Algorithms in Java textbook)

package tree234app;

public class DataItem
 
{
    
   String record;
   public long dData;          // one data item 
 
//--------------------------------------------------------------
 
   public DataItem(long dd)    // constructor
 
      { dData = dd; }
 
//--------------------------------------------------------------
 
   public void displayItem()   // display item, format "/27"
 
      { System.out.print("/"+dData); }
 
//--------------------------------------------------------------
 
   public String getRecord()    // constructor
 
      { return record; }
   
//--------------------------------------------------------------
 
   public void setRecord(String rec)    // constructor
 
      { record = rec; }
   
//--------------------------------------------------------------
   
}  // end class DataItem
 