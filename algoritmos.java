package semana7;
import java.io.*;



class algoritmos {

 
 static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintStream out = System.out;

//algoritmo de ordenamiento por seleccion
public static void ordenamientoSeleccion(String[] palabras){
    //variables de control
    int n=palabras.length;
    String menor;
    String temp;
    int posicion;

    //el ciclo principal que recorre todo el arreglo
  for (int i = 0; i < n - 1; i++){

    posicion=i;
    menor=palabras[i];

    //ciclo interno que se utiliza para  recorrer las porcion restante del arreglo, omitiendo casillas ya ordenadas
    for(int j = i + 1; j < n ; j++){
        if (palabras[j].compareToIgnoreCase(menor)<0) {
            menor=palabras[j];
            posicion=j;
        }
    }

    //aca se sustituye la casilla considerada durante las iteraciones del ciclo
    temp=palabras[i];
    palabras[i]=palabras[posicion];
    palabras[posicion]=temp;


    //aca se muestra el arreglo parte por parte para ver como se comporta el el ordenamiento 

         System.out.print("Pasada " + (palabras.length - i) + ": ");
        for (int k = 0; k < palabras.length; k++) {
            System.out.print(palabras[k] + " ");
        }
        System.out.println();
  }

}

//algoritmo de ordenamiento de insercion 
public static void ordenamientoInsercion(String[] palabras){

    //variables necesarias para el algoritmo
    int n=palabras.length;
    String[]palabrasNuevas=new String[n];
    int posicionInsertar=0;
    int cantidadInsertados=0;
    
    //ciclo externo que se encarga de recorrer el arreglo original 
    for(int i = 0; i < n; i++ ){
       
        if (i==0) {
            palabrasNuevas[i]=palabras[i];
        }else{
            //este primer ciclo interno se encarga de determinar la casilla del arreglo nuevo para insertar el siguiente dato 
            for(int j=0; j<= cantidadInsertados; j++){
              
                if (palabras[i].compareToIgnoreCase(palabrasNuevas[j])<=0) {
                    posicionInsertar=j;
                    break;
                }
                //aca se inserta un nuevo dato
                posicionInsertar=cantidadInsertados;
            }

            //este el segundo ciclo interno que se encarga de desplazar hacia adelante todas las casillas del arreglo nuevo cuyo valor es mayor que el siguiente dato
          for(int k = n-1; k >= posicionInsertar + 1; k++){
            palabrasNuevas[k]=palabrasNuevas[k-1];
          }

          palabrasNuevas[posicionInsertar]=palabras[i];
        }


        //se acrualizan las variables de control tras cada interaccion del ciclo externo
        posicionInsertar=0;
        cantidadInsertados++;

            //aca se muestra el arreglo parte por parte para ver como se comporta el el ordenamiento 

         System.out.print("Pasada " + (palabras.length - i) + ": ");
        for (int f = 0; f < palabras.length; f++) {
            System.out.print(palabras[f] + " ");
        }
        System.out.println();
    }
    

    //se sustituye cada casilla del arreglo original por la casilla corespondiente del nuevo arreglo actualizando el original 
    for(int c=0; c< palabras.length; c++){
        palabras[c]=palabrasNuevas[c];
    }

    
}


//algoritmo burbuja 
 public static String[] algoritmoBurbuja(String[] palabras) {
    for (int i = palabras.length - 1; i >= 0; i--) {
        for (int j = 0; j < i; j++) {
            
            if (palabras[j].compareToIgnoreCase(palabras[j + 1]) > 0) {
                String aux = palabras[j];
                palabras[j] = palabras[j + 1];
                palabras[j + 1] = aux;
            }
        }
          out.print("Pasada " + (palabras.length - i) + ": ");
        for (int k = 0; k < palabras.length; k++) {
           out.print(palabras[k] + " ");
        }
        out.println();
    }
    return palabras;
}

  //  Mezcla (Merge Sort)
    static void mergeSort(String[] arr, int izq, int der) {
        if (izq < der) {
            int mid = (izq + der) / 2;
            mergeSort(arr, izq, mid);
            mergeSort(arr, mid + 1, der);
            merge(arr, izq, mid, der);
        }
    }

    static void merge(String[] arr, int izq, int mid, int der) {
        int n1 = mid - izq + 1, n2 = der - mid;
        String[] L = new String[n1];
        String[] R = new String[n2];

        for (int i = 0; i < n1; i++) L[i] = arr[izq + i];
        for (int j = 0; j < n2; j++) R[j] = arr[mid + 1 + j];

        int i = 0, j = 0, k = izq;
        while (i < n1 && j < n2) {
            if (L[i].compareTo(R[j]) <= 0) arr[k++] = L[i++];
            else arr[k++] = R[j++];
        }
        while (i < n1) arr[k++] = L[i++];
        while (j < n2) arr[k++] = R[j++];
    }

    //  Rápido (Quick Sort)
    static void quickSort(String[] arr, int izq, int der) {
        if (izq < der) {
            int piv = particion(arr, izq, der);
            quickSort(arr, izq, piv - 1);
            quickSort(arr, piv + 1, der);
        }
    }

    static int particion(String[] arr, int izq, int der) {
        String pivote = arr[der];
        int i = izq - 1;
        for (int j = izq; j < der; j++) {
            if (arr[j].compareTo(pivote) <= 0) {
                i++;
                String temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        String temp = arr[i + 1];
        arr[i + 1] = arr[der];
        arr[der] = temp;
        return i + 1;
    }

    static void mostrarArreglo(String[] arr) {
        for (String palabra : arr) {
            out.print(palabra + " ");
        }
        out.println();
    }

    // ---------- BÚSQUEDA BINARIA ----------
    static int busquedaBinaria(String[] arr, String palabra) {
        int inicio = 0;
        int fin = arr.length - 1;

        // Mientras el rango sea válido
        while (inicio <= fin) {
            int medio = (inicio + fin) / 2;

            // Se compara la palabra buscada con la del centro
            int comparacion = palabra.compareTo(arr[medio]);

            if (comparacion == 0) {
                return medio; // Encontrada
            } else if (comparacion > 0) {
                inicio = medio + 1; // Buscar a la derecha
            } else {
                fin = medio - 1; // Buscar a la izquierda
            }
        }
        return -1; // No encontrada
    }

public static void main(String[] args)throws IOException {
  

       out.print("Ingrese el tamaño del arreglo de palabras: ");
        int n = Integer.parseInt(in.readLine());

        String[] palabras = new String[n];
        for (int i = 0; i < n; i++) {
            out.print("Palabra " + (i + 1) + ": ");
            palabras[i] = in.readLine();
        }

        int opcion;
        do {
            out.println("\n===== MENÚ DE ORDENAMIENTO =====");
            out.println("1. Ordenamiento por Selección");
            out.println("2. Ordenamiento por Inserción");
            out.println("3. Ordenamiento Burbuja");
            out.println("4. Ordenamiento por Mezcla (Merge Sort)");
            out.println("5. Ordenamiento Rápido (Quick Sort)");
            out.println("6. Mostrar arreglo actual");
            out.println("0. Salir");
            out.print("Elija una opción: ");
            opcion = Integer.parseInt(in.readLine());

            switch (opcion) {
                case 1:
                    out.println("\n--- ORDENAMIENTO POR SELECCIÓN ---");
                    algoritmos.ordenamientoSeleccion(palabras);
                    break;
                case 2:
                    out.println("\n--- ORDENAMIENTO POR INSERCIÓN ---");
                    algoritmos.ordenamientoInsercion(palabras);
                    break;
                case 3:
                    out.println("\n--- ORDENAMIENTO BURBUJA ---");
                    algoritmos.algoritmoBurbuja(palabras);
                    break;
                case 4:
                    out.println("\n--- ORDENAMIENTO POR MEZCLA ---");
                    algoritmos.mergeSort(palabras, 0, palabras.length - 1);
                    break;
                case 5:
                    out.println("\n--- ORDENAMIENTO RÁPIDO ---");
                    algoritmos.quickSort(palabras, 0, palabras.length - 1);
                    break;
                case 6:
                    out.println("\n--- ARREGLO ACTUAL ---");
                    mostrarArreglo(palabras);
                    break;
                case 0:
                    out.println("Saliendo del programa...");
                    break;
                default:
                    out.println("Opción no válida. Intente de nuevo.");
            }

            // Si se ejecutó un método de ordenamiento
            if (opcion >= 1 && opcion <= 5) {
                out.println("\nArreglo final ordenado:");
                mostrarArreglo(palabras);

                // Se realiza la búsqueda binaria
                out.print("\nIngrese la palabra que desea buscar: ");
                String buscada = in.readLine();

                int pos = busquedaBinaria(palabras, buscada);

                if (pos != -1) {
                    out.println("✅ Palabra encontrada en la posición: " + pos);
                } else {
                    out.println("❌ La palabra no se encuentra en el arreglo.");
                }

                out.println("\nComplejidad temporal de la búsqueda binaria: O(log n)");
            }

        } while (opcion != 0);
    }
    
 
}





