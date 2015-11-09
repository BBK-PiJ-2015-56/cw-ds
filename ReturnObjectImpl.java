public class ReturnObjectImpl implements ReturnObject{
	private Object obj;
	private ErrorMessage errMessage;
	private ReturnObjectImpl next;
	
	public ReturnObjectImpl(ErrorMessage errMessage , Object obj){ // should impl be here??
		this.obj = obj;
		this.errMessage = errMessage;
		next =  null; // we cant initialise here as it would go on forever
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
	
	// note that a return Object can have a null obj and a null error!!!
	public Object getReturnValue(){
		return obj;
	}
	
	public void setError(ErrorMessage message){
		this.errMessage = message;
	}
	
	
	//Q) how will these insert methods be accessed 
	//when we have declared them as returnobjects not returnobjectimpl's?
	// may have to declare them as returnobjimpl's but 
	//still return value may be ok as returnobjects??
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
	
	
	// recursively add return value onto string
	public String listAsString(){
		String str = "";
		str += this.getReturnValue;
		if(this.getNext() != null){
			str += this.getNext().listAsString();
		}
		return str;
	}
			
		
		
		
		
		
	}
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
		// do I need this for reporting?? No. Just make sure erro is set when ReturnObject is returned or value is set if approprate.
		//Q) when do I need to use either getValue or getError????
	}
	
	
}