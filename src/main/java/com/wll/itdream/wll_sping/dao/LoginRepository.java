package com.wll.itdream.wll_sping.dao;

import com.wll.itdream.wll_sping.entity.Login;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepository extends JpaRepository<Login, Integer> {
}
