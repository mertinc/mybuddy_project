package com.cengs.mybuddy.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cengs.mybuddy.dto.AdDTO;
import com.cengs.mybuddy.dto.CommentDTO;
import com.cengs.mybuddy.dto.UserDTO;
import com.cengs.mybuddy.service.AdService;

@RestController
@Validated
@RequestMapping("/ads")
public class AdController {
	
	@Autowired
	AdService adService;
	
	@PostMapping("/addAd")
	public AdDTO addAd(@Valid @RequestBody AdDTO dto) {
		System.out.println("Post CREATE AD tested");
		System.out.println(dto.getId()+"\n "+dto.getUserId()+"\n "+dto.getDate()+"\n "+dto.getTitle());
		return adService.createAd(dto);
	}
	@GetMapping("/findAll")
	public List<AdDTO> findAll(){
		return adService.findAllAd();		
	}

}
