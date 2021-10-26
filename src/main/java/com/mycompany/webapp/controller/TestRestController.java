package com.mycompany.webapp.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.mycompany.webapp.dto.Board;
import com.mycompany.webapp.dto.Member;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/rest")
@Slf4j
public class TestRestController {
	@RequestMapping("/getObject")
	public Board getObject() {
		log.info("실행");
		Board board = new Board();
		board.setBno(1);
		board.setBtitle("제목");
		board.setBcontent("내용");
		board.setMid("user");
		board.setBdate(new Date());
		return board;
	}

	@RequestMapping("/getMap")
	public Map<String, Object> getMap() {
		log.info("실행");

		Map<String, Object> map = new HashMap<>();
		map.put("name", "홍길동");
		map.put("age", 25);

		Board board = new Board();
		board.setBno(1);
		board.setBtitle("제목");
		board.setBcontent("내용");
		board.setMid("user");
		board.setBdate(new Date());
		map.put("board", board);

		return map;
	}

	@RequestMapping("/getArray")
	public String[] getArray() {
		log.info("실행");
		String[] array = { "Java", "Spring", "Thymeleaf" };
		return array;
	}

	@RequestMapping("/getList1")
	public List<String> getList1() {
		log.info("실행");
		List<String> list = new ArrayList<>();
		list.add("RestController");
		list.add("JSON");
		list.add("AJAX");
		return list;
	}

	@RequestMapping("/getList2")
	public List<Board> getList2() {
		log.info("실행");
		List<Board> list = new ArrayList<>();
		for (int i = 1; i <= 3; i++) {
			Board board = new Board();
			board.setBno(i);
			board.setBtitle("제목" + i);
			board.setBcontent("내용" + i);
			board.setMid("user");
			board.setBdate(new Date());
			list.add(board);
		}
		return list;
	}

	@RequestMapping("/sendQueryString")
	public Member sendQueryString(Member member) {
		log.info("실행");
		return member;
	}

	@PostMapping("/sendJson")
	public Member sendJson(@RequestBody Member member) {
		log.info("실행");
		return member;
	}

	@RequestMapping("/sendMultipartFormData")
	public Map<String, String> sendMultipartFormData(String title, MultipartFile attach) {
		log.info("실행");
		Map<String, String> map = new HashMap<>();
		map.put("title", title);
		map.put("attachoname", attach.getOriginalFilename());
		map.put("attachtype", attach.getContentType());
		return map;
	}

	@RequestMapping("/sendAuth")
	public Map<String, String> sendAuth(@RequestHeader("Authorization") String authorization) {
		log.info("실행");
		log.info(authorization);
		String jwt = authorization.substring(7);
		Map<String, String> map = new HashMap<>();
		map.put("jwt", jwt);
		return map;
	}
}
