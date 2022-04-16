import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

//Time Complexity : O(m+n); where m and n are length given  arrays
//Space Complexity : O(n)
public class Solution {	
	/**Approach 1: HashMap**/
	public int[] intersect(int[] nums1, int[] nums2) {		
        if(nums1==null || nums2==null) return new int[0];        
        if(nums1.length > nums2.length) return intersect(nums2, nums1);
        
        //Add smaller array into hashset
        HashMap<Integer, Integer> map = new HashMap();
        for(int num: nums1){
            map.put(num, map.getOrDefault(num,0)+1);            
        }
                
        //Check common elements from other array
        List<Integer> list= new ArrayList<>();
        for(int num: nums2){
            if(map.containsKey(num)){
                list.add(num);
                map.put(num, map.getOrDefault(num,0)-1);
                map.remove(num,0);
            }
        }       
        return list.stream().mapToInt(i->i).toArray();       
    }
	
	/**Approach 2: Binary Search | Time O(m log n)| Space O(m + log n) after ignoring sorting**/
	/*public int[] intersect(int[] nums1, int[] nums2) {	
		if(nums1==null || nums2==null) return new int[0];        
        if(nums1.length > nums2.length) return intersect(nums2, nums1);
        int m= nums1.length; int n= nums2.length;
        List<Integer> list= new ArrayList<>(); 
        
        Arrays.sort(nums1);
        Arrays.sort(nums2);  
        
        int low = 0; int high = n-1;   
        for(int num: nums1){
            int idx= binarySearch(num, nums2, low, high);
            if(idx != -1){                
                low= idx + 1;    
                list.add(num);
            }
        }        
        return list.stream().mapToInt(i->i).toArray();
	}
	private int binarySearch(int target, int[] nums, int low, int high){               
        while(low <= high){
            int mid = low + (high-low)/2;
            if(nums[mid] == target){
                if(mid == low || nums[mid] > nums[mid-1]){//find very left element
                    return mid;
                }else{
                    high = mid-1;
                }             
            }else if (nums[mid] > target){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }        
        return -1;
    }*/
	
	// Driver code to test above
	public static void main (String[] args) {
		Solution ob = new Solution();	
		int[] nums1= {1,2,2,1};
		int[] nums2= {2,2};
		
		System.out.println("Intersection array: "+ Arrays.toString(ob.intersect(nums1, nums2)));
	}	
}
