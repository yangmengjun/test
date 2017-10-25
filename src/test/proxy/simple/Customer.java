package test.proxy.simple;

public class Customer {
	public static void main(String[] args) {
		//定义一个java码农
        ICoder coder = new JavaCoder("Zhang");
        
        ICoder proxy = new CoderProxy(coder);
        proxy.implDemands("Add");
	}
}
