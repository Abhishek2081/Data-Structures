package test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.*;

public class testCode1 {

	public static void main(String[] args) {
		
		LinkedList<Integer> list = new LinkedList<>();
		ArrayList<Integer> arlist = new ArrayList<>();
		
		getTimeDiff(arlist);
		getTimeDiff(list);
	}
	
	static void getTimeDiff(List <Integer> list)
	{
		long start = System.currentTimeMillis();
		
		for(int i = 0; i < 100000; i++)
		{
			//list.add(i);
			list.add(0, i);
		}
		
		long end = System.currentTimeMillis();
		
		System.out.println(list.getClass().getName() + " --> " + (end - start));
	}

}
