package ar.com.ggb.gui.listener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class BarraBotonesActionListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e!=null && e.getActionCommand()!=null && e.getActionCommand().equals("CERRAR")){
			System.exit(0);
		}

	}

}
