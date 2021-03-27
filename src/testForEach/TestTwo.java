package testForEach;

import java.util.ArrayList;
import java.util.Iterator;

public class TestTwo implements Iterable{

	private ArrayList<String> args;

	/**
	 * @param args the args to set
	 */
	public void setArgs(ArrayList<String> args) {
		this.args = args;
	}

	@Override
	public Iterator iterator() {

		return args.iterator();
	}
	
	
}
