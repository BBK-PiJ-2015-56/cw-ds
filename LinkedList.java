/**
* implementation of list using pointers
*/
public class LinkedList implements List{
	
	private ReturnObjectImpl head;
	
	/**
	* constructor sets the head to null
	*/
	public LinkedList(){   
		head = null; 
	}
	
	/**
	 * Returns true if the list is empty, false otherwise. 
	 * 
	 * @return true if the list is empty, false otherwise. 
	 */
	public boolean isEmpty(){
		if (head == null)
			return true;
		else
			return false;
		}
		
	/**
	 * Returns the number of items currently in the list.
	 * 
	 * @return the number of items currently in the list
	 */	
	public int size(){
		int count = 0;
		ReturnObjectImpl current = head; 
		while (current != null){ 
			count++;
			current = current.getNext();
		}
		return count;
	}
	
	/**
	 * Returns the element at the given position. 
	 * 
	 * If the index is negative or greater or equal than the size of
	 * the list, then an appropriate error must be returned.
	 * 
	 * @param index the position in the list of the item to be retrieved
	 * @return the element or an appropriate error message, 
	 *         encapsulated in a ReturnObject
	 */
	public ReturnObject get(int index){
		ReturnObjectImpl current = head;
		int count = 0; 
		while(count < index){
			count++;
			current = current.getNext();
		}
		return current;
	}
	
	/**
	 * Returns the elements at the given position and removes it
	 * from the list. The indeces of elements after the removed
	 * element must be updated accordignly.
	 * 
	 * If the index is negative or greater or equal than the size of
	 * the list, then an appropriate error must be returned.
	 * 
	 * @param index the position in the list of the item to be retrieved
	 * @return the element or an appropriate error message, 
	 *         encapsulated in a ReturnObject
	 */
	public ReturnObject remove(int index){
		if((index < 0) || (index > size())){
				return new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS , null);
		}
		else{
			ReturnObjectImpl current = new ReturnObjectImpl();
			current = head;
			int count = 0;    
			while(count < (index-1)){
				count++;
				current = current.getNext();
				}
			ReturnObjectImpl temp = new ReturnObjectImpl();
			temp = current.getNext();
			current.setNext(current.getNext().getNext());
			return temp;
		}			
	}
	
	/**
	 * Adds an element to the list, inserting it at the given
	 * position. The indeces of elements at and after that position
	 * must be updated accordignly.
	 * 
	 * If the index is negative or greater or equal than the size of
	 * the list, then an appropriate error must be returned.
	 * 
	 * If a null object is provided to insert in the list, the
	 * request must be ignored and an appropriate error must be
	 * returned.
	 * 
	 * @param index the position at which the item should be inserted in
	 *              the list
	 * @param item the value to insert into the list
	 * @return an ReturnObject, empty if the operation is successful
	 *         or containing an appropriate error message otherwise
	 */
	// There is a problem with head.insert(). It seems to create a list of ReturnObjects where next is never null. 
	public ReturnObject add(int index, Object item){
		if(item == null){
			return new ReturnObjectImpl(ErrorMessage.INVALID_ARGUMENT , null);
		}
		else {
			if((index < 0) || (index > size())){
				return new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS , null);
				}
				else{
					ReturnObjectImpl objToAdd = new ReturnObjectImpl(ErrorMessage.NO_ERROR , item);
					if(index == 0){
						ReturnObjectImpl temp = new ReturnObjectImpl();
						temp = head;
						head = objToAdd;
						objToAdd.setNext(temp);
					}
					else{
						head.insert(objToAdd , index);
					}
					return new ReturnObjectImpl(ErrorMessage.NO_ERROR , null);
			}
			
		}
	}
	
	/**
	 * Adds an element at the end of the list.
	 * 
	 * If a null object is provided to insert in the list, the
	 * request must be ignored and an appropriate error must be
	 * returned.
	 * 
	 * @param item the value to insert into the list
	 * @return an ReturnObject, empty if the operation is successful
	 *         or containing an appropriate error message otherwise
	 */
	public ReturnObject add(Object item){ 
		if(item == null){
			return new ReturnObjectImpl(ErrorMessage.INVALID_ARGUMENT , null);
		}
		else {	
			ReturnObjectImpl objToAdd = new ReturnObjectImpl(ErrorMessage.NO_ERROR , item);
			if(head == null){
				head = objToAdd;
				}
				else{
					head.insert(objToAdd);
					}
			return new ReturnObjectImpl(ErrorMessage.NO_ERROR , null);
		}
	}
	
	/**
	* This is for testing of the list. It returns all of the elements.
	*/
	public String toString(){
		if (head == null){
			return "The list is empty";
			}
			else{
				return "Here are the elements: " + head.listAsString();
				}
	}
	/*public String toString(){
		String str = "";
		if (head == null){
			str += "The list is empty";
			return str;
		}
		else{
			ReturnObjectImpl temp = new ReturnObjectImpl();
			temp = head;
			str += "Here are the elements: [ " + temp.getReturnValue() + " ,";
			while (temp.getNext() != null){
				temp = temp.getNext();
				str += temp.getReturnValue() + " ,";
			}
		str += " ]";
		return str;
		}
	}*/
}