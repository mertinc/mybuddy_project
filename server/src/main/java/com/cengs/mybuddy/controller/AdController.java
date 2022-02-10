package com.cengs.mybuddy.controller;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cengs.mybuddy.dto.AdDTO;
import com.cengs.mybuddy.dto.CommentDTO;
import com.cengs.mybuddy.dto.UserDTO;
import com.cengs.mybuddy.model.Ad;
import com.cengs.mybuddy.model.User;
import com.cengs.mybuddy.service.AdService;

@CrossOrigin
@RestController
@Validated
@RequestMapping("/ads")
public class AdController {
	
	@Autowired
	AdService adService;
	
	@PostMapping("/createAdd")
	public AdDTO addAd(@Valid @RequestBody AdDTO dto) {
		System.out.println("Post CREATE AD tested");
		System.out.println(dto.getId()+"\n "+dto.getUserId()+"\n "+dto.getDate()+"\n "+dto.getTitle());
		return adService.createAd(dto);
	}
	@GetMapping("/findAll")
	public List<AdDTO> findAll(){
		return adService.findAllAd();		
	}

	@GetMapping("/{id}")
	public ResponseEntity<Ad> findById(@PathVariable("id") UUID id){
		return ResponseEntity.ok(adService.findById(id));		
	}

}
