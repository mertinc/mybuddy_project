package com.cengs.mybuddy.service;

import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cengs.mybuddy.dto.AdDTO;
import com.cengs.mybuddy.dto.UserDTO;
import com.cengs.mybuddy.model.Ad;
import com.cengs.mybuddy.model.Comment;
import com.cengs.mybuddy.model.User;
import com.cengs.mybuddy.repository.AdRepository;
import com.cengs.mybuddy.repository.CommentRepository;
import com.cengs.mybuddy.repository.UserRepository;

@Service
public class AdService {
	@Autowired
	private UserService userService;
	private final AdRepository adRepository;
	private final UserRepository userRepository;
	private final CommentRepository commentRepository;
	
	
public AdService(AdRepository adRepository, UserRepository userRepository,CommentRepository commentRepository) {
		this.adRepository = adRepository;
		this.userRepository= userRepository;
		this.commentRepository= commentRepository;
	}
	
	public AdDTO createAd(AdDTO adDTO) {
		Ad newAd = new Ad();
		User user = new User();
		//Comment comment= new Comment();
		
		user=userService.findById(adDTO.getUserId());
		newAd=mapAdDtoToAd(adDTO);
		newAd.setUser(userService.findById(adDTO.getUserId()));
		newAd.setId(UUID.randomUUID());
		newAd= adRepository.save(newAd);
		System.out.println("Ad saved.");
		user.getAds().add(newAd);
		user=userRepository.save(user);
		
		return mapAdDtoToAd(newAd);
	}
	
	/*public List<AdDTO> findAllAd(){
		List<Ad> ads=adRepository.findAll();
		return ads.stream().map(ad->mapAdDtoToAd(ad)).collect(Collectors.toList());
	}*/
	private Ad mapAdDtoToAd(AdDTO dto) {
		Ad ad = new Ad();
		ad.setId(dto.getId());
		ad.setUser(userService.findById(dto.getUserId()));
		ad.setDate(dto.getDate());
		ad.setTitle(dto.getTitle());
		ad.setExplanation(dto.getExplanation());
		ad.setImage(dto.getImage());
		ad.setPhoneNumber(dto.getPhoneNumber());
		ad.setStatus(dto.getStatus());
		return ad;
	}

	private AdDTO mapAdDtoToAd(Ad ad) {
		AdDTO dto = new AdDTO();
		dto.setId(ad.getId());
		dto.setUserId(ad.getUser().getId());
		dto.setDate(ad.getDate());
		dto.setTitle(ad.getTitle());
		dto.setExplanation(ad.getExplanation());
		dto.setImage(ad.getImage());
		dto.setPhoneNumber(ad.getPhoneNumber());
		dto.setStatus(ad.getStatus());
		return dto;
	}
	
	
}
