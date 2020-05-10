import java.util.ArrayList;
import java.util.List;

import soot.PackManager;
import soot.Scene;
import soot.SootClass;
import soot.SootMethod;
import soot.options.Options;

public class SootDemo {

	public static void main(String[] args) {
		Options.v().parse(args);
		SootClass c = Scene.v().forceResolve("SampleCode", SootClass.BODIES);
		c.setApplicationClass();
		Scene.v().loadNecessaryClasses();
		SootMethod method = c.getMethodByName("printFizzBuzz");
		List entryPoints = new ArrayList<SootMethod>();
		entryPoints.add(method);
		Scene.v().setEntryPoints(entryPoints);
		PackManager.v().runPacks();
	}
}
