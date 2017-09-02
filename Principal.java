import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Principal extends JPanel implements ActionListener, MouseListener{
		
	private JButton btnIr,
					btnAtras,
					btnAdelante;
	
	private Chrome buscadorAtras,
					buscadorAdelante;
		
	private BufferedImage img;
	
	private JTextField jtPagina;
	
	private String paginaWeb;
	
	public Principal(){
		
		this.setPreferredSize(new Dimension(400,300));
		setLayout(null);
		
		this.buscadorAtras=new Chrome();
		this.buscadorAdelante=new Chrome();
		
		this.paginaWeb="www.google.com";
		//this.paginaWeb="";
		this.buscadorAtras.Push(this.paginaWeb);	
		
		this.btnIr = new JButton("Ir");
		this.btnIr.addActionListener(this);
		this.btnIr.setBounds(301, 50, 89, 23);
		this.add(btnIr);
		
		this.btnAtras = new JButton("Atrás");
		this.btnAtras.addActionListener(this);
		this.btnAtras.setBounds(10, 11, 89, 23);
		this.add(btnAtras);
		
		this.btnAdelante = new JButton("Adelante");
		this.btnAdelante.addActionListener(this);
		this.btnAdelante.setBounds(114, 11, 89, 23);
		this.add(btnAdelante);
		
		this.jtPagina = new JTextField("URL"); 
		this.jtPagina.setBounds(250, 11, 140, 20);
		this.jtPagina.addMouseListener(this);
		this.add(this.jtPagina);		
	}	
	
	public void cargarImagen(){
		if(this.paginaWeb.equals("www.google.com") || this.paginaWeb.equals("www.twitter.com") || 
				this.paginaWeb.equals("www.youtube.com")|| this.paginaWeb.equals("www.facebook.com")|| 
				this.paginaWeb.equals("www.github.com") ||this.paginaWeb.equals("www.wikipedia.com")||
				this.paginaWeb.equals("www.wordpress.com") ||this.paginaWeb.equals("www.buzzfeed.com")||
				this.paginaWeb.equals("google.com") || this.paginaWeb.equals("twitter.com") || 
				this.paginaWeb.equals("youtube.com")|| this.paginaWeb.equals("facebook.com")|| 
				this.paginaWeb.equals("github.com") ||this.paginaWeb.equals("wikipedia.com")||
				this.paginaWeb.equals("wordpress.com") ||this.paginaWeb.equals("buzzfeed.com")){
		
			try{
				this.img= ImageIO.read(getClass().getClassLoader().getResource(this.paginaWeb+".png"));
			}
			catch(IOException e){
			}
		}
		else{
			this.img=null;
		}
	}
		
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.setColor(Color.BLACK);
		g.setFont(new Font("Tahoma", Font.PLAIN, 20));
		g.drawString("Página actual", 10, 80);
		g.setFont(new Font("Tahoma", Font.PLAIN, 17));
		g.drawString(this.paginaWeb, 10, 110);
		this.cargarImagen();
		g.drawImage(this.img, 10, 130, 300, 100, this);
	}

	public boolean esPaginaWeb(){
		if(this.jtPagina.getText().contains(".com")){
			return true;
		}
		else{
			return false;
		}
	}
	
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==this.btnAtras){
			if(!this.buscadorAtras.isEmpty()){
				this.buscadorAdelante.Push(this.buscadorAtras.Peek());
				this.buscadorAtras.Pop();
			
				this.paginaWeb=this.buscadorAtras.Peek()+"";
				if(this.buscadorAtras.isEmpty()){
					this.paginaWeb="www.google.com";
				}
				this.repaint();
			}
			else{
				this.paginaWeb="www.google.com";
			}
		}
		
		else if(e.getSource()==this.btnAdelante){
			if(!this.buscadorAdelante.isEmpty()){
				this.buscadorAtras.Push(this.buscadorAdelante.Peek());
				this.paginaWeb=this.buscadorAdelante.Peek()+"";
				this.buscadorAdelante.Pop();
				this.repaint();
			}
		}
		
		else if(e.getSource()==this.btnIr){
			
			if(!this.buscadorAdelante.isEmpty()){
				this.buscadorAdelante.vaciarTodo();
			}	
			if(this.jtPagina.getText().equals("") || this.jtPagina.getText().equals("URL")){
				//solo quiero que haga algo si mi texto es diferente a URL y que no esté vacío
			}
			//else if(this.esPaginaWeb()){
			else{
				this.buscadorAtras.Push(this.jtPagina.getText());
				this.paginaWeb=this.buscadorAtras.Peek()+"";
				this.jtPagina.setText("");
				this.repaint();
			}
		//	}
		}	
	}
	
	public void mouseClicked(MouseEvent e) {
		if(e.getSource()==this.jtPagina){
			this.jtPagina.setText("");
		}
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}

