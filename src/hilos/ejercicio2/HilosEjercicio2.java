
package hilos.ejercicio2;

/**
 *
 * @author carlos
 */
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class HolaRunnable implements Runnable {
    @Override
    public void run() {
        while (true) {
            System.out.println("hola");
            try {
                Thread.sleep(500); // Pausa para evitar saturar la consola
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
}

class MundoRunnable implements Runnable {
    @Override
    public void run() {
        while (true) {
            System.out.println("mundo");
            try {
                Thread.sleep(500); // Pausa para evitar saturar la consola
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
}

public class HilosEjercicio2 {
    public static void main(String[] args) {
        // Usando Threads directamente
        Thread hiloHola = new Thread(new HolaRunnable());
        Thread hiloMundo = new Thread(new MundoRunnable());

        hiloHola.start();
        hiloMundo.start();

        // Usando ExecutorService
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(new HolaRunnable());
        executorService.submit(new MundoRunnable());
    }
}
