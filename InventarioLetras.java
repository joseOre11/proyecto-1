//proyecto-1 JOSE ORELLANA
public class InventarioLetras{
  private int[] contador; // arreglo para contar las letras
  private int totalCount; // contador total de letras
  private int nonZeroCount; // contador de letras con cantidad mayor a cero

  //constructor que recibe un string y cuenta las letras
  public InventarioLetras(String data){
  contador = new int[26];
  totalCount = 0;
  nonZeroCount = 0;
  String texto = data;

  if (texto != null) {
    texto = texto.toLowerCase(); // Convertir el texto a minúsculas 
//recorrer el string y contar las letras
    for (int i = 0; i < texto.length(); i++) {
      char caracter = texto.charAt(i);
      
      // Verificar si el caracter es una letra 
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
//verificar si un caracter es una letra
private boolean esLetra(char caracter){
   return (caracter >= 'a' && caracter <= 'z') || (caracter >= 'A' && caracter <= 'Z');
}
//convierte una letra mayuscula a minuscula
private char volverMinuscula(char caracter){
  if (caracter >= 'A' && caracter <= 'Z'){
    return (char) (caracter + 32);
  }
  return caracter;
}
// retorna el conteo de una letra
public int get(char letra){
  if(!esLetra(letra)){
    throw new IllegalArgumentException("No es una letra:" + letra);

  }
  char minuscula = volverMinuscula(letra);
  return contador[minuscula - 'a'];
}
//establece el conteo de una letra
public void set(char letra, int valor){
  if (!esLetra(letra)){
     throw new IllegalArgumentException("no es letra valida:" + letra);
  }
  if (valor < 0) {
     throw new IllegalArgumentException("no puede ser negativo: " + valor);
  }
//actualizar el contador y el totalCount
  char minusculas = volverMinuscula(letra);
  int posicion = minusculas - 'a';
  int valorAnterior = contador[posicion];

  contador[posicion] = valor;
  totalCount = totalCount + (valor - valorAnterior);
//actualizar el nonZeroCount
if (valorAnterior == 0 && valor > 0 ) {
  nonZeroCount++;
 } else if (valorAnterior > 0 && valor == 0 ){
  nonZeroCount--;
 }
}
//retorna el numero total de letras en el inventario
public int size() {
  return totalCount;
}
//retorna true si el inventario esta vacio
public boolean isEmpty () {
  return nonZeroCount == 0; 
}
//retorna el inventario como un string
@Override
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
//desplaza una letra n posiciones
private char cifrar(char letra, int desplazamiento) {
  if (!esLetra(letra)) {
    return letra;
}
// mayuscula o minuscula
char base;
if (letra >= 'A' && letra <= 'Z') {
  base = 'A';
} else {
  base = 'a';
}
int offset = ((letra - base + desplazamiento) % 26 + 26) % 26;
return (char) (base + offset);
}

//encriptar letra con cesar (desplazamiento de 3)
public char encriptarCesar(char letra) {
  letra = volverMinuscula(letra);
  return cifrar(letra,3);
}
//desencriptar letra con cesar(desplazamiento de -3)
public char desencriptarCesar(char letra){
  letra = volverMinuscula(letra);
  return cifrar(letra, -3);
}
//encriptar una palabra usando el cifrado de cesar
public String encriptarPalabra(String palabra, int desplazamiento) {
  String resultado = "";
  for (int i = 0; i < palabra.length(); i++) {
    resultado += encriptarCesar(palabra.charAt(i));
}
return resultado;
}
//desencripta palabra con cesar
public String desencriptarPalabra(String palabra, int desplazamiento) {
  String resultado = "";
  for (int i = 0; i < palabra.length(); i++) {
    resultado += desencriptarCesar(palabra.charAt(i));
}
return resultado;
} 
//suma de inventarios
public InventarioLetras add(InventarioLetras inventarioSumar) {
  InventarioLetras resultado = new InventarioLetras("");
  for (int i = 0; i < 26; i++) {
    char letra = (char) ('a' + i);
    int suma = this.contador[i] + inventarioSumar.contador[i];
    resultado.set(letra, suma);
}
return resultado;
}
//resta otro inventario, returna null si el resultado es negativo
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
//multiplicar el inventario por un numero entero
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
System.out.println ("--INVENTARIO--");
InventarioLetras inv = new InventarioLetras (" Hola Mundo ");
System.out.println("palabra: Hola Mundo");
System.out.println ("letras : " + inv.size ()); // 9
System.out.println ("esta vacio?  : " + inv.isEmpty ()); // false
System.out.println ("cuantas ('o') hay?: " + inv.get ('o')); // 2
System.out.println ("letra encriptada: " + inv.encriptarCesar('a')); // "d"
System.out.println ("letra desencriptada: " + inv.desencriptarCesar('d')); // "a"
System.out.println ("palabra encriptada: " + inv.encriptarPalabra ("play ", 3)); // " sodb "
System.out.println ("palabra desencriptada: " + inv.desencriptarPalabra ("sodb ", 3)); // " play "
System.out.println ("inventario 1: " + inv); //[ adhlnmou ]
//inventario 2
System.out.println ("--NUEVO INVENTARIO--");
InventarioLetras inv2 = new InventarioLetras (" jose orellana ");
System.out.println("palabra: jose orellana");
//operaciones
InventarioLetras suma = inv.add(inv2);
System.out.println ("suma de inventarios: " + suma); // [ aadehjlnmoors ]
InventarioLetras resta = inv.subtract(inv2);
System.out.println ("resta de inventarios: " + resta); // [ adhnmou ]
InventarioLetras multiplicacion = inv.amplifies(2);
System.out.println ("amplificacion del inventario 1: " + multiplicacion); // [ aaaddhhllnnmmmooouu ]
inv.set('o',3);
System.out.println ("cantidad de 'o' en el inventario 1: " + inv.get('o')); // 3
System.out.println ("inventario 1 actualizado: " + inv); // [ adhlnmooou ]
} 
}
