
public enum Jerarquia {
	
	
	PAR_ABRE("(", 6),PAR_CIERRA(")", 0),
	MAS_POW("^", 4), ASTERISCO_POW("*", 3), 
	CONCAT("-", 2), UNION("+", 1);
	
	private String operador;
	private int importancia;
	
	Jerarquia(String operador, int importancia){
		
		this.operador= operador;
		this.importancia= importancia;
		
	}

	public String getOperador() {
		return operador;
	}

	public int getImportancia() {
		return importancia;
	}
	
	
}
