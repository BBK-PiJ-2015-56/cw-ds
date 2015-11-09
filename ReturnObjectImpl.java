/**
 * A wrapper containing either an object (the result of an operation
 * on a data structure) or an error value.
 */
public class ReturnObjectImpl implements ReturnObject{
	
	private Object obj;
	private ErrorMessage errMessage;
	private ReturnObjectImpl next;
	
	/**
	*constructor method takes a given error message and object
	*
	*@param errMessage    one of four static variables of enum ErrorMessage
	*@param obj           a given Object to be assigned to this.obj
	*/
	public ReturnObjectImpl(ErrorMessage errMessage , Object obj){ 
		this.obj = obj;
		this.errMessage = errMessage;
		next =  null; 
	}
	
	/**
	*another constructor without args, for temp constructions
	*/
	public ReturnObjectImpl(){
		this.obj = null;
		this.errMessage = null;
		this.next = null;
	}
	 
	 /**
	 * Returns whether there has been an error
	 * @return whether there has been an error
	 */
	public boolean hasError(){
		if (errMessage == null)
			return false;
		else
			return true;
	}
	
	/**
	 * Returns the error message. 
	 * 
	 * This method must return NO_ERROR if and only if
	 * {@hasError} returns false.
	 * 
	 * @return the error message
	 */
	public ErrorMessage getError(){
		ErrorMessage noErrorMessage = ErrorMessage.NO_ERROR;
		if (errMessage != null)
			return errMessage;
		else 
			return noErrorMessage;
	}
	
	/**
	 * Returns the object wrapped in this ReturnObject, i.e. the
	 * result of the operation if it was successful, or null if
	 * there has been an error.
	 * 
	 * Note that the output of this method must be null if {@see
	 * hasError} returns true, but the opposite is not true: if
	 * {@see hasError} returns false, this method may or may not
	 * return null.
	 * 
	 * @return the return value from the method or null if there has been an error
	 */
	public Object getReturnValue(){
		return obj;
	}
	
	/**
	* Sets errMessage to a particular value
	*
	*@param message    the required value for errMessage
	*/
	public void setError(ErrorMessage message){
		this.errMessage = message;
	}
	
	/**
	*inserts a ReturnObjectImpl into a given position of the list
	*
	*@param objToInsert    the object to be inserted
	*@param index          the position at which to insert objToInsert
	*/
	public void insert(ReturnObjectImpl objToInsert , int index){
		int count = 0;
		ReturnObjectImpl current = new ReturnObjectImpl();
		current = this;
		while(count < index){
			count++;
			current = current.getNext();
		}
		ReturnObjectImpl temp = new ReturnObjectImpl();
		temp = current;
		current.setNext(objToInsert);
		objToInsert.setNext(temp.getNext());
	}
	
	/**
	*inserts a ReturnObjectImpl at the end of the list
	*
	*@param objToInsert    the object to be inserted
	*/
	public void insert(ReturnObjectImpl objToInsert){
		if(this.next == null){
			this.next = objToInsert;
		}
		else{
			this.next.insert(objToInsert);
		}
	}
	public ReturnObjectImpl getNext(){
		return next;
	}
	public void setNext(ReturnObjectImpl returnObj){
		next = returnObj;
	}
	
	/**
	*This method is for initial testing of the pointer list for string objects
	*/
	public String listAsString(){
		String str = "" + obj;
		if (next == null){
			return str;
		}
		else{
			return str + next.listAsString();
			}
	}
	/**
	*This method is also for initial testing of the programme for String objects
	*/
	public String toString(){
		String str = "[ value: "+ this.getReturnValue();
		switch (errMessage){
			case EMPTY_STRUCTURE:
				str += "    Error: Empty structure.";
			case INDEX_OUT_OF_BOUNDS:
				str += "    Error: Index out of bounds.";
			case INVALID_ARGUMENT:
				str += "    Error: Invalid argument error.";
			default:
				str += "    No Error.";
		}
		str += "] ";
		return str;
	}
	
	
}