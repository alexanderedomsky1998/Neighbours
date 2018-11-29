package neighbours;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Field {
	private int n_berries;
	private int n_portion;
	private ReentrantLock locker;
	private Condition condition;
	private String str;

	public Field(int n_berries, int n_portion) {
		str = "left";
		this.n_berries = n_berries;
		this.n_portion = n_portion;
		locker = new ReentrantLock(); // создаем блокировку
		condition = locker.newCondition(); // получаем условие, св€занное с блокировкой
	}

	public boolean is_empty() {
		return n_berries == n_portion;
	}

	public void process_left() throws InterruptedException {
		locker.lock();
		try {
			if (n_berries != 0) {
				while (str != "left")
					condition.await();
				for (int i = 0; i < 10000000; i++) {

				}
				str = "right";
				n_berries -= n_portion;
				System.out.println("Ћевый сосед вернулс€ с пол€");
				System.out.println("ќсталось €год:" + n_berries);
				condition.signalAll();
			}
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		} finally {
			locker.unlock();
		}
	}

	public void process_right() throws InterruptedException {
		locker.lock();
		try {
			if (n_berries != 0) {
				while (str != "right")
					condition.await();
				for (int i = 0; i < 10000000; i++) {

				}
				str = "left";
				n_berries -= n_portion;
				System.out.println("ѕравый сосед вернулс€ с пол€");
				System.out.println("ќсталось €год:" + n_berries);
				condition.signalAll();
			}
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		} finally {
			locker.unlock();
		}
	}

}
