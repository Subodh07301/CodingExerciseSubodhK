package in.co.subodhk.footballleague.controller;

import in.co.subodhk.footballleague.dto.TeamStandingDto;
import in.co.subodhk.footballleague.log.annotation.Trace;
import in.co.subodhk.footballleague.log.eventtype.LogEventType;
import in.co.subodhk.footballleague.model.TeamStandingRequest;
import in.co.subodhk.footballleague.service.TeamStandingService;

import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/service/v1/team/standing")
public class FootBallStandingController {

  private final TeamStandingService teamStandingService;

  @Autowired
  public FootBallStandingController(
      TeamStandingService teamStandingService) {
    this.teamStandingService = teamStandingService;
  }

  @GetMapping
  @Trace(type = LogEventType.CONTROLLER)
  public ResponseEntity<TeamStandingDto> getStandings(@Valid TeamStandingRequest teamStandingRequest) {
    log.info("Request {}", teamStandingRequest.toString());
    return ResponseEntity.ok(teamStandingService.getTeamStanding(teamStandingRequest));
  }


}
