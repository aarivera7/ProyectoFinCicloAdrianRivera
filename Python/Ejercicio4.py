#Ejercicio #4
"""Realice un algoritmo que dada una matriz de tamaño 2n*2n intercambie el primer
cuadrante con el tercero y el segundo con el cuarto."""

def llenarMatrizCuadrante(M, n):
        """Este metodo recibe una matriz 2n*2n para dividirla en 4 cuadrantes
        en la que cada uno tiene un tamaño n y es  rellenado con un
        solo valor proporcionado por el usuario.
        Se debe enviar como parámetro el vector y su tamaño en filas y columnas"""
        #Inialización de variable que cuenta los cuadrantes
        c = 0

        #Con este bucle se recorre los cuadrantes de la matriz
        for i in range(0,2*n,n):
                for j in range(0, 2*n,n):
                        c+=1
                        print("Ingrese el número del cuadrante #", c,end =": ")
                        aux = int(input())

                        #Con este ciclo se rellena cada cuadrante con el valor proporcionado
                        for k in range(i,n+i):
                                for l in range(j, n+j):
                                        M[k].append(aux)
        return M

def imprimirMatriz(M):
        """Con este metodo se manda a imprimir la matriz que fue enviada como parametro.
        Se debe mandar como parámetro la matriz a imprimir"""

        #Con este bucle se pide al usuario que ingrese los datos a la matriz
        for i in M:
                for j in i:
                        print("[",j,"]", end = " ")
                print()
        return M

def remplazarCuadrantes(M,n):
        """El metodo recibe una matriz 2n*2n con 4 cuadrantes, y remplaza el primer cuadrante
        con el tercero yel segundo con el cuarto. Se envia como parámetro
        la matriz y el tamaño del cuadrante."""

        
        #Ciclo que controla en que cuadrante se esta remplazando los valores
        for i in range(2):
                n1 = (2*n) - (n*i) #Calcula cual es la ultima columna del cuadrante 3 y 4
                aux1 = M[n][n1-1]  #Guarda los valores que poseian los cuadrantes 3 y 4
                aux2 = M[0][i*n]  #Guarda los valores que poseian los cuadrantes 1 y 2

        #Remplaza los valores de los cuadrantes inferiores a los superiores del 3 al 1 y del 4 al 2
		#El primer ciclo recorre las filas correpondientes al primer y tercer cuadrante
                for j in range(n):
                        #El segundo ciclo recorre las columnas correpondientes al primer y tercer cuadrante
                        for k in range((i*n),n + (i*n)):
                                M[j][k] = aux1

        #Remplaza los valores de los cuadrantes superiores a los inferiores del 1 al 3 y del 2 al 4
		#El primer ciclo recorre la filas correpondientes al segundo y cuarto cuadrante
                for j in range(n,2*n):
                        #El segundo ciclo recorre las filas correpondientes al segundo y cuarto cuadrante
                        for k in range(n - (n*i),n1):
                                M[j][k] = aux2
        return M

#Inialización de varibles
b = False

print("Programa que crea una matriz 2n * 2n de cuatro cuadrantes y remplaza")
print("el primer cuadrante con el tercero y el segundo con el cuarto.")

#Se ingresa el tamaño del cuadrante de la matriz y se verifica que sea el correcto
print("Ingrese el tamaño que van a tener los cuadrantes de la matriz")
while b == False:
        n = int(input())

        if n > 0:
                b = True
        else:
                print("Error: El cuadrante no puede tener un tamaño menor a 1")
                print("Ingrese otro número:")

#Se crea la matriz
A = []

for i in range(2*n):
	A.append([])

#Se manda a rellenar los cuadrantes de la matriz
A = llenarMatrizCuadrante(A, n)

#Se muestra la matriz original
print("\nMatriz Original")
imprimirMatriz(A)

#Se manda a remplazar los cuadrantes de la matriz 
A = remplazarCuadrantes(A, n)

#Se muestra la matriz con los cuadrantes remplazados
print("\nMatriz con los cuadrantes remplazados")
imprimirMatriz(A)
