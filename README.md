# proyecto-1
package cl.utalca;
import java.util.Scanner;

public class inventarioLetras{
  private int[] contador;
  private int totalCount;
  private int nonZeroCount;

  //constructor
  public InventarioLetra(String data){
  contador = new int[26];
  totalCount = 0;
  nonZeroCount = 0;
  
  String texto = data;

  if (texto != null) {
    texto = texto.toLowerCase();

    for (int i = 0; i < texto.lenght(); i++) {
      char caracter = texto.CharAt(i);

      if (esLetra(caracter)) { 
        int lugar = caracter - 'a';
        contador[posicion]++;
        contadorTotal++;

        if (contador[posicion] == 1){
          nonZeroCount++;
            }  
          }
        }   
      }
    } 
  
private boolean esLetra(char caracter){
  return (caracter >= 'a' && <= 'z'>) || (caracter >=A && caracter <= Z>);
}
private char aMinuscula(char caracter){
  if (caracter >= 'A' && caracter <='Z'){
    return (char) (caracter + 32);
  }
  return caracter;
}

public int get(char letra){
  if(!esLetra(letra)){
    throw new illegalArgumentException("No es una letra:" + letra);

  }
  char minuscula = aMinuscula(letra);
  return contador[minuscula - 'a'];
}
public void set(char letra, int valor){
  if (!esLetra(letra)){
    throw new illegalargumentException("no es letra valida:" + letra)
  }
  
  if (valor < 0) {
    throw new illegalArgumentExepction("no puede ser negativo: " + valor)
  }

  char minusculas = aMinuscula(letra)
  int = posicion - 'a';
  int valorAnterior = contador[posicion];

  contador[posicion] = valor;
  totalCount = totalCount + (valor - valorAnterior);

if (valorAnterior == 00 && valor > 0 ) {
  nonZeroCount++;

 } else if (valorAnterior > 0 && valor == 0 ){
  nonZeroCount--;
 }
}

public int size() {
  return totalCount;
}
public boolean isEmpty () {
  return nonZeroCOunt == 0; 
}
public String toString() {
  String resultado = "[";
  
  for (int i = 0; i < 26; i++) {
    char letra = (char) ('a' + i);
    for (int j = 0; j < contador[i]; ++j) {
      resultado = resultado + total;

    }
  }
  resultado = resultado + "]";
  return resultado;
}
private char cifrar(char letra,int desplazamiento){
  if (!esLetra(letra)){
    return letra;
  }

  char base ;
  if (letra>='A' && letra <= 'Z'){
    base = 'A'
  } else {
    base = 'a';
  }
 int offset = ((letra - base + desplazamiento) % 26 + 26) % 26;
return (char) (base + offset);
}
public char encritarCesar(char letra) {
  letra = volverMinuscula(letra);
  return cifrar(letra,3);
}
public char decencriptarCesar(char Letra){
  letra = volverMinuscula(letra);
  return cifrar(letra, -3);
  wqeqeq
}
qeq

public static void main(String[] args){
InventarioLetras inv = new InventarioLetras (" Hola Mundo ");
System .out. println (" size : " + inv . size ()); // 9
System .out. println (" isEmpty : " + inv . isEmpty ()); // false
System .out. println ("get ('o '): " + inv . get ('o')); // 2
System .out. println (inv ); //
[ adhlnmou ]
System .out. println (inv . encriptarCesar ('a')); // 'd'
System .out. println (inv . encriptarPalabra (" play ", 3)); // " sodb "
}







  
  
  
