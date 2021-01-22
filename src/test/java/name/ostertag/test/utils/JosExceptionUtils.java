package name.ostertag.test.utils;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.stream.Collectors;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.NotFoundException;

public class JosExceptionUtils {

	/**
	 * gives a filtered Stacktrace as string. So only our Stacktrace Elements are
	 * shown. For now we filter to StartsWith("name.ostertag");
	 *
	 * @param e
	 * @return
	 */
	public static String CompactStackTrace(Exception e) {
		String result = "";
		final String message = e.getMessage();
		result += message + "\n";
		final StackTraceElement[] stackTrace = e.getStackTrace();

		result += Arrays.stream(stackTrace)//
				.filter(se -> se.getClassName().startsWith("name.ostertag")) //
				.map(stackTraceElement -> "	at " + stackTraceElement.toString())//
				.collect(Collectors.joining("\n")); //
		return result;

	}

	/**
	 * Returns a string which can be used to reference the Method in the Eclipse
	 * Debug output. The benefit is that eclipse will convert this line to a
	 * clickable link which brings you directly to the method definition.
	 *
	 * @param method
	 * @return
	 */
	public static String getEclipseDebugString(Method method) {
		final Class<?> clazz = method.getDeclaringClass();
		final ClassPool pool = ClassPool.getDefault();
		int lineNumber = 0;
		try {
			final CtClass ctClass = pool.get(clazz.getName());
			final CtMethod ctMethod = ctClass.getDeclaredMethod(method.getName());
			lineNumber = ctMethod.getMethodInfo().getLineNumber(0);
		} catch (final NotFoundException e) {
		}

		return clazz.getName() + "." + method.getName() + "(" + clazz.getSimpleName() + ".java:" + lineNumber + ")";

	}
}
