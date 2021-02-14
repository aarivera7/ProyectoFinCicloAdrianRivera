/*
 * Ejercicio #3
 * Construir una función que reciba como parámetro un vector de 10 posiciones enteras y retorne la
 * posición en la que se encuentre el mayor número primo que termine en 3 almacenado en el vector.
 */
package proyectofinalciclo;
import java.util.Scanner;
/**
 * @author Adrián Alessandro Rivera Cueva
 */
public class Ejercicio3 {
    //Se crea el obejeto Scanner como variable global para utilizarlo en todos los metodos
    public static Scanner leer = new Scanner(System.in);
    
    public static void main(String[] args) {
        //Declaración e inialización de varibles
        int n = 10, k = 0, mayor;
        
        System.out.println("Programa que te dice el mayor de los números primos terminados en 3 que ingresaste");
        System.out.println("Ingrese 10 números:");
        
        int A[] = new int [n]; //Se crea el vector
        int primos [] = new int [n]; //Se crea el vector que aloja los primos
        
        //Se rellena el vector
        A = llenarVector(A);
        
        //Se comprueba que el número sea primo y termine en 3
        for(int i = 0; i < n;i++){
            if(Primo(A[i])){  //Se comprueba que el número sea primo
                if(A[i] % 10 == 3){  //Si el número es primo se comprueba si termina en 3
                    primos[i] = A[i];
                    k++;
                }
            }
        }
        //Se muestra el número que cumplio las condiciones
        if(k > 0){
            mayor = MayorVector(primos);
            System.out.println("El número mayor, primo y terminado en 3 del vector es: "+ mayor);
            System.out.println("Que se encuentra en la posición: "+posicionVector(A, mayor));
        }//Se manda un mensaje de que no se encontro ningun número que cumpliera las condiciones
        else{
            System.out.println("No se encontro ningún número primo terminado en 3");
        }
    }
        
    /**
    * Este metodo recibe un vector y le va pidiendo al usuario que valla 
    * intrduciendo los números en el vector.
    * @param v A travez de este parámetro se pasa el vector para ser rellenado con 
    * los datos proporcionados por el usuario.
    * @return Se devuelve el vector con los datos proporcionados por el usuario.
    */
    public static int []llenarVector(int v[]){
        //Este ciclo recorre todo el vector y va pidiendo los datos al usuario
        for(int i = 0; i < v.length;i++){
            System.out.print("Escriba el valor de #"+i+" del vector: ");
            v[i] = leer.nextInt();
        }
        return v;
    }
    
    /**
     * Con este metodo se verifica si un número es primo o no.
     * @param num Con este parámetro se ingresa el número que se quiere averiguar
     * si es primo o no.
     * @return Devuelve un valor booleano en donde si el número es primo se manda
     * true y si no se manda false.
     */
    public static boolean Primo(int num){
        //Declaración e inialización de varibles
        int div = 0;
        
        /*Con este bucle se divide el número con todos sus números anteriores 
        para comprobar que sea primo*/
        for(int i = 1; i <= num; i++){
            if(num % i == 0){
                div++;
            }
        }//Si solo tiene 2 divisores el número es primo de lo contrario no.
        return div == 2;
    }
    
    /**
     * Con este metodo se busca el mayor de un vector.
     * @param V Con este parámetro se manda el vector donde se va a buscar el mayor.
     * @return Se devuelve el número mayor del vector.
     */
    public static int MayorVector(int []V){
        //Declaración e inialización de varibles
        int mayor = V[0];
        
        //Con este ciclo se busca al mayor del vector
        for(int i = 0; i < V.length; i++){
            if(V[i] > mayor){
                mayor = V[i];
            }
        }return mayor;
    }
    
    /**
     * Con este metodo se puede buscar en que posición se encuentra un número en un vector.
     * @param V A traves de este parámetro se envia el vector donde se va a buscar.
     * @param num Con este parámetro se envia el número que se quiere saber la posición.
     * @return Se devuelve la posición en que se encuentra el número, en caso de no 
     * encontrarse el número en el vector se enviara un -1.
     */
    public static int posicionVector(int V[],int num){
        //Con este bucle se busca la posición del número
        for(int i = 0; i < V.length;i++){
            if(num == V[i]){
                return i;
            }
        }return -1;
    }
}
