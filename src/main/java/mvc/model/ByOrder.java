package mvc.model;

import java.util.Iterator;
import java.util.List;

public class ByOrder {

	List<Product> proList;
	
	Address addr;
	
	int sum;
	
	

	public int getSum() {
		return sum;
	}

	public List<Product> getProList() {
		return proList;
	}

	public void setProList(List<Product> proList) {
		this.proList = proList;
	}

	public Address getAddr() {
		return addr;
	}

	public void setAddr(Address addr) {
		this.addr = addr;
	}
	
	public void execute() {
		
		sum =0;
		Iterator<Product> it = proList.iterator();
		
		while(it.hasNext()) {
			Product pro = it.next();
			
			if(pro.id.equals("") 		||
				pro.id.equals("null")	||
				pro.id==null) {
				//proList.remove(pro);  에러!!!
				it.remove();	////삭제 가능!!!
			
			}else {
				sum += pro.getTotal();
			}
		}
		/*for (int i = proList.size()-1; i>=0; i--) {
			Product pro = proList.get(i);
			
			if(pro.id.equals("") 		||
				pro.id.equals("null")	||
				pro.id==null) {
				proList.remove(pro);
			
			}else {
				sum += pro.getTotal();
			}
		}*/
	}
	
	
}
