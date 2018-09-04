package com.t;


public class T_test<T> {

    private T t;

    public static void main(String[] args) {
        testT();
        int[] a = new int[]{4,1,2,6};
        String s = "";
        for (int i = 0; i < 11; i++) {
			s+= a[i];
		}
        System.out.println(s);
    }

    private static void testT() {
        // List<T> t = new ArrayList<T>();
    	int[] i = new int[]{12342,65745};
//    	String s = StringUtils.join(i,",");/
    }
    

}
