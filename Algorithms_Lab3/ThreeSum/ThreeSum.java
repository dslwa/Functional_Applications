package ThreeSum;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import Exceptions.EmptyArray;
import Printable.Printable;
public class ThreeSum implements Printable{
    private int nums[];

    public ThreeSum(int n[]) {
        this.nums = n;
    }
    public List<List<Integer>> threeSum() {
        try{
            if(nums.length == 0){
                throw new EmptyArray("Array is empty");
            }
        }
        catch(EmptyArray a){
            System.out.printf(a.getMessage());
        }
        Arrays.sort(nums);
        List<List<Integer>> output_arr = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
                int left_pointer = i + 1;
                int right_pointer = nums.length - 1;
                int sum = 0 - nums[i];

                while (left_pointer < right_pointer) {
                    if (nums[left_pointer] + nums[right_pointer] == sum) {
                        output_arr.add(Arrays.asList(nums[i], nums[left_pointer], nums[right_pointer]));
                        while (left_pointer < right_pointer && nums[left_pointer] == nums[left_pointer + 1]) left_pointer++;
                        while (left_pointer < right_pointer && nums[right_pointer] == nums[right_pointer - 1]) right_pointer--;
                        left_pointer++;
                        right_pointer--;
                    } else if (nums[left_pointer] + nums[right_pointer] > sum) {
                        right_pointer--;
                    } else {
                        left_pointer++;
                    }
                }
            }
        }
        return output_arr;
    }

    @Override
    public void print() {
        System.out.print("Array: ");
        for (Integer o : nums) {
            System.out.print(o + " ");
        }
        System.out.println();
        List<List<Integer>> result = threeSum();
        System.out.println("ThreeSum:");
        for (List<Integer> triplet : result) {
            System.out.println(triplet);
        }
    }
}