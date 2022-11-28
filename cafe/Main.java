package cafe;

import java.util.LinkedList;

import javax.swing.JOptionPane;

public class Main {

	public static int id = 0;
	public static String opcion[] = { "Latte", "Flat White", "Lágrima", "Expresso" };
	public static LinkedList<Cafe> cafes = new LinkedList<Cafe>();

	public static void main(String[] args) {
		añadir_cafe();
		borrar_cafe();
	

	}

	public static void menu() {
		
		
		
		
	}

	public static void añadir_cafe() {
		String opciones[] = { "1-Latte", "2-Flat White", "3-Lágrima", "4-Expresso" };
		int cantidad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de cafe"));
		char caracter = ((String) JOptionPane.showInputDialog(null, "seleccione el tipo de cafe", "añadir pedido",
				JOptionPane.DEFAULT_OPTION, null, opciones, null)).charAt(0);
		String convertido = String.valueOf(caracter);
		int idcafe = Integer.parseInt(convertido);
		System.out.println(idcafe);
		String tipocafe = opcion[idcafe - 1];
		Cafe cafe = new Cafe(id, cantidad, tipocafe, Math.random() * 11 >= 5);
		id++;
		cafes.add(cafe);
	}

	// calcular cafes vendidos

	public static void mostrar_topventas() {

	}

	public static void borrar_cafe() {
		boolean pregunta;
		boolean valor = false;
		char valoresposibles[]= {'-','0','1','2','3','4','5','6','7','8','9'};
		do {
		String pedidos[] = new String[cafes.size() + 1];
		for (int i = 0; i < cafes.size(); i++) {
			pedidos[i]= cafes.get(i).getId() + " Tipo de cafe "+ cafes.get(i).getCafe();
		}
			pedidos[cafes.size() ]="-1 salir";
			int k=0;
			char pedidoid[]=new char [15];
			String res=(String) JOptionPane.showInputDialog(null, "seleccione el tipo de cafe", "borrar pedido",
					JOptionPane.DEFAULT_OPTION, null, pedidos, null);
			do {
			pedidoid[k] = (res).charAt(k);
			for (int i = 0; i < valoresposibles.length; i++) {
			if (valoresposibles[i]!=pedidoid[k]) {
				valor=true;
			}	
			}
			k++;
			} while (valor);
			pregunta = pedidoid[0] == '-';
			if (!pregunta) {
				cafes.remove(pedidoid);
			}
		} while (pregunta);
	}

}
