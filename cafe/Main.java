package cafe;

import java.util.LinkedList;

import javax.swing.JOptionPane;

public class Main {

	public static int id = 0;
	public static String opcion[] = { "Latte", "Flat White", "Lágrima", "Expresso" };
	public static double precios[] = { 1.50, 2.50, 1.3, 1 };
	public static LinkedList<Cafe> cafes = new LinkedList<Cafe>();

	public static void main(String[] args) {
		menu();

	}

	public static void menu() {
		String[] botones = { "cajero", "admin", "salir" };
		int ventana = JOptionPane.showOptionDialog(null, "selecciona una opcion", "Menu", JOptionPane.DEFAULT_OPTION,
				JOptionPane.QUESTION_MESSAGE, null, botones, botones[0]);
		if (ventana == 0) {
			usuariomenu();
		} else if (ventana == 1) {
			empresamenu();
		} else if (ventana == 2) {
			System.out.println("salir");
		}
	}

	public static void usuariomenu() {
		String[] botones = { "pedir cafe", "salir" };
		int ventana = JOptionPane.showOptionDialog(null, "selecciona una opcion", "Menu", JOptionPane.DEFAULT_OPTION,
				JOptionPane.QUESTION_MESSAGE, null, botones, botones[0]);
		if (ventana == 0) {
			añadir_cafe();
		} else if (ventana == 1) {
			menu();
		}
	}

	public static void empresamenu() {
		String[] botones = { "ver ventas", "ver tipo de cafe mas vendido", "ver recaudacion",
				"ver ventas con descuento", "mas", "salir" };
		int ventana = JOptionPane.showOptionDialog(null, "selecciona una opcion", "Menu", JOptionPane.DEFAULT_OPTION,
				JOptionPane.QUESTION_MESSAGE, null, botones, botones[0]);
		if (ventana == 0) {
			mostrar_totalventas();
		} else if (ventana == 1) {
			mostrar_topventas();
		} else if (ventana == 2) {
			mostrar_recaudacion();
		} else if (ventana == 3) {
			mostrar_ventas_descuentos();
		} else if (ventana == 4) {
			cerradomenu();
		} else if (ventana == 5) {
			menu();
		}
	}

	public static void cerradomenu() {
		String[] botones = { "borrar pedido", "salir", "cerrar" };
		int ventana = JOptionPane.showOptionDialog(null, "selecciona una opcion", "Menu", JOptionPane.DEFAULT_OPTION,
				JOptionPane.QUESTION_MESSAGE, null, botones, botones[0]);
		if (ventana == 0) {
			borrar_cafe();
		} else if (ventana == 1) {
			empresamenu();
		} else if (ventana == 2) {
			System.out.println("salir");
			
		}
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
		Cafe cafe = new Cafe(id, cantidad, idcafe - 1, tipocafe, Math.random() * 11 >= 5);
		id++;
		cafes.add(cafe);
		usuariomenu();
	}

	// calcular cafes vendidos

	public static void mostrar_topventas() {
		int cantidadvendidos[] = new int[4];
		int max = 0;
		for (int i = 0; i < cafes.size(); i++) {
			cantidadvendidos[cafes.get(i).getTipocafe()] = cafes.get(i).getCantidad();
		}
		for (int i = 0; i < cantidadvendidos.length; i++) {
			if (cantidadvendidos[i] > max) {
				max = i;
			}
		}
		JOptionPane.showMessageDialog(null, "el cafe mas vendido es: " + opcion[max]);
		empresamenu();
	}

	public static void mostrar_totalventas() {
		int cafesventas[]=new int[4];
		for (int i = 0; i < cafes.size(); i++) {
			if (cafes.get(i).getTipocafe() == 0) {
				cafesventas[0]+=cafes.get(i).getCantidad();
			}
			if (cafes.get(i).getTipocafe() == 1) {
				cafesventas[1]+=cafes.get(i).getCantidad();
			}
			if (cafes.get(i).getTipocafe() == 2) {
				cafesventas[2]+=cafes.get(i).getCantidad();
			}
			if (cafes.get(i).getTipocafe() == 3) {
				cafesventas[3]+=cafes.get(i).getCantidad();
			}
		}
		
		
		JOptionPane.showMessageDialog(null,opcion[0] +" "+ cafesventas[0] +"\n"+opcion[1] +" "+ cafesventas[1] +"\n"+opcion[2] +" "+ cafesventas[2] +"\n"+opcion[3] +" "+ cafesventas[3] +"\n");
		empresamenu();
	}

	public static void mostrar_recaudacion() {
		double ventast = 0;
		for (int i = 0; i < cafes.size(); i++) {
			ventast += precios[cafes.get(i).getTipocafe()] * cafes.get(i).getCantidad();
		}
		JOptionPane.showMessageDialog(null, "total recaudado $" + ventast);
		empresamenu();
	}


	public static void mostrar_ventas_descuentos() {
		int verificados = 0;
		for (int i = 0; i < cafes.size(); i++) {
			if (cafes.get(i).isSocio()) {
				verificados++;
			}
		}
		
		String descuentos[]= new String[verificados];
		for (int i = 0; i < descuentos.length; i++) {
			if(cafes.get(i).isSocio()) {
				descuentos[i]= "id "+ cafes.get(i).getId() + "Producto: " + opcion[cafes.get(i).getTipocafe()] +" cantidad "+ cafes.get(i).getCantidad();
			}
			
		}
		JOptionPane.showInputDialog(null,"Pick a printer", "Input", JOptionPane.QUESTION_MESSAGE,
		        null, descuentos, null);
		empresamenu();
	}

	
	public static void borrar_cafe() {
		boolean pregunta = false;
		do {
			String pedidos[] = new String[cafes.size() + 1];
			int del = 0;
			for (int i = 0; i < cafes.size(); i++) {
				pedidos[i] = cafes.get(i).getId() + " Tipo de cafe " + cafes.get(i).getCafe();
			}
			pedidos[cafes.size()] = "-1 salir";
			String res = (String) JOptionPane.showInputDialog(null, "seleccione el tipo de cafe", "borrar pedido",
					JOptionPane.DEFAULT_OPTION, null, pedidos, null);
			if (res.equalsIgnoreCase("-1 salir")) {

			} else {
				for (int i = 0; i < pedidos.length; i++) {
					if (pedidos[i] == res) {
						del = i;
					}
				}
			
			if (!pregunta) {
				cafes.remove(del);
			}
			}
		} while (pregunta);
		System.out.println(cafes.size());
		cerradomenu();
	}

}
