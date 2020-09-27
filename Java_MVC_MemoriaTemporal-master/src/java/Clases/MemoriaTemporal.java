
package Clases;
public class MemoriaTemporal {
    private int longitud;
    private int indice;
    public double[] vectorDouble;
    public String[] vectorString;
    
   public MemoriaTemporal(int longitud){
        this.longitud=longitud;
        this.vectorDouble=new double[this.longitud];
        this.vectorString=new String[this.longitud];
        this.indice=0;
    }   
    public void agregarElementoDouble(double elemento){
        this.vectorDouble[indice]=elemento;
        indice=indice+1;
    }    
    public void agregarElementoString(String elemento){
         this.vectorString[indice]=elemento;
        indice=indice+1;
    }     
    public String[] obtenerVector(){
        return this.vectorString;
    } 
   
}
