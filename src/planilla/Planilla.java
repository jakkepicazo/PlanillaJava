
package planilla;

import java.util.*;

/**
 *
 * @author Jakke
 */
public class Planilla {


    public static void main(String[] args) {
        

        
        ArrayList<InfoEmpleado> listaEmpleados = new ArrayList();
        
        Scanner teclado = new Scanner(System.in);
        
        InfoEmpleado empleado1 = new InfoEmpleado();
        
       int opc = 1, resp = 0;
 
        boolean fin = false;
    
     
   while(!fin){    
            System.out.println("** Bienvenidos al menú planilla ** ");
            System.out.println("\n1 - Ingresar nuevo empleado");
            System.out.println("2 - Listar empleados");
            System.out.println("3 - Modificar un empleado");
            System.out.println("4 - Borrar un empleado");
            System.out.println("5- Mostrar información de un empleado");
            System.out.println("6- Ajustar salario base empleado");
            System.out.println("0- Salir del sistema");
            
            try {
                System.out.println("Digite la opción de su preferencia:");
                opc = teclado.nextInt();

                switch (opc) {
                    case 1:
                        System.out.println("Has elegido la 1era opción | Ingresar nuevo colaborador\n");
                        
                        if (listaEmpleados.size() >= 10) {
                                System.out.println("Ya no hay espacio disponible");
                            } else {
                                empleado1.AgregarEmpleado(listaEmpleados);
                                break;
                            }
                        
                        
                        break;

                    case 2:
                        System.out.println("Has elegido la 2da opción | Lista de Colaboradores");
                        
                        if (listaEmpleados.size() <= 0) {
                                System.out.println("No se agrego ningún empleado ");
                            } else {
                                empleado1.MostrarLista(listaEmpleados);
                            }
                            break;

                    case 3:
                        System.out.println("Has elegido la 3era opción | Modificar un empleado");
                        
                         if (listaEmpleados.size() <= 0) {
                                System.out.println("No posee ningun empleado");
                            } else {
                                empleado1.ModificarDatos(listaEmpleados);
                            }
                            break;

                    case 4:
                        System.out.println("Has elegido la 4ta opción | Borrar un empleado ");
                        
                        if (listaEmpleados.size() <= 0) {
                                System.out.println("No posee ningun empleado agregado");
                            } else {
                                empleado1.Eliminar(listaEmpleados);
                            }
                        break;
                        
                    case 5:
                        System.out.println("Has elegido la 5ta opción | Mostrar información de un empleado");
                        
                        if (listaEmpleados.size() <= 0) {
                                System.out.println("No posee ningun empleado agregado");
                            } else {
                                empleado1.MostrarEmpleado(listaEmpleados);
                            }
                        break;
                        
                    case 6:
                        System.out.println("Has elegido la 6ta opción | Ajustar salario base del empleado");
                        
                        if (listaEmpleados.size() <= 0) {
                                System.out.println("No posee ningun empleado agregado");
                            } else {
                                empleado1.CambiarSalario(listaEmpleados);
                            }
                            break;
                        
                    case 0:
                        
                        fin = true;
                        break;
                        
                    default:
                        System.out.println("Digito una opción invalida | Digite una opción entre 0 - 6");
                        break;
                }//switch
            }//try
            catch (InputMismatchException e) {
                System.out.println(" ERROR detectado | Digite una opción entre 0 - 6");
                teclado.next();
            }//catch
        }//while
        System.out.println("Fin del menú");
        
        

        
    }
    
}
