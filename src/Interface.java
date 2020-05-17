
public class Interface implements Comparable<Interface> {
	private String data;
	
	@Override
	public int compareTo(Interface o) {
		// TODO Auto-generated method stub
		return data.compareTo(o.data);
	}
	
}
