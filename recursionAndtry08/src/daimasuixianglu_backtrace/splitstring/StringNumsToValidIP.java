package daimasuixianglu_backtrace.splitstring;

/**
 * @author :zhangwensheng
 * @date : 2022/11/6  0006 10:35
 */
public class StringNumsToValidIP {
    /*
    * 有效ip和切割子串一样
    * 第一个刀从index=0开始切,第一个刀可能性(0,0)(0,1)...遇到(0,i)的切割无效,那么(0,i+k)都是无效的，直接break。。。i+1的位置加入点，回溯是去了“。”重新画点
    * 第二刀从第一个刀结尾的i+2开始，因为i+1要变为   “。”
    * base case ip的点数等于3，切最后一刀后面部分也是有效的，那么这种方法整体就是有效的
    * */

}
