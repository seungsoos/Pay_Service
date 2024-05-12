package org.example.membershipservice.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberShipRepository extends JpaRepository<MemberShipEntity, Long> {
}
