package com.cadastro.usuario.Controller;

import com.cadastro.usuario.Model.LoginUser;
import com.cadastro.usuario.Model.TrainingUser;
import com.cadastro.usuario.Service.PdfGenerator;
import com.cadastro.usuario.Service.UserService;
import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Base64;

@Controller
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    PdfGenerator pdfGenerator;

    @GetMapping("/homeUser")
    public ModelAndView home(HttpSession session) {
        LoginUser user = (LoginUser) session.getAttribute("loggedUser");
        ModelAndView modelAndView = new ModelAndView("homeUser");
        modelAndView.addObject("nome", user.getNome());
        return modelAndView;
    }

    /////////////////////////Tela Minha Matricula///////////////////////////////////
    @GetMapping("/matriculaUser")
    public ModelAndView showMatriculaUser(HttpSession session) {
        LoginUser user = (LoginUser) session.getAttribute("loggedUser");
        ModelAndView modelAndView = new ModelAndView("matriculaUser");
        // Convertendo a imagem para base64
        String base64Encoded = Base64.getEncoder().encodeToString(user.getFoto());
        modelAndView.addObject("foto", base64Encoded);

        modelAndView.addObject("id", user.getId());
        modelAndView.addObject("nome", user.getNome());
        modelAndView.addObject("telefone", user.getTelefone());
        modelAndView.addObject("cpf", user.getCpf());  // Adicionando o CPF ao modelo
        return modelAndView;
    }

    /////////////////////////Tela Meus Treinos///////////////////////////////////
    @GetMapping("/meusTreinos")
    public void gerarPDF(HttpServletResponse response, HttpSession session) throws Exception {
        LoginUser user = (LoginUser) session.getAttribute("loggedUser");
        Long idUser = user.getId();
        TrainingUser treinoUser = userService.getTreinoUserByUserId(idUser);

        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment; filename=treinoUser.pdf"); // Mude de 'inline' para 'attachment'

        pdfGenerator.generateTrainingPdf(response, treinoUser);
    }
}