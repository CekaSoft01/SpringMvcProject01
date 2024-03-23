package com.rungroup.web.service.impl;

import com.rungroup.web.dto.ClubDto;
import com.rungroup.web.models.Club;
import com.rungroup.web.repository.ClubRepository;
import com.rungroup.web.service.ClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClubServiceImpl implements ClubService {
    private ClubRepository clubRepository;

    @Autowired
    public ClubServiceImpl(ClubRepository clubRepository) {
        this.clubRepository = clubRepository;
    }

    @Override
    public List<ClubDto> findAllClubs() {
       List<Club> clubs=clubRepository.findAll();
       return clubs.stream().map(this::mapToClubDto).collect(Collectors.toList());//bize dto olarak dönecek
    }

    @Override
    public Club saveClub(ClubDto clubDto) {
        Club club=mapToClub(clubDto);
        return  clubRepository.save(club);
    }

    @Override
    public ClubDto findClubById(long id) {
        Club club=clubRepository.findById(id).orElseThrow();
        return mapToClubDto(club);

    }

    @Override
    public void updateClub(ClubDto clubDto) {
        Club club=mapToClub(clubDto);
        clubRepository.save(club);

        
    }

    @Override
    public void delete(Long id) {
        clubRepository.deleteById(id);
    }

    @Override
    public List<ClubDto> searchClubs(String query) {
        List<Club> clubs=clubRepository.searchClubs(query);
        return  clubs.stream().map(club->mapToClubDto(club)).collect(Collectors.toList());
}

    private Club mapToClub(ClubDto clubDto) {
        Club club=Club.builder()
                .id(clubDto.getId())
                .title(clubDto.getTitle())
                .photoUrl(clubDto.getPhotoUrl())
                .content(clubDto.getContent())
                .createdOn(clubDto.getCreatedOn())
                .updatedOn(clubDto.getUpdatedOn())

                .build();
        return club;

    }

    private ClubDto mapToClubDto(Club club){
        ClubDto clubDto=ClubDto.builder()
                .id(club.getId())
                .title(club.getTitle())
                .photoUrl(club.getPhotoUrl())
                .content(club.getContent())
                .createdOn(club.getCreatedOn())
                .updatedOn(club.getUpdatedOn())
                .build();
        return  clubDto;


    }
}
