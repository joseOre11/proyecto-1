//proyecto-1

public class inventarioLetras{
  private int[] contador;
  private int totalCount;
  private int nonZeroCount;

  //constructor
  public inventarioLetras(String data){
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
  }  
  
private boolean esLetra(char caracter){
   return (caracter >= 'a' && caracter <= 'z') || (caracter >= 'A' && caracter <= 'Z');
}
private char aMinuscula(char caracter){
  if (caracter >= 'A' && caracter <= 'Z'){
    return (char) (caracter + 32);
  }
  return caracter;
}

public int get(char letra){
  if(!esLetra(letra)){
    throw new IllegalArgumentException("No es una letra:" + letra);

  }
  char minuscula = aMinuscula(letra);
  return contador[minuscula - 'a'];
}
public void set(char letra, int valor){
  if (!esLetra(letra)){
     throw new IllegalArgumentException("no es letra valida:" + letra);
  }

  
  if (valor < 0) {
     throw new IllegalArgumentException("no puede ser negativo: " + valor);
  }


  
  char minusculas = aMinuscula(letra);
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
  return nonZeroCOunt == 0; 
}
public String toString() {
  String resultado = "[";
  
  for (int i = 0; i < 26; i++) {
    char letra = (char) ('a' + i);
    for (int j = 0; < contador[i]; ++j) {
      resultado = resultado + total;

    }
  }
  resultado = resultado + "]";
  retur resultado;
}

public static void main(String[] args){
inventarioLetras inv = new inventarioLetras (" Hola Mundo ");
System .out. println (" size : " + inv . size ()); // 9
System .out. println (" isEmpty : " + inv . isEmpty ()); // false
System .out. println ("get ('o '): " + inv . get ('o')); // 2
System .out. println (inv ); //
[ adhlnmou ]
}
