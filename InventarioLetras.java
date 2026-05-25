//proyecto-1
//jose orellana
public class InventarioLetras{
  private int[] contador;
  private int totalCount;
  private int nonZeroCount;

  //constructor
  public InventarioLetras(String data){
  contador = new int[26];
  totalCount = 0;
  nonZeroCount = 0;
  
  String texto = data;

  if (texto != null) {
    texto = texto.toLowerCase();

    for (int i = 0; i < texto.length(); i++) {
      char caracter = texto.charAt(i);

      if (esLetra(caracter)) { 
        int posicion = caracter - 'a';
        contador[posicion]++;
        totalCount++;

        if (contador[posicion] == 1){
          nonZeroCount++;
            }  
          }
        }   
      }
    }
     
private boolean esLetra(char caracter){
   return (caracter >= 'a' && caracter <= 'z') || (caracter >= 'A' && caracter <= 'Z');
}
private char volverMinuscula(char caracter){
  if (caracter >= 'A' && caracter <= 'Z'){
    return (char) (caracter + 32);
  }
  return caracter;
}

public int get(char letra){
  if(!esLetra(letra)){
    throw new IllegalArgumentException("No es una letra:" + letra);

  }
  char minuscula = volverMinuscula(letra);
  return contador[minuscula - 'a'];
}
public void set(char letra, int valor){
  if (!esLetra(letra)){
     throw new IllegalArgumentException("no es letra valida:" + letra);
  }

  
  if (valor < 0) {
     throw new IllegalArgumentException("no puede ser negativo: " + valor);
  }

  char minusculas = volverMinuscula(letra);
  int posicion = minusculas - 'a';
  int valorAnterior = contador[posicion];

  contador[posicion] = valor;
  totalCount = totalCount + (valor - valorAnterior);

if (valorAnterior == 0 && valor > 0 ) {
  nonZeroCount++;

 } else if (valorAnterior > 0 && valor == 0 ){
  nonZeroCount--;
 }
}

public int size() {
  return totalCount;
}
public boolean isEmpty () {
  return nonZeroCount == 0; 
}

public String toString() {
  String resultado = "[";
  
  for (int i = 0; i < 26; i++) {
    char letra = (char) ('a' + i);
    for (int j = 0; j < contador[i]; ++j) {
      resultado = resultado + letra;

    }
  }
  resultado = resultado + "]";
  return resultado;
}
private char cifrar(char letra, int desplazamiento) {
  if (!esLetra(letra)) {
    return letra;
}

char base;
if (letra >= 'A' && letra <= 'Z') {
  base = 'A';
} else {
  base = 'a';
}

int offset = ((letra - base + desplazamiento) % 26 + 26) % 26;
return (char) (base + offset);
}
public char encriptarCesar(char letra) {
  letra = volverMinuscula(letra);
  return cifrar(letra,3);
}
public char desencriptarCesar(char letra){
  letra = volverMinuscula(letra);
  return cifrar(letra, -3);
}
public String encriptarPalabra(String palabra, int desplazamiento) {
  String resultado = "";
  for (int i = 0; i < palabra.length(); i++) {
    resultado += encriptarCesar(palabra.charAt(i));
}
return resultado;
}

public String desencriptarPalabra(String palabra, int desplazamiento) {
  String resultado = "";
  for (int i = 0; i < palabra.length(); i++) {
    resultado += desencriptarCesar(palabra.charAt(i));
}
return resultado;
} 
//rere
public InventarioLetras add(InventarioLetras inventarioSumar) {
  InventarioLetras resultado = new InventarioLetras("");
  for (int i = 0; i < 26; i++) {
    char letra = (char) ('a' + i);
    int suma = this.contador[i] + inventarioSumar.contador[i];
    resultado.set(letra, suma);
  
}
return resultado;
}
public InventarioLetras subtract(InventarioLetras inventarioRestar) {
  InventarioLetras resultado = new InventarioLetras("");
  for (int i = 0; i < 26; i++) {
    char letra = (char) ('a' + i);
    int resta = this.contador[i] - inventarioRestar.contador[i];
    if (resta < 0) {
        return null;
    }
    resultado.set(letra, resta);
  }
  return resultado;
}
public InventarioLetras amplifies(int n) {
  InventarioLetras nuevo = new InventarioLetras("");
  for (int i = 0; i < 26; i++) {
    char letra = (char) ('a' + i);
    int multiplicacion = this.contador[i] * n;
    nuevo.set(letra, multiplicacion);
  }
  return nuevo;
}

public static void main(String[] args){
InventarioLetras inv = new InventarioLetras (" Hola Mundo ");
System.out.println (" size : " + inv . size ()); // 9
System.out.println (" isEmpty : " + inv.isEmpty ()); // false
System.out.println (" get ('o'): " + inv.get ('o')); // 2
System.out.println (inv ); //[ adhlnmou ]
System.out.println (inv.encriptarCesar ('a')); // 'd'
System.out.println (inv.encriptarPalabra (" play ", 3)); // " sodb "

//inventario 2
System.out.println ("--NUEVO INVENTARIO--");
InventarioLetras inv2 = new InventarioLetras (" Universidad de Chile  ");
System.out.println("Universidad de Chile");
System.out.println(inv2);
System.out.println (" letras : " + inv2.size ()); // 22



} 
}
