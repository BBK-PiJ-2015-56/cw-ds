public class FunctionalLinkedList extends LinkedList{
	public ReturnObject head(){
		if(head == null){
			return new ReturnObject(ErrorMessage.EMPTY_STRUCTURE , null);
			}
			else{
				return head;
				}
	}
	
	
	// public FunctionalList rest();
}