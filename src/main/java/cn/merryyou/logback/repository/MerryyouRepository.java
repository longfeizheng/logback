package cn.merryyou.logback.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * Created on 2018/1/28 0028.
 *
 * @author zlf
 * @email i@merryyou.cn
 * @since 1.0
 */
@NoRepositoryBean
public interface MerryyouRepository<T> extends JpaRepository<T, String>, JpaSpecificationExecutor<T> {
}
