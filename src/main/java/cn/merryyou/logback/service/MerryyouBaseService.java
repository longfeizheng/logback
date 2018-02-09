package cn.merryyou.logback.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * Created on 2018/2/9.
 *
 * @author zlf
 * @since 1.0
 */
public interface MerryyouBaseService<T> {

    T findOne(String id);

    T save(T t);

    List<T> findAll();

    Page<T> findAll(PageRequest pageRequest);

    void delete(String id);

}
