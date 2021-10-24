package homework_6;

public class Test {
    public static int binarySearch(int[] input, int target) {
        // look for the index of target in input
        int low = 0;
        int high = input.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (input[mid] == target) { // middle element is the target. Success!!!
                return mid;
            } else if (input[mid] > target) { // middle element is greater than the target
                high = mid - 1;
            } else { // middle element is smaller than the target
                low = mid + 1;
            }
        }
        return -1; // element is not found
    }    
    
	public static void main(String[] args) {		
		//int i = 100;
		int [] array = {1, 3, 5, 7, 9, 11, 13, 15};
		
		
		System.out.println(binarySearch(array, 15));
		//System.out.println(String.valueOf(i).length());

		}

}
