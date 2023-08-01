package com.moviement.service;

import java.util.List;

import com.moviement.container.Container;
import com.moviement.dao.MemberDao;
import com.moviement.dto.Member;
import com.moviement.dto.Review;

public class MemberService {
	private MemberDao memberDao;

	public MemberService() {
		memberDao = Container.memberDao;
	}

	public Member getMemberByLoginId(String loginId) {
		return memberDao.getMemberByLoginId(loginId);
	}

	public Member getMemberByEmail(String Email) {
		return memberDao.getMemberByEmail(Email);
	}

	public Member getMemberBynickName(String nickName) {
		return memberDao.getMemberBynickName(nickName);
	}

	public void join(String loginId, String eMail, String nickName, String loginPw, String name, String grade) {
		Member member = new Member(loginId, eMail, nickName, loginPw, name, grade);
		memberDao.join(member);
	}

	public String getMemberByNameId(int memberId) {
		return null;
	}

	public void modifyEmail(int id, String Email) {
		memberDao.modifyEmail(id, Email);
	}

	public void modifyLoginPw(int id, String loginPw) {
		memberDao.modifyLoginPw(id, loginPw);
	}

	public void modifyNickName(int id, String nickName) {
		memberDao.modifyNickName(id, nickName);
	}
	
	public void doDelete(int id) {
		memberDao.doDelete(id);
	}

	public List<Member> getMembers() {
		return memberDao.getMembers();
	}

	public Member getMember(int id) {
		return memberDao.getMember(id);
	}
}