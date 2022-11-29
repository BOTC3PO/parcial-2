package cafe;

public class Cafe {
private int id,cantidad;
private int tipocafe;
private String cafe;
private boolean socio;


public Cafe(int id, int cantidad,int tipocafe, String cafe, boolean socio) {
	this.id = id;
	this.cantidad = cantidad;
	this.tipocafe=tipocafe;
	this.cafe = cafe;
	this.socio = socio;
}

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getCantidad() {
	return cantidad;
}
public void setCantidad(int cantidad) {
	this.cantidad = cantidad;
}
public String getCafe() {
	return cafe;
}
public void setCafe(String cafe) {
	this.cafe = cafe;
}
public boolean isSocio() {
	return socio;
}
public void setSocio(boolean socio) {
	this.socio = socio;
}

public int getTipocafe() {
	return tipocafe;
}

public void setTipocafe(int tipocafe) {
	this.tipocafe = tipocafe;
}

@Override
public String toString() {
	return "Cafe [id=" + id + ", cantidad=" + cantidad + ", cafe=" + cafe + ", socio=" + socio + "]";
}	

}
