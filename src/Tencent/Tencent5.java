package Tencent;

public class Tencent5 {
    /**
     * The rand7() API is already defined in the parent class SolBase.
     * public int rand7();
     * @return a random integer in the range 1 to 7
     */

    public int rand10() {
        while(true){
            int num = (rand7()-1)*7 + rand7(); //等概率生成[1,49]
            if(num<=40){
                return num%10 + 1;
            }
        }
    }

}
