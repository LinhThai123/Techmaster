package vn.techmaster.Hackathon_JobHut.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import vn.techmaster.Hackathon_JobHut.exception.StorageException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class StoragService {
    @Value("${upload.path}")
    private String path;
    //id của Employer id
    public String saveFile(MultipartFile file,String id) throws IOException {
        if (file.isEmpty()) {
            throw new StorageException("Failed to store empty file");
        }
        //logo.png
        String extension = getFileExtension(file.getOriginalFilename());//png
        String newFileName = path + id + "." + extension;
        //lấy extension
        try {
            var is = file.getInputStream();
            Files.copy(is, Paths.get(newFileName), StandardCopyOption.REPLACE_EXISTING);
            return id + "." + extension;
        } catch (IOException e) {
            var msg = String.format("Failed to store file %s", newFileName);
            throw new StorageException(msg, e);
        }
    }
    /*
        Bóc tách phần file extension
    * */
    public String getFileExtension (String fileName) {
        int postOfDot = fileName.lastIndexOf(".") ;
        if(postOfDot >= 0) {
            return fileName.substring(postOfDot + 1) ;
        }
        else {
            return null ;
        }
    }
}
