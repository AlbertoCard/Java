package Libs;

public class Hectareas {
    private int IdHectarea;
    private String Comunidad;
    private int Renta;
    private String Ubicacion;


    public Hectareas(int IdHectarea, String Comunidad, int Renta, String Ubicacion){
        this.IdHectarea = IdHectarea;
        this.Comunidad = Comunidad;
        this.Renta = Renta;
        this.Ubicacion = Ubicacion;
    }

    public int getIdHectarea(){
        return IdHectarea;
    }

    public void setIdHectarea(int IdHectarea){
        this.IdHectarea = IdHectarea;
    }

    public String getComunidad(){
        return Comunidad;
    }

    public void setComunidad(String Comunidad){
        this.Comunidad = Comunidad;
    }

    public int getRenta(){
        return Renta;
    }

    public void setRenta(int Renta){
        this.Renta = Renta;
    }

    public String getUbicacion(){
        return Ubicacion;
    }

    public void setUbicacion(String Ubicacion) {
        this.Ubicacion = Ubicacion;
    }
}
