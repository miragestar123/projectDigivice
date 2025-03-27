// FilePathGen
// Class for independent file path generation
// Return will be a "Path" type, use ".toString()" conversion method when needed
// Author: Xandino

package digiProject;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FilePathGen {
	public Path getFilePath(String filename) {
		Path filePath = Paths.get("src", "digiProject", "res", filename).toAbsolutePath();
		try {
			Files.lines(filePath);
		}
		catch(IOException e) {
			System.err.println("Error reading the file: " + e.getMessage());
			return Paths.get("");
		}
		return filePath;
	}

}
