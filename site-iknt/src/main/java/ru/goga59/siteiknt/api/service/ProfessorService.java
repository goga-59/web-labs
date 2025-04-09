package ru.goga59.siteiknt.api.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ru.goga59.siteiknt.storage.model.ProfessorModel;
import ru.goga59.siteiknt.storage.repository.ProfessorRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProfessorService {

    private final ProfessorRepository professorRepository;

    public List<ProfessorModel> getAllProfessors() {
        return professorRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }

    public ProfessorModel getProfessorById(long id) {
        return professorRepository.findById(id).orElseThrow(() -> new RuntimeException("Преподаватель не найден"));
    }

    public void deleteProfessorById(long id) {
        professorRepository.deleteById(id);
    }

    public void addProfessor(ProfessorModel professor) {
        professorRepository.save(professor);
    }

    public void updateProfessor(ProfessorModel professor) {
        professorRepository.save(professor);
    }

}
