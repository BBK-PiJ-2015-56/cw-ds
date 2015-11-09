public class ArrayList implements List{
	
	private ReturnObjectImpl[] objArray;
	
	private static int INITIAL_ARRAY_SIZE = 10;
	
	//constructor
	public ArrayList(){
		objArray = new ReturnObjectImpl[INITIAL_ARRAY_SIZE];
	}
	
	public boolean isEmpty(){
		if (size() == 0) {
			return true;
			} 
			else {
				return false;
				}
	}
	
	public int size(){
		int count = 0;
		while(objArray[count] != null){
			count++;
		}
		return count;
	}
	
	
	public ReturnObject get(int index){
		if((index < 0) || (index > size())){
				return new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS , null);
		}
		else {
			return objArray[index];
			}
	}
	
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
	private boolean isAlmostFull() {
		if (objArray.length - size() < 1) {
			return true;
		}
		else {
		    return false;	
		}
	}
	private void increaseArrayLength() {
		int currentLength = objArray.length;
		ReturnObjectImpl[]  biggerobjArray = new ReturnObjectImpl[currentLength * 2];
		for (int i = 0; i < size() ; i++) {
			biggerobjArray[i] = this.objArray[i];
		}
		this.objArray = biggerobjArray;
	}
	
	public String toString(){
		String str = "Here are the elements: ";
		for(int i = 0; i < size(); i++){
			str+= objArray[i].getReturnValue() + " ,";
		}
		return str;
	} 
		
}