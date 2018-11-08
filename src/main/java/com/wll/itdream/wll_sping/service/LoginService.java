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
public class LoginService {
    @Autowired
    private LoginRepository loginRepository;

    /**
     * 根据账号密码进行查询
     *
     * @param name
     * @param password
     * @return
     */
    public List<Login> findByNameAndPassword(String name, String password) {
        List<Login> loginList = loginRepository.findAll(new Specification() {
            @Override
            public Predicate toPredicate(Root root, CriteriaQuery criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                if (name != null && !name.equals("")) {
                    predicates.add(criteriaBuilder.like(root.get("login_name").as(String.class), "%" + name + "%"));
                } else {
                    System.out.print("名称不能为空!");
                    return null;
                }
                if (password != null && !password.equals("")) {
                    predicates.add(criteriaBuilder.like(root.get("password").as(String.class), "%" + password + "%"));
                } else {
                    System.out.print("密码不能为空!");
                    return null;
                }
                Predicate[] pre = new Predicate[predicates.size()];
                criteriaQuery.where(predicates.toArray(pre));
                return criteriaBuilder.and(predicates.toArray(pre));
            }
        });
        return loginList;

    }

    public List<Login> findName_password(String name, String password) {
        return loginRepository.findByLoginnameAndPassword(name, password);
    }

}
