package Controller;

import DAO.DocumentDAO;
import Entity.Document;
import jakarta.ejb.EJB;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import jakarta.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.util.List;

/**
 *
 * @author Hatice
 */

@Named(value = "documentBeanjpa")
@SessionScoped
public class DocumentBean implements Serializable {

    private Document document;
    
    @EJB
    private DocumentDAO documentDAO;

    private transient  Part doc;  //java servlet http part nesnesi
    private final String uploadTo = "/Users/Hatice/";

    public DocumentBean() {
        document = new Document();
    }

    public void upload() {
        try {
            if (doc != null) {
                InputStream input = doc.getInputStream();
                String fileName = doc.getSubmittedFileName();
                if (fileName != null && !fileName.isEmpty()) {
                    File f = new File(uploadTo + doc.getSubmittedFileName());
                    Files.copy(input, f.toPath());
                    document = this.getDocument();

                    document.setFilepath(f.getParent());
                    document.setFilename(f.getName());
                    document.setFiletype(doc.getContentType());

                    this.getDocumentDAO().insert(document);

                    // Reset document object for next upload
                    document = new Document();
                } else {
                    System.out.println("Dosya adı geçerli değil.");
                }
            } else {
                System.out.println("Yüklenen dosya bulunamadı.");
            }
        } catch (IOException e) {
            System.out.println("Dosya yükleme hatası: " + e.getMessage());
        }
    }

    public List<Document> getList() {
        return getDocumentDAO().getList();
    }

    public String getUploadTo() {
        return uploadTo;
    }

    public Document getDocument() {
        if (this.document == null) {
            this.document = new Document();
        }
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    public DocumentDAO getDocumentDAO() {
        return documentDAO;
    }

    public Part getDoc() {
        return doc;
    }

    public void setDoc(Part doc) {
        this.doc = doc;
    }
}
