/**
* An implementation of List using an Array
*/
public class ArrayList implements List{
	
	private ReturnObjectImpl[] objArray;
	
	private static int INITIAL_ARRAY_SIZE = 8;
	
	/** 
	* constructor creates an empty array of size 8
	*/
	public ArrayList(){
		objArray = new ReturnObjectImpl[INITIAL_ARRAY_SIZE];
	}
	
	/**
	 * Returns true if the list is empty, false otherwise. 
	 * 
	 * @return true if the list is empty, false otherwise. 
	 */
	public boolean isEmpty(){
		if (size() == 0) {
			return true;
			} 
			else {
				return false;
				}
	}
	
	/**
	 * Returns the number of items currently in the list.
	 * 
	 * @return the number of items currently in the list
	 */
	public int size(){
		int count = 0;
		while(objArray[count] != null){
			count++;
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
		if((index < 0) || (index > size())){
				return new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS , null);
		}
		else {
			return objArray[index];
			}
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
			ReturnObjectImpl temp = new ReturnObjectImpl();
			temp = objArray[index];
			for(int i = index; i < size(); i++){
				objArray[i] = objArray[i+1];
				}
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
	public ReturnObject add(int index, Object item){
		if(item == null){
			return new ReturnObjectImpl(ErrorMessage.INVALID_ARGUMENT , null);
		}
		else {
			if (isAlmostFull()){
				increaseArrayLength();
			}
			int count = 0;
			ReturnObjectImpl objToAdd = new ReturnObjectImpl(ErrorMessage.NO_ERROR , item);
			while(count < index){
				count++;
			}
			for( int i = size() ; i >= count ; i--){
				objArray[i+1] = objArray[i];
			}
			objArray[count] = objToAdd;
			return new ReturnObjectImpl(ErrorMessage.NO_ERROR , null);
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
			if (isAlmostFull()){
				increaseArrayLength();
			}
			ReturnObjectImpl objToAdd = new ReturnObjectImpl(ErrorMessage.NO_ERROR , item);
			objArray[size()] = objToAdd;
			return new ReturnObjectImpl(ErrorMessage.NO_ERROR , null);
			}
	}
	
	/**
	* checks if the array is almost full
	*
	* @return    true if array only has one or less empty space(s), false otherwise
	*/
	private boolean isAlmostFull() {
		if (objArray.length - size() < 1) {
			return true;
		}
		else {
		    return false;	
		}
	}
	
	/**
	* creates a new array double the size of objArray, copies the existing elements into
	* the corresponding positions of the new array, 
	* then replaces the old objArray with the new array
	*/
	private void increaseArrayLength() {
		int currentLength = objArray.length;
		ReturnObjectImpl[]  biggerobjArray = new ReturnObjectImpl[currentLength * 2];
		for (int i = 0; i < size() ; i++) {
			biggerobjArray[i] = this.objArray[i];
		}
		this.objArray = biggerobjArray;
	}
	
	/**
	* This is for testing of the list. It returns all of the elements.
	*/
	public String toString(){
		String str = "Here are the elements: ";
		for(int i = 0; i < size(); i++){
			str+= objArray[i].getReturnValue() + " ,";
		}
		return str;
	} 
		
}