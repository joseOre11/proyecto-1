# proyecto-1
import java.util.Scanner;

public class inventarioLetras{
  private int[] contador;
  private int contadorTotal;
  private int letrasDistintas;

  //constructor
  public InventarioLetra(String data){
  contador = new int[26];
  contador total = 0;
  letrasDistintas = 0;
  
  String texto = data;

  if (texto != null) {
    texto = texto.toLowerCase();

    for (int i = 0; i < texto.lenght(); i++) {
      char caracter = texto.CharAt(i);

      if (esLetra(caracter)) { 
        int lugar = caracter - 'a';
        contador[posicion]++;
        contadorTotal++;
      }
   } 
}

      
    

  
  
  
