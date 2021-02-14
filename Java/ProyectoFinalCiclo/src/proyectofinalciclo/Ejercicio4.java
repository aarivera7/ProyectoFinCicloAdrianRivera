/*
 * Ejercicio #4
 * Realice un algoritmo que dada una matriz de tamaño 2n*2n intercambie el primer
 * cuadrante con el tercero y el segundo con el cuarto.
 */
package proyectofinalciclo;
import java.util.Scanner;

/**
 * @author Adrián Alessandro Rivera Cueva
 */
public class Ejercicio4 {
    //Se crea el obejeto Scanner como variable global para utilizarlo en todos los metodos
    public static Scanner leer = new Scanner(System.in);
    
    public static void main(String[] args) {
        //Declaración de la varible que va a contener el tamaño de los cuadrantes de la matriz
        int n;
        
        System.out.println("Programa que te crea una matriz 2n * 2n de cuatro cuadrantes y "
                + "remplaza el primer cuadrante con el tercero y el segundo con el cuarto");
        
        //Se ingresa el tamaño del cuadrante de la matriz
        System.out.println("Ingrese el tamaño que van a tener los cuadrantes de la matriz");
        n = leer.nextInt();
        
        //Se crea la matriz
        int A[][] = new int [2*n][2*n];
        
        //Se manda a rellenar los cuadrantes de la matriz
        A = llenarMatrizCuadrante(A, n);
        
        //Se muestra la matriz original
        System.out.println("\nMatriz Original");
        ImprimirMatriz(A);
        
        //Se manda a remplazar los cuadrantes de la matriz 
        A = cambiarCuadrantes(A);
        
        //Se muestra la matriz con los cuadrantes remplazados
        System.out.println("Matriz con los cuadrantes remplazados");
        ImprimirMatriz(A);
    }
    
    /**
    * Este metodo recibe una matriz 2n * 2n para dividirla en cuatro cuadrantes
    * en la que cada cuadrante tiene un tamaño de n y en cada cuadrante es 
    * rellenado con un solo valor que es proporcionado por el usuario
    * @param M mediante este parámetro se recibe la matriz para rellenarla
    * @param n mediante este parámetro se recibe el tamaño de cada cuadrante
    * @return La función devuelve la matriz rellenada con su repectivos valores en 
    * sus cuadrantes
    */
    public static int[][] llenarMatrizCuadrante(int M[][],int n){
     //Declaración e inialización de varibles
     int c = 0;
     //Con este bucle se recorre los cuadrantes de la matriz
        for(int i = 0; i < 2*n; i+=n){
            for(int j = 0; j < 2*n; j+=n){
                c++;
                System.out.println("Ingrese el número del cuadrante #"+c);
                M[i][j] = leer.nextInt();
                
             //Con este ciclo se rellena cada cuadrante con el valor proporcionado
                for(int k = i; k < n+i; k++){
                    for(int l = j; l < n+j; l++){
                        M[k][l] = M[i][j];
                    }
                }
            }
        }return M;
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
    
    /**
     * Este metodo recibe una matriz de tamaño 2n * 2n con cuatro cuadrante, a estos
     * cuadrantes se remplaza el primer cuadrante con el tercero y el segundo 
     * con el cuarto.
     * @param M Se recibe la matriz 2n * 2n con sus repectivos cuatro cuadrantes
     * @return Devuelve la matriz con los cuadrantes remplazados
     */
    public static int[][] cambiarCuadrantes(int M[][]){
        //Declaración e inialización de varibles
        int n = M.length / 2;
        int aux1, aux2, n1;
        
        for(int i = 0; i < 2; i++){
            n1 = (2*n)-(n*i);  //Calcula cual es la ultima columna del cuadrante 3 y 4
            aux1 = M[n][n1-1];  //Guarda los valores que poseian los cuadrantes 3 y 4
            aux2 = M[0][i*n];  //Guarda los valores que poseian los cuadrantes 1 y 2
           
        //Remplaza los valores de los cuadrantes inferiores a los superiores del 3 al 1 y del 4 al 2
            //El primer ciclo recorre las filas correpondientes al primer y tercer cuadrante
            for(int j = 0; j < n; j++){
                
                //El segundo ciclo recorre las columnas correpondientes al primer y tercer cuadrante
                for(int k = (i*n); k < n+(i*n); k++){
                      M[j][k] = aux1; //Transfiere el valor de los cuadrantes del 3 al 1 y del 4 al 2
                }
            }
            
        //Remplaza los valores de los cuadrantes superiores a los inferiores del 1 al 3 y del 2 al 4
            //El primer ciclo recorre la filas correpondientes al segundo y cuarto cuadrante
            for(int j = n; j < 2*n; j++){
                
                //El segundo ciclo recorre las filas correpondientes al segundo y cuarto cuadrante
                for(int k = n -(n*i); k < n1; k++){
                     M[j][k] = aux2; //Transfiere el valor de los cuadrantes del 1 al 3 y del 2 al 4
                }
            }
        }return M;
    }
}