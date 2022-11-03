
public class MedianOfSortedArray {
	
	public static void main(String args[]) {
		System.out.println(findMedianSortedArrays(new int[] {1,2,3,4,5}, new int[] {6,7,8,9,10}));
	}
	

	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int l1 = nums1.length;
		int l2 = nums2.length;
		int low = 0, high = l1 - 1;
		int noOfElements1 = (high - low) / 2;
	nums1[-1] = nums2[-1] = Integer.MIN_VALUE;
		int noOfElements2 = (l1 + l2 + 1) / 2 - noOfElements1;
		while (!(nums1[high - 1] <= nums2[noOfElements2] && nums1[high] >= nums2[noOfElements2 - 1])) {
			noOfElements1 = (high - low) / 2;
			noOfElements2 = (l1 + l2 + 1) / 2 - noOfElements1;
			if (nums1[high - 1] > nums2[noOfElements2])
				high /= 2;
			else
				high = (l1-1 - high) / 2;
		}
		return (l1 + l2) % 2 == 0
				? (double) (Math.max(nums1[high - 1], nums2[noOfElements2 - 1])
						+ Math.min(nums1[high], nums2[noOfElements2])) / 2
				: Math.max(nums1[high - 1], nums2[noOfElements2 - 1]);
	}
	
	
	

}
