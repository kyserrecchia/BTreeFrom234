/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tree234app;
 
public class BTree extends Tree234 {
    
    
    // insert a DataItem

   public void insert(String rec)
 
      {
      int dVal = 0;
      long dValue;
      String[] arrayRecord = rec.split(",");
      dVal = Integer.parseInt(arrayRecord[0]);
      dValue = dVal;
 
      Node curNode = root;
 
      DataItem tempItem = new DataItem(dValue);
      tempItem.setRecord(rec);

 
      while(true)
 
         {
 
         if( curNode.isFull() )               // if node full,
 
            {
 
            split(curNode);                   // split it
 
            curNode = curNode.getParent();    // back up
 
                                              // search once
 
            curNode = getNextChild(curNode, dValue);
 
            }  // end if(node is full)
 

 
         else if( curNode.isLeaf() )          // if node is leaf,
 
            break;                            // go insert
 
         // node is not full, not a leaf; so go to lower level
 
         else
 
            curNode = getNextChild(curNode, dValue);
 
         }  // end while
 

 
      curNode.insertItem(tempItem);       // insert new DataItem
 
      }  // end insert()
   
   
/////////////////////////////////////////////////////////
    
    @Override
    public void split(Node thisNode)     // split the node
 
      {
 
      // assumes node is full
      // this is how many need to be removed and dumped into the new node
      int numberOfItemsToRemove = (Node.getOrder() - 2)/2;
      
      // this is an array to hold those items (instead of just itemC)
      DataItem[] removedItems = new DataItem[numberOfItemsToRemove];
      
      // this is the middle item (used to be itemB)
      DataItem middleItem;
 
      // remove items
      for(int i = numberOfItemsToRemove-1; i>=0; i--){
        removedItems[i] = thisNode.removeItem();   
      }
      
      // take next item after all those removed, which is the middle item
      middleItem = thisNode.removeItem();   
      
      // then remove children
      Node parent;
      // child nodes to be removed
      Node[] children = new Node[numberOfItemsToRemove + 1];
 
      int itemIndex;
      
      // unload from the node backward into the children array
      for(int i = Node.getOrder()-2; i>Node.getOrder()/2 -1; i--){
          children[i-Node.getOrder()/2] = thisNode.disconnectChild(i);
      }
 
      Node newRight = new Node();       // make new node

 
      if(thisNode==root)                // if this is the root,
 
         {
 
         root = new Node();                // make new root
 
         parent = root;                    // root is our parent
 
         root.connectChild(0, thisNode);   // connect to parent
 
         }
 
      else                              // this node not the root
 
         parent = thisNode.getParent();    // get parent
 

 
      // deal with parent
 
      itemIndex = parent.insertItem(middleItem); // middle item to parent
 
      int n = parent.getNumItems();         // total items?
 
 
      for(int j=n-1; j>itemIndex; j--)          // move parent's
 
         {                                      // connections
 
         Node temp = parent.disconnectChild(j); // one child
 
         parent.connectChild(j+1, temp);        // to the right
 
         }
 
                                   // connect newRight to parent
 
      parent.connectChild(itemIndex+1, newRight);
 
      // instead of inserting just itemC, insert ALL removed items except middle item
      for(int i = 0; i<numberOfItemsToRemove; i++){
          newRight.insertItem(removedItems[i]);
      }
      
      // this is for knowing where to dump the children into as new children in the right node
      // they must be offset by the right amount
      int subtractOffset = (Node.getOrder() + 1)/2;
      
      for(int i = Node.getOrder()-2; i>numberOfItemsToRemove + 1; i--){
          newRight.connectChild(i-subtractOffset, children[i-Node.getOrder()/2]);
      }
      
    }  // end split()
 
    
}