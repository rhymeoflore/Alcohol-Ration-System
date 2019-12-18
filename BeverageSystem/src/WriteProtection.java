import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;

public class WriteProtection {
	public static void main(String[] args) throws IOException {
		File f = new File("M:\\Ration\\a.txt");
		

		if (f.exists()) {
			f.delete();
		}
		f.createNewFile();
		//Runtime.getRuntime().exec("attrib " + "" + f.getAbsolutePath() + "" + " +R");
		f.setReadable(false);
		FileWriter fw = new FileWriter(f);
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write("ayyyo");
		bw.close();
		fw.close();

	}
}
