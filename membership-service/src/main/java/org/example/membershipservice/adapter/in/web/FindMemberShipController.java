package org.example.membershipservice.adapter.in.web;


import lombok.RequiredArgsConstructor;
import org.example.membershipservice.application.port.in.FindMemberShipCommand;
import org.example.membershipservice.application.port.in.FindMemberShipUseCase;
import org.example.membershipservice.application.port.in.RegisterMemberShipCommand;
import org.example.membershipservice.common.WebAdapter;
import org.example.membershipservice.domain.Membership;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@WebAdapter
@RestController
@RequiredArgsConstructor
public class FindMemberShipController {

    private final FindMemberShipUseCase findMemberShipUseCase;
    @GetMapping("/membership/{membershipId}")
    public ResponseEntity<Membership> findMemberShipMemberId(@PathVariable String membershipId) {

        FindMemberShipCommand command = FindMemberShipCommand.builder()
                .memberShipId(membershipId)
                .build();

        return ResponseEntity.ok(findMemberShipUseCase.findMembership(command));
    }
}
