package com.cadastro.usuario.Service;

import com.cadastro.usuario.Model.TrainingUser;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import java.io.OutputStream;

public class PdfGenerator {

    private Font titleFont = new Font(Font.FontFamily.HELVETICA, 18, Font.BOLD);
    private Font headerFont = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD);
    private Font bodyFont = new Font(Font.FontFamily.HELVETICA, 12, Font.NORMAL);

    public void generateTrainingPDF(OutputStream outputStream, TrainingUser treinoUser, String logoPath) throws Exception {
        Document document = new Document();
        PdfWriter writer = PdfWriter.getInstance(document, outputStream);
        writer.setPageEvent(new HeaderFooterPageEvent());
        document.open();

        addLogo(document, logoPath);
        addDocumentTitle(document, "Relatório de Treino");
        addTrainingDetails(document, treinoUser);

        document.close();
    }

    private void addLogo(Document document, String logoPath) throws Exception {
        Image logo = Image.getInstance(logoPath);
        logo.scaleToFit(140, 140);
        logo.setAlignment(Element.ALIGN_CENTER);
        document.add(logo);
    }

    private void addDocumentTitle(Document document, String title) throws Exception {
        Paragraph p = new Paragraph(title, titleFont);
        p.setAlignment(Element.ALIGN_CENTER);
        document.add(p);
    }

    private void addTrainingDetails(Document document, TrainingUser treinoUser) throws Exception {
        PdfPTable table = new PdfPTable(2); // 2 colunas.
        table.setWidthPercentage(100);
        table.setSpacingBefore(10f);
        table.setSpacingAfter(10f);

        PdfPCell cell;

        // Nome do Usuário
        cell = new PdfPCell(new Phrase("Nome do Usuário", headerFont));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(cell);

        cell = new PdfPCell(new Phrase(treinoUser.getNameUser(), bodyFont));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(cell);

        // Nome do Professor
        cell = new PdfPCell(new Phrase("Nome do Professor", headerFont));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(cell);

        cell = new PdfPCell(new Phrase(treinoUser.getNameTeacher(), bodyFont));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(cell);

        document.add(table);
    }

    class HeaderFooterPageEvent extends PdfPageEventHelper {
        public void onStartPage(PdfWriter writer, Document document) {
            // Adicione o cabeçalho
        }

        public void onEndPage(PdfWriter writer, Document document) {
            // Adicione o rodapé
        }
    }
}

