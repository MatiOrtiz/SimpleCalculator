/*Clase de la lógica que realiza operaciones matemáticas simples sobre
   numeros enteros (no negativos)*/
public class Calculadora
{
    
    /*Crea una instancia de la clase calculadora*/   
    public Calculadora()
    {
    }
    /*Retorna la suma de los enteros x e y*/
    public int suma(int x, int y)
    {
        return x + y;
    }
    /*Retorna el producto de los enteros x e y*/
    public int producto(int x, int y)
    {
        return x * y;
    }
    /*Retorna la resta de los enteros x e y*/
    public int resta(int x, int y)
    {
        return x - y;
    }
    /*Retorna la división de los enteros x e y. Retorna -1 en caso
       de que y sea 0*/
    public int cociente(int x, int y)
    {
        if (y != 0)
            return x / y;
        else
            return -1;   
    }
}
