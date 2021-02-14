/* 
 * Ejercicio #1
 * Leer n números enteros, almacenarlos en un vector y determinar si existe 
 * al menos un número repetido.
 */
package proyectofinalciclo;
import java.util.Scanner;

/**
 * @author Adrián Alessandro Rivera Cueva
 */
public class Ejercicio1 {
    //Se crea el obejeto Scanner como variable global para utilizarlo en todos los metodos
    public static Scanner leer = new Scanner(System.in);
    
    public static void main(String[] args) {
        //Declaración e inialización de variables
        int n, i, k = 0;
        boolean b = false;
        
        System.out.println("Programa que te dice cuantas veces se repite un numero en un vector");
       
        //Se ingresa el tamaño del vector y se verifica que tenga el tamaño apropiado
        System.out.print("Ingrese el tamaño del vector: ");
        do{
            n = leer.nextInt();

            if(n > 1){
                b = true;
            }else{
                System.out.println("Error: El tamaño del vertor no puede ser menor a 2");
                System.out.print("Vuelva a ingresar el tamaño del vector: ");
            }
        }while(!b);  System.out.println();
        
        //Se crea el vector y se ingresa los datos al mismo
        int A[] = new int [n];
        A = llenarVector(A);  System.out.println();
        
        //Se crea el vector que va almacenar los números ya procesados
	int noHacer[] = new int [n];
        
        //Se verifica cuantas veces se encuentra un números en un vector
        for(i = 0; i < n;i++){
            /*Se verifica cuantas veces se encuentra el número y esa 
            cantidad se ingresa en la varible*/
            
            int repetido = vecesRepetido(A, A[i]);
            
            /*Se verifica que el número se repita y que no se vuelva a procesar
            otra vez el mismo número*/
            
            if((repetido > 1) && NoRepetir(A[i], noHacer)){
                System.out.println("El numero "+A[i]+" se encuentra "+repetido+" en la serie");
                
                //Se almacena los números ya contados para no volverlos a mostrar en pantalla
                noHacer[i] = A[i];
                k++;
            }
        }
        //Sino no se encontro número repetidos se manda un mensaje
        if(k == 0){
            System.out.println("No se ha encontrado ningun número repetido");
        }
    }
    
    /**
    * Este metodo recibe un vector y le va pidiendo al usuario que valla 
    * intrduciendo los números en el vector.
    * @param v A travez de este parámetro se pasa el vector para ser rellenado con 
    * los datos proporcionados por el usuario.
    * @return Se devuelve el vector con los datos proporcionados por el usuario
    */
    public static int []llenarVector(int v[]){
        //Este ciclo recorre todo el vector y va pidiendo los datos al usuario
        for(int i = 0; i < v.length;i++){
            System.out.print("Escriba el valor #"+i+" del vector: ");
            v[i] = leer.nextInt();
        }
        return v;
    }
    
    /**
     * Con este metodo se verifica cuantas veces se repite un número en un vector.
     * @param v A travez de este parámetro se manda el vector para encontrar 
     * cuantas veces se repite el número solicitado.
     * @param num A travez de este parámetro se manda el número para encontrar
     * cuantas veces se repite.
     * @return Devuelve cuantas veces se repite el número.
     */
    public static int vecesRepetido(int []v,int num){
        //Declaración e inialización de variables
        int j = 0;
        
        //Este ciclo recorre todo el vector para contar las veces que se repite un número
        for(int i = 0; i < v.length;i++){
            if (v[i] == num){
                j++;
            }
        }return j;
    }
    
    /**
     * Con este metodo recibe un vector con los número ya procesados y el número
     * a verificar si ya fue procesado o no.
     * @param A A travez de este parámetro se ingresa el número a verificar.
     * @param v A travez de este parámetro se ingresa el vector con los números 
     * ya procesados.
     * @return Se devuelve si el número no se procesa, si el número ya se proceso
     * devuelve falso y si no se proceso devuelve verdadero.
     */
    public static boolean NoRepetir(int A,int [] v){
        //Este ciclo recorre todo el vector y verifica si ya se proceso el número
        for(int i = 0; i < v.length;i++){
            if (v[i] == A){
                return false;
            }
        }return true;
    }
}
