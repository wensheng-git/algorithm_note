import java.util.ArrayList;
import java.util.List;

/**
 * @author :zhangwensheng
 * @date : 2022/11/3  0003 22:46
 *
 * 全排列：它的每一个元素都要，只是顺序不一样而已
 *
 * 子序列是要和不要两种可能
 * 排列是我这个位置可以用n-已经选了元素种可能。。用for循环表示还可以选的次数
 * for循环层序遍历
 */
public class AllPermutations {
    /*
    * reset:可以选择的元素，最开始就是str的全部
    * 必须：
    * str: 数组
    * path: 一个排列
    * list：收集的排列
    * */
    public static void process1(char[] str, List<Character> reset, String path, List<String> list){
        if (reset.isEmpty()){
            list.add(path);
            return;
        }
        // TODO:还有问题??????????????????去重
        boolean[] visited=new boolean[256];
        for (int i=0;i<reset.size();i++){//还有多少个没有处理
                if (!visited[str[i]]) {//我这个位置如果第一个选择了一个元素,第二次后面的元素和前面一样,那么我不用再去讨论这个元素作为这个位置的情况了
                    visited[str[i]]=true;
                    char cur = reset.get(i);
                    reset.remove(i);
                    // path不能放外面，不然不能回溯
                    process1(str, reset, path + cur, list);
                    reset.add(i, cur);//回溯（是保证答案的可靠）
                }
        }
    }

    //TODO：好的全排列：每次到达位置它的可能性是自己和后面数组所有的元素，通过交换来得到
    public static void process2(char[] str, int index, List<String> list){
        if(index==str.length){
            list.add(String.valueOf(str));
            return ;
        }
        //去重的元素标志
        boolean[] visited=new boolean[256];
        for (int i=index;i<str.length;i++){//index还有几个节点没有处理
            if (!visited[str[i]]) {
                visited[str[i]]=true;//如果我们元素位置一样,那么交换后的排列是一样的
                swap(str, index, i);//处理
                process2(str, index + 1, list);//深度处理
                swap(str, index, i);//回溯
            }
        }

    }
    public static void swap(char[] str,int i,int j){
        char temp=str[i];
        str[i]=str[j];
        str[j]=temp;
    }

    public static void main(String[] args) {
        String s="cbc";
        char[] chars = s.toCharArray();
        String path="";
        List<String> list = new ArrayList<>();
        List<Character> reset = new ArrayList<>();
        for (char c: chars){
            reset.add(c);
        }
        process1(chars,reset,path,list);
        for (String s1 : list){
            System.out.println(s1);
        }

        System.out.println("===========================");
        list.clear();
        process2(chars,0,list);
        for (String s1 : list){
            System.out.println(s1);
        }
    }
}
