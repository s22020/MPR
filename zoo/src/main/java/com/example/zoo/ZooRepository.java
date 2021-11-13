package com.example.zoo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface ZooRepository extends JpaRepository<Zoo, Integer> {

    @Transactional
    @Modifying
    // : - parametr w metodzie
    @Query("UPDATE Zoo z SET z.name = :name, z.open = :open where z.id = :id")
    int updateZoo(String name, boolean open, Integer id);

    List<Zoo> findAllByOpenIsFalse();
    List<Zoo> findAllByIdGreaterThan(Integer id);
}
