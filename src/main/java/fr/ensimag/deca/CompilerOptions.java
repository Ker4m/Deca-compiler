package fr.ensimag.deca;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.io.File;
import java.nio.file.Files;
import java.util.*;

/**
 * User-specified options influencing the compilation.
 *
 * @author gl09
 * @date 01/01/2022
 */
public class CompilerOptions {
    public static final int QUIET = 0;
    public static final int INFO = 1;
    public static final int DEBUG = 2;
    public static final int TRACE = 3;
    private final List<File> sourceFiles = new ArrayList<File>();
    private int debug = 0;
    private boolean parallel = false;
    private boolean parse = false;
    private boolean verif = false;
    private boolean noCheck = false;
    private boolean printBanner = false;
    private boolean comments = false;
    private int X = 16; // argument of -r option, by default the nb of reg is 15 (X-1)

    public int getDebug() {
        return debug;
    }

    public boolean getParallel() {
        return parallel;
    }

    public boolean getPrintBanner() {
        return printBanner;
    }

    public boolean getNoCheck() {
        return noCheck;
    }

    public boolean getParse() {
        return parse;
    }

    public boolean getVerif() {
        return verif;
    }

    public boolean getComments() {
        return comments;
    }

    public int getX() {
        return X;
    }

    public List<File> getSourceFiles() {
        return Collections.unmodifiableList(sourceFiles);
    }

    public void parseArgs(String[] args) throws CLIException {
        int i = 0;
        Set<File> setSourceFiles = new HashSet<File>(); // on utilise un set pr gérer les doublons dans un premier temps
        while (i < args.length) {
            switch (args[i]) {
                case "-b":
                    if (args.length > 1) {
                        throw new CLIException("    -b option has to be used with no other argument");
                    } else {
                        printBanner = true;
                    }
                    break;

                case "-p":
                    parse = true;
                    break;

                case "-v":
                    verif = true;
                    break;

                case "-n":
                    noCheck = true;
                    break;

                case "-c":
                    comments = true;
                    break;

                case "-r":
                    i++;
                    X = Integer.parseInt(args[i]);
                    if (!(4 <= X && X <= 16)) {
                        throw new CLIException("    The -r option must be followed by an integer between 4 and 16.");
                    }
                    break;

                case "-d":
                    debug++;
                    break;

                case "-P":
                    parallel = true;
                    break;

                default:
                    File f = new File(args[i]);
                    if (!Files.exists(f.toPath())) {
                        throw new CLIException("    File : " + f + " does not exist");
                    }
                    if (!f.toString().endsWith(".deca")) {
                        throw new CLIException("    File : " + f + " is not in format .deca");
                    }
                    setSourceFiles.add(f);

            }
            i++;
        }
        sourceFiles.addAll(setSourceFiles);
        if (verif && parse) {
            throw new CLIException("    The -v and -p options are not compatible");
        }
        if (debug > 3) {
            throw new CLIException("    The -d option is limited to 3 iterations");
        }
        if (!printBanner && sourceFiles.isEmpty()) {
            throw new CLIException("    No file in argument");
        }

        Logger logger = Logger.getRootLogger();
        // map command-line debug option to log4j's level.
        switch (getDebug()) {
            case QUIET:
                break; // keep default
            case INFO:
                logger.setLevel(Level.INFO);
                break;
            case DEBUG:
                logger.setLevel(Level.DEBUG);
                break;
            case TRACE:
                logger.setLevel(Level.TRACE);
                break;
            default:
                logger.setLevel(Level.ALL);
                break;
        }

        logger.info("Application-wide trace level set to " + logger.getLevel());

        boolean assertsEnabled = false;
        assert assertsEnabled = true; // Intentional side effect!!!
        if (assertsEnabled) {
            logger.info("Java assertions enabled");
        } else {
            logger.info("Java assertions disabled");
        }

    }

    protected void displayUsage() {
        // ajouter -w
        System.out.println("Usage: decac [[-p | -v] [-n] [-r X] [-d]* [-P] [-c] <fichier deca>...] | [-b]");
        System.out.println("where possible options are:");
        System.out.println("    -b      (banner) : display a banner with the name of team\n");
        System.out.println("    -p      (parse) : stops decac after the tree construction step, and displays the decompilation of the tree (i.e. if there is only one source file to compile, the output should be a syntactically correct deca program)\n");
        System.out.println("    -v      (verification) : stops decac after the verification step (does not produce any output if there is no error)\n");
        System.out.println("    -n      (no check) : removes the runtime tests specified in 11.1 and 11.3 of the Deca semantics.\n");
        System.out.println("    -r X    (registers) : limits the available unmarked registers to R0 ... R{X-1}, with 4 <= X <= 16\n");
        System.out.println("    -d      (debug) : enables debugging traces. Repeat the option several times to get more traces.\n");
        System.out.println("    -P      (parallel) : if there are several source files, launches the compilation of the files in in parallel (to speed up the compilation)\n");
        System.out.println("    -c      (comments) : write the comments in the .ass file\n");

    }

    public void displayBanner() {
        System.out.println("----------------------------------------------------------------------------------------------------");
        System.out.println("|                                  Projet GL 2022                                                  |");
        System.out.println("----------------------------------------------------------------------------------------------------");
        System.out.println("|                               Team n°09 in group 2                                               |");
        System.out.println("|                                                                                                  |");
        System.out.println("| Members :  Marek Elmayan, Hugo Dabadie, Garence Dupont-Ciabrini, Julien Lalanne, Yanis Bouhjoura |");
        System.out.println("|                                                                                                  |");
        System.out.println("----------------------------------------------------------------------------------------------------");
    }
}
