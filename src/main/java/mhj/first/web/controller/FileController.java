package mhj.first.web.controller;

import mhj.first.web.bean.History;
import mhj.first.web.bean.Msg;
import mhj.first.web.exception.file.FileException;
import mhj.first.web.service.FileService;
import mhj.first.web.bean.Employee;
import mhj.first.web.util.FileUtil;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Controller
public class FileController {

    @Autowired
    FileService fileService;
    @RequestMapping("fileup")
    public String uploadFile(@RequestParam("file") MultipartFile[] files, HttpSession session) throws Exception, FileException {
        if(files==null) throw new FileException("上传文件失败，未获取到上传内容！");
        Employee employee = (Employee) session.getAttribute("employee");
        for (MultipartFile file : files) {
            fileService.uploadFile(file,employee);
        }
        return "index";
    }
    @RequestMapping("downfile")
    public void downloadfile(Integer hid, HttpServletResponse response) throws Exception {
        if(hid==null){
            throw new FileException("下载失败：参数为空");
        }
        History history = fileService.selectHistoryByHid(hid);
        String filepath = FileUtil.getUpLoadFilePath()+history.getFilepath();
        File file = new File(filepath);
        response.setHeader("Accept-Ranges","bytes");
        response.setHeader("Content-Disposition","attachment;filename=" + new String(history.getFilepath().getBytes(), StandardCharsets.ISO_8859_1));
        response.setHeader("Content-Length",file.length()+"");
        response.setContentType(history.getType());
        OutputStream toClient = new BufferedOutputStream(response.getOutputStream());
        InputStream inputStream =new BufferedInputStream(new FileInputStream(file));
        IOUtils.copy(inputStream,toClient);
        toClient.flush();
    }
    @RequestMapping("showHistories")
    @ResponseBody
    public Msg showHistories(){
        List<History> histories = fileService.getHistories();
        return Msg.success().add("histories",histories);
    }
    @RequestMapping(value = "deleteFile/{hid}",method = RequestMethod.DELETE)
    @ResponseBody
    public Msg deleteFile(@PathVariable("hid") Integer hid) throws Exception {
        fileService.deleteFile(hid);
        return Msg.success();
    }
}
