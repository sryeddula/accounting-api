package com.pecuniara.accounts.rest.controller;

import com.pecuniara.accounts.jpa.repository.JPAImplService;
import com.pecuniara.accounts.jpa.repository.PersistenceContext;
import com.pecuniara.accounts.rest.model.Document;
import net.sourceforge.tess4j.Tesseract;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import java.io.File;
import java.util.Base64;
import java.util.List;
import org.apache.commons.io.FileUtils;


@RestController
@RequestMapping("/documents")
public class DocumentController {
    //@PersistenceContext
    private EntityManager entityManager;
    public DocumentController(){
        this.entityManager = PersistenceContext.getEm();
    }
    @RequestMapping(value = "/getDocument", method = RequestMethod.GET)
    public Document getDocument(@RequestParam(value="id") String id){
        var q = JPAImplService.getEm().createQuery("select d from Document d");
        List<Document> docs = q.getResultList();
        if (id==null){
            return null;
        }else {
            return new Document();
        }
    }
    @RequestMapping(value = "/addDocument", method = RequestMethod.POST)
    public String addDocument(@RequestParam(value = "fileExtension") String ext, @RequestBody String content) throws Exception {
        var file = new File("target/data/temp." + ext);
        //var file = new File("/Users/sryeddula/Downloads/temp.tiff");
        var bytes = Base64.getDecoder().decode(content);
        FileUtils.writeByteArrayToFile(file,bytes);
        Tesseract tesseract = new Tesseract();
        tesseract.setLanguage("eng");
        tesseract.setDatapath("/Users/sryeddula/Downloads/tessdata");
        String text = tesseract.doOCR(file);
        return text;
    }
}
