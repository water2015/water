package sodoku;

import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import org.junit.rules.MethodRule;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.Statement;

public class SudokuRule implements MethodRule {

	@Override
	public Statement apply(Statement base, final FrameworkMethod method, Object target) {
		return new Statement() {
			@Override
			public void evaluate() throws Throwable {
				Path path = Paths.get(System.getProperty("soeid"), method.getName());
				Files.createDirectories(path);
				try (PrintStream consoleOut = new PrintStream(Files.newOutputStream(path.resolve("console.txt"),
						StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING, StandardOpenOption.WRITE))) {
					System.setOut(consoleOut);

					base.evaluate();
				}
			}
		};
	}

}
