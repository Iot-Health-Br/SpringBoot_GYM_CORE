package com.cadastro.usuario.Service;

import com.cadastro.usuario.Model.TrainingUser;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.stereotype.Service;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@Service
public class PdfGenerator {
    public void generateTrainingPdf(HttpServletResponse response, TrainingUser trainingUser) throws DocumentException, IOException {
        Document document = new Document();
        PdfWriter.getInstance(document, response.getOutputStream());
        document.open();

        addLogoAndAddress(document);
        addUserInfo(document, trainingUser);
        addExercicioPeito(document, trainingUser);
        addExercicioTricipes(document, trainingUser);
        addExercicioCosta(document, trainingUser);
        addExercicioBiceps(document, trainingUser);
        addExercicioOmbro(document, trainingUser);
        addExercicioTrapezio(document, trainingUser);
        addExercicioPernas(document, trainingUser);

        document.close();
    }

    private void addLogoAndAddress(Document document) throws DocumentException, IOException {
        // Carrega a imagem do logo
        Image logo = Image.getInstance("./Logo Imagens/Logo Principal.jpeg");
        logo.scaleToFit(100, 100);
        logo.setAlignment(Image.ALIGN_CENTER);

        // Cria um parágrafo para o nome e endereço, centralizando o texto
        Paragraph name = new Paragraph("GYM CORE\nGoiânia - Goiás\n\n");
        name.setAlignment(Element.ALIGN_CENTER);

        // Adiciona o logo e o parágrafo ao documento
        document.add(logo);
        document.add(name);
    }

    private void addUserInfo(Document document, TrainingUser trainingUser) throws DocumentException {
        // Define as fontes
        Font regularFont = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL);
        Font boldFont = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);
        // Adiciona informações do usuário com estilo misto
        Paragraph userInfo = new Paragraph();
        userInfo.add(new Chunk("Nome do Aluno: ", regularFont));
        userInfo.add(new Chunk(trainingUser.getNameUser() + "\n", boldFont));

        userInfo.add(new Chunk("Professor Responsável: ", regularFont));
        userInfo.add(new Chunk(trainingUser.getNameTeacher() + "\n", boldFont));

        userInfo.add(new Chunk("Data do Treino: ", regularFont));
        userInfo.add(new Chunk(trainingUser.getDataTreino() + "\n", boldFont));

        userInfo.add(new Chunk("Validade do Treino: ", regularFont));
        userInfo.add(new Chunk(trainingUser.getVencimentoTreino() + "\n\n", boldFont));

        // Adiciona o parágrafo ao documento
        document.add(userInfo);
    }

    private void addExercicioPeito(Document document, TrainingUser trainingUser) throws DocumentException {
        // Define as fontes
        Font boldFont = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);
        Paragraph userInfo = new Paragraph();
        userInfo.add(new Chunk("Treino de Peito: \n\n", boldFont));

        PdfPTable table = new PdfPTable(4);
        table.setWidthPercentage(100); // Define a largura da tabela para 100% da página

        // Títulos das colunas
        PdfPCell cell = new PdfPCell(new Paragraph("Dia"));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        table.addCell(cell);

        cell = new PdfPCell(new Paragraph("Exercício"));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        table.addCell(cell);

        cell = new PdfPCell(new Paragraph("Série"));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        table.addCell(cell);

        cell = new PdfPCell(new Paragraph("Repetições"));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        table.addCell(cell);

        // Adiciona uma única linha para "Dia" centralizado
        cell = new PdfPCell(new Paragraph(trainingUser.getDiaPeito()));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);// Center the cell Horizontally
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE); // Center the cell vertically
        cell.setRowspan(3); // Esta célula se estende por 3 linhas
        table.addCell(cell);

        // Adicionar informações de exercícios
        addExerciseInfo(table, trainingUser.getExercicio_Peito(), trainingUser.getPeito_Serie(), trainingUser.getPeito_Repeticao());
        addExerciseInfo(table, trainingUser.getExercicio_Peito2(), trainingUser.getPeito_Serie2(), trainingUser.getPeito_Repeticao2());
        addExerciseInfo(table, trainingUser.getExercicio_Peito3(), trainingUser.getPeito_Serie3(), trainingUser.getPeito_Repeticao3());

        document.add(userInfo);
        document.add(table);
    }

    private void addExercicioTricipes(Document document, TrainingUser trainingUser) throws DocumentException {
        // Define as fontes
        Font boldFont = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);
        Paragraph userInfo = new Paragraph();
        userInfo.add(new Chunk("Treino de Triceps: \n\n", boldFont));

        PdfPTable table = new PdfPTable(4);
        table.setWidthPercentage(100); // Define a largura da tabela para 100% da página

        // Títulos das colunas
        PdfPCell cell = new PdfPCell(new Paragraph("Dia"));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        table.addCell(cell);

        cell = new PdfPCell(new Paragraph("Exercício"));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        table.addCell(cell);

        cell = new PdfPCell(new Paragraph("Série"));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        table.addCell(cell);

        cell = new PdfPCell(new Paragraph("Repetições"));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        table.addCell(cell);

        // Adiciona uma única linha para "Dia" centralizado
        cell = new PdfPCell(new Paragraph(trainingUser.getDiaPeito()));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);// Center the cell Horizontally
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE); // Center the cell vertically
        cell.setRowspan(3); // Esta célula se estende por 3 linhas
        table.addCell(cell);

        // Adicionar informações de exercícios
        addExerciseInfo(table, trainingUser.getExercicio_Tricipes(), trainingUser.getTricipes_Serie(), trainingUser.getTricipes_Repeticao());
        addExerciseInfo(table, trainingUser.getExercicio_Tricipes2(), trainingUser.getTricipes_Serie2(), trainingUser.getTricipes_Repeticao2());
        addExerciseInfo(table, trainingUser.getExercicio_Tricipes3(), trainingUser.getTricipes_Serie3(), trainingUser.getTricipes_Repeticao3());

        document.add(userInfo);
        document.add(table);
    }

    private void addExercicioCosta(Document document, TrainingUser trainingUser) throws DocumentException {
        // Define as fontes
        Font boldFont = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);
        Paragraph userInfo = new Paragraph();
        userInfo.add(new Chunk("Treino de Costas: \n\n", boldFont));

        PdfPTable table = new PdfPTable(4);
        table.setWidthPercentage(100); // Define a largura da tabela para 100% da página

        // Títulos das colunas
        PdfPCell cell = new PdfPCell(new Paragraph("Dia"));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        table.addCell(cell);

        cell = new PdfPCell(new Paragraph("Exercício"));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        table.addCell(cell);

        cell = new PdfPCell(new Paragraph("Série"));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        table.addCell(cell);

        cell = new PdfPCell(new Paragraph("Repetições"));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        table.addCell(cell);

        // Adiciona uma única linha para "Dia" centralizado
        cell = new PdfPCell(new Paragraph(trainingUser.getDiaPeito()));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);// Center the cell Horizontally
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE); // Center the cell vertically
        cell.setRowspan(3); // Esta célula se estende por 3 linhas
        table.addCell(cell);

        // Adicionar informações de exercícios
        addExerciseInfo(table, trainingUser.getExercicio_Costa(), trainingUser.getCosta_Serie(), trainingUser.getCosta_Repeticao());
        addExerciseInfo(table, trainingUser.getExercicio_Costa2(), trainingUser.getCosta_Serie2(), trainingUser.getCosta_Repeticao2());
        addExerciseInfo(table, trainingUser.getExercicio_Costa3(), trainingUser.getCosta_Serie3(), trainingUser.getCosta_Repeticao3());

        document.add(userInfo);
        document.add(table);
    }


    private void addExercicioBiceps(Document document, TrainingUser trainingUser) throws DocumentException {
        // Define as fontes
        Font boldFont = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);
        Paragraph userInfo = new Paragraph();
        userInfo.add(new Chunk("Treino de Biceps: \n\n", boldFont));

        PdfPTable table = new PdfPTable(4);
        table.setWidthPercentage(100); // Define a largura da tabela para 100% da página

        // Títulos das colunas
        PdfPCell cell = new PdfPCell(new Paragraph("Dia"));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        table.addCell(cell);

        cell = new PdfPCell(new Paragraph("Exercício"));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        table.addCell(cell);

        cell = new PdfPCell(new Paragraph("Série"));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        table.addCell(cell);

        cell = new PdfPCell(new Paragraph("Repetições"));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        table.addCell(cell);

        // Adiciona uma única linha para "Dia" centralizado
        cell = new PdfPCell(new Paragraph(trainingUser.getDiaPeito()));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);// Center the cell Horizontally
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE); // Center the cell vertically
        cell.setRowspan(3); // Esta célula se estende por 3 linhas
        table.addCell(cell);

        // Adicionar informações de exercícios
        addExerciseInfo(table, trainingUser.getExercicio_Bicipes(), trainingUser.getBicipes_Serie(), trainingUser.getBicipes_Repeticao());
        addExerciseInfo(table, trainingUser.getExercicio_Bicipes2(), trainingUser.getBicipes_Serie2(), trainingUser.getBicipes_Repeticao2());
        addExerciseInfo(table, trainingUser.getExercicio_Bicipes3(), trainingUser.getBicipes_Serie3(), trainingUser.getBicipes_Repeticao3());

        document.add(userInfo);
        document.add(table);
    }

    private void addExercicioOmbro(Document document, TrainingUser trainingUser) throws DocumentException {
        // Define as fontes
        Font boldFont = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);
        Paragraph userInfo = new Paragraph();
        userInfo.add(new Chunk("Treino de Ombro: \n\n", boldFont));

        PdfPTable table = new PdfPTable(4);
        table.setWidthPercentage(100); // Define a largura da tabela para 100% da página

        // Títulos das colunas
        PdfPCell cell = new PdfPCell(new Paragraph("Dia"));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        table.addCell(cell);

        cell = new PdfPCell(new Paragraph("Exercício"));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        table.addCell(cell);

        cell = new PdfPCell(new Paragraph("Série"));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        table.addCell(cell);

        cell = new PdfPCell(new Paragraph("Repetições"));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        table.addCell(cell);

        // Adiciona uma única linha para "Dia" centralizado
        cell = new PdfPCell(new Paragraph(trainingUser.getDiaPeito()));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);// Center the cell Horizontally
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE); // Center the cell vertically
        cell.setRowspan(3); // Esta célula se estende por 3 linhas
        table.addCell(cell);

        // Adicionar informações de exercícios
        addExerciseInfo(table, trainingUser.getExercicio_Ombro(), trainingUser.getOmbro_Serie(), trainingUser.getOmbro_Repeticao());
        addExerciseInfo(table, trainingUser.getExercicio_Ombro2(), trainingUser.getOmbro_Serie2(), trainingUser.getOmbro_Repeticao2());
        addExerciseInfo(table, trainingUser.getExercicio_Ombro3(), trainingUser.getOmbro_Serie3(), trainingUser.getOmbro_Repeticao3());

        document.add(userInfo);
        document.add(table);
    }

    private void addExercicioTrapezio(Document document, TrainingUser trainingUser) throws DocumentException {
        // Define as fontes
        Font boldFont = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);
        Paragraph userInfo = new Paragraph();
        userInfo.add(new Chunk("Treino de Trapézio: \n\n", boldFont));

        PdfPTable table = new PdfPTable(4);
        table.setWidthPercentage(100); // Define a largura da tabela para 100% da página

        // Títulos das colunas
        PdfPCell cell = new PdfPCell(new Paragraph("Dia"));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        table.addCell(cell);

        cell = new PdfPCell(new Paragraph("Exercício"));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        table.addCell(cell);

        cell = new PdfPCell(new Paragraph("Série"));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        table.addCell(cell);

        cell = new PdfPCell(new Paragraph("Repetições"));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        table.addCell(cell);

        // Adiciona uma única linha para "Dia" centralizado
        cell = new PdfPCell(new Paragraph(trainingUser.getDiaPeito()));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);// Center the cell Horizontally
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE); // Center the cell vertically
        cell.setRowspan(3); // Esta célula se estende por 3 linhas
        table.addCell(cell);

        // Adicionar informações de exercícios
        addExerciseInfo(table, trainingUser.getExercicio_Trapezio(), trainingUser.getTrapezio_Serie(), trainingUser.getTrapezio_Repeticao());
        addExerciseInfo(table, trainingUser.getExercicio_Trapezio2(), trainingUser.getTrapezio_Serie2(), trainingUser.getTrapezio_Repeticao2());
        addExerciseInfo(table, trainingUser.getExercicio_Trapezio3(), trainingUser.getTrapezio_Serie3(), trainingUser.getTrapezio_Repeticao3());

        document.add(userInfo);
        document.add(table);
    }

    private void addExercicioPernas(Document document, TrainingUser trainingUser) throws DocumentException {
        // Define as fontes
        Font boldFont = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);
        Paragraph userInfo = new Paragraph();
        userInfo.add(new Chunk("Treino de Pernas: \n\n", boldFont));

        PdfPTable table = new PdfPTable(4);
        table.setWidthPercentage(100); // Define a largura da tabela para 100% da página

        // Títulos das colunas
        PdfPCell cell = new PdfPCell(new Paragraph("Dia"));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        table.addCell(cell);

        cell = new PdfPCell(new Paragraph("Exercício"));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        table.addCell(cell);

        cell = new PdfPCell(new Paragraph("Série"));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        table.addCell(cell);

        cell = new PdfPCell(new Paragraph("Repetições"));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        table.addCell(cell);

        // Adiciona uma única linha para "Dia" centralizado
        cell = new PdfPCell(new Paragraph(trainingUser.getDiaPeito()));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);// Center the cell Horizontally
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE); // Center the cell vertically
        cell.setRowspan(3); // Esta célula se estende por 3 linhas
        table.addCell(cell);

        // Adicionar informações de exercícios
        addExerciseInfo(table, trainingUser.getExercicio_Perna(), trainingUser.getPerna_Serie(), trainingUser.getPerna_Repeticao());
        addExerciseInfo(table, trainingUser.getExercicio_Perna2(), trainingUser.getPerna_Serie2(), trainingUser.getPerna_Repeticao2());
        addExerciseInfo(table, trainingUser.getExercicio_Perna3(), trainingUser.getPerna_Serie3(), trainingUser.getPerna_Repeticao3());

        document.add(userInfo);
        document.add(table);
    }

    // Método auxiliar para adicionar informações de exercício à tabela
    private void addExerciseInfo(PdfPTable table, String exercicio, String serie, String repeticao) {
        PdfPCell cell;

        cell = new PdfPCell(new Paragraph(exercicio));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        table.addCell(cell);

        cell = new PdfPCell(new Paragraph(String.valueOf(serie)));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        table.addCell(cell);

        cell = new PdfPCell(new Paragraph(String.valueOf(repeticao)));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        table.addCell(cell);
    }
}
