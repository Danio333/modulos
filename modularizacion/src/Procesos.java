import javax.swing.JOptionPane;

public class Procesos {
	int edadesEstudiantes[];
	String nombres[];
	int eleccion;
	
	public void iniciar () {
		String menu = "Bienvenido al sistema de estudiantes, elige una opción:\n\n";
		menu += "1. Meter la info de los alumnos\n";
		menu += "2. Sacar el promedio de las edades\n";
		menu += "3. Quién es/son el/los más viejo/s\n";
		menu += "4. Quién es/son el/los más joven/s\n";
		menu += "5. Los estudiantes adultos\n";
		menu += "6. Buscar a algún alumno por su nombre\n";
		menu += "7. Buscar a algún alumno por su edad\n";
		menu += "8. Salir\n";

		   
		do {
			eleccion = Integer.parseInt(JOptionPane.showInputDialog(menu));
			switch (eleccion) {
				case 1:
					ingresarEstudiantes();
					break;
				case 2:
					if (nombres != null) {
						PromEd(edadesEstudiantes);
					} else {
						System.out.println("Primero debe ingresar los estudiantes.");
					}
					break;
				case 3:
					if (nombres != null) {
						EstMayor(edadesEstudiantes);
					} else {
						System.out.println("Primero debe ingresar los estudiantes.");
					}
					break;
				case 4:
					if (nombres != null) {
						Estmenor(edadesEstudiantes);
					} else {
						System.out.println("Primero debe ingresar los estudiantes.");
					}
					break;
				case 5:
					if (nombres != null) {
						Adultos(edadesEstudiantes);
					} else {
						System.out.println("Primero debe ingresar los estudiantes.");
					}
					break;
				case 6:
					if (nombres != null) {
						NombreBuscar(nombres);
					} else {
						System.out.println("Primero debe ingresar los estudiantes.");
					}
					break;
				case 7:
					if (nombres != null) {
						EdadBuscar(edadesEstudiantes);
					} else {
						System.out.println("Primero debe ingresar los estudiantes.");
					}
					break;
				default:
					break;
			}
		} while (eleccion != 8);
	}
	public void ingresarEstudiantes() {
	    int cantidadEstudiantes = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de estudiantes a registrar:"));
	    nombres = new String[cantidadEstudiantes];
	    edadesEstudiantes = new int[cantidadEstudiantes];
	    
	    for (int i = 0; i < cantidadEstudiantes; i++) {
	        nombres[i] = JOptionPane.showInputDialog("Ingrese el nombre del estudiante " + (i+1) + ":");
	        edadesEstudiantes[i] = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la edad de " + nombres[i] + ":"));
	    }
	    
	    JOptionPane.showMessageDialog(null, "Datos ingresados correctamente.");
	}
	
	public void PromEd(int[] ages) {
	    double sumaEdades = 0;
	    for (int edad : ages) {
	        sumaEdades += edad;
	    }
	    double promedio = sumaEdades / ages.length;
	    JOptionPane.showMessageDialog(null, "El promedio de edades es: " + promedio);
	}

	public void EstMayor(int[] ages) {
	    int mayor = 0;
	    for (int i = 0; i < ages.length; i++) {
	        if (ages[i] > mayor) {
	            mayor = ages[i];
	        }
	    }
	    System.out.println("El/los estudiantes con mayor edad son:");
	    for (int i = 0; i < ages.length; i++) {
	        if (ages[i] == mayor) {
	            System.out.println(nombres[i] + " con " + ages[i] + " años.");
	        }
	    }
	}
	
	public void Estmenor(int[] ages) {
	    int minAge = Integer.MAX_VALUE;
	    for (int i = 0; i < ages.length; i++) {
	        if (ages[i] < minAge) {
	            minAge = ages[i];
	        }
	    }
	    
	    System.out.println("El/los estudiante(s) con la(s) menor(es) edad(es):");
	    for (int i = 0; i < ages.length; i++) {
	        if (ages[i] == minAge) {
	            System.out.println(nombres[i] + " - " + edadesEstudiantes[i] + " años");
	        }
	    }
	}

	public void Adultos(int[] edades) {
	    System.out.println("Estudiantes mayores de edad:");
	    for (int i = 0; i < edades.length; i++) {
	        if (edades[i] >= 18) {
	            System.out.println(nombres[i]);
	        }
	    }
	}
	
	public void NombreBuscar(String[] nombres) {
	    String nombreBuscado = JOptionPane.showInputDialog("Ingrese el nombre del estudiante que desea buscar:");
	    boolean encontrado = false;
	    for (int i = 0; i < nombres.length; i++) {
	        if (nombres[i].equals(nombreBuscado)) {
	            JOptionPane.showMessageDialog(null, "El estudiante " + nombres[i] + " se encuentra en la posición " + (i+1));
	            encontrado = true;
	        }
	    }
	    if (!encontrado) {
	        JOptionPane.showMessageDialog(null, "No se encontró ningún estudiante con el nombre ingresado.");
	    }
	}

	public void EdadBuscar(int[] edades) {
	    int edadBuscada = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la edad del estudiante que desea buscar:"));
	    boolean encontrado = false;
	    for (int i = 0; i < edades.length; i++) {
	        if (edades[i] == edadBuscada) {
	            JOptionPane.showMessageDialog(null, "El estudiante con edad " + edades[i] + " se encuentra en la posición " + (i+1) + " llamado " + nombres[i]);
	            encontrado = true;
	        }
	    }
	    if (!encontrado) {
	        JOptionPane.showMessageDialog(null, "No se encontró ningún estudiante con la edad ingresada.");
	    }
	}



}
