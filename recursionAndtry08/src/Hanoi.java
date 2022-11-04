/**
 * @author :zhangwensheng
 * @date : 2022/11/3  0003 21:39
 *
 * TODO:对于递归要有宏观的认识--写好base case,再想清楚宏观逻辑
 */
public class Hanoi {
    /*
    * from,to,other三个圆盘
    * 要求从from移到to中
    * */
    static int count=0;
    public static void func(int n,String from,String to,String other){
        if (n == 1){ //base case
            System.out.println(1+":"+from+"==>"+to);
            return;
        }

        /*
        * 核心逻辑:宏观逻辑
        * */
        //先把n-1从from移道other中(此时other变为了to)
        func(n-1,from,other,to);
        System.out.println(n+":"+from+"==>"+to);
        count++;
        //把n-1从other移到to(此时other变为from)
        func(n-1,other,to,from);
    }

    public static void main(String[] args) {
        func(3,"left","right","mid");
        System.out.println(count);
    }
}
