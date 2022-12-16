package PaqueteNumeroUno;

public class Tenis {

    private String tenis;
    private double precio;
    
    public Tenis(String tenis , double precio){
        this.tenis = tenis;
        this.precio = precio;
    }
    
    public String getTenis(){
        return this.tenis;
    }
    
    public void setTenis(String tenis){
        this.tenis = tenis;
    }
    
    public double getPrecio(){
        return this.precio;
    }
    
    public void setPrecio(double precio){
        this.precio = precio;
    }
    
    public String toString(){
        System.out.println("--------------------");
        System.out.println("Tenis : " + getTenis());
        System.out.println("Precio : " + getPrecio());
        System.out.println("--------------------");
        return "";
    }
}
