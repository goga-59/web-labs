package ru.goga59.siteiknt.api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.goga59.siteiknt.api.service.ProfessorService;
import ru.goga59.siteiknt.storage.model.ProfessorModel;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin/professors")
public class AdminProfessorController {

    private final ProfessorService professorService;

    @GetMapping
    public String adminProfessor(Model model) {
        List<ProfessorModel> professors = professorService.getAllProfessors();
        model.addAttribute("professors", professors);
        model.addAttribute("content", "admin/fragments/admin-professors");
        return "admin/admin-base";
    }

    @GetMapping("/add")
    public String addProfessor(Model model) {
        model.addAttribute("professor", new ProfessorModel());
        return "admin/crud/professors-add";
    }

    @PostMapping("/add")
    public String addProfessor(@ModelAttribute ProfessorModel professor) {
        professorService.addProfessor(professor);
        return "redirect:/admin/professors";
    }

    @GetMapping("/edit/{id}")
    public String editProfessor(Model model, @PathVariable long id) {
        ProfessorModel professor = professorService.getProfessorById(id);
        model.addAttribute("professor", professor);
        return "admin/crud/professors-edit";
    }

    @PostMapping("/edit")
    public String savaEditProfessor(@ModelAttribute ProfessorModel professor) {
        professorService.updateProfessor(professor);
        return "redirect:/admin/professors";
    }

    @GetMapping("/delete/{id}")
    public String deleteProfessor(@PathVariable long id) {
        professorService.deleteProfessorById(id);
        return "redirect:/admin/professors";
    }


}
