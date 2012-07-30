package ar.com.ggb.gui.app;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

import ar.com.ggb.gui.listener.BarraBotonesActionListener;
import ar.com.ggb.gui.tablemodel.PersonasTableModel;
import ar.com.ggb.comp.Persona;


public class App extends JFrame implements ActionListener, ListSelectionListener, TableModelListener{
	private static final long serialVersionUID = 1L;
	
	private JTextField jtfPersonaDni = new JTextField(15);
	private JTextField jtfPersonaNombre= new JTextField(15);
	private JTextField jtfPersonaApellido= new JTextField(15);
	private JTextField jtfPersonaEdad= new JTextField(15);
	private JTextField jtfPersonaDireccion= new JTextField(15);
	private JTextField jtfPersonaEmail= new JTextField(15);
	private JRadioButton botonM = new JRadioButton("Masculino", true);
	private JRadioButton botonF = new JRadioButton("Femenino", false);
	private ButtonGroup grupoBotonesSexo = new ButtonGroup();

	private JButton jbNuevo = new JButton("Nuevo");
	private JButton jbAgregar = new JButton("Agregar");
	private JButton jbModificar = new JButton("Modificar");
	private JButton jbEliminar = new JButton("Eliminar");
	
	private JScrollPane jspTabla = new JScrollPane();
	private JTable jtTabla=new JTable();
	
	private Persona persona=new Persona();
	private PersonasTableModel tmPersonas=new PersonasTableModel();
	
	private JButton jbCerrar = new JButton("Cerrar");
	
	public App(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		getContentPane().setLayout(new BorderLayout());
		setTitle("Final Java - ABM");
		getContentPane().setPreferredSize(new Dimension(800, 600));
    	Color cyan = Color.cyan;
    	getContentPane().setBackground(cyan);

		
		JPanel jpAdm=new JPanel();
		jpAdm.setLayout(new GridBagLayout());
		getContentPane().add(jpAdm,BorderLayout.CENTER);
		
		JPanel jpAdmFormulario = new JPanel();
		
		jpAdmFormulario.setBorder(BorderFactory.createTitledBorder("Datos de la Persona"));
		jpAdmFormulario.setLayout(new GridBagLayout());
		jpAdm.add(jpAdmFormulario,new GridBagConstraints(0,0,1,1,0.0,0.0, GridBagConstraints.CENTER,GridBagConstraints.NONE,new Insets(5,5,10,5),1,1));
		
		jpAdmFormulario.add(new JLabel("D.N.I.: ",SwingConstants.RIGHT),new GridBagConstraints(0,0,1,1,0.0,0.0, GridBagConstraints.CENTER,GridBagConstraints.NONE,new Insets(5,5,10,5),1,1));
		jpAdmFormulario.add(jtfPersonaDni,new GridBagConstraints(1,0,1,1,0.0,0.0, GridBagConstraints.CENTER,GridBagConstraints.HORIZONTAL,new Insets(5,5,10,5),1,1));
		
		jpAdmFormulario.add(new JLabel("Nombre: ",SwingConstants.RIGHT),new GridBagConstraints(0,1,1,1,0.0,0.0, GridBagConstraints.CENTER,GridBagConstraints.NONE,new Insets(5,5,10,5),1,1));
		jpAdmFormulario.add(jtfPersonaNombre,new GridBagConstraints(1,1,2,1,0.0,0.0, GridBagConstraints.CENTER,GridBagConstraints.HORIZONTAL,new Insets(5, 5, 10, 0),1,1));
		
		jpAdmFormulario.add(new JLabel("Apellido: ", SwingConstants.RIGHT),new GridBagConstraints(0,2,1,1,0.0,0.0, GridBagConstraints.CENTER,GridBagConstraints.NONE,new Insets(5,5,10,5),1,1));;
		jpAdmFormulario.add(jtfPersonaApellido,new GridBagConstraints(1,2,2,1,1.0,0.0, GridBagConstraints.CENTER,GridBagConstraints.HORIZONTAL,new Insets(5,5,10,5),1,1));
		
		jpAdmFormulario.add(new JLabel("Sexo: ", SwingConstants.RIGHT),new GridBagConstraints(0,3,1,1,0.0,0.0, GridBagConstraints.CENTER,GridBagConstraints.NONE,new Insets(5,5,10,5),1,1));
		jpAdmFormulario.add(botonM,new GridBagConstraints(1,3,1,1,1.0,0.0, GridBagConstraints.CENTER,GridBagConstraints.HORIZONTAL,new Insets(5,5,10,5),1,1));
		jpAdmFormulario.add(botonF,new GridBagConstraints(2,3,1,1,1.0,0.0, GridBagConstraints.CENTER,GridBagConstraints.HORIZONTAL,new Insets(5,5,10,5),1,1));		
		
		jpAdmFormulario.add(new JLabel("Edad: ", SwingConstants.RIGHT),new GridBagConstraints(0,4,1,1,0.0,0.0, GridBagConstraints.CENTER,GridBagConstraints.NONE,new Insets(5,5,10,5),1,1));;
		jpAdmFormulario.add(jtfPersonaEdad,new GridBagConstraints(1,4,1,1,0.0,0.0, GridBagConstraints.CENTER,GridBagConstraints.HORIZONTAL,new Insets(5,5,10,5),1,1));
		
		jpAdmFormulario.add(new JLabel("Dirección: ", SwingConstants.RIGHT),new GridBagConstraints(0,5,1,1,0.0,0.0, GridBagConstraints.CENTER,GridBagConstraints.NONE,new Insets(5,5,10,5),1,1));;
		jpAdmFormulario.add(jtfPersonaDireccion,new GridBagConstraints(1,5,2,1,0.0,0.0, GridBagConstraints.CENTER,GridBagConstraints.HORIZONTAL,new Insets(5,5,10,5),1,1));
		
		jpAdmFormulario.add(new JLabel("E-mail: ", SwingConstants.RIGHT),new GridBagConstraints(0,6,1,1,0.0,0.0, GridBagConstraints.CENTER,GridBagConstraints.NONE,new Insets(5,5,10,5),1,1));;
		jpAdmFormulario.add(jtfPersonaEmail,new GridBagConstraints(1,6,2,1,1.0,0.0, GridBagConstraints.CENTER,GridBagConstraints.HORIZONTAL,new Insets(5,5,10,5),1,1));

		grupoBotonesSexo.add(botonM);
		grupoBotonesSexo.add(botonF);
		
		JPanel jpAdmDetalle=new JPanel();
		jpAdmDetalle.setLayout(new BorderLayout());
		jpAdm.add(jpAdmDetalle,new GridBagConstraints(0,1,1,2,0.0,0.0, GridBagConstraints.CENTER,GridBagConstraints.NONE,new Insets(5,5,10,5),1,1));
		
		JPanel jpAdmDetalleBarraBotones = new JPanel();
		jpAdmDetalleBarraBotones.setLayout(new FlowLayout());
		jpAdmDetalle.add(jpAdmDetalleBarraBotones,BorderLayout.NORTH);
		jpAdmDetalleBarraBotones.add(jbNuevo);
		jbNuevo.addActionListener(this);	
		jpAdmDetalleBarraBotones.add(jbAgregar);
		jbAgregar.addActionListener(this);								
		jpAdmDetalleBarraBotones.add(jbModificar);
		jbModificar.addActionListener(this);				
		jpAdmDetalleBarraBotones.add(jbEliminar);
		jbEliminar.addActionListener(this);		

		jpAdmDetalle.add(jspTabla);
		jtTabla.setModel(tmPersonas);
		
		jtTabla.setAutoCreateRowSorter(true);
		jtTabla.getSelectionModel().addListSelectionListener(this);
		jspTabla.setViewportView(jtTabla);
		jtTabla.setPreferredScrollableViewportSize(new Dimension(780, 200));
		jtTabla.setFillsViewportHeight(true);
		
		JPanel jpBarraBotones = new JPanel();
		getContentPane().add(jpBarraBotones,BorderLayout.SOUTH);
		jpBarraBotones.setLayout(new FlowLayout());		
		jpBarraBotones.add(jbCerrar);
		
		jbCerrar.setActionCommand("CERRAR");
		jbCerrar.addActionListener(new BarraBotonesActionListener());				
		
		nuevaPersona();
		this.pack();
	}

	public static void main(String [] args){
		App app=new App();
		app.setVisible(true);
	}

	public void seleccionarPersona(){
		this.persona=tmPersonas.personas.get(jtTabla.getSelectedRow());
		if(persona!=null){
			jtfPersonaDni.setText(persona.getDni().toString());
			jtfPersonaNombre.setText(persona.getNombre());
			jtfPersonaApellido.setText(persona.getApellido());
			if(persona.getSexo()=='M'){
				botonM.doClick();
			}else{
				botonF.doClick();
			}
			//jtfPersonaSexo.setText(persona.getSexo().toString());
			jtfPersonaEdad.setText(persona.getEdad().toString());
			jtfPersonaDireccion.setText(persona.getDireccion());
			jtfPersonaEmail.setText(persona.getEmail());
		}
		
		if(this.persona!=null){
			this.jbNuevo.setEnabled(true);
			this.jbAgregar.setEnabled(false);
			this.jbModificar.setEnabled(true);
			this.jbEliminar.setEnabled(true);
		}else{
			nuevaPersona();
		}
	}
	public void nuevaPersona(){
		this.persona=new Persona();
		jtfPersonaDni.setText("");
		jtfPersonaNombre.setText("");
		jtfPersonaApellido.setText("");
		botonM.doClick();
		jtfPersonaEdad.setText("");
		jtfPersonaDireccion.setText("");
		jtfPersonaEmail.setText("");
		
		this.jbNuevo.setEnabled(true);
		this.jbAgregar.setEnabled(true);
		this.jbModificar.setEnabled(false);
		this.jbEliminar.setEnabled(false);
	}
	
	public void addPersona(){
		this.jspTabla.remove(jtTabla);
			
		persona = new Persona();
		try{
			Integer dni = null;
			
			if(jtfPersonaDni.getText()!=null && !jtfPersonaDni.getText().equals("")	&& !jtfPersonaDni.getText().contains(" ")){
				dni=Integer.parseInt(jtfPersonaDni.getText());
			}
	
			String nombre = jtfPersonaNombre.getText();
			String apellido = jtfPersonaApellido.getText();
			Integer edad= Integer.parseInt(jtfPersonaEdad.getText());
			String direccion=jtfPersonaDireccion.getText();
			String email=jtfPersonaEmail.getText();
	
			persona.setDni(dni);			
			persona.setNombre(nombre);
			persona.setApellido(apellido);
			if(botonM.isSelected()){
				persona.setSexo('M');
			}else{
				persona.setSexo('F');
			}
			persona.setEdad(edad);
			persona.setDireccion(direccion);
			persona.setEmail(email);
			
			if(persona.getDni()!=null){
				tmPersonas.personas.add(persona);		
			}

			this.jspTabla.setViewportView(jtTabla);

			this.persona=new Persona();
			jtfPersonaDni.setText("");
			jtfPersonaNombre.setText("");
			jtfPersonaApellido.setText("");
			botonM.setSelected(true);
			jtfPersonaEdad.setText("");
			jtfPersonaDireccion.setText("");
			jtfPersonaEmail.setText("");

			this.jbNuevo.setEnabled(true);
			this.jbAgregar.setEnabled(true);
			this.jbModificar.setEnabled(false);
			this.jbEliminar.setEnabled(false);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void modificarPersona(){
		this.persona=tmPersonas.personas.get(jtTabla.getSelectedRow());
		
		if(this.persona!=null){
			Integer dni=null;
			String nombre = jtfPersonaNombre.getText();
			String apellido = jtfPersonaApellido.getText();
			Integer edad= Integer.parseInt(jtfPersonaApellido.getText());
			String direccion=jtfPersonaDireccion.getText();
			String email=jtfPersonaEmail.getText();
			
			if(jtfPersonaDni.getText()!=null){
				dni=Integer.parseInt(jtfPersonaDni.getText());
			}
			persona.setDni(dni);
			persona.setNombre(nombre);
			persona.setApellido(apellido);
			persona.setEdad(edad);
			persona.setDireccion(direccion);
			persona.setEmail(email);
		}
		
		this.jtTabla.repaint();
	}
	
	public void eliminarPersona(){
		this.persona=tmPersonas.personas.get(jtTabla.getSelectedRow());
		tmPersonas.personas.remove(persona);
		this.jtTabla.repaint();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e!=null && jbNuevo.equals(e.getSource())){
			nuevaPersona();
		}else if(e!=null && jbAgregar.equals(e.getSource())){
			addPersona();
			nuevaPersona();
		}else if(e!=null && jbModificar.equals(e.getSource())){
			modificarPersona();
		}else if(e!=null && jbEliminar.equals(e.getSource())){
			eliminarPersona();
			nuevaPersona();
		}
		
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		int viewRow = jtTabla.getSelectedRow();
        if (viewRow < 0) {
            System.out.println("");
        } else {
            int modelRow = jtTabla.convertRowIndexToModel(viewRow);
            System.out.println(String.format("Fila seleccionada en la tabla: %d. " +"Fila seleccionada en el modelo: %d.",viewRow, modelRow));
            seleccionarPersona();
        }
	}


	@Override
	public void tableChanged(TableModelEvent e) {
		int row = e.getFirstRow();
		int column = e.getColumn();
		PersonasTableModel model = (PersonasTableModel) e.getSource();
		String columnName =  model.getColumnName(column);
		Persona data = (Persona)model.getValueAt(row, column);
		System.out.println(data.getId()+"-"+data.getDni()+"-"+data.getNombre()+"-"+data.getApellido()+"-"+data.getSexo()+"-"+data.getEdad()+"-"+data.getDireccion()+"-"+data.getEmail()+"-"+columnName);
	}
}