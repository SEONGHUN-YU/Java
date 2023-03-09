package com.yu.bpbascp.member;


public interface MemberMapper {
	public abstract Member getMemberByID(Member m);
	public abstract int reg(Member m); // 동사형 이름으로, reg/join 등등
	public abstract int update(Member m);
	public abstract int bye(Member m);
}
