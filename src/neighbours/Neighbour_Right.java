package neighbours;

public class Neighbour_Right implements Runnable{
	Field field;
	Neighbour_Right(Field field1) {
		// TODO Auto-generated constructor stub
		this.field = field1;
	}
	@Override
	public void run() {
		while(!field.is_empty()) {
			try {
				field.process_right();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
