package net.javaguides.springboot.repository;


import net.javaguides.springboot.model.Crop;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CropRepository extends JpaRepository<Crop, Long>{

}
