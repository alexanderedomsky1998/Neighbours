package neighbours;

public class Main {
	public static void main(String[] args) {
		Field field=new Field(120000,20000);
		Neighbour_Right n_right = new Neighbour_Right(field);
		Neighbour_Left n_left = new Neighbour_Left(field);
		new Thread(n_right).start();
		new Thread(n_left).start();
     }
}
