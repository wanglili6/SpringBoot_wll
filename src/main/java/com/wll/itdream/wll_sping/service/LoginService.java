package com.wll.itdream.wll_sping.service;

import com.wll.itdream.wll_sping.dao.LoginRepository;
import com.wll.itdream.wll_sping.entity.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Spliterator;

@Service
public interface LoginService {
    /**
     * 根据账号密码进行查询
     *
     * @param name
     * @param password
     * @return
     */
    public List<Login> findByNameAndPassword(String name, String password) ;

    public List<Login> findName_password(String name, String password) ;

}
