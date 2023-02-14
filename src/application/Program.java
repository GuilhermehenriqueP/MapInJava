package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Program {
	public static void main(String[] args) {
		
Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter file full path: ");
		String path = sc.nextLine();
		
		Map<String, Integer> candidates = new TreeMap<>();
		
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {

			String line = br.readLine();
			while (line != null) {
				String[] fields = line.split(",");
				String Name = fields[0];
				int votes = Integer.parseInt(fields[1]);
				
				
				if(candidates.containsKey(Name)) {
					votes = votes + candidates.get(Name);
				}
				
				candidates.put(Name, votes);
				line = br.readLine();
			}	

		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		
		for(String key : candidates.keySet()){
			System.out.println(key + " " + "votes: " + candidates.get(key));
		}
		sc.close();
		
	}
}
