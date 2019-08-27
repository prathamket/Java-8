package Java8New;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Performance_Implications {
	public static void main(String[] args) {

		long t1,t2;
		List<Empl> eList = new ArrayList<Empl>();
		for(int i=0;i<10000;i++){
			eList.add(new Empl("A",20000));
			eList.add(new Empl("B",3000));
			eList.add(new Empl("C",15030));
			eList.add(new Empl("D",25030));
			eList.add(new Empl("E",5030));
		}

		int count = 0;
		/***** Here We Are Iterating the List using Universal Iterator & Checking The Result *****/
		t1=System.currentTimeMillis();
		Iterator<Empl> itr = (Iterator<Empl>) eList.iterator();
		while(itr.hasNext()){
			Empl e =itr.next();
			if(e.getSalary()>15000){
				count++;
			}
		}
		t2= System.currentTimeMillis();
		System.out.println("Sequential iterator Time taken: "+(t2-t1));

		/***** Here We Are Creating A 'Sequential Stream' & Displaying The Result *****/
		t1=System.currentTimeMillis();
		System.out.println("Sequential stream count: "+eList.stream().filter(e->e.getSalary()>15000).count());
		t2= System.currentTimeMillis();
		System.out.println("Sequential stream Time taken: "+(t2-t1));

		/***** Here We Are Creating A 'Parallel Stream' & Displaying The Result *****/
		t1=System.currentTimeMillis();
		System.out.println("Parallel Stream Count: = "+eList.parallelStream().filter(e->e.getSalary()>15000).count());
		t2 = System.currentTimeMillis();
		System.out.println("Parallel Stream Time Taken: " + (t2-t1));



	}
}

class Empl{
	String name;
	int salary;

	public Empl(String name,int salary) {
		this.name=name;
		this.salary=salary;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return name+" "+salary;
	}

}