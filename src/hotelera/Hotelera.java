/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelera;
import java.io.BufferedReader;
import java.io.InputStreamReader;
/**
 *
 * @author edosi_000
 */
public class Hotelera {
   
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       int matrimonial [] = new int[4];
       int Doble[] = new int[3];
       int Simple[] = new int[3]; 
       boolean estado = false;
        do{
            Menu();
            estado = Opcion(estado, matrimonial,Doble,Simple);
          }while(estado != true);
    }
    
    public static void Menu(){
        System.out.println("");
        System.out.println("MENU");
        System.out.println("____________________________________");
        System.out.println("1 - Estado de habitación");
        System.out.println("2 - Estado del Hotel");
        System.out.println("3 - Reiniciar Hotel");
        System.out.println("4 - Salir");
        System.out.println("");
      
    }
    public static int Leer (int x){ 
       boolean estado = true;
       BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
        do{
            try{
                 x = Integer.parseInt(leer.readLine());
                 estado = true;
                }catch(Exception e){
                      System.out.println("Error! Ingrese sólo números");
                      estado = false;
                                   }
          }while(estado== false);
    return x;
    }
    
    public static boolean Opcion (boolean estado, int m[], int d[] , int s[]){
       int opc = 0; 
       estado = false;
       do{
         opc = Leer(opc);
         if(opc <1 || opc>4){
                 System.out.println("Error, limitarse a las opciones (1 a 4)");
            }
        }while(opc<1 ||opc>4);
        
       switch(opc){
            case 1: Menu2(); Opcion2(m, d, s); break;
            case 2: Disponibilidad(m,d,s);break;  
            case 3: Reiniciar(m,d,s);break; 
            case 4: System.out.println("¿Desea Salir del programa?");
                    if(OpcionSiNo(estado) == true){
                        estado = true;
                        System.out.println("Adios!!");};break;    
            default: break;
      
       }
    return estado;
    }
   
    
     public static void Menu2 (){
        System.out.println("Elija tipo de habitación");
        System.out.println("1 = Matrimonial");
        System.out.println("2 = Doble");
        System.out.println("3 = Simple");
        System.out.println("4 = Volver al Menu");
    }
    public static void Opcion2(int m [], int d [], int s []){
        int op =0, matri = 1, dob = 2, sim = 3;
        do{
          op = Leer(op);
          if(op <1 || op>4){
              System.out.println("Error, limitarse a las opciones (1 a 4)");
            }    
        }while(op<1 || op>4);
    
    switch(op){
        case 1: Habitaciones(m,matri);break;
        case 2: Habitaciones(d, dob);break;
        case 3: Habitaciones(s, sim);break;    
        case 4: break;    
        default:break;    
            }
    }
    public static void Habitaciones(int x [], int tipo){
        int habit = 0;
        boolean op =false;
        System.out.println("");
        System.out.println("Existen "+(x.length)+" habitaciones");
        System.out.println("Elija habitación");
        for (int i = 0; i < x.length; i++) {
            System.out.println((i+1)+"° - Habitación");
        }
        do{
            habit = Leer(habit);
            if(habit <1 || habit>x.length){
                System.out.println("Error, limitarse a las opciones (1 a "+x.length+")");
             }
          }while(habit<1 || habit>x.length);        
        System.out.println("El estado de la habitación "+habit+ " es: "+ Estado(x, habit));  
        if(x[habit-1] == 1 || x[habit-1]==2 ){
                System.out.println("Desea cambiar de Estado?");
                op  = OpcionSiNo(op);
            if(op == true){
                llenado(x, habit, tipo);
            }
        }else {llenado(x, habit, tipo);}
    }
    public static String Estado(int x[] , int habit){
        String disp = "Disponible";
        String ocup = "Ocupada" ;
        String reserv = "Reservada";
        if(x[habit-1]==0){
             return disp;
            }else
                  if(x[habit-1]==1){
                      return ocup;
                } else
                      return reserv;
    }
    public static void llenado (int x[] , int habit, int tipo){
        int noche = 0;
        int estado = 0;
        do{
            System.out.println("Introduzca nuevo estado");
            System.out.println("1 = Disponible");
            System.out.println("2 = Ocupada");
            System.out.println("3 = Reservada");
            estado = Leer(estado);
            if(estado <1 || estado>3){
                System.out.println("Error, limitarse a las opciones (1 a 3)");
             }
        }while(estado<1 || estado>3);
        x[habit-1]= (estado-1);
        if(estado== 2 || estado == 3){
            Boleta(x,habit,tipo,Noches(noche));
        }
    }
    public static int Noches(int c){
        do{
        System.out.println("Ingrese cantidad de noches");
        c = Leer(c);
        }while(c<1);
        return c;
    }
    public static void Boleta (int [] x, int habit, int tipo, int noche){
        System.out.println("____________________________________________________________________");
        System.out.println("BOLETA");
        System.out.println("____________________________________________________________________");
        int precio = 0;
        if(tipo == 1){
            System.out.println("Habitación "+habit+" Matrimonial "+Estado(x,habit));
            System.out.println("");
            System.out.println("Precio por noche $ 60.000");
            precio = 60000;
           }else
             if(tipo == 2){
                 System.out.println("Habitación "+habit+" Doble "+Estado(x,habit));
                 System.out.println("");
                 System.out.println("Precio por noche $ 50.000");
                 precio = 50000;
                } else{
                    System.out.println("Habitación "+habit+" Simple "+Estado(x,habit));
                    System.out.println("");
                    System.out.println("Precio por noche $ 40.000");
                    precio = 40000;
            }
        System.out.println("Cantidad de noches adquiridas "+noche);
        System.out.println("Total a pagar : $"+(precio * noche));
    }
    public static void Disponibilidad(int[] m, int [] d, int s[]){
        boolean estado = false;
        System.out.println("Estado del Hotel");
        System.out.println("Habitaciones Disponibles:");
        System.out.println("");
        System.out.println("Matrimoniales:");
        HabitDisp(m);
        System.out.println("");
        System.out.println("Dobles:");
        HabitDisp(d);
        System.out.println("");
        System.out.println("Simples:");
        HabitDisp(s);
        System.out.println("");
        System.out.println("¿Desea registrar una habitación?");
        if(OpcionSiNo(estado)==true){
        Menu2(); Opcion2(m, d, s);
        }
        }
    public static void HabitDisp(int[]x){
        int cont = 0;
        for (int i = 0; i < x.length; i++) {
            if(x[i]== 0){
                System.out.println("Habitación "+(i+1));
                cont ++;
            }
        }
        if(cont == 0){
            System.out.println(" No quedan disponibles");
        }
    }
    public static void Reiniciar(int m[], int d[], int s[]){
        int [] clave = new int [4];
        int c = 0;
        
        System.out.println("Ingrese clave de 4 Dígitos");
        for (int i = 0; i < 4; i++) {
            System.out.println("Ingrese "+(i+1)+"° dígito");
            clave[i] = Leer(c); 
        }
        if(clave[0] == 1 && clave[1]==2 && clave[2]==3 && clave[3]== 4){ 
        for (int i = 0; i < m.length; i++) {
            m[i]=0;
            if(i!=3){
            d[i]=0;
            s[i]=0;
            }
        }
        System.out.println("----------------------------------------------------------");
        System.out.println("Hotel Reiniciado;");
        }  else
            System.out.println("Clave Incorrecta");
    }
    public static boolean OpcionSiNo(boolean x){
        int op=0;
        boolean estado = false;
        do{
            System.out.println("1 = SI / 2 = NO");
            op = Leer(op);
            if(op<1 || op>2){
            System.out.println("Error, limitarse a las opciones (1 ó 2)");
            }
        }while(op<1 || op>2);
        if(op==1){
        estado = true;}
        return estado;
    }
    }

    
   
    

