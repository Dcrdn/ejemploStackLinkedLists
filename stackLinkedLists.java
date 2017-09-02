
public class stackLinkedLists {
	//creo mi clase nodo, la cual tendrá guardado el siguiente nodo y el dato que almacenaré
	public class Node{
		public Node next;
		public Comparable node;
		
		public Node(Comparable node){
			this.node=node;
			this.next=null;
		}	
	}
	//hago un objeto de tipo Node el cual se encuentra vacío
	private Node top = null;
	
	public boolean isEmpty(){
		return(top==null);
	}
		
	//mi push hace un nuevo objeto Nodo, le dice que este tendrá un nodo dentro (.next)
	// el cual está actualmente en la parte de arriba del stack, en el top
	//posteriormente iguala ese nodo al top, puesto que es el más nuevo
	public void push(Comparable data){
		Node node=new Node(data);
		node.next=this.top;
		this.top=node;
	}
	//estoy diciendo que mi top actual, va a ser el siguiente nodo
	//por tanto, java se encarga de eliminar el nodo actual debido a que ya
	//no se estará usando y no se podrá acceder a él
	public Node pop(){
		if(!this.isEmpty()){
			this.top=this.top.next;
		}
		return this.top;
	}
	
	//si mi top es igual a null, mi stack estará vacío
	public void vaciarTodo(){
		this.top=null;
	}
	//me hace un return de mi dato que está en el top si el stack
	//no se encuentra vacío
	public Comparable peek(){
		if(!this.isEmpty()){
			return this.top.node;
		}
		else{
			return "";
		}
	}
	
}
