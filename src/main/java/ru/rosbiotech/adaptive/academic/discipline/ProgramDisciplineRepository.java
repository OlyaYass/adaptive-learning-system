package ru.rosbiotech.adaptive.academic.discipline;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProgramDisciplineRepository
        extends JpaRepository<ProgramDiscipline, Long> {

    @Query("""
            select pd
            from ProgramDiscipline pd
            join fetch pd.discipline
            join fetch pd.educationalProgram
            where pd.educationalProgram.code = :programCode
            order by pd.curriculumIndex
            """)
    List<ProgramDiscipline> findAllByProgramCode(
            @Param("programCode") String programCode
    );
}