package readinglist;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ReaderRepository extends JpaRepository<Reader, String> {
    // 无需自己实现
    // 扩展了JpaRepository， Spring Data JPA会在运行时自动创建它的实现
    // 提供了18个操作Reader实体的方法
}
