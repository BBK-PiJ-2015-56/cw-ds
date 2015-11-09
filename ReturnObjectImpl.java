public class ReturnObjectImpl implements ReturnObject{
	private Object obj;
	private ErrorMessage errMessage;
	private ReturnObjectImpl next;
	
	public ReturnObjectImpl(ErrorMessage errMessage , Object obj){ 
		this.obj = obj;
		this.errMessage = errMessage;
		next =  null; 
	}
	
	//another constructor without args, for temp and current constructions
	public ReturnObjectImpl(){
		this.obj = null;
		this.errMessage = null;
		this.next = null;
	}
	
	public boolean hasError(){
		if (errMessage == null)
			return false;
		else
			return true;
	}
	public ErrorMessage getError(){
		ErrorMessage noErrorMessage = ErrorMessage.NO_ERROR;
		if (errMessage != null)
			return errMessage;
		else 
			return noErrorMessage;
	}
	
	public Object getReturnValue(){
		return obj;
	}
	
	public void setError(ErrorMessage message){
		this.errMessage = message;
	}
	
	
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
	
	
	// This method is for testing the pointer list for string objects
	public String listAsString(){
		String str = "" + obj;
		if (next == null){
			return str;
		}
		else{
			return str + next.listAsString();
			}
	}
	//This method is also for testing  the programme for String objects
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