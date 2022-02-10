package com.cengs.mybuddy.controller;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.data.mongodb.gridfs.GridFsResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.cengs.mybuddy.dto.AdDTO;
import com.cengs.mybuddy.dto.CommentDTO;
import com.cengs.mybuddy.dto.UserDTO;
import com.cengs.mybuddy.model.Ad;
import com.cengs.mybuddy.model.User;
import com.cengs.mybuddy.service.AdService;
import com.cengs.mybuddy.service.FileService;

@CrossOrigin
@RestController
@Validated
@RequestMapping("/ads")
public class AdController {
	
	@Autowired
	AdService adService;
	
	@Autowired
	private FileService fileService;
	
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
	
	@PostMapping(value = "/",consumes = {"multipart/form-data"})
	public ResponseEntity<AdDTO> addAd(@RequestPart("form") AdDTO dto,@RequestPart("file") MultipartFile file) throws IOException {
		if(file == null) return ResponseEntity.ok(adService.createAd(dto));
		dto.setImageURL("/ads/adImage/"+ fileService.uploadFile(file).toString());
		return ResponseEntity.ok(adService.createAd(dto));
	}
	/*
	@GetMapping(value = "")
	public ResponseEntity<List<Ad>> getAllAd() {
		return  ResponseEntity.ok(adService.getAllAd());
	}
/*
	@GetMapping(value = "/{id}")
	public ResponseEntity<AdDTO> getAd(@PathVariable String id) {
		Optional<Ad> ad = adService.getAllAd().stream().filter(new Predicate<Ad>() {
		@Override
				public boolean test(Ad ad) {
					return ad.getId().toString().equals(id);
				}
			}).findFirst();
			return  ResponseEntity.ok(adService.mapAdDtoToAd(ad.get()));
		}*/	
	
	@GetMapping("/adImage/{id}")
	public ResponseEntity<InputStreamResource> getImage(@PathVariable String id) throws IOException {
		GridFsResource resource = fileService.getFile(id);
		return ResponseEntity.ok().contentType(MediaType.IMAGE_PNG).body(new InputStreamResource(resource.getInputStream()));
	}
	@GetMapping("/{id}")
	public ResponseEntity<Ad> findById(@PathVariable("id") UUID id){
		return ResponseEntity.ok(adService.findById(id));		
	}

}
