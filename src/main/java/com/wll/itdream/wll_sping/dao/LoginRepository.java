package com.wll.itdream.wll_sping.dao;

import com.wll.itdream.wll_sping.entity.Login;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LoginRepository extends JpaRepository<Login, Integer> {

}
