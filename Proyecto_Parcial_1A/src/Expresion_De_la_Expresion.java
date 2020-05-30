
public class Expresion_De_la_Expresion {
	
	private String sub_expresion;
	private Jerarquia operacion;
	
	//setters y Getters para el Arreglo
	public String getSub_expresion() {
		return sub_expresion;
	}
	public void setSub_expresion(String sub_expresion) {
		this.sub_expresion = sub_expresion;
	}
	public Jerarquia getOperacion() {
		return operacion;
	}
	public void setOperacion(Jerarquia operacion) {
		this.operacion = operacion;
	}
	
	

	//Constructor Default // Con Union // Cerraduras
	
	public Expresion_De_la_Expresion(String valor){
		this.sub_expresion= valor;
		this.operacion= Jerarquia.CONCAT;
	}
}
