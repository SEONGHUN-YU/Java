package com.yu.bpbascp.sns;

public interface SNSMapper { // xxxMapper.xml 새로 만들면 servlet-context.xml에 꼭 등록할 것
	// beans:list 사이에 beans:value에 넣어주면 됨 classpath:(Mapper명).xml로 넣어주면 됨
	public abstract int writePost(SNSPOST s);
}
