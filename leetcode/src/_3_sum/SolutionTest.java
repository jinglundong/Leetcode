package _3_sum;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class SolutionTest {

	@Test
	public void testThreeSum() {
		Solution solution = new Solution();
		int[] in = new int[]{-1,-1,2};
		assertEquals(solution.threeSum(in).size(), 1);
		int[] in2 = new int[]{-1,0,1,2,-1,-4};
		assertEquals(solution.threeSum(in2).size(), 2);
		System.out.println(solution.threeSum(in2));
	}

	@Test
	public void testAddToList() {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> in = new ArrayList<Integer>();
		in.add(2);
		in.add(3);
		in.add(4);
		assertEquals(result.size(), 0);
		Solution solution = new Solution();		
		solution.addToList(result, (ArrayList<Integer>)in.clone());
		assertEquals(result.size(), 1);
		
		in.clear();
		in.add(2);
		in.add(3);
		in.add(3);
		solution.addToList(result, (ArrayList<Integer>)in.clone());
		System.out.println(result);
		assertEquals(result.size(), 2);
		
		solution.addToList(result, (ArrayList<Integer>)in.clone());
		assertEquals(result.size(), 2);	
		
		result.clear();
		in.clear();
		in.add(-4);
		in.add(0);
		in.add(4);
		solution.addToList(result, (ArrayList<Integer>)in.clone());
		assertEquals(result.size(), 1);	
		solution.addToList(result, (ArrayList<Integer>)in.clone());
		assertEquals(result.size(), 1);			
	}

}
