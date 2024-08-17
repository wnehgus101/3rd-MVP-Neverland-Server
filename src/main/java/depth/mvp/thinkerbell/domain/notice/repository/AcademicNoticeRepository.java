package depth.mvp.thinkerbell.domain.notice.repository;

import depth.mvp.thinkerbell.domain.notice.entity.AcademicNotice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AcademicNoticeRepository extends JpaRepository<AcademicNotice, Long> {
    List<AcademicNotice> findByImportant(boolean important);

    @Query("SELECT n FROM AcademicNotice n WHERE n.title LIKE CONCAT('%', :keyword, '%')")
    List<AcademicNotice> searchByTitle(@Param("keyword") String keyword);
}
