package com.appium.base;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {
	
	
	public static List<String> getFileFromDir(File file){
		List<String> resultFileName = new ArrayList<>();
		File[] files = file.listFiles();
        if(files==null)
        		return resultFileName;// 判断目录下是不是空的
        for (File f : files) {
            if(f.isDirectory()){// 判断是否文件夹
                resultFileName.add(f.getPath());
                getFileFromDir(f);// 调用自身,查找子目录
            }else
                resultFileName.add(f.getPath());
        }
        return resultFileName;
    }
	
	public static void main(String[] args) {
		File file = new File("/Users/user/Documents");
		List<String> ergodic = getFileFromDir(file);
		System.out.println(ergodic);
	}
}
