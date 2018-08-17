package tn.esprit.spring.service.impl;

import java.io.IOException;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import tn.esprit.exception.FileStorageException;
import tn.esprit.spring.entity.File;
import tn.esprit.spring.repository.FileRepository;

@Service
public class FileStorageService {
@Autowired
FileRepository fr;
public File storeFile(MultipartFile file) {
    // Normalize file name
    String fileName = StringUtils.cleanPath(file.getOriginalFilename());

    try {
        // Check if the file's name contains invalid characters
        if(fileName.contains("..")) {
            throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
        }

        File dbFile = new File(fileName, file.getContentType(), file.getBytes());
        System.out.println("///************************" +file.getBytes());

        return fr.save(dbFile);
    } catch (IOException ex) {
        throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
    }
}

public File getFile(Long fileId) {
    return  fr.findOne(fileId);//fr.findById(fileId);
           // .orElseThrow(() -> new MyFileNotFoundException("File not found with id " + fileId));
}

}
