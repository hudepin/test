/**
 * 
 */
package com.deep.test;

/**
 * @author HDP23
 *
 */
public class Outer {
	private String name;
	private int age;
	public static class Builder{
		private String name;
		private int age;
		public Builder(int age){
			this.age=age;
		}
		public Builder buildWithName(String name){
			this.name = name;
			return this;
		}
		public Builder buildWithAge(int age){
			this.age=age;
			return this;
		}
		public Outer build(){
			return new Outer(this);
		}
	}
	private Outer(Builder b){
		this.age=b.age;
		this.name=b.name;
	}
	public static void main(String[] args) {
		
	}
	public Outer getOuter()
	{
	    Outer outer = new Outer.Builder(2).buildWithName("Yang Liu").build();
	    return outer;
	}
}
