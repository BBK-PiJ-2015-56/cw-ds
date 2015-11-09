/** 
*An implementation of Functional List by extending LinkedList
*/

public class FunctionalLinkedList extends LinkedList{
	
	/**
     * Returns the element at the beginning of the list. 
     * 
     * If the list is empty, an appropriate error is returned. 
     *
     * @return a copy of the element at the beginning of the list or 
     *         an error if the list is empty.
     */
	public ReturnObject head(){
		if(head == null){
			return new ReturnObject(ErrorMessage.EMPTY_STRUCTURE , null);
			}
			else{
				return head;
				}
	}
	
	/**
     * Returns a list with the elements in this list except the
     * head. The elements must be in the same order. The original list
     * must not change or be affected by changes in the new list. 
     * 
     * If the list is empty, another empty list is returned. 
     */
	public FunctionalList rest{
		if(head == null)
			return this;
		}
		else{
			// not finished
			return 
			}
}