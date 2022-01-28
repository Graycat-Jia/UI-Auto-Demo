package debugTest;

import org.testng.annotations.Test;

/**
 * @Author GrayCat.
 * @date 2022/01/25 9:34
 */


public class SomeTest {

    @Test
    public int removeDuplicates(int[] nums) {
        int tmp=nums[0];
        int index = 0;
        for(int i=1;i<nums.length;i++){
           if(nums[i]==tmp){
                continue;
            }else{
                tmp = nums[i];
                index++;
                nums[index] = tmp;
            }
        }
        return index;
    }

}
