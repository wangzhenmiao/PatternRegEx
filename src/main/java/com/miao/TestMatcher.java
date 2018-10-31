package com.miao;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @ClassName TestMatcher
 * @Description
 * @Author wangzhen
 * @Date 2018/10/31 下午2:43
 **/
public class TestMatcher {
    public static void main(String[] args) {

/*        介绍：
       1、 group是针对（）来说的，group（0）就是指的整个串，group（1） 指的是第一个括号里的东西，group（2）指的第二个括号里的东西
        2、 据我观察：matcher.end 会把符合条件的索引值+1，例如："Hello,World!"中！的索引是11，但是matcher.end(0)输出的是12，在截取字符串的时候也注意吧
         3、public String substring(int beginIndex, int endIndex)
         beginIndex -- 起始索引（包括）, 索引从 0 开始。
         endIndex -- 结束索引（不包括）。
         是不包括endIndex的*/

        String str = "Hello,World! in Java.";
        Pattern pattern = Pattern.compile("W(or)(ld!)");
        Matcher matcher = pattern.matcher(str);
        while(matcher.find()){
            System.out.println("Group 0:"+matcher.group(0));//得到第0组——整个匹配
            System.out.println("Group 1:"+matcher.group(1));//得到第一组匹配——与(or)匹配的
            System.out.println("Group 2:"+matcher.group(2));//得到第二组匹配——与(ld!)匹配的，组也就是子表达式
            System.out.println("Start 0:"+matcher.start(0)+" End 0:"+matcher.end(0));//总匹配的索引
            System.out.println("Start 1:"+matcher.start(1)+" End 1:"+matcher.end(1));//第一组匹配的索引
            System.out.println("Start 2:"+matcher.start(2)+" End 2:"+matcher.end(2));//第二组匹配的索引
            System.out.println(str.substring(matcher.start(0),matcher.end(1)));//从总匹配开始索引到第1组匹配的结束索引之间子串——Wor
        }
    }
 /*   输出：
    Group 0:World!
    Group 1:or
    Group 2:ld!
    Start 0:6 End 0:12
    Start 1:7 End 1:9
    Start 2:9 End 2:12
    Wor*/

}
