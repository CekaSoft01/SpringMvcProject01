package com.rungroup.web.controller;

import com.rungroup.web.dto.ClubDto;
import com.rungroup.web.models.Club;
import com.rungroup.web.models.UserEntity;
import com.rungroup.web.security.SecurityUtil;
import com.rungroup.web.service.ClubService;
import com.rungroup.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping()//http://localhost:8080
public class ClubController {//yirmi
    private ClubService clubService;
    private UserService userService;

    @Autowired
    public ClubController(ClubService clubService,UserService userService) {
        this.clubService = clubService;
        this.clubService=clubService;
    }

    @GetMapping("/clubs")//http://localhost:8080/clubs
    public String listClubs(Model model) {
        UserEntity user=new UserEntity();
        List<ClubDto> clubs = clubService.findAllClubs();
        String username= SecurityUtil.getSessionUSer();
        if (username!=null) {
            user=userService.findByUsername(username);
            model.addAttribute("user",user);
        }
        model.addAttribute("user",user);
        model.addAttribute("clubs", clubs);
        return "clubs-list";

    }
    @GetMapping("/clubs/{clubId}")
    public String clubdetail(@PathVariable("clubId") Long clubId,Model model){
    UserEntity user=new UserEntity();
        ClubDto clubDto=clubService.findClubById(clubId);
        String username= SecurityUtil.getSessionUSer();
        if (username!=null) {
            user=userService.findByUsername(username);
            model.addAttribute("user",user);
        }
        model.addAttribute("user",user);

        model.addAttribute("club",clubDto);
        return  "clubs-detail";
    }



    @GetMapping("/clubs/new")
    public String createClubForm(Model model) {
        Club club = new Club();
        model.addAttribute("club", club);
        return "clubs-create";

    }

    @GetMapping("/club/{clubId}/delete")
    public String deleteClub(@PathVariable("clubId") Long id){
        clubService.delete(id);
        return "redirect:/clubs";
    }


    @GetMapping("/clubs/search")
    public String searchClub(@RequestParam(value = "query") String query,Model model){
        List<ClubDto> clubs=clubService.searchClubs(query);

        model.addAttribute("clubs",clubs);
        return "redirect:/clubs";
    }

    @PostMapping("/clubs/new")
    public String saveClub(@Valid @ModelAttribute("club") ClubDto clubDto, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("club", clubDto);
            return "clubs-create";
        }
        clubService.saveClub(clubDto);
        return "redirect:/clubs";

    }

    @GetMapping("/clubs/{clubId}/edit")
    public String editClubForm(@PathVariable("clubId") long clubId, Model model) {
        ClubDto clubDto = clubService.findClubById(clubId);
        model.addAttribute("club", clubDto);
        return "clubs-edit";

    }

    @PostMapping("/clubs/{clubId}/edit")
    public String updateClub(@PathVariable("clubId") Long id,
                             @Valid @ModelAttribute("club") ClubDto clubDto,
                             BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("club",clubDto);
            return "clubs-edit";//validation da hata varsa sayfayı gönder
        }
        clubDto.setId(id);
        clubService.updateClub(clubDto);
        return "redirect:/clubs";
    }


}
