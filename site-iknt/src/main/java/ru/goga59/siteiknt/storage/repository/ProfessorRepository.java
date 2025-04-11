package ru.goga59.siteiknt.storage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.goga59.siteiknt.storage.model.ProfessorModel;

public interface ProfessorRepository extends JpaRepository<ProfessorModel, Long> {
}
