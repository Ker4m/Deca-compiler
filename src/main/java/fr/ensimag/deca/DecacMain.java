package fr.ensimag.deca;

import org.apache.log4j.Logger;

import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Main class for the command-line Deca compiler.
 *
 * @author gl09
 * @date 01/01/2022
 */
public class DecacMain {
    private static final Logger LOG = Logger.getLogger(DecacMain.class);

    public static void main(String[] args) {
        // example log4j message.
        LOG.info("Decac compiler started");
        boolean error = false;
        final CompilerOptions options = new CompilerOptions();
        try {
            options.parseArgs(args);
        } catch (CLIException e) {
            System.err.println("Error during option parsing:\n"
                    + e.getMessage());
            System.out.println();
            options.displayUsage();
            System.exit(1);
        }

        if (options.getPrintBanner()) {
            options.displayBanner();
            System.exit(0);
        }
        if (options.getSourceFiles().isEmpty()) {
            options.displayUsage();
            // pas vraiment utiliser car si pas de fichier c'est attraper en tant qu'erreur
        }
        if (options.getParallel()) {
            ExecutorService executor = Executors.newFixedThreadPool(java.lang.Runtime.getRuntime().availableProcessors());
            /*
            — Soumettre aux travailleurs une tâche par fichier à exécuter (ExecutorService.submit()). On
            obtient un ensemble de Future<Boolean>, c’est à dire une classe représentant une valeur qui n’est
            peut-être pas encore calculée. Ici, la valeur est la valeur de retour de DecacCompiler.compile()
            — Pour chaque Future, appeler la méthode get qui va attendre que la compilation soit terminée
            si ce n’est pas déjà le cas.
            */
            ArrayList<Future<Boolean>> results = new ArrayList<>(options.getSourceFiles().size());

            for (File source : options.getSourceFiles()) {
                DecacCompiler compiler = new DecacCompiler(options, source);
                results.add(executor.submit(Executors.callable(new Runnable() {
                    @Override
                    public void run() {
                        compiler.compile();
                    }
                }, false)));

            }
            for (Future<Boolean> res : results) {
                try {
                    if (res.get()) {
                        error = true;
                    }
                } catch (InterruptedException e) {
                    error = true;
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    error = true;
                    e.printStackTrace();
                }
            }
            executor.shutdown();

        } else {
            for (File source : options.getSourceFiles()) {
                DecacCompiler compiler = new DecacCompiler(options, source);
                if (compiler.compile()) {
                    error = true;
                }
            }
        }
        System.exit(error ? 1 : 0);
    }
}
