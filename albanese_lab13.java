import java.util.*;
//import java.util.stream.*;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class albanese_lab13 {

	public java.util.ArrayList<Integer> fileData = new ArrayList<>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*readData(args[0]);
	

		System.out.println(getTotalCount());
		System.out.println(	getOddCount());
		System.out.println(	getEvenCount());
		System.out.println(getDistinctGreaterThanFiveCount());*/
	}

	public void readData(String filename) {
		
	
		String inn = "";
		
		try {
			
			BufferedReader input = new BufferedReader(new InputStreamReader(new FileInputStream(filename)));
				while((inn = input.readLine()) != null){
			
					fileData.add(Integer.parseInt(inn));
					
				}
		
				
			input.close();
			
			}
		catch(Exception e) {
			
		}
		
	}
	
	public long getTotalCount() {
		
		//fileData.parallelStream().count();
		
		return fileData.stream().count();
	}
	
	public long getOddCount() {
		//fileData.stream().filter(x -> x % 3 == 0).count();
		//return fileData.stream().filter(x -> x % 2 != 0).count();
		return fileData.stream().filter(x -> x % 2 == 1).count();
	}
	
	public long getEvenCount() {
		
		return fileData.stream().filter(x -> x % 2 == 0).count();
	}
	
	public long getDistinctGreaterThanFiveCount() {
		
		return fileData.stream().distinct().filter(x -> x > 5).count();
	}
	
	public Integer[] getResult1() {
		
		
		Integer[] listSorted = fileData.stream().filter(x -> (x % 2 == 0) && (x>5) && (x<50)).sorted().toArray(Integer[]::new);
		
		return listSorted;
	}
	
	public Integer[] getResult2() {
		//Use a stream to return the first 50 of the values in the ArrayList after
		//squaring each of the values and multiplying by 3 as and Integer[]
		
		//Integer[] listSorted = fileData.stream().limit(50).sorted().toArray(Integer[]::new);
		Integer[] listSorted = fileData.stream().limit(50).map(x -> (x*x)*3).toArray(Integer[]::new);
		return listSorted;
	}
	
	public Integer[] getResult3() {
		/*Use a stream to filter out the even values (or keep the odd values),
		multiply the remaining values by 2, sorting the values, skipping over the
		first 20 elements, and removing duplicate values from the ArrayList, and
		return the values as an Integer[] */
		Integer[] listSorted = fileData.stream().filter(x -> x % 2 == 1).map(x -> x*2).sorted().skip(20).distinct().toArray(Integer[]::new);

		return listSorted;
	}
}
