/* Minigame
 * Methods for battle / training slider minigame
 * Author: Xandino
*/
package digiProject;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Minigame extends mainDigivice{
	
	//filename argument points to a text file in the /res directory
	private java.util.List<Integer> getAttackMeter(Path filePath) {
		try {
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
		FilePathGen f = new FilePathGen();
		Path filePath = f.getFilePath("AM.txt");
		java.util.List<Integer> attackMeter = minigame.getAttackMeter(filePath);
		if (attackMeter.size() == 0) {
			return;
		}
		java.util.ListIterator<Integer> iterator = attackMeter.listIterator();
		
		
		//Rest of code currently used for testing 
		System.out.println(attackMeter.size());
		System.out.println(attackMeter);
		for (int i=0; i < attackMeter.size(); i++) {
			System.out.print(iterator.next());
		}
		System.out.println();
		//Resets iterator to first position
		iterator = attackMeter.listIterator();
		//Loop structure for iterating through the attack meter from beginning to end and back to beginning in sequence
		int i = 0;
		boolean goFoward = true;
		while (i<60) {
			while (goFoward == true) {
				if (iterator.hasNext()) {
					System.out.print(iterator.next());
					++i;
				}
				else {
					goFoward = !goFoward;
				}
			}
			while (goFoward == false) {
				if (iterator.hasPrevious()) {
					System.out.print(iterator.previous());
					++i;
				}
				else {
					goFoward = !goFoward;
				}
			}
		}
	}

}
