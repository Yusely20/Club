package club;
import java.util.InputMismatchException;
import java.util.Scanner;
import club.Socio.Tipo;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        int op;
        Club c = new Club();
        c.afiliarSocio("1727509513", "Maria", Tipo.REGULAR);
        c.afiliarSocio("0502451024","Luis",Tipo.VIP);
        c.afiliarSocio("1756645832","Giselle",Tipo.VIP);

        do{
            String pCedula;
            String pNombre;
            double pValor = 0;
            System.out.println("1. Afiliar un socio al club.");
            System.out.println("2. Registrar una persona autorizada por un socio.");
            System.out.println("3. Pagar una factura.");
            System.out.println("4. Registrar un consumo en la cuenta de un socio");
            System.out.println("5. Aumentar fondos de la cuenta de un socio");
            System.out.println("6. Salir");
            System.out.print("Ingrese una opcion: ");
            op = Integer.parseInt(scan.next());
            switch (op) {
                case 1:
                    do {
                        System.out.println("Ingrese el numero de cedula: ");
                        pCedula = scan.next();
                        try {
                            if (Character.isDigit((char) Float.parseFloat(pCedula))) ;
                            {
                                break;
                            }
                        } catch (Exception e) {
                            System.out.println("Ingrese solo numeros en la cedula!!");
                        }
                    } while (true);
                    System.out.println("Ingrese el nombre: ");
                    pNombre = scan.next();
                    Tipo pTipo = tipo(scan);
                    try {
                        c.afiliarSocio(pCedula, pNombre, pTipo);
                        System.out.println("Afiliación exitosa!");
                    } catch (Exception e) {
                        System.out.println("No se pudo afiliar al socio: " + e.getMessage());
                    }
                    break;
                case 2:
                    System.out.println("Ingrese el numero de cedula del socio: ");
                    pCedula = scan.next();
                    System.out.println("Ingrese el nombre de la persona autorizada: ");
                    pNombre = scan.next();
                    try {
                        c.agregarAutorizadoSocio(pCedula, pNombre);
                        System.out.println("Registro exitoso");
                    } catch (Exception e) {
                        System.out.println("Error de registro de persona autorizada: " + e.getMessage());
                    }
                    break;
                case 3:
                    System.out.println("Ingrese el numero de cedula: ");
                    pCedula = scan.next();
                    System.out.println("Ingrese el indice de Factura: ");
                    int pIndice = scan.nextInt();
                    try {
                        c.pagarFacturaSocio(pCedula, pIndice);
                        System.out.println("Pago exitoso");
                    }catch (IndexOutOfBoundsException iobe){
                        System.out.println("No existe ninguna factura");
                    }catch (Exception e){
                        System.out.println("Error de pago: " +  e.getMessage());
                    }
                    break;
                case 4:
                    System.out.println("Ingrese el numero de cedula: ");
                    pCedula = scan.next();
                    System.out.println("Ingrese el nombre de la persona que realizo el consumo: ");
                    String pNombreCliente = scan.next();
                    System.out.println("Ingrese el concepto del consumo: ");
                    String pConcepto = scan.next();
                    try {
                        System.out.println("Ingrese el valor del consumo: ");
                        pValor = scan.nextDouble();
                    }catch (InputMismatchException ime){
                        System.out.println("Valor invalido, se espera un double: " + ime.getMessage());
                        scan.next();
                        pValor = 0;
                    }
                    try {
                        c.registrarConsumo(pCedula, pNombreCliente, pConcepto, pValor);
                        System.out.println("Registro exitoso.");
                        break;
                    } catch (Exception e) {
                        System.out.println("Error al registrar el consumo: " + e.getMessage());
                    }
                    break;
                case 5:
                    System.out.println("Ingrese el numero de cedula: ");
                    pCedula = scan.next();
                    System.out.println("Ingrese el valor a aumentar: ");
                    pValor = scan.nextDouble();
                    try {
                        c.aumentarFondosSocio(pCedula, pValor);
                        System.out.println("Aumento exitoso.");
                    } catch (Exception e) {
                        System.out.println("Error al aumentar los fondos: " + e.getMessage());
                    }
                    break;
                case 6:
                    System.out.println("Gracias!");
                break;
                default:
                    System.out.println("opcion invalida");
            }
        }while(op!=6);
    }
    public static Tipo tipo (Scanner scan){
        int tipoNum;
        Tipo pTipo;
      do{
          try{
              System.out.println("Ingrese el numero tipo: ");
              System.out.println("1. VIP");
              System.out.println("2. REGULAR");
              tipoNum = scan.nextInt();
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
              scan.next();
          }
      }while (true);
      return pTipo;
    }

}

