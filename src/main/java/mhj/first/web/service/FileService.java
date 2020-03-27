package mhj.first.web.service;

import mhj.first.web.bean.Employee;
import mhj.first.web.bean.History;
import mhj.first.web.mapper.FileMapper;
import mhj.first.web.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;

@Service
public class FileService {

    @Autowired
    FileMapper fileMapper;
    public void uploadFile (MultipartFile file , Employee employee) throws Exception {
        String newfilename =employee.getEmpName()+"_"+file.getOriginalFilename();
        File newfile = new File(FileUtil.getUpLoadFilePath() + newfilename);
        History history = new History();
        history.setEid(employee.getEmpId());
        history.setType(file.getContentType());
        history.setFilesize((double) file.getSize());
        history.setFilepath(newfilename);
        fileMapper.insertHistory(history);
        file.transferTo(newfile);
    }
    public History selectHistoryByHid(Integer hid){
        return fileMapper.selectHistoryByHid(hid);
    }

    public List<History> getHistories() {
        return fileMapper.getHistories();
    }

    public void deleteFile(Integer hid) throws Exception {
        History history = this.selectHistoryByHid(hid);
        System.out.println(history.toString());
        File file = new File(FileUtil.getUpLoadFilePath()+history.getFilepath());
        if (file.exists()) {
            file.delete();
        }
        fileMapper.deleteFile(hid);
    }
}
