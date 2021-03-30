package util;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindCsvListDiff {

	public static void main(String[] args) {
		String csvList1 = "14409,16675,80442,145751,291287,1028058,1213851,18484,118489,80442,845211,959512,1265523,31136,31137,1338884,123964,1034994,822164,563956,1241185,284089,388837,1210071,26527,22508,861231,196923,594963,82241,11998,1226562,352695,724216";
		String csvList2 = "1028058,1034994,118489,11998,1210071,1213851,1226562,123964,1241185,1265523,1338884,14409,16675,196923,22508,291287,31136,31137,352695,388837,563956,594963,724216,822164,145751,18484,26527,284089,82241,80442,845211,861231,959512";
		
		List<String> list1 = Arrays.asList(csvList1.split(","));
		List<String> list2 = Arrays.asList(csvList2.split(","));
		
		System.out.println(list1.size());
		System.out.println(list2.size());
		
		//Set<String> set1 = new HashSet<>(list1);
		//Set<String> set2 = new HashSet<>(list2);
		
		//set1.removeAll(set2);
		
		Collections.sort(list1);
		Collections.sort(list2);
		
		System.out.println("Sorted First list");
		for(String val: list1) {
			System.out.println(val);
		}
		
		System.out.println("Sorted Second list");
		for(String val: list2) {
			System.out.println(val);
		}
		for(String s1: list1) {
			if(!list2.contains(s1)) {
				System.out.println(s1);
			}
		}

	}

}
