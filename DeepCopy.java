/**
 *  Author: Stuart Spiegel
 * ********************************************************************************
 *  Question: Perform a deep copy of a linked list in which each node in the list
 *  has a reference to a random other node.
 * ********************************************************************************
 */
public class Solution
{
    public ALNode deepCopy(ALNode head)
    {
       ALNode node = head;
       //clone every node on first traversal
       while(node!= null){
           ALNode copy = new ALNode(node.value);
           copy.next = node.next;
           node.next = copy;
           node = copy.next;
       }
       
       //list = node - 1 
       //second traversal 
       
       node = head;
       //assign the nodes to arbitrary pointers of nodes already Cloned 
       
       //2nd traversal 
       while(node!= null){
           ALNode copy = node.next;
           
           if(node.arbitrary!= null){
               copy.arbitrary = node.arbitrary.next;
           }
           node = copy.next; //iterate 
       }
       
       node = head; //reference the top of the list 
       
      ALNode cloneTemp = new ALNode(0);
      ALNode cloned = cloneTemp;
      
      //third traversal, split clones from the list 
      while(node != null){
          cloned.next = node.next;
          node.next = node.next.next;
          node = node.next;
          cloned = cloned.next;
      }
       
       return cloneTemp.next;
       
    }
    // METHOD SIGNATURE ENDS
}