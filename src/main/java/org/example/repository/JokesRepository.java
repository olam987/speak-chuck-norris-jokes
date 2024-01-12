package org.example.repository;

import org.example.repository.entity.JokesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JokesRepository extends JpaRepository<JokesEntity,Long> {
}
