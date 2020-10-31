import javax.swing.JOptionPane;

public class Monedero {
    //atributo
    private int dinero;
    //constructor
    public Monedero(int dineroincial){
        this.dinero=dineroincial;
        }
    //Metodo para meter dinero
    public void meterDinero(int entrada) {
		this.dinero=this.dinero+entrada;
	}
    //Metodo para sacar dinero
    public int sacarDinero(int salida) {
    	int band=0;
		if(this.dinero>salida){//valida que haya dinero suficiente
			this.dinero=this.dinero-salida;
			//Se muestra mensaje de exito
			JOptionPane.showMessageDialog(null,"Dinero retirado con exito","",JOptionPane.INFORMATION_MESSAGE);
		}
		else {
			//Se muestra mensaje de error
			JOptionPane.showMessageDialog(null,"No tiene esa cantidad en el monedero","", JOptionPane.WARNING_MESSAGE);
			band=1;
		}
		return band;
	}
    //Metodo para consultar dinero
    public  int consultarDinero() {
              return this.dinero;
	}
}