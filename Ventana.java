import javax.swing.JFrame;
import javax.swing.JPanel;
		
public class Ventana extends JFrame{

		public Ventana(){
				
			super("Stack Linked List");
			this.setDefaultCloseOperation(EXIT_ON_CLOSE);
			Principal pr=new Principal();
			this.add(pr);
			this.pack();
			this.setLocationRelativeTo(null);
			this.setVisible(true);
		}
			
		public static void main(String[] args){
			Ventana window = new Ventana();
			/*String paginaWeb="perro.com";
			System.out.println(paginaWeb.contains(".com"));
			String paginaWeb1="perro";
			System.out.println(paginaWeb1.contains(".com"));
			String paginaWeb2="perr.comasdinads";
			System.out.println(paginaWeb2.contains(".com"));*/
			
		}
}
