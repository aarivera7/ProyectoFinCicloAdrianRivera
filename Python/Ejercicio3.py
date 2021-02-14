#Ejercicio #3
"""Construir una función que reciba como parámetro un vector de 10 posiciones enteras y retorne la
posición en la que se encuentre el mayor número primo que termine en 3 almacenado en el vector."""

def llenarVector(V, n):
    """Esta función recibe un vector y le va pidiendo al usuario que valla 
    intrduciendo los números en el vector. Se debe intorducir como parametro
    el vector y su tamaño"""

 #Este ciclo recorre todo el vector para contar las veces que se repite un número
    for i in range(n):
        print("Escriba el valor de #",i," del vector:", end = " ")
        V.append(int(input()))
    return V

def Primo(num):
    """Con esta funcion se determinar si un número es primo o no.
    Se debe mandar como parametro el número para verificar si es primo."""
    #Inialización de varible
    div = 0

    #En este ciclo se divide el número desde el 1 al número a verificar
    for i in range(1,num+1):
        if num % i == 0:
            div+=1
    return div == 2

def MayorVector(V):
    """Con esta función se determina cual es el mayor de un vector.
    Se debe mandar como parametro al vector y su tamaño."""
    #Inialización de varibles
    mayor = V[0]

    #Con este ciclo se busca al mayor del vector
    for i in V:
        if i > mayor:
            mayor = i
    return mayor

def posicionVector(V, n, num):
    """Con esta función se puede buscar en que posición se encuentra un número en un vector.
    Se debe enviar como parámetro el vector y su tamaño, y el número a buscar la posición."""

    for i in range(n):
        if V[i] == num:
            return i
    return -1

print("Programa que te dice el mayor de los números primos terminados en 3 que ingresaste")
print("Ingrese 10 números:")

#Inialización de varibles
k = 0
n = 10

A = []  #Se crea el vector
primos = []  #Se crea el vector que aloja los primos

#Se rellena el vector
A = llenarVector(A, n)
print()

#Se comprueba que el número sea primo y termine en 3
for i in A:
   if Primo(i):  #Se comprueba que el número sea primo
       if i % 10 == 3:  #Si el número es primo se comprueba si termina en 3
           primos.append(i)
           k+=1

#Se muestra el número que cumplio las condiciones
if k > 0:
    mayor = MayorVector(primos)
    print("El número mayor, primo y terminado en 3 del vector es: ", mayor)
    print("Que se encuentra en la posición: ", posicionVector(A, n, mayor))
#Se manda un mensaje de que no se encontro ningun número que cumpliera las condiciones
else:
    print("No se encontro ningún número primo terminado en 3")
