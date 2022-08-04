
package planilla;

import java.util.*;

/**
 *
 * @author Jakke
 */
public class InfoEmpleado extends TipoEmpleado {

    ArrayList<InfoEmpleado> listaEmpleados = new ArrayList();
    
    Scanner teclado = new Scanner(System.in);
    
    int numCed;
    String nom;
    String ape;
    int modifica;
    int i;
    
    
    // getters & setters
    public int getNumCed() {
        return numCed;
    }

    public void setNumCed(int numCed) {
        this.numCed = numCed;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getApe() {
        return ape;
    }

    public void setApe(String ape) {
        this.ape = ape;
    }

//-------------------------------------------------------------------------------------------    
    public void AgregarEmpleado(ArrayList<InfoEmpleado> listaEmpleados) {
        InfoEmpleado empleado1 = new InfoEmpleado();
        boolean continuar = true;
        while (continuar) {
            try {
                System.out.println("Digite el numero cedula");
                numCed = teclado.nextInt();
                empleado1.setNumCed(numCed);
                System.out.println("Digite el nombre del colaborador");
                nom = teclado.next();
                empleado1.setNom(nom);
                System.out.println("Digite el apellido del colaborador");
                ape = teclado.next();
                empleado1.setApe(ape);
                System.out.println("Digite el tipo de colaborador");
                tipoEmpleado = teclado.next();
                empleado1.setTipoEmpleado(tipoEmpleado);
                System.out.println("Digite el salario base del colaborador (debe ser mayor a 75.000)");
                salBase = teclado.nextDouble();
                empleado1.setSalBase(salBase);
                if (salBase <= 75000) {
                    System.out.println("El salario base no puede ser menor o igual a 75000");
                    System.out.println("Ingrese el salario base del empleado a registrar, este debe ser mayor a 75.000");
                    salBase = teclado.nextDouble();
                    empleado1.setSalBase(salBase);
                }
                continuar = false;
                listaEmpleados.add(empleado1);
                System.out.println("Se guardo con exito el colaborador");
            } catch (InputMismatchException e) {
                teclado.next();
                System.out.println("Los datos no validos.");
            }
        }
    }
    
//-------------------------------------------------------------------------------------------
    public void ModificarDatos(ArrayList<InfoEmpleado> listaEmpleados) {
        boolean continuar = true;
        System.out.println("** Lista de Colaboradores **");
        for (i = 0; i < listaEmpleados.size(); i++) {
            System.out.println("#" + i + ":" + listaEmpleados.get(i));
        }
        while (continuar) {
            try {
                System.out.println("Digite el numero de colaborador que desea modificar: ");
                modifica = teclado.nextInt();
                continuar = false;
            } catch (InputMismatchException e) {
                teclado.next();
                System.out.println("Elija numero de colaborador correcto");
            }
        }
        continuar = true;
        while (continuar) {
            try {
                System.out.println("""
                                   Digite la opcion a modificar: 
                                    1 - Número Cédula: 
                                    2 - Nombre: 
                                    3 - Apellido: 
                                    4 - Tipo de colaborador: 
                                    5 - Salario base: """);
                int modificarDato = teclado.nextInt();
                switch (modificarDato) {
                    case 1:
                        System.out.println("Indique la nueva cédula");
                        int nuevaCed = teclado.nextInt();
                        listaEmpleados.get(modifica).setNumCed(nuevaCed);
                        break;
                    case 2:
                        System.out.println("Indique el nuevo nombre");
                        String nuevoNom = teclado.next();
                        listaEmpleados.get(modifica).setNom(nuevoNom);
                        break;
                    case 3:
                        System.out.println("Indique el nuevo apellido");
                        String nuevoApe = teclado.next();
                        listaEmpleados.get(modifica).setApe(nuevoApe);
                        break;
                    case 4:
                        System.out.println("Digite el tipo de colaborador deseado");
                        String nuevoTipoEmpleado = teclado.next();
                        listaEmpleados.get(modifica).setTipoEmpleado(nuevoTipoEmpleado);
                        break;
                    case 5:
                        System.out.println("Digite el salario base");
                        Double nuevoSalario = teclado.nextDouble();
                        listaEmpleados.get(modifica).setSalBase(nuevoSalario);
                        if (nuevoSalario <= 75000) {
                            System.out.println("El salario base no puede ser inferior a 75000");
                            System.out.println("Digite el salario base del colaborador, este debe ser mayor a 75.000");
                            nuevoSalario = teclado.nextDouble();
                            listaEmpleados.get(modifica).setSalBase(nuevoSalario);
                        }
                        break;
                }
                continuar = false;
            } catch (InputMismatchException e) {
                teclado.next();
                System.out.println("Digito un dato incorrecto");
            }
        }
        System.out.println("1 - Número de Cédula: " + listaEmpleados.get(modifica).getNumCed()
                + "\n 2 - Nombre: " + listaEmpleados.get(modifica).getNom()
                + "\n 3 - Apellido: " + listaEmpleados.get(modifica).getApe()
                + "\n 4 - Tipo de empleado: " + listaEmpleados.get(modifica).getTipoEmpleado()
                + "\n 5 - Salario base: " + listaEmpleados.get(modifica).getSalBase());
    }
    
//-----------------------------------------------------------------------------------------------    
    
    public void CambiarSalario(ArrayList<InfoEmpleado> listaEmpleados) {
        boolean continuar = true;
        System.out.println("** Lista de Colaboradores **");
        for (i = 0; i < listaEmpleados.size(); i++) {
            System.out.println("#" + i + ":" + listaEmpleados.get(i));
        }
        while (continuar) {
            try {
                System.out.println("Digite a cual colaborador desea cambiarle el salario base");
                int modificarSalario = teclado.nextInt();
                System.out.println("Digite el nuevo monto de salario base");
                double nuevoSalarioBase = teclado.nextDouble();
                listaEmpleados.get(modificarSalario).setSalBase(nuevoSalarioBase);
                if (nuevoSalarioBase < 70000) {
                    System.out.println("El salario base no puede ser inferior a 70000");
                    System.out.println("Digite el salario base del colaborador, este debe ser mayor a 70.000");
                    nuevoSalarioBase = teclado.nextDouble();
                    listaEmpleados.get(modificarSalario).setSalBase(nuevoSalarioBase);
                }
                System.out.println("Se ha guardado el numero salario base");
                System.out.println("1) Cédula: " + listaEmpleados.get(modificarSalario).getNumCed()
                        + "\n 2) Nombre: " + listaEmpleados.get(modificarSalario).getNom()
                        + "\n 3) Apellido: " + listaEmpleados.get(modificarSalario).getApe()
                        + "\n 4) Tipo de empleado: " + listaEmpleados.get(modificarSalario).getTipoEmpleado()
                        + "\n 5) Salario base: " + listaEmpleados.get(modificarSalario).getSalBase());
                continuar=false;
            } catch (InputMismatchException e) {
                teclado.next();
                System.out.println("Opción invalida : Elija un número");
            }
        }
    }
    
 //-----------------------------------------------------------------------------------------------     
    public void MostrarEmpleado(ArrayList<InfoEmpleado> listaEmpleados) {
        boolean continuar = true;
        System.out.println("** Lista de empleados **");
        for (i = 0; i < listaEmpleados.size(); i++) {
            System.out.println("#" + i + ":" + listaEmpleados.get(i));
        }
        while (continuar) {
            try {
                System.out.println("Que número de colaborador desea revisar: ");
                int consultar = teclado.nextInt();
                System.out.println("1 - Número de Cédula: " + listaEmpleados.get(consultar).getNumCed()
                        + "\n 2 - Nombre: " + listaEmpleados.get(consultar).getNom()
                        + "\n 3 - Apellido: " + listaEmpleados.get(consultar).getApe()
                        + "\n 4 - Tipo de empleado: " + listaEmpleados.get(consultar).getTipoEmpleado()
                        + "\n 5 - Salario base: " + listaEmpleados.get(consultar).getSalBase());
                continuar = false;
            } catch (InputMismatchException e) {
                teclado.next();
                System.out.println("Opción invalida : Elija un número");
            }
        }

    }
    
 //-----------------------------------------------------------------------------------------------       
   public void gema(ArrayList<InfoEmpleado> listaEmpleados) {
        InfoEmpleado empleado1 = new InfoEmpleado();
        empleado1.setApe("Rutina");
        empleado1.setNumCed(678232222);
        empleado1.setNom("Francisco");
        empleado1.setTipoEmpleado("Operario");
        empleado1.setSalBase(570000);
        listaEmpleados.add(empleado1);

        InfoEmpleado empleado2 = new InfoEmpleado();
        empleado2.setApe("Mora");
        empleado2.setNumCed(102330221);
        empleado2.setNom("Juan");
        empleado2.setTipoEmpleado("Administrador");
        empleado2.setSalBase(400000);
        listaEmpleados.add(empleado2);

        InfoEmpleado empleado3 = new InfoEmpleado();
        empleado3.setApe("Picado");
        empleado3.setNumCed(102800221);
        empleado3.setNom("Jose");
        empleado3.setTipoEmpleado("Administrador");
        empleado3.setSalBase(900000);
        listaEmpleados.add(empleado3);

        InfoEmpleado empleado4 = new InfoEmpleado();
        empleado4.setApe("Martinez");
        empleado4.setNumCed(203654890);
        empleado4.setNom("Joseph");
        empleado4.setTipoEmpleado("Operario");
        empleado4.setSalBase(2750000);
        listaEmpleados.add(empleado4);

        InfoEmpleado empleado5 = new InfoEmpleado();
        empleado5.setApe("Lucas");
        empleado5.setNumCed(59090900);
        empleado5.setNom("Ana");
        empleado5.setTipoEmpleado("Administradora");
        empleado5.setSalBase(800000);
        listaEmpleados.add(empleado5);

        InfoEmpleado empleado6 = new InfoEmpleado();
        empleado6.setApe("Ruiz");
        empleado6.setNumCed(303022445);
        empleado6.setNom("Maria");
        empleado6.setTipoEmpleado("Operaria");
        empleado6.setSalBase(800000);
        listaEmpleados.add(empleado6);

        InfoEmpleado empleado7 = new InfoEmpleado();
        empleado7.setApe("Perez");
        empleado7.setNumCed(10545285);
        empleado7.setNom("Juana");
        empleado7.setTipoEmpleado("Administradora");
        empleado7.setSalBase(465000);
        listaEmpleados.add(empleado7);
    }
 
   //-----------------------------------------------------------------------------------------------   
    
    public void MostrarLista(ArrayList<InfoEmpleado> listaEmpleados) {
        System.out.println("** Lista de Colaboradores** ");
        for (int i = 0; i < listaEmpleados.size(); i++) {
            System.out.println("#" + i + ":" + listaEmpleados.get(i));
        }
    }
    
    //-----------------------------------------------------------------------------------------------  
    
    public void Eliminar(ArrayList<InfoEmpleado> listaEmpleados) {
        boolean continuar = true;
        System.out.println("** Lista de empleados **");
        for (i = 0; i < listaEmpleados.size(); i++) {
            System.out.println("#" + i + ":" + listaEmpleados.get(i));
        }
        while (continuar) {
            try {
                System.out.println("Digite el número de colaborador a eliminar");
                int usuarioEliminar = teclado.nextInt();
                listaEmpleados.remove(usuarioEliminar);
                continuar = false;
            } catch (InputMismatchException e) {
                teclado.next();
                System.out.println("Opción invalida : Elija un número");
            }
        }
        System.out.println("Colaborador eliminado con éxito ");
    }

 //----------------------------------------------------------------------------------------------- 
    
    @Override
    public String toString() {
        return " Número de Cédula: " + numCed +" " +" Nombre: " + nom + " " + " Apellido: " + ape + "| Tipo de Colaborador: "+this.tipoEmpleado +" | Salario base: " +this.salBase;
    }

    
}

    
    

