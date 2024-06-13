package Pilas;

public class PilaEnteros {
    private int[] Elementos;

    public PilaEnteros() {
    }

    public PilaEnteros(int[] elementos) {
        Elementos = elementos;
    }

    public void aniadir(int elemento){
        int total = this.Elementos.length + 1;
        int[] temp = new int[total];

        int i = 0;
        for (int e : Elementos){
            temp[i] = e;
            i++;
        }
        temp[total] = elemento;
        this.Elementos = temp;
    }

    public int eliminar(){
        int[] temp = new int[Elementos.length-1];

        int i = 0;
        for (int t : temp){
            t = Elementos[i];
            i++;
        }
        int aux = this.Elementos[i];
        this.Elementos = temp;
        return aux;
    }

    public int ultimo(){
        int aux = this.Elementos[Elementos.length-1];
        return aux;
    }

    public int buscar(int n){
        int aux = -1;

        for (int e : Elementos){
            if (e == n){
                aux = 1;
            }
        }

        return aux;
    }
}
