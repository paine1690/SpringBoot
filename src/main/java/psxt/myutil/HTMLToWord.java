package psxt.myutil;

import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.poifs.filesystem.DirectoryEntry;
import org.apache.poi.poifs.filesystem.DocumentEntry;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

public class HTMLToWord {
	public static String createWord(String rootPath,String fileName,String htmlContent) throws IOException{

		System.out.println(htmlContent);
		byte b[] = htmlContent.getBytes("GBK");
		ByteArrayInputStream bais = new ByteArrayInputStream(b);
		POIFSFileSystem poifs = new POIFSFileSystem();
		DirectoryEntry directory = poifs.getRoot();

		DocumentEntry documentEntry = directory.createDocument("WordDocument", bais);

		FileOutputStream ostream = new FileOutputStream(rootPath + "\\" + fileName);
		poifs.writeFilesystem(ostream);
		ostream.close();
		poifs.close();
		bais.close();
		return fileName;
	}
}
