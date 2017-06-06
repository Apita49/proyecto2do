package interaccionArchivos;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

import javax.imageio.ImageIO;

public class FileProcesser {
	private static FileProcesser fp;

	private FileProcesser() {
	};

	public static FileProcesser getInstance() {
		if (fp == null) {
			fp = new FileProcesser();
		}
		return fp;
	}

	public String processFile(String direccion) {
		try {
			FileReader fr = new FileReader(direccion);
			BufferedReader br = new BufferedReader(fr);
			String text = "";
			String line = br.readLine();
			while (line != null) {
				text += line;
				line = br.readLine();
			}
			br.close();
			return text;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public String processFoto(String foto) {
		FileInputStream instream = null;
		FileOutputStream outstream = null;
		File imageIn = new File(foto);
		String nombre = getNombre(foto);
		File copy = new File(
				"C:\\Paulo 2\\UPB\\Semestre V\\Proyecto Ingenieria de Software\\SEGIP\\uploads\\"
						+ nombre);
		try {
			instream = new FileInputStream(imageIn);
			outstream = new FileOutputStream(copy);
			byte[] buffer = new byte[1024];
			int length;
			while ((length = instream.read(buffer)) > 0) {
				outstream.write(buffer, 0, length);
			}
			if (instream != null) {
				instream.close();
			}
			if (outstream != null) {
				outstream.close();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}

	public String processFoto2(String foto) {
		BufferedImage image = null;
		try {
			File in = new File(foto);
			image = ImageIO.read(in);
			ImageIO.write(
					image,
					"jpg",
					new File(
							"C:\\Paulo 2\\UPB\\Semestre V\\Proyecto Ingenieria de Software\\SEGIP\\uploads\\"
									+ getNombre(foto)));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println();
		return null;
	}

	private String getNombre(String foto) {
		char[] c = foto.toCharArray();
		String ans = "";
		for (int i = c.length - 1; i >= 0; i--) {
			if (c[i] == '\\') {
				break;
			}
			ans = c[i] + ans;
		}
		return ans;
	}
}
