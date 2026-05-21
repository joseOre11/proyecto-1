# proyecto-1
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
    throw new illegalArgumentExceotion("No es ina letra:" + letra);

  }
  char minuscula = aMinuscula(letra);
  return contador[minuscula - 'a'];
}
public void set(char letra, int valor){
  if (!esLetra(letra)){
    throw new illegalarmentException("no es letra valida:" + letra)
  }
  
  if (valor < 0) {
    throw new illegalArgumentExepction("no puede ser negativo: " + valor)
  }

  char minusculas = aMinuscula(letra)
  int = indice - 'a';
  int valorAnterior = contador[indice];

  contador[indice] = valor;
  totalCounts = totalCount + (valor - valorAnterior);

if (valorAnterior == 00 && valor > 0 ) {

 } else if (valorAnterior > 0 && valor == 0 ){


}
}


  
  
  
