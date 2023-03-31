package dp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectStreamTest {
	public static void main(String[] args) {
		//write();
		read();
	}

	private static File target = new File("./Person.dat");

	private static void write() {
		Person person = new Person("홍길동2", "pass1234", 12);
		// TODO: person을 target에 저장하시오.
		try (ObjectOutputStream oout = new ObjectOutputStream(new FileOutputStream(target))) {
			oout.writeObject(person);
			System.out.println("파일 저장 완료!");
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		// END:
	}

	private static void read() {
		// TODO: target에서 person을 읽어서 내용을 출력하시오.
		try (ObjectInputStream oin = new ObjectInputStream(new FileInputStream(target))) {
			Object obj = oin.readObject();
			if (obj != null && obj instanceof Person) {
				Person casted = (Person) obj;
				System.out.println(casted);
			}
		}
		catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		// END:
	}
}
