package com.yu.bpbascp.sns;

import java.util.List;

public interface SNSMapper { // xxxMapper.xml 새로 만들면 servlet-context.xml에 꼭 등록할 것
	// beans:list 사이에 beans:value에 넣어주면 됨 classpath:(Mapper명).xml로 넣어주면 됨
	public abstract int writePost(SNSPOST s);
	public abstract List<SNSPOST> getPost(SNSSelector ss);
	public abstract int getPostCount(SNSSelector ss);
	public abstract int deletePost(SNSPOST s);
}
