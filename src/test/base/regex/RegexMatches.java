package test.base.regex;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexMatches {
	public static void main(String[] args) {
		testAndOrSplit();
	}

	/**
	 * 通过match解析参数
	 */
	public static void testUrlParams() {
		String s = "key=12&ctrl=ab&test=";
		Pattern p = Pattern.compile("([^&]{1,})(=)([^&]{0,})");
		Matcher m = p.matcher(s);
		while (m.find()) {
			System.out.println(" m.group(): " + m.group()); // 打印所有

			System.out.println(" m.group(1): " + m.group(1)); // 打印数字的

			System.out.println(" m.group(2): " + m.group(2)); // 打印字母的
			System.out.println(" m.group(3): " + m.group(3)); // 打印字母的
			System.out.println();

		}
		System.out.println(" 捕获个数:groupCount()= " + m.groupCount());
	}

	public static void testAndOrSplit() {
		List<String> result = new LinkedList<String>();
		String s = "key=12 and ctrl=ab or selec 1 from ";
		Pattern p = Pattern.compile("( and | or )");
		Matcher m = p.matcher(s);
		System.out.println("切割符：");
		Queue<String> splitterList = new LinkedList<String>();
		while (m.find()) {
			splitterList.offer(m.group().trim());
			System.out.println(" m.group(): " + m.group()); // 打印所有
		}
		String[] sarr = s.split(" and | or ");
		Queue<String> matcherList = new LinkedList<String>();
		for (String s1 : sarr) {
			matcherList.offer(s1);
			System.out.println(s1);
		}
		int size = splitterList.size()+matcherList.size();
		for(int i=0;i<size;i++){
			if(i%2==0){
				result.add(matcherList.poll());
			}else{
				result.add(splitterList.poll());
			}
		}
		System.out.println("最终叠加结果：");
		for (String r : result) {
			System.out.println(r);
		}
	}

	public static void main2(String[] args) {
		// 按指定模式在字符串查找
		String line = "This order was placed for QT3000! OK?123";
		String pattern = "(\\D*)(\\d+)(.*)";

		// 创建 Pattern 对象
		Pattern r = Pattern.compile(pattern);

		// 现在创建 matcher 对象
		Matcher m = r.matcher(line);
		if (m.find()) {
			System.out.println("Found value: " + m.group(0));
			System.out.println("Found value: " + m.group(1));
			System.out.println("Found value: " + m.group(2));
			System.out.println("Found value: " + m.group(3));
		} else {
			System.out.println("NO MATCH");
		}
	}

}
