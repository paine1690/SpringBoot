package psxt.handler;


import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import psxt.myutil.UUIGenerator;

@Slf4j
@Component
public class AttachementHandler {
	
		@Autowired
		private Environment env;
		
	    public ResponseEntity<InputStreamResource> getFile( HttpServletRequest request,HttpServletResponse response,String filePath) throws IOException{
	    	String path = "E://"+filePath+".rar";
	    	System.out.println("####### path %%%%% "+path);
	    	FileSystemResource file=new FileSystemResource(path);
	    	if(!file.exists()){
	    		System.out.println("文件不存在");
	    	}
	    	HttpHeaders headers = new HttpHeaders();  
	        headers.add("Cache-Control", "no-cache, no-store, must-revalidate");  
	        headers.add("Content-Disposition", String.format("attachment; filename=\"%s\"", file.getFilename()));  
	        headers.add("Pragma", "no-cache");  
	        headers.add("Expires", "0");  
	        return ResponseEntity  
	                .ok()  
	                .headers(headers)  
	                .contentLength(file.contentLength())  
	                .contentType(MediaType.parseMediaType("application/octet-stream"))  
	                .body(new InputStreamResource(file.getInputStream())); 
	    }
	    
	    public String uploadFile(MultipartFile file,String fileName) throws IOException {
	        	String path = env.getProperty("rootPath");
	        	String uuid = UUIGenerator.getUUID();
	  		    String newFileName =  uuid+"."+getFileType(fileName);
				try(BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(new File(path,newFileName)))){
					out.write(file.getBytes());
					out.flush();
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
//				Attachement attachement = new Attachement();
//				attachement.setAttachementId(uuid);
//				attachement.setFilePath(path+"/"+newFileName);
//				attachementDBMapper.insertAttachementDBMapper(attachement);
//	        	String fileDir = path+"/"+newFileName;
				String fileDir = newFileName;
//	        	return newFileName;
	  		    return fileDir;
	   }
	    
	   private String getFileType(String filename){
		   if ((filename != null) && (filename.length() > 0)) {   
	            int dot = filename.lastIndexOf('.');   
	            if ((dot >-1) && (dot < (filename.length() - 1))) {   
	                return filename.substring(dot + 1);   
	            }   
	        }   
	        return filename;  
		   
	   }
	   
	 
	    
}
