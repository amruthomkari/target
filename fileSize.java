

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONObject;

public class fileSize {
	
	@SuppressWarnings("unchecked")
	public static void folderSize(File directory, String args) throws IOException {
		JSONObject fileList = new JSONObject();
	    for (File file : directory.listFiles()) {
	        if (file.isFile())
	        	fileList.put(file, file.length());
	    	}
	    JSONObject files = new JSONObject();
	    files.put("files", fileList);
        FileWriter fileWriter = new FileWriter(args);
        fileWriter.write(files.toJSONString());
        fileWriter.close();
        System.out.println("JSON Object Successfully written to the file: "+args);
	    return ;
	}

	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		if(args.length<2) {
			System.out.println("Usage: <interface> <path> <output.json>");
			return ;
		}
		File folder = new File(args[0]);
		folderSize(folder,args[1]);
	}

}
