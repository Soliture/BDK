package bdk.data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import bdk.game.entities.sprites.actors.ActorCollection;

/**
 * 
 * @author Andreas Farley
 *
 */
public class FileUtil {

	public static void saveSerializableObject(Object o, String path){
		try {
			FileOutputStream fos = new FileOutputStream(new File(path));
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			
			oos.writeObject(o);
			
			fos.close();
			oos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Object loadSerializedObject(String path){
		try {
			FileInputStream fis = new FileInputStream(new File(path));
			ObjectInputStream ois = new ObjectInputStream(fis);
			Object readObject = ois.readObject();
			
			fis.close();
			ois.close();
			
			return readObject;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
