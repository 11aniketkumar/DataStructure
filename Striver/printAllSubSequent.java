public class printAllSubSequent
{
    public static void subset(int index, String list, int[] arr) {
        if(index == arr.length) {
            System.out.println(list + " ]");
            return;
        }
        
        subset(index + 1, list, arr);
        
        list += " " + arr[index];
        subset(index + 1, list, arr);
    }
    
	public static void main(String[] args) {
		int[] arr = {1,2,3};
		String list = "[";
		subset(0, list, arr);
	}
}
