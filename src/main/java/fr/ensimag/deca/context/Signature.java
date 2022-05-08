package fr.ensimag.deca.context;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Signature of a method (i.e. list of arguments)
 *
 * @author gl09
 * @date 01/01/2022
 */
public class Signature {
    List<Type> args = new ArrayList<Type>();

    public void add(Type t) {
        args.add(t);
    }

    public boolean isNotCompatible(Signature signature) {
        if (args.size() != signature.args.size()) {
            return true;
        }
        Iterator<Type> itThis = args.iterator();
        Iterator<Type> itOther = signature.args.iterator();
        while (itThis.hasNext()) {
            Type tThis = itThis.next();
            Type tOther = itOther.next();
            if (!tThis.getName().equals(tOther.getName())) {
                if (tThis.isClass() && tOther.isClass()) {
                    if (((ClassType) tThis).isSubClassOf((ClassType) tOther) || ((ClassType) tOther).isSubClassOf((ClassType) tThis)) {
                        continue;
                    }
                }
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return args.toString();
    }

}
