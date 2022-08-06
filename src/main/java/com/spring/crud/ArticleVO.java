package com.spring.crud;

import org.springframework.lang.Nullable;

public class ArticleVO {
	private int id; // 추가된 거
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	private String title;
	private String content;
	private String video;
	private String thumbnail;
	
	public String getVideo() {
		return video;
	}
	
	public void setVideo(String video) {
		this.video = video;
	}
	
	public String getThumbnail() {
		return thumbnail;
	}
	
	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(@Nullable String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(@Nullable String content) {
		this.content = content;
	}
}
