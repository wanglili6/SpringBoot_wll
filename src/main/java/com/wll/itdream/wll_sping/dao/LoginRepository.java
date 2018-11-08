package com.wll.itdream.wll_sping.dao;

import com.wll.itdream.wll_sping.entity.Login;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LoginRepository extends JpaRepository<Login, Integer> {
    /**
     * 根据账号密码查询
     *
     * @param specification
     */
    public List<Login> findAll(Specification specification);

    /**
     * 查询所有的用户
     *
     * @return
     */
    public List<Login> findAll();

    public List<Login> findByPhone(String phone);
    public List<Login> findByLoginnameAndPassword(String name,String password);

}
