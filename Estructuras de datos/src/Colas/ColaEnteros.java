package Colas;

public class ColaEnteros {
    private int[] elementos;

    public ColaEnteros() {
        this.elementos = new int[0];
    }

    public ColaEnteros(int[] elementos) {
        this.elementos = elementos;
    }

    public void insertar(int n) {
        int[] temp = new int[this.elementos.length + 1];

        for (int i = 0; i < this.elementos.length; i++) {
            temp[i] = this.elementos[i];
        }

        temp[temp.length - 1] = n;

        this.elementos = temp;
    }

    public void remover() {
        if (this.elementos.length == 0) {
            return;
        }

        int[] temp = new int[this.elementos.length - 1];

        for (int i = 1; i < this.elementos.length; i++) {
            temp[i - 1] = this.elementos[i];
        }

        this.elementos = temp;
    }

    public int primer() {

        if (this.elementos.length == 0) {
            throw new IllegalStateException("La cola está vacía");
        }

        int aux = this.elementos[0];
        return aux;
    }
}
