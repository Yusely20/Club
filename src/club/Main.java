package club;
import java.util.InputMismatchException;
import java.util.Scanner;
import club.Socio.Tipo;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        int op;
        Club c = new Club();
        c.afiliarSocio("1727509513", "Maria", Tipo.REGULAR);
        c.afiliarSocio("0502451024","Luis",Tipo.VIP);
        c.afiliarSocio("1756645832","Giselle",Tipo.VIP);

        do{
            System.out.println("1. Afiliar un socio al club.");
            System.out.println("2. Registrar una persona autorizada por un socio.");
            System.out.println("3. Pagar una factura.");
            System.out.println("4. Registrar un consumo en la cuenta de un socio");
            System.out.println("5. Aumentar fondos de la cuenta de un socio");
            System.out.println("6. Salir");
            System.out.print("Ingrese una opcion: ");
            op = Integer.parseInt(sc.next());
            switch (op){
                case 1:{
                    System.out.println("---Ingreso de Datos del Socio---");
                    System.out.println("Ingrese el numero de cedula: ");
                    String pCedula = sc.next();
                    System.out.println("Ingrese el nombre: ");
                    String pNombre = sc.next();
                    Tipo pTipo = tipo(sc);
                    try{
                        c.afiliarSocio(pCedula,pNombre,pTipo);
                    } catch (Exception e) {
                        System.out.println("Error al afiliar al socio: " + e.getMessage());
                    }
                }break;
                case 2:{
                    System.out.println("Ingrese el numero de cedula: ");
                    String pCedula = sc.next();
                    System.out.println("Ingrese el nombre de la persona autorizada: ");
                    String pNombre =  sc.next();
                    try {
                        c.agregarAutorizadoSocio(pCedula,pNombre);
                        System.out.println("Registro exitoso");
                    } catch (Exception e){
                        System.out.println("Error de registro de persona autorizada: " + e.getMessage());
                    }

                }break;
                case 3:{
                    System.out.println("Ingrese el numero de cedula: ");
                    String pCedula = sc.next();
                    System.out.println("Ingrese el indice de Factura: ");
                    int pIndice = sc.nextInt();
                    try{
                        c.pagarFacturaSocio(pCedula,pIndice);
                        System.out.println("Pago exitoso");
                    }catch (Exception e){
                        System.out.println("Error de pago: " +  e.getMessage());
                    }

                }break;
                case 4:{
                    System.out.println("Ingrese el numero de cedula: ");
                    String pCedula = sc.next();
                    System.out.println("Ingrese el nombre de la persona que realizo el consumo: ");
                    String pNombreCliente = sc.next();
                    System.out.println("Ingrese el concepto del consumo: ");
                    String pConcepto = sc.next();
                    double pValor = 0;
                    try {
                        System.out.println("Ingrese el valor del consumo: ");
                        pValor = sc.nextDouble();
                        break;
                    }catch (InputMismatchException ime){
                        System.out.println("Valor invalido, se espera un double: " + ime.getMessage());
                        sc.next();
                    }
                    try {
                        c.registrarConsumo(pCedula, pNombreCliente, pConcepto, pValor);
                        System.out.println("Registro exitoso.");
                        break;
                    } catch (Exception e) {
                        System.out.println("Error al registrar el consumo: " + e.getMessage());
                    }

                }break;
                case 5:{
                    System.out.println("Ingrese el numero de cedula: ");
                    String pCedula = sc.next();
                    System.out.println("Ingrese el valor a aumentar: ");
                    double pValor = sc.nextDouble();
                    try {
                        c.aumentarFondosSocio(pCedula, pValor);
                        System.out.println("Aumento exitoso.");
                    } catch (Exception e) {
                        System.out.println("Error al aumentar los fondos: " + e.getMessage());
                    }

                }break;
                case 6:{
                    System.out.println("Gracias!");
                }break;
                default:
                    System.out.println("opcion invalida");
            }

        }while(op!=6);


    }

    public static Tipo tipo (Scanner sc){
        int tipoNum;
        Tipo pTipo = null;
      do{
          try{
              System.out.println("Ingrese el numero tipo: ");
              System.out.println("1. VIP");
              System.out.println("2. REGULAR");
              tipoNum = sc.nextInt();
              if (tipoNum == 1 ) {
                  pTipo = Tipo.VIP;
                  break;
              } else if (tipoNum == 2){
                  pTipo = Tipo.REGULAR;
                  break;
              } else {
                  System.out.println("Ingrese 1 para VIP o 2 para Regular.");
              }
          }catch (InputMismatchException ime){
              System.out.println("Inválido. Ingrese un numero entero");
              sc.next();
          }
      }while (true);
      return pTipo;
    }

}

