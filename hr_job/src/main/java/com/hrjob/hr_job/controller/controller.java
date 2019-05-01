package com.hrjob.hr_job.controller;

import com.hrjob.hr_job.service.serviceimpl.ResumeDealServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping(value = "/hrjob")
@CrossOrigin
public class controller {

    @Autowired
    private ResumeDealServiceImpl resumeDealServiceImpl;

    @RequestMapping(value = "/resume",method = RequestMethod.POST)
    @ResponseBody
    public void getAllResume(HttpServletRequest request) throws IOException {
        MultipartHttpServletRequest params=((MultipartHttpServletRequest) request);
        List<MultipartFile> files = params.getFiles("file");
        boolean upload = resumeDealServiceImpl.upload(files);

    }

    /*@PostMapping(value = "/{i}")
    public void test2Html(HttpServletRequest request, HttpServletResponse response, @PathVariable(name = "i") int i) throws IOException, TransformerException {
        MultipartHttpServletRequest params=((MultipartHttpServletRequest) request);
        List<MultipartFile> files = params.getFiles("file");
        InputStream inputStream = files.get(i).getResource().getInputStream();
        HSSFWorkbook hssfWorkbook=new HSSFWorkbook(inputStream);
        ExcelToHtmlConverter excelToHtmlConverter = new ExcelToHtmlConverter (DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument() );
        excelToHtmlConverter.processWorkbook(hssfWorkbook);
*//*        List pics = hssfWorkbook.getAllPictures();
        if (pics != null) {
            for (int s = 0; s < pics.size(); s++) {
                Picture pic = (Picture) pics.get (i);
                try {
                    pic.writeImageContent (new FileOutputStream(path + pic.suggestFullFileName() ) );
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }*//*
        Document htmlDocument =excelToHtmlConverter.getDocument();
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        DOMSource domSource = new DOMSource (htmlDocument);
        StreamResult streamResult = new StreamResult (outStream);
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer serializer = tf.newTransformer();
        serializer.setOutputProperty (OutputKeys.ENCODING, "utf-8");
        serializer.setOutputProperty (OutputKeys.INDENT, "yes");
        serializer.setOutputProperty (OutputKeys.METHOD, "html");
        serializer.transform (domSource, streamResult);
        outStream.close();

        String content = new String (outStream.toByteArray() );

        FileUtil.fileToURL(new File (path, "exportExcel.html"), content, "utf-8");
        response.setContentType("image/jpeg");
        response.getOutputStream().write(bytes);
        response.sendRedirect("http://localhost:8080");
    }
*/
}
