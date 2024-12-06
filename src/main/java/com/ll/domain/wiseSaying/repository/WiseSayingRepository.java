package com.ll.domain.wiseSaying.repository;

import com.ll.domain.wiseSaying.entity.WiseSaying;

import java.util.ArrayList;
import java.util.List;

//가져오거나 저장할때 쓰는 것
public class WiseSayingRepository {
	private final List<WiseSaying> wiseSayings;
	private int lastId;

	public WiseSayingRepository() {
		this.wiseSayings = new ArrayList<>();
		this.lastId = 0;
	}

	public WiseSaying save(WiseSaying wiseSaying) {
		wiseSaying.setId(++lastId);
		wiseSayings.add(wiseSaying);
		return wiseSaying;
	}

	public List<WiseSaying> findAll() {
		return wiseSayings;
	}
}