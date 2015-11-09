public class PointerList implements List{
	
	private ReturnObjectImpl head;
	
	public PointerList(){   
		head = null; 
	}
	
	public boolean isEmpty(){
		if (head == null)
			return true;
		else
			return false;
		}
		
	public int size(){
		int count = 0;
		ReturnObjectImpl current = head; 
		while (current != null){ 
			count++;
			current = current.getNext();
		}
		return count;
	}
	
	public ReturnObject get(int index){
		ReturnObjectImpl current = head;
		int count = 0; 
		while(count < index){
			count++;
			current = current.getNext();
		}
		return current;
	}
	
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
						System.out.println("Hello");
					}
					return new ReturnObjectImpl(ErrorMessage.NO_ERROR , null);
			}
			
		}
	}
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
	public String toString(){
		if (head == null){
			str += "The list is empty";
			return str;
			}
			else{
				return "Here are the elements: "" + head.listAsString();
				};
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