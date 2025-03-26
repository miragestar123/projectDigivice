/* Minigame
 * Methods for battle / training slider minigame
 * Author: Xandino
*/
package digiProject;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Minigame extends mainDigivice{
	
	//filename argument points to a text file in the /res directory
	private java.util.List<Integer> getAttackMeter(String filename) {
		try {
			Path filePath = Paths.get("src", "digiProject", "res", filename).toAbsolutePath();
        	java.util.List<String> lines = Files.readAllLines(filePath);
            java.util.List<Integer> attackMeter = new java.util.LinkedList<>();
            for (String line : lines) {
                attackMeter.add(Integer.parseInt(line.trim()));
            }
            return attackMeter;
        }
        
        catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
            return new java.util.LinkedList<>();
        }
        
	}
	
	public static void main(String[] args) {
		Minigame minigame = new Minigame();
		String fileName = "AM.txt";
		java.util.List<Integer> attackMeter = minigame.getAttackMeter(fileName);
		if (attackMeter.size() == 0) {
			return;
		}
		else {
			System.out.println(attackMeter.size());
		}
		java.util.ListIterator<Integer> iterator = attackMeter.listIterator();
		
		
		//Rest of code currently used for testing 
		System.out.println(attackMeter);
		for (int i=0; i < attackMeter.size(); i++) {
			System.out.print(iterator.next());
		}
		System.out.println();
		iterator = attackMeter.listIterator();
		int i = 0;
		while (iterator.hasNext() || iterator.hasPrevious()) {
			if (i==60) {
				return;
			}
			++i;
			if (iterator.hasNext()) {
				System.out.print(iterator.next());
				continue;
			}
			if (iterator.hasPrevious()) {
				System.out.print(iterator.previous());
				continue;
			}
		}
	}

}
