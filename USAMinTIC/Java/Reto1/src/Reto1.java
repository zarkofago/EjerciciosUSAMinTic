import java.util.Scanner;

class Reto1 {

    private final Scanner lectura = new Scanner(System.in);

    public String read() {
        return this.lectura.nextLine();
    }

    public void run() {
        String datos = read();

        String[] leer = datos.split(" ");
        double masa = Double.parseDouble(leer[0]);
        double altura = Double.parseDouble(leer[1]);
        int edad = Integer.parseInt(leer[2]);
        String riesgo = "";

        double indice = masa / (altura * altura);

        if (masa >= 0 && masa <= 150) {
            if (altura >= 0.1 && altura <= 2.5) {
                if (edad >= 0 && edad <= 110) {
                    if (edad <= 45) {
                        if (indice <= 20) {
                            riesgo = "Bajo";
                        } else {
                            riesgo = "Medio";
                        }
                    } else {
                        if (indice <= 20) {
                            riesgo = "Medio";
                        } else {
                            riesgo = "Alto";
                        }
                    }
                    String IMC = String.format("%.2f", indice);
                    System.out.println(IMC + " " + riesgo); // Mensaje de salida
                } else {
                    System.out.println("ERROR");
                }
            } else {
                System.out.println("ERROR");
            }
        } else {
            System.out.println("ERROR");
        }
    }
}