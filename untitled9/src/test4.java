public class test4 {
    /*    public int FindGreatestSumOfSubArray1(int[] array){
            int max = -99999;

            if(array.length < 1){
                return max;
            }
            for(int i=0; i<array.length; i++){
                int temp1 = 0;
                for(int j=i; j<array.length; j++){
                    temp1 += array[j];
                    if(temp1 > max){
                        max = temp1;
                    }
                }
            }
            return max;
        }*/

        /**
         * 动态规划
         * @param array
         * @return
         */
        public int FindGreatestSumOfSubArray(int[] array){
            int max = array[0];
            int res = array[0];
            for(int i=1; i<array.length; i++){
                max = (max+array[i]) > array[i] ? max+array[i] : array[i];
                res = max>res ? max : res;
            }
            return res;
        }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] array = {-1,2,1};
        test4 test4 = new test4();
        System.out.println(test4.FindGreatestSumOfSubArray(array));


    }




}
