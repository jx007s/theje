package mvc.service;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileService {
	
	String path;

	public String fileUpload(MultipartFile mf, HttpServletRequest request) {

		path = request.getRealPath("/resources/up")+"/";
		path = "D:\\lee\\study\\work\\springWork\\mvcProj\\src\\main\\webapp\\resources\\up/";
		
		String res = fileNamePolicy(mf);
		
		try {

			FileOutputStream fos = new FileOutputStream(path+res);
			fos.write(mf.getBytes());
			
			fos.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return res;
		
	}
	
	
	String fileNamePolicy(MultipartFile mf) {
		
		
		int pos = mf.getOriginalFilename().lastIndexOf(".");
		
		String ext = mf.getOriginalFilename().substring(pos);
		String fileName = mf.getOriginalFilename().substring(0,pos);
		
		String res = mf.getOriginalFilename();
		String filePath =path+res;
		
		File file = new File(filePath);
		
		int no =0;
		while(file.exists()) {
			res = fileName+"_"+no+ext;
			filePath = path+res;
			
			file = new File(filePath);
			no++;
		}

		return res;
	}
	
	
	
	public boolean isImgChk(MultipartFile mf) {
		String ext = mf.getOriginalFilename().toLowerCase().substring(
				mf.getOriginalFilename().lastIndexOf(".")+1);
		

		return Arrays.asList("jpeg,jpg,bmp,gif,png".split(",")).contains(ext);
	}
}
