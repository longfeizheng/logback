package cn.merryyou.logback.service.impl;

import cn.merryyou.logback.repository.MerryyouRepository;
import cn.merryyou.logback.service.MerryyouBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * Created on 2018/2/9.
 *
 * @author zlf
 * @since 1.0
 */
public abstract class MerryyouBaseServiceImpl<T> implements MerryyouBaseService<T> {

    @Autowired
    private MerryyouRepository<T> merryyouRepository;

    @Override
    public T findOne(String id) {
        return (T)merryyouRepository.findById(id).get();
    }

    @Override
    public T save(T t) {
        return (T)merryyouRepository.save(t);
    }

    @Override
    public List<T> findAll() {
        return merryyouRepository.findAll();
    }

    @Override
    public Page<T> findAll(PageRequest pageRequest) {
        return merryyouRepository.findAll(pageRequest);
    }

    @Override
    public void delete(String id) {
        merryyouRepository.deleteById(id);
    }
}
