public class Test3 {

    //截取字符串

    public static void main(String[] args){
        String str1 = "测ABC";
        String str2 = "测ABC试DEF";

        splitString(str1,4);
        splitString(str2,9);
    }
    public static void splitString(String str ,int len){
        if(null == str){
            System.out.println("The string is null");
            return;
        }
        int byteNum = 0 ;

        byte[] bt = str.getBytes();
        byteNum = bt.length;
        if(len > byteNum){
            len = byteNum;
        }
        if(bt[len]<0){
            str = new String(bt,0,--len);
            System.out.println(str);
        }
        else{
            str = new String(bt,0,len);
            System.out.println(str);
        }
    }
}
