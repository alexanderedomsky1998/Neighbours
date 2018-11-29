package neighbours;

public class Neighbour_Left implements Runnable{
	Field field;
	Neighbour_Left(Field field){
		// TODO Auto-generated constructor stub
    	this.field = field;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(!field.is_empty()) {
			try {
				field.process_left();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
