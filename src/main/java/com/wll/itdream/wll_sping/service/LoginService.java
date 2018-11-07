package com.wll.itdream.wll_sping.service;

import com.wll.itdream.wll_sping.dao.LoginRepository;
import com.wll.itdream.wll_sping.entity.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Spliterator;

@Service
public class LoginService {
//    @Autowired
//    private LosginRepository loginRepository;
//
//    public List<Login> findByNameAndPassword(String name, String password) {
//        loginRepository.findAll(new Specification() {
//
//            @Override
//            public Predicate toPredicate(Root root, CriteriaQuery criteriaQuery, CriteriaBuilder criteriaBuilder) {
//                return null;
//            }
//        });
//        return null;
//
//    }

}
