package ar.com.ggb.gui.tablemodel;

import java.util.ArrayList;
import java.util.List;

import ar.com.ggb.comp.Persona;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

public class PTM implements TableModel {
	
	public List<Persona> personas = new ArrayList<Persona>();
	public List<String> nombreColumnas = new ArrayList<String>();
	public List<TableModelListener> tableModelListeners = new ArrayList<TableModelListener>();
	
	public PTM(){
		nombreColumnas.add("D.N.I.");
		nombreColumnas.add("Nombre");
		nombreColumnas.add("Apellido");
		nombreColumnas.add("Sexo");
		nombreColumnas.add("Edad");
		nombreColumnas.add("Dirección");
		nombreColumnas.add("E-mail");
	}


	@Override
	public void addTableModelListener(TableModelListener arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Class<?> getColumnClass(int arg0) {
		return getValueAt(0, arg0).getClass();
	}

	@Override
	//genera la división en columnas en la JTable
	public int getColumnCount() {
		if(nombreColumnas!=null){	
			return nombreColumnas.size();
		}
		return 0;
	}

	@Override
	//obtiene los nombres para cada columna en la JTable
	public String getColumnName(int arg0) {
		if(nombreColumnas!=null && arg0>=0 && nombreColumnas.size()>arg0){
			return nombreColumnas.get(arg0);
		}
		return null;
	}

	@Override
	public int getRowCount() {
		if(personas!=null){
			return personas.size();
		}
		return 0;
	}


	@Override
	public Object getValueAt(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isCellEditable(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void removeTableModelListener(TableModelListener arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setValueAt(Object arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
		
	}

}

/*

	@Override
	public Object getValueAt(int arg0, int arg1) {
		if(personas!=null && arg0>=0 && arg1>=0 && personas.size()>arg0){
			Persona persona=personas.get(arg0);
			switch(arg1){
				case 0: return persona.getDni();
				case 1: return persona.getNombre();
				case 2: return persona.getApellido();
				case 3: return persona.getSexo();
				case 4: return persona.getEdad();
				case 5: return persona.getDireccion();
				case 6: return persona.getEmail();
			}
		}
		return null;
	}
	@Override
	public void setValueAt(Object arg0, int arg1, int arg2) {
		if(personas!=null && arg1>=0 && arg2>=0 && personas.size()>arg1){
			Persona persona=personas.get(arg1);
			switch(arg2){
				case 0:
					Integer dniNuevo=null;
					if(arg0!=null){
						dniNuevo=(Integer)arg0;
					}
					persona.setDni(dniNuevo);
					break;
				case 1: 
					String nombreNuevo=null;
					if(arg0!=null){
						nombreNuevo=(String)arg0;
					}
					persona.setNombre(nombreNuevo);
					break;
				case 2: 
					String apellidoNuevo=null;
					if(arg0!=null){
						apellidoNuevo=(String)arg0;
					}
					persona.setApellido(apellidoNuevo);
					break;
				case 3: 
					char sexoNuevo=(Character) null;
					if(arg0!=null){
						sexoNuevo=(Character)arg0;
					}
					persona.setSexo(sexoNuevo);
					break;
				case 4: 
					int edadNueva=0;
					if(arg0!=null){
						edadNueva=(Integer)arg0;
					}
					persona.setEdad(edadNueva);
					break;
				case 5: 
					String direccionNueva=null;
					if(arg0!=null){
						direccionNueva=(String)arg0;
					}
					persona.setDireccion(direccionNueva);
					break;
				case 6: 
					String emailNuevo=null;
					if(arg0!=null){
						emailNuevo=(String)arg0;
					}
					persona.setEmail(emailNuevo);
					break;
			}
		}
	}

	@Override
	public boolean isCellEditable(int arg0, int arg1) {
		return false;
	}

	@Override
	public void removeTableModelListener(TableModelListener arg0) {
		tableModelListeners.add(arg0);
	}
	@Override
	public void addTableModelListener(TableModelListener arg0) {
		tableModelListeners.remove(arg0);
	}
}
*/
