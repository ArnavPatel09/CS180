package homework_8;

import java.io.File;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 File testFile = new File("");
		 String currentPath = testFile.getAbsolutePath();
		 System.out.println("current path is: " + currentPath);
	}

}
