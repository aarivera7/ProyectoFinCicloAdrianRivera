/*
 * Ejercicio #2
 * Leer dos matrices 5x5 enteras y determinar si el promedio entero de los números
 * mayores de cada fila de una matriz es igual al promedio de los números mayores 
 * de cada fila de la otra matriz.
 */
package proyectofinalciclo;
import java.util.Scanner;

/**
 * @author Adrián Alessandro Rivera Cueva
 */
public class Ejercicio2 {
    //Se crea el obejeto Scanner como variable global para utilizarlo en todos los metodos
    public static Scanner leer = new Scanner(System.in);
    
    public static void main(String[] args) {
        //Declaración e inialización de varibles
        int n = 5, promedioA, promedioB;
        
        System.out.println("Programa que saca el promedio entero de los mayores números de las filas de una ");
        System.out.println("matriz y compara el promedio de otra matriz");
        
        //Se crean las matrices
        int A[][] = new int [n][n];
        int B[][] = new int [n][n];
        
        //Se rellenan las matrices con los datos proporcionados por el usuario
        System.out.println("Ingrese los datos de la Matriz A");
        A = llenarMatriz(A, "A");
        System.out.println("\nIngrese los datos de la Matriz B");
        B = llenarMatriz(B, "B");
        
        //Se muestran las matrices
        System.out.println("\nMatriz A");
        ImprimirMatriz(A);
        System.out.println("Matriz B");
        ImprimirMatriz(B);
        
        //Se calcula el promedio de los mayores de todas las filas de la matriz
	promedioA = promedioMayoresFilas(A);
	promedioB = promedioMayoresFilas(B);
        System.out.println();
        
        //Se comprueba que el promedio de los mayores de las filas de las 2 matrices sean iguales
        if(promedioA == promedioB){
            System.out.println("El promedio entero de los mayores de las filas de las matrices son iguales");
            System.out.println("Promedio entero de los mayores de las filas de la matriz A es: "+promedioA);
            System.out.println("Promedio entero de los mayores de las filas de la matriz B es: "+promedioB); 
	}else{
            System.out.println("El promedio entero de los mayores de las filas de las matrices no son iguales");
            System.out.println("Promedio entero de los mayores de las filas de la matriz A es: "+promedioA);
            System.out.println("Promedio entero de los mayores de las filas de la matriz B es: "+promedioB);
	}
    }
    
    /**
     * A traves de este metodo se ingresan los datos de tipo entero a la matriz.
     * @param M A travez de este parámetro se envia la matriz a rellenar
     * @param S A travez de este parámetro se envia el nombre de la matriz
     * @return Se devuelve la matriz con los datos ingresados por el usuario
     */
    public static int[][] llenarMatriz(int M[][], String S){
        //Con este bucle se pide al usuario que ingrese los datos a la matriz
        for(int i = 0; i < M.length; i++){
            for(int j = 0; j < M[0].length; j++){
                System.out.print("Escriba el valor de la posición "+S+"["+i+"]["+j+"] = ");
                M[i][j] = leer.nextInt();
            }
        }return M;
    }
    
    /**
     * Este metodo saca el mayor de cada fila para luego sacar el promedio de los 
     * mayores de las filas de la matriz.
     * @param M Se envia la matriz para sacr el promedio de los mayores de las filas.
     * @return Devuelve el promedio de los mayores de las filas.
     */
    public static int promedioMayoresFilas(int M[][]){
        //Declaración e inialización de varibles
        int mayor, promedio = 0;
        
        //Con este ciclo se busca los mayores de cada fila y se va sacando el promedio
        for(int i = 0; i < M.length; i++){
            mayor = M[i][0];
            for(int j = 0; j < M.length; j++){
                if(M[i][j] > mayor){
                    mayor = M[i][j];
                }
            }
            promedio += mayor;
        }
        promedio /= M.length;
        return promedio;
    }
    
    /**
     * Con este metodo se manda a imprimir la matriz que fue enviada como parametro
     * @param A Con este parámetro se manda la matriz a imprimir
     */
    public static void ImprimirMatriz(int A[][]){
        for(int i = 0;i < A.length;i++){
            for(int j = 0;j < A[0].length;j++){
                System.out.print("["+A[i][j]+"]");
            }
            System.out.println();
        }System.out.println();
    }
}
