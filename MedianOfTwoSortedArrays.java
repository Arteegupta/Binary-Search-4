//Time Complexity : O(log n); where n is length of smaller array
//Space Complexity : O(1)
public class MedianOfTwoSortedArrays {	
	/**Approach: Binary search **/
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1= nums1.length; int n2= nums2.length;   
        
        //Swap arrays to partition on smaller array
        if(n1 > n2) return findMedianSortedArrays(nums2, nums1);       
        
        int low= 0; int high=n1;         
        while(low<=high){
            int partX= low+(high-low)/2;            
            int partY= (n1+n2)/2- partX;            
            double L1= (partX==0)? Integer.MIN_VALUE : nums1[partX-1];
            double R1= (partX==n1)? Integer.MAX_VALUE : nums1[partX];
            double L2= (partY==0)? Integer.MIN_VALUE : nums2[partY-1];
            double R2= (partY==n2)? Integer.MAX_VALUE : nums2[partY];
            
            if(L1<=R2 && L2<=R1){
                //Correct partition, find median
                if((n1+n2)%2==0){//even 
                    return (Math.max(L1,L2) + Math.min(R1,R2))/2;
                }else{//odd
                    return Math.min(R1,R2);
                }                
            }else if (L1 > R2){
                high= partX-1;
            }else if (L2 > R1){
                low= partX+1;
            }        
        }
        
        return 1.0;        
    }
	
	// Driver code to test above
	public static void main (String[] args) {
		MedianOfTwoSortedArrays ob = new MedianOfTwoSortedArrays();	
		/*int[] arr1= {1,3};
		int[] arr2= {2};*/
		
		int[] arr1= {1,7,8,10,11};
		int[] arr2= {2,3,4,5,6,12,13};
        
        System.out.println("Median:"+ ob.findMedianSortedArrays(arr1, arr2));        
	}	
}
