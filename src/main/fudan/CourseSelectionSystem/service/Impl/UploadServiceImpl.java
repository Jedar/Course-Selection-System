package main.fudan.CourseSelectionSystem.service.Impl;

import main.fudan.CourseSelectionSystem.service.UploadService;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class UploadServiceImpl implements UploadService {
    HttpServletRequest request;

    @Override
    public String handleUploadFile(HttpServletRequest request) {
        this.request = request;
        try {
            request.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        boolean isMultipart = ServletFileUpload.isMultipartContent(request);
        if(!isMultipart){
            throw new RuntimeException("The form's enctype attribute value must be multipart/form-data");
        }
        //产生FileItem的工厂
        DiskFileItemFactory factory = new DiskFileItemFactory();
        factory.setRepository(new File("/WEB-INF/files"));
        ServletFileUpload sfu = new ServletFileUpload(factory);
        sfu.setHeaderEncoding("utf-8");
        //单个文件大小限制
        sfu.setFileSizeMax(3*1024*1024);
        //总文件大小
        sfu.setSizeMax(5*1024*1024);
        List<FileItem> items = new ArrayList<FileItem>();
        try {
            items = sfu.parseRequest(request);
        }catch(FileUploadBase.FileSizeLimitExceededException e) {
            e.printStackTrace();
        }
        catch(FileUploadBase.SizeLimitExceededException e) {
            e.printStackTrace();
        }catch (FileUploadException e) {
            e.printStackTrace();
            throw new RuntimeException("解析请求失败");
        }
        String res = null;
        for(FileItem item:items){
            if(!item.isFormField()){
                //处理上传字段
                res = processUploadField(item);
                break;
            }
        }
        return res;
    }

    /* 处理文件域,返回路径 */
    private String processUploadField(FileItem item) {
        String res = null;
        try {
            //找一个存放文件的位置；存放的文件名
            String id = item.getFieldName();
            //上传的文件的文件名
            String fileName = item.getName();
            //上传文件类型
            String contentType = item.getContentType();
            //上传文件放置目录
            String putDir = "/excel/";
            //上传文件后缀名
            String postfix = ".xlsx";

            if(fileName!=null&&!fileName.equals("")){
                /* 使用UUID获取文件名 */
                fileName = UUID.randomUUID().toString() + postfix;
                /* 文件暂存路径 */
                String realPath = request.getServletContext().getRealPath("/WEB-INF/files");

                String childDirectory = genChildDirectory(realPath,fileName);
                /* 创造新的存放目录 */
                File storeDirectory = new File(realPath+putDir);
                /* 如果目录不存在，那么就创建它 */
                if(!storeDirectory.exists()){
                    storeDirectory.mkdirs();
                }
                File file = new File(storeDirectory, fileName);
                res = file.getAbsolutePath();
                /* 这个方法会自动的进行临时文件的清理，也就是上传完毕之后，他会自动的清除临时文件 */
                item.write(file);
                /* 将缓存好的文件移动到目标目录下 */
                File imageDir = new File(request.getServletContext().getRealPath(putDir));
                FileUtils.copyFileToDirectory(file,imageDir);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return res;
    }

    /* 处理文本域 */
    private boolean processFormField(FileItem item, Map<String, String> map) {
        //打印到控制台
        String fieldName = item.getFieldName();
        String fieldValue = "";
        try {
            //这里是为了解决表单提交的汉字在控制台输出乱码的问题，也就是得到表单里边的
            //数据在控制台输出不会乱码
            fieldValue = item.getString("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println(fieldName+"="+fieldValue);
        map.put(fieldName,fieldValue);

        return !"".equals(fieldValue);
    }

    /* 随机生成子文件名 */
    private String genChildDirectory(String realPath, String fileName) {
        int hashCode = fileName.hashCode();
        int dir1 = hashCode&0xf;
        int dir2 = (hashCode&0xf0)>>4;

        String str = dir1+File.separator+dir2;

        File file = new File(realPath,str);
        if(!file.exists()){
            file.mkdirs();
        }
        return str;
    }
}


