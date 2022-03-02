package file;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Examenparcial {
	/**
	 * Pre:---
	 * Post: Este programa lee el fichero titanic y muestra por pantalla el numero total de pasajeros,
	 * cuantos de ellos son hombres y cuanto son mujeres, cuantos hombres y mujeres han fallecido y su porcentaje.
	 */
	
	public static void main(String[] args) {
		//Leemos el fichero
		String nombre = "C:\\Users\\Carlos\\Desktop\\titanic.csv";
		File file = new File(nombre);
		int numeroPasajeros=0;
		int hombres=0;
		int mujeres=0;
		int hombresFallecidos=0;
		int mujeresFallecidas=0;
		try {
			Scanner f = new Scanner(file);
			//Vamos linea por linea
			while (f.hasNextLine()) {
				String linea = f.nextLine();
				//Spliteamos los datos separados por comas
				String[] lineaSeparada = linea.split(",");
				//Contamos el numero de pasajeros
				numeroPasajeros++;
				//Contamos el numero de hombres y mujeres
				if (lineaSeparada[5].equals("male")) {
					hombres++;
				}else if(lineaSeparada[5].equals("female")) {
					mujeres++;
				}
				//Contamos el numero de hombres y mujeres fallecidos
				if(lineaSeparada[5].equals("male")&&lineaSeparada[1].equals("0")) {
					hombresFallecidos++;
				}else if(lineaSeparada[5].equals("female")&&lineaSeparada[1].equals("0")) {
					mujeresFallecidas++;
				}
			}
			System.out.println("El nuero de pasajeros es: " + numeroPasajeros);
			System.out.println("El numero de mujeres es: " + mujeres);
			System.out.println("El numero de hombres es: " + hombres);
			System.out.println("El numero de mujeres fallecidas es: " + mujeresFallecidas+ " y su porcentaje es: " + mujeresFallecidas*100/mujeres+ "%");
			System.out.println("El numero de hombres fallecidos es: " + hombresFallecidos+ " y su porcentaje es: " + hombresFallecidos*100/hombres+ "%");
			f.close();
		} catch (FileNotFoundException e) {
			System.out.println("El fichero " + nombre + " no ha podido ser abierto.");
		}
	}
}
