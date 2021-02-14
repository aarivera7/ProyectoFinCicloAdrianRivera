#Ejercicio #1
"""Leer n números enteros, almacenarlos en un vector y determinar si existe 
al menos un número repetido."""

def llenarVector(V, n):
    """Esta función recibe un vector y le va pidiendo al usuario que valla 
    intrduciendo los números en el vector. Se debe intorducir como parametro
    el vector y su tamaño"""

 #Este ciclo recorre todo el vector para contar las veces que se repite un número
    for i in range(n):
        print("Escriba el valor de #",i," del vector:", end = " ")
        V.append(int(input()))
    return V

def vecesRepetido(V, num):
    """Con este metodo se verifica cuantas veces se repite un número en un
    vector. Se debe intorducir como parametro el vector y el número a contar
    cuantas veces se repite."""
    
    j = 0
    #Este ciclo recorre todo el vector y va pidiendo los datos al usuario
    for i in V:
        if i == num:
            j+=1
    return j

def NoRepetir(V, A):
    """Con este metodo recibe un vector con los número ya procesados y el número
    a verificar si ya fue procesado o no."""

    #Este ciclo recorre todo el vector y verifica si ya se proceso el número
    for i in V:
        if A == i:
            return False
    return True

print("Programa que te dice cuantas veces se repite un numero en un vector")

#Se ingresa el tamaño del vector
n = int(input("Ingrese el tamaño del vector: "))

#Se crea el vector e ingresa los datos
A = []
A = llenarVector(A, n)
print()

#Se crea el vector que va almacenar los números ya procesados
noHacer = []

#Se verifica cuantas veces se encuentra un números en un vector
for i in range(0, n):

    #Se verifica cuantas veces se encuentra el número y esa cantidad se ingresa en la varible
    repetido = vecesRepetido(A, A[i])
    
    #Se verifica que el número se repita y que no se vuelva a procesar otra vez el mismo número
    if (repetido > 1) & NoRepetir(noHacer, A[i]):
        print("El numero ", A[i]," se encuentra ",repetido," veces en la serie")

        #Se guardan los números ya procesados para no volver a procesarlos
        noHacer.append(A[i])

#Si no se encontro ningún número repetido se envia un mensaje al usuario
if len(noHacer) == 0:
    print("No se ha encontrado ningún número repetido en la serie")
    
