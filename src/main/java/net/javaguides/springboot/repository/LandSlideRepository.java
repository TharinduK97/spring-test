package net.javaguides.springboot.repository;


import net.javaguides.springboot.model.Landslide;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LandSlideRepository extends JpaRepository<Landslide, Long>{

}
