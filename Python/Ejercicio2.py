#Ejercicio #2
"""Leer dos matrices 5x5 enteras y determinar si el promedio entero de los números
mayores de cada fila de una matriz es igual al promedio de los números mayores
de cada fila de la otra matriz."""

def llenarMatriz(M, n, m, S):
    """A traves de esta función se ingresan los datos de tipo entero
    a la matriz. Se debe ingresar como parametro la matriz, su tamaño
    en filas y columnas, y su nombre"""

    #Con este bucle se pide al usuario que ingrese los datos a la matriz
    for i in range(n):
        M.append([])
        for j in range(m):
            print("Escriba el valor de la posición",S,"[",i,"][",j,"] =", end=" ")
            M[i].append(int(input()))
    return M

def promedioMayoresFilas(M):
    """Con esta función se calcula el promedio de los mayores de las filas
    de las matrices Se debe ingresar como parametro la matriz."""
    
    promedio = 0
#Con este ciclo se busca los mayores de cada fila y se va sacando el promedio
    for i in M:
        mayor = i[0]
        for j in i:
            if j > mayor:
                mayor = j
        promedio += mayor
    promedio /= n
    return promedio

def imprimirMatriz(M):
        """Con este metodo se manda a imprimir la matriz que fue enviada como parametro.
        Se debe mandar como parámetro la matriz a imprimir"""

        #Con este bucle se pide al usuario que ingrese los datos a la matriz
        for i in M:
                for j in i:
                        print("[",j,"]", end = " ")
                print()
        return M

#Se inicializa la veriable que va a tener el tamaño de la matriz cuadratica
n = 5

print("Programa que saca el promedio entero de los mayores números de las filas de una")
print("matriz y compara el promedio de otra matriz\n")

#Se crean las matrices
A = []
B = []

#Se llenan las matrices
print("Ingrese los datos de la Matriz A")
A = llenarMatriz(A, n, n, "A")
print("\nIngrese los datos de la Matriz B")
B = llenarMatriz(B, n, n, "B")

#Se muestran las matrices
print("\nMatriz A")
imprimirMatriz(A)
print("\nMatriz B")
imprimirMatriz(B)

#Se calcula el promedio de los mayores de todas las filas de la matriz
promedioA = int(promedioMayoresFilas(A))
promedioB = int(promedioMayoresFilas(B))
print("")

#Se comprueba que el promedio de los mayores de las filas de las 2 matrices sean iguales
if promedioA == promedioB:
    print("El promedio entero de los mayores de las filas de las matrices son iguales")
    print("Promedio entero de los mayores de las filas de la matriz A es:", promedioA)
    print("Promedio entero de los mayores de las filas de la matriz B es:", promedioB)
else:
    print("El promedio entero de los mayores de las filas de las matrices no son iguales")
    print("Promedio entero de los mayores de las filas de la matriz A es:", promedioA)
    print("Promedio entero de los mayores de las filas de la matriz B es:", promedioB)
