package homework_11;

public class test {
	
	public static int occur(String line, char character, int index) {
		int count = 0;
		
		if (index >= line.length())
			return 0;
		if (line.toLowerCase().charAt(index) == character) { 
			count++;
		}
		
		return count + occur(line, character, index + 1);
	}
	
	public static String numLetter(String line) { 
		int[] freq = new int[26];
		String letToString = "";
		freq[0] = occur(line, 'a', 0);
		freq[1] = occur(line, 'b', 0);
		freq[2] = occur(line, 'c', 0);
		freq[3] = occur(line, 'd', 0);
		freq[4] = occur(line, 'e', 0);
		freq[5] = occur(line, 'f', 0);
		freq[6] = occur(line, 'g', 0);
		freq[7] = occur(line, 'h', 0);
		freq[8] = occur(line, 'i', 0);
		freq[9] = occur(line, 'j', 0);
		freq[10] = occur(line, 'k', 0);
		freq[11] = occur(line, 'l', 0);
		freq[12] = occur(line, 'm', 0);
		freq[13] = occur(line, 'n', 0);
		freq[14] = occur(line, 'o', 0);
		freq[15] = occur(line, 'p', 0);
		freq[16] = occur(line, 'q', 0);
		freq[17] = occur(line, 'r', 0);
		freq[18] = occur(line, 's', 0);
		freq[19] = occur(line, 't', 0);
		freq[20] = occur(line, 'u', 0);
		freq[21] = occur(line, 'v', 0);
		freq[22] = occur(line, 'w', 0);
		freq[23] = occur(line, 'x', 0);
		freq[24] = occur(line, 'y', 0);
		freq[25] = occur(line, 'z', 0);
		
		
		
		for (int k = 0; k < freq.length; k++) { 
			if (freq[k] != 0) {
				letToString += String.format("%c-%d ", ((char) (k + 65)), freq[k]);
			}
			if (k == 9)
				letToString.stripTrailing();
		}
		return letToString;
	}
	
	public static void main(String[] args) {
		int k = 25;
		System.out.println(numLetter("yes"));

	}

}
