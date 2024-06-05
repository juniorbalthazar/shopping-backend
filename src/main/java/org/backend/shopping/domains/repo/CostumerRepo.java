package org.backend.shopping.domains.repo;

import org.backend.shopping.domains.Costumers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CostumerRepo  extends JpaRepository<Costumers, Integer> {
}
