package gestaoindicadores.models;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.io.OutputStream;
public class PDF {
    public static void exportarPDF(String nome, String titulo, String conteudo) throws Exception {
        Document doc = null;
        OutputStream os = null;
        try {
            //cria o documento tamanho A4, margens de 2,54cm (72)
            doc = new Document(PageSize.A4, 48, 48, 48, 48);
            //cria a stream de saída
            os = new FileOutputStream(nome);
            //associa a stream de saída ao 
            PdfWriter.getInstance(doc, os);
            //abre o documento
            doc.open();
            //cria a fonte
            Font f = new Font(FontFamily.HELVETICA, 20, Font.BOLDITALIC);
            Font f2 = new Font(FontFamily.TIMES_ROMAN, 14, Font.NORMAL);
            //adiciona o texto ao PDF
            Paragraph p1 = new Paragraph(titulo, f);
            p1.setAlignment(Element.ALIGN_CENTER);
            doc.add(p1);
            Paragraph p2 = new Paragraph(conteudo, f2);
            doc.add(p2);
            System.out.println("PDF criado com sucesso!");
        } finally {
            if (doc != null) {
                //fechamento do documento
                doc.close();
            }
            if (os != null) {
               //fechamento da stream de saída
               os.close();
            }
        }
    }
}
