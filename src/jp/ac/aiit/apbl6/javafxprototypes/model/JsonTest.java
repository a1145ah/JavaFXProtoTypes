package jp.ac.aiit.apbl6.javafxprototypes.model;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class JsonTest extends Entity {
	private String name;
	private int age;
	
	@Override
	protected void setStore() {
		try {
			store = new Store<JsonTest>(this);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public JsonTest() {
		setStore();
	}
	
	public JsonTest(String name, int age) {
		this.name = name;
		this.age = age;
		setStore();
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public static void main(String[] args) throws IOException {
		JsonTest test = new JsonTest();
		test.load();
		test.add(new JsonTest("dudada", 20));
		test.save();
		@SuppressWarnings("unchecked")
		List<JsonTest> all = test.findAll();
		for (Iterator<JsonTest> it = all.iterator(); it.hasNext();) {
			JsonTest d = it.next();
			System.out.println(d.getId() + ", " + d.getName() + ", " + d.getAge() );
		}
	}
}
