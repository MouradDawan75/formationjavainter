package javainter.threadings;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class demo {

    //Ressource partagée
    static int total = 0;

    public static void main(String[] args) throws Exception {
        /*
        Processus: un programme en cours d'exécution
        Thread: unité physique d'exécution d'une tâche

        Multi Threading: permte d'obtenir des applications non bloquantes (responsives)
         */

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Tâche1............"+Thread.currentThread().getName());
            }
        });

        //Les tâches dites lentes: bonne pratique, les exécuter dans un thread à part

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Tâche2............"+Thread.currentThread().getName());
            }
        });

        t1.start();
        t2.start();

        t1.join(); //join: permet de mettre en attente le thread principale
        t2.join();


        System.out.println("Tâche principale: "+Thread.currentThread().getName());

        Thread th1 = new Thread(demo::addMillion);
        Thread th2 = new Thread(demo::addMillion);
        Thread th3 = new Thread(demo::addMillion);

        th1.start();
        th2.start();
        th3.start();

        th1.join();
        th2.join();
        th3.join();


        System.out.println("Total = "+total);

        //On souhaite lacer une centaine de copies de fichiers au mm temps

        //Définir un ThreadPool: réservoir de thread

        String src1 = "a.tmp";
        String src2 = "b.tmp";
        String src3 = "c.tmp";
        String src4 = "d.tmp";

        String dest1 = "e.tmp";
        String dest2 = "f.tmp";
        String dest3 = "g.tmp";
        String dest4 = "h.tmp";

        ExecutorService executor = Executors.newFixedThreadPool(2);

        Thread copy1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Copy1 ....."+Thread.currentThread().getName());
                try {
                    FileTool.copy(src1, dest1);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread copy2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Copy2 ....."+Thread.currentThread().getName());
                try {
                    FileTool.copy(src2, dest2);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread copy3 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Copy3 ....."+Thread.currentThread().getName());
                try {
                    FileTool.copy(src3, dest3);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread copy4 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Copy1 ....."+Thread.currentThread().getName());
                try {
                    FileTool.copy(src4, dest4);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });

        executor.execute(copy1);
        executor.execute(copy2);
        executor.execute(copy3);
        executor.execute(copy4);

        int a = 25, b = 50;
        int resultat = 0;

        //Exécuter une tâche asynchrone et récupérer e résultat à la fin de son exécution

        Future<Integer> future = executor.submit(new Callable<Integer>() {

            @Override
            public Integer call() throws Exception {
                Thread.sleep(1000); //simuler une tâche lente
                return a + b;
            }
        });

        //comment savoir si la tâche à finie son exécution

        resultat = future.get(); //exécute un join
        System.out.println("Résultat = "+resultat);

        executor.shutdown(); //libérer les threads monopolisés par ce réservoir

    }

    //Gestion des accès concurrentiels à la ressource partagée

    public synchronized static void addMillion(){
        for (int i = 0; i < 1000000; i++){
            total++;
        }
    }
}
