package com.moviement.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.moviement.container.Container;
import com.moviement.db.DBConnection;
import com.moviement.dto.Member;
import com.moviement.dto.Review;

public class MemberDao {
	private DBConnection dbConnection;

	public MemberDao() {
		dbConnection = Container.getDBConnection();
	}

	public int join(Member member) {
		StringBuilder sb = new StringBuilder();

		sb.append(String.format("INSERT INTO `member` "));
		sb.append(String.format("SET regDate = NOW(), "));
		sb.append(String.format("updateDate = NOW(), "));
		sb.append(String.format("loginId = '%s', ", member.loginId));
		sb.append(String.format("loginPw = '%s', ", member.loginPw));
		sb.append(String.format("Email = '%s', ", member.eMail));
		sb.append(String.format("nickName = '%s', ", member.nickName));
		sb.append(String.format("`name` = '%s', ", member.name));
		sb.append(String.format("grade = '%s' ", member.grade));


		return dbConnection.insert(sb.toString());
	}

	public Member getMemberByLoginId(String loginId) {
		StringBuilder sb = new StringBuilder();

		sb.append(String.format("SELECT * "));
		sb.append(String.format("FROM `member` "));
		sb.append(String.format("WHERE loginId = '%s' ", loginId));

		Map<String, Object> memberRow = dbConnection.selectRow(sb.toString());

		if (memberRow.isEmpty()) {
			return null;
		}
		return new Member(memberRow);
	}

	public Member getMemberByEmail(String Email) {
		StringBuilder sb = new StringBuilder();

		sb.append(String.format("SELECT * "));
		sb.append(String.format("FROM `member` "));
		sb.append(String.format("WHERE Email = '%s' ", Email));

		Map<String, Object> memberRow = dbConnection.selectRow(sb.toString());

		if (memberRow.isEmpty()) {
			return null;
		}
		return new Member(memberRow);
	}

	public Member getMemberBynickName(String nickName) {
		StringBuilder sb = new StringBuilder();

		sb.append(String.format("SELECT * "));
		sb.append(String.format("FROM `member` "));
		sb.append(String.format("WHERE nickName = '%s' ", nickName));

		Map<String, Object> memberRow = dbConnection.selectRow(sb.toString());

		if (memberRow.isEmpty()) {
			return null;
		}
		return new Member(memberRow);
	}

	public int modifyEmail(int id, String Email) { // modify(int id, String Email)
		StringBuilder sb = new StringBuilder();

		sb.append(String.format("UPDATE `member` ")); // UPDATE `member`
		sb.append(String.format("SET updateDate = NOW(), ")); // SET updateDate = NOW(), ""
		sb.append(String.format("Email = '%s' ", Email)); // Email = '%s', ",Email
		sb.append(String.format("WHERE id = %d; ", id));

		return dbConnection.update(sb.toString());
	}

	public int modifyLoginPw(int id, String loginPw) {
		StringBuilder sb = new StringBuilder();

		sb.append(String.format("UPDATE `member` ")); // UPDATE `member`
		sb.append(String.format("SET updateDate = NOW(), ")); // SET updateDate = NOW(), ""
		sb.append(String.format("loginPw = '%s' ", loginPw)); // Email = '%s', ",Email
		sb.append(String.format("WHERE id = %d; ", id));

		return dbConnection.update(sb.toString());
	}

	public int modifyNickName(int id, String nickName) {
		StringBuilder sb = new StringBuilder();

		sb.append(String.format("UPDATE `member` ")); // UPDATE `member`
		sb.append(String.format("SET updateDate = NOW(), ")); // SET updateDate = NOW(), ""
		sb.append(String.format("nickName = '%s' ", nickName)); // Email = '%s', ",Email
		sb.append(String.format("WHERE id = %d; ", id));

		return dbConnection.update(sb.toString());
	}
	
	public int doDelete(int id) {
		StringBuilder sb = new StringBuilder();

		sb.append(String.format("DELETE FROM `member` "));
		sb.append(String.format("WHERE id = '%d' ", id));

		return dbConnection.delete(sb.toString());
	}

	public List<Member> getMembers() {
		StringBuilder sb = new StringBuilder();

		sb.append(String.format("SELECT * FROM `member`"));
		List<Member> members = new ArrayList<>();
		List<Map<String, Object>> rows = dbConnection.selectRows(sb.toString());

		for (Map<String, Object> row : rows) {
			members.add(new Member(row));
		}
		return members;
	}

	public Member getMember(int id) {
		StringBuilder sb = new StringBuilder();

		sb.append(String.format("SELECT * "));
		sb.append(String.format("FROM `member` "));
		sb.append(String.format("WHERE id = '%d' ", id));

		Map<String, Object> row = dbConnection.selectRow(sb.toString());

		if (row.isEmpty()) {
			return null;
		}
		return new Member(row);
	}
}