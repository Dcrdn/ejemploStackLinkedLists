
public class Chrome {
	
	private stackLinkedLists stackBefore;
	
	public Chrome(){
		this.stackBefore=new stackLinkedLists();
	}
	
	public void Push(Comparable data){
		this.stackBefore.push(data);
	}
	
	public Comparable Peek(){
		return this.stackBefore.peek();
	}
	
	public void Pop(){
		this.stackBefore.pop();
	}
	
	public Boolean isEmpty(){
		return this.stackBefore.isEmpty();
	}
	
	public void vaciarTodo(){
		this.stackBefore.vaciarTodo();
	}
}
