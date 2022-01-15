package utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;

public class UtilsFile {

	private String filePath;
	private File file;
	private final String projectPath = System.getProperty("user.dir");

	public UtilsFile(String filePath) {
		this.setFilePath(filePath);
		this.file= new File(projectPath + filePath);
	}

	public String getDataFromXml(String nodeName){
		DocumentBuilder dBuilder;
		Document doc = null;
		File xmlFile = this.file;
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		try {
			dBuilder = dbFactory.newDocumentBuilder();
			doc = dBuilder.parse(xmlFile);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		doc.getDocumentElement().normalize();
		return doc.getElementsByTagName(nodeName).item(0).getTextContent();
	}

	public String inputStreamToString() throws IOException {
		FileInputStream inputStream = new FileInputStream(file);
		StringBuilder sb = new StringBuilder();
		String line;
		BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
		while ((line = br.readLine()) != null) {
			sb.append(line);
		}
		br.close();
		return sb.toString();
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public File getFile() {
		return this.file;
	}

	public void setFile(File file) {
		this.file = file;
	}
}
