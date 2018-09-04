package com.general;

public class GenericTest {
	public static void main(String[] args) {
		Tack<Integer> l = new Tack<Integer>();
		
	}
}
class Tack<T>{
	
}
class TackChild<Intger, T> extends Tack<T>{
	//SqlSessionopenSessionFromDataSource = null;
}

class Ques1028 {
    public static void main(String[] args){
        new B().out();  // 输出
    }
}

class A{
    String message = "AAA";

    void out(){
        System.out.println(message);
    }
}

class B extends A{
    String message = "BBB";
}
