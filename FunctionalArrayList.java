/** 
*An implementation of Functional List by extending LinkedList
*/
public class functionalList extends ArrayList{
	
	/**
     * Returns the element at the beginning of the list. 
     * 
     * If the list is empty, an appropriate error is returned. 
     *
     * @return a copy of the element at the beginning of the list or 
     *         an error if the list is empty.
     */
	public ReturnObject head(){
		if(objArray[0] == null){
			return new ReturnObject(ErrorMessage.EMPTY_STRUCTURE , null);
			}
			else{
				return objarray[0];
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
		if (size == 0){
			return this;
		}
		else{
			// not finished
		}
	}


}