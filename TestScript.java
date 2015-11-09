
public class TestScript{
	public static void main(String[] args){
		TestScript script =new TestScript();
		script.launch();
		}
		
		public void launch(){
			List pList = new PointerList();
			test(pList);
			//List aList = new ArrayList(); 
			//Q) the toString still works even though its declard as a list not an ArrayList! why?
			//test(aList);
		}
			
		public void test(List list){
			System.out.println(list.toString());
			System.out.println(list.add("This is a String"));
			System.out.println(list.toString());
			System.out.println(list.add("This is a second String"));
			System.out.println(list.toString());
			System.out.println(list.add( "This is a third String"));
			System.out.println(list.toString());
			System.out.println(list.add( "This is a fourth String"));
			System.out.println(list.toString());
			System.out.println(list.add( "This is a fifth String"));
			System.out.println(list.toString());
			System.out.println(list.add(0 , "This is another String"));
			System.out.println(list.toString());
			System.out.println(list.add(3 , "This is an intrusive String"));
			System.out.println(list.toString());
			/*System.out.println("The size is " + list.size()); 
			list.remove(2);
			System.out.println(list.toString());
			System.out.println("The size is " + list.size());
			System.out.println(list.remove(15)); //should return retobj with error out of bounds*/
		}
		
		
}


