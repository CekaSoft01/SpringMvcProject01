package com.rungroup.web.controller;

import com.rungroup.web.dto.ClubDto;
import com.rungroup.web.models.Club;
import com.rungroup.web.service.ClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping()//http://localhost:8080
public class ClubController {
    private ClubService clubService;

    @Autowired
    public ClubController(ClubService clubService) {
        this.clubService = clubService;
    }

    @GetMapping("/clubs")
    public String listClubs(Model model){
        List<ClubDto> clubs=clubService.findAllClubs();
       model.addAttribute("clubs",clubs);
        return "clubs-list";

    }
    @GetMapping("/clubs/new")
    public String createClubForm(Model model){
        Club club=new Club();
        model.addAttribute("club",club);
        return "clubs-create";

    }
    @PostMapping("/clubs/new")
    public String saveClub(@ModelAttribute("club") Club club){
        clubService.saveClub(club);
        return "redirect:/clubs";

    }

    @GetMapping("/clubs/{clubId}/edit")
    public  String editClubForm(@PathVariable("clubId") long clubId, Model model){
        ClubDto clubDto=clubService.findClubById(clubId);
        model.addAttribute("club",clubDto);
        return "clubs-edit";

    }


}
