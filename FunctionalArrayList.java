public class functionalList extends ArrayList{
	public ReturnObject head(){
		if(objArray[0] == null){
			return new ReturnObject(ErrorMessage.EMPTY_STRUCTURE , null);
			}
			else{
				return objarray[0];
			}
	}
	
	// public FunctionalList rest();


}