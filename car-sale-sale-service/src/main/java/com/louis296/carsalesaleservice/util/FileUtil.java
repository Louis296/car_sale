package com.louis296.carsalesaleservice.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.UUID;

public class FileUtil {
    public static String saveFileToAssetWithFolderName(String name, MultipartFile file){
        String realPath=System.getProperty("user.dir")+"/asset/"+name;
        File folder=new File(realPath);
        if(!folder.exists()){
            folder.mkdirs();
        }
        String oldName=file.getOriginalFilename();
        String newName= UUID.randomUUID().toString()+oldName.substring(oldName.lastIndexOf("."));
        try{
            file.transferTo(new File(folder,newName));
        }catch (Exception e){
            return "";
        }
        return newName;
    }
}
