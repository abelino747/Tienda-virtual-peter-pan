package controlador;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import modelo.ClientesDAO;
import modelo.ClientesDTO;
import modelo.DetalleVentaDAO;
import modelo.DetalleVentaDTO;
import modelo.ProductosDTO;
import modelo.ProductosDAO;
import modelo.VentasDAO;
import modelo.VentasDTO;

/**
 * Servlet implementation class ervletVentas
 */
@WebServlet("/ServletVentas")
public class ServletVentas extends HttpServlet {
	private static final long serialVersionUID = 1L;
	double iva,iva1,iva2;   
	int  cant1,cant2,cant3;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletVentas() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sesion=request.getSession();
		if(request.getParameter("confirmar")!=null) {
		long cedula;
	
		
		ClientesDTO listado;
		cedula=Long.parseLong(request.getParameter("cedula"));
		ClientesDAO clidao=new ClientesDAO();
		ClientesDTO clidto=new ClientesDTO(cedula);
		listado=clidao.consultar(clidto);
		
		//ced=listadto.getCedula();
		//nom=listadto.getNombre();
		 sesion.setAttribute("cliente",listado);
		 ///request.setAttribute("clientenombre",nom);
		//JOptionPane.showMessageDialog(null, ced+nom);
		 request.getRequestDispatcher("ventas.jsp").forward(request, response);
		}
		
		
		
		
		//_________________________________________________________________________________
		
		if(request.getParameter("conpro")!=null) {
			
			long codpro;
			ProductosDTO listapro;
			codpro=Long.parseLong(request.getParameter("codigo"));
			ProductosDTO podto=new ProductosDTO(codpro);
			ProductosDAO prodao=new ProductosDAO();
			listapro=prodao.consultar(podto);
			iva= listapro.getIva_compra() ;
			sesion.setAttribute("producto",listapro);
			request.getRequestDispatcher("ventas.jsp").forward(request, response);
	
		} 
		
	//____________________________________________________________________________________________	
		
		if(request.getParameter("conpro2")!=null) {
			long codpro;
			ProductosDTO listapro1;
			codpro=Long.parseLong(request.getParameter("codigo2"));
			ProductosDTO podto=new ProductosDTO(codpro);
			ProductosDAO prodao=new ProductosDAO();
			listapro1=prodao.consultar(podto);
			iva1= listapro1.getIva_compra();
			sesion.setAttribute("producto2",listapro1);
			request.getRequestDispatcher("ventas.jsp").forward(request, response);
			
			
			
		} 
		if(request.getParameter("conpro3")!=null) {
			long codpro;
			ProductosDTO listapro2;
			codpro=Long.parseLong(request.getParameter("codigo3"));
			ProductosDTO podto=new ProductosDTO(codpro);
			ProductosDAO prodao=new ProductosDAO();
			listapro2=prodao.consultar(podto);
			iva2= listapro2.getIva_compra();
			
			sesion.setAttribute("producto3",listapro2);
			request.getRequestDispatcher("ventas.jsp").forward(request, response);
			
			
			
		} 
		double tot,tot1,tot2,res,res1,res2,totalsiniva,totaliva,totaldesiva;

		if(request.getParameter("total")!=null) {
		   double total1,total2,total3;
		
		  
			cant1=Integer.parseInt(request.getParameter("can"));
			cant2=Integer.parseInt(request.getParameter("can2"));
			cant3=Integer.parseInt(request.getParameter("can3"));
			
			tot=Double.parseDouble(request.getParameter("precio"));
			tot1=Double.parseDouble(request.getParameter("precio2"));
			tot2=Double.parseDouble(request.getParameter("precio3"));
			
			
			res=cant1*tot;
			res1=cant2*tot1;
			res2=cant3*tot2;
			total1=res*iva/100;
			total2=res1*iva1/100;
			total3=res2*iva2/100;
			totalsiniva=res+res1+res2;
			totaliva=total1+total2+total3;
			totaldesiva=totalsiniva+totaliva;
			
			//JOptionPane.showMessageDialog(null,"Art1 "+res+"\n"+"Art2 "+res1+"\n"+"Art3 "+res2+"\n");
			//JOptionPane.showMessageDialog(null,"\nIVA "+total1+"\n"+"IVA2 "+total2+"\n"+"IVA3 "+total3+"\n");
			//JOptionPane.showMessageDialog(null,"Art1 "+res+"\n"+"Art2 "+res1+"\n"+"Art3 "+res2+"\n"+"\nIVA "+total1+"\n"+"IVA2 "+total2+"\n"+"IVA3 "+total3+"\n"+"\nTotal sin IVA  "+totalsiniva+"\n"+"TOTAL IVA "+totaliva+"\n"+"Total a pagar "+totaldesiva+"\n");
		    
			int i=JOptionPane.showConfirmDialog(null,"Art1 "+res+"\n"+"Art2 "+res1+"\n"+"Art3 "+res2+"\n"+"\nIVA "+total1+"\n"+"IVA2 "+total2+"\n"+"IVA3 "+total3+"\n"+"\nTotal sin IVA  "+totalsiniva+"\n"+"TOTAL IVA "+totaliva+"\n"+"Total a pagar "+totaldesiva+"\n" );
		     JOptionPane.showMessageDialog(null, "imprimiendo la i"+i);
		     
		    if(i==0) {
		    	
		    	
			    String cedcli,cedusu;
			    long cc,cu;
			    double iva,tv,vv;
			    boolean ress;
			    cedcli=(request.getParameter("cedula"));
			    //cedusu="544567";
			    
			    cedusu=(request.getParameter("cu"));
			    iva=totaliva;
			    tv=totalsiniva;
			    vv=totaldesiva;
			    cc=Long.parseLong(cedcli);
			    cu=Long.parseLong(cedusu);
			    VentasDTO ven=new VentasDTO(cc, cu, iva, tv,vv);
			    VentasDAO vendao=new VentasDAO();
			    ress=vendao.insertarventa(ven);
			    if(ress) {
			    JOptionPane.showMessageDialog(null, "Venta registrada");
			    int can;
			    long cv;
			    double iv,dtv,dvv;
			    boolean x;
			    VentasDTO venn;
			    DetalleVentaDTO dd;
			    DetalleVentaDAO dedao;
			    long codpro=Long.parseLong(request.getParameter("codigo"));
			    long codpro2=Long.parseLong(request.getParameter("codigo2"));
			    long codpro3=Long.parseLong(request.getParameter("codigo3"));
			    VentasDAO vend=new VentasDAO();
			    venn=vend.consultarcodventa();
			  
			     can=cant1;
			     if(can>0) {
			   
				    cv=venn.getCodigo();
				    iv=ven.getIvaventa();
				    dtv=ven.getTotalventa();
				    dvv=ven.getValorventa();
				    dd=new DetalleVentaDTO(can, cv, codpro, total3, iva, iva);
				    dedao=new DetalleVentaDAO();
				    x=dedao.Inserta_Cliente(dd);
				    	if(x) {
				    		JOptionPane.showMessageDialog(null, "detalle insertado");
				    	}
			     }
			     
			     
			     else {
			    	 JOptionPane.showMessageDialog(null, "No inserto cantidad");
			     }
			     can=cant2;
			     if(can>0) {
					   
					    cv=venn.getCodigo();
					    iv=ven.getIvaventa();
					    dtv=ven.getTotalventa();
					    dvv=ven.getValorventa();
					    dd=new DetalleVentaDTO(can, cv, codpro2, total3, iva, iva);
					    dedao=new DetalleVentaDAO();
					    x=dedao.Inserta_Cliente(dd);
					    	if(x) {
					    		JOptionPane.showMessageDialog(null, "detalle insertado");
					    	}
					     }
			     else {
			    	 JOptionPane.showMessageDialog(null, "No inserto cantidad");
			     }
			     can=cant3;
			     if(can>0) {
					   
					    cv=venn.getCodigo();
					    iv=ven.getIvaventa();
					    dtv=ven.getTotalventa();
					    dvv=ven.getValorventa();
					    dd=new DetalleVentaDTO(can, cv, codpro3, total3, iva, iva);
					    dedao=new DetalleVentaDAO();
					    x=dedao.Inserta_Cliente(dd);
					    if(x) {
					    	JOptionPane.showMessageDialog(null, "detalle insertado");
					    	response.sendRedirect("menuprincipal.jsp");
					    }
				 }
			     else {
			    	 JOptionPane.showMessageDialog(null, "No inserto cantidad");
			     }
			     
			     
			     
			    }
			    else {
			    	JOptionPane.showMessageDialog(null, "Venta NO registrada");
			    }
			    	
		  }
		}
		
	}

}

