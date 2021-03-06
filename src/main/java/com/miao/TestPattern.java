package com.miao;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @ClassName TestPattern
 * @Description
 * @Author wangzhen
 * @Date 2018/10/31 上午11:18
 **/
public class TestPattern {

    public static void main(String[] args) {

  /*      case1:判断字符串中是否包含 a或者F 字母。
        用到了Pattern和Matcher两个类
        如果s中有regEx，那么rs为true，否则为flase。
        主要用到两个类
        import java.util.regex.Matcher;
        import java.util.regex.Pattern;
         输出：true*/
        String s = "@Shang Hai Hong Qiao Fei Ji Chang";
        String regEx = "a|F"; //表示a或F
        Pattern pat = Pattern.compile(regEx);
        Matcher mat = pat.matcher(s);
        boolean rs = mat.find();
        System.out.println(rs);

        //case2：忽略大小写
        //Pattern patIgnore=Pattern.compile(regEx,Pattern.CASE_INSENSITIVE);
        // 输出：true
        String str = "abcD";
        String regIgnore = "A|d";
        Pattern patIgnore=Pattern.compile(regEx,Pattern.CASE_INSENSITIVE);
        Matcher matIgnore = patIgnore.matcher(str);
        boolean rsIgnore = matIgnore.find();
        System.out.println(rsIgnore);

        //项目中的校验
        String jsonPath = "${curr.em}=OK";
        Pattern pattern = Pattern.compile("(\\$\\{[^\\}]+})");
        Matcher matJsonPath = pattern.matcher(jsonPath);
        boolean reJsonPath = matJsonPath.find();
        System.out.println(reJsonPath);

        //
        jsonPath = "${curr.data.products[2].product_id}= 1534994141512";
        Map<String,String> paramData = new HashMap<String,String>();
        Pattern pattern1 = Pattern.compile("(\\$\\{[^\\}]+})");
        Matcher matcher = pattern1.matcher(jsonPath);
        while(matcher.find()){
            String paramCode = matcher.group(1);
//            paramData.put(formatParamCode(paramCode), StringUtils.EMPTY);
            System.out.println(paramCode);
        }



    }
}
