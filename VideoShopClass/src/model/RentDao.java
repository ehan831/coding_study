package model;

import java.util.ArrayList;

/** 고객관리 JDBC 연결 */
public interface RentDao {
	// 대여 매소드
	public void rentVideo(String tel, String vnum) throws Exception;

	// 반납 메소드
	public String returnVideo(String vnum) throws Exception;

	// 대여 중인 비디오 검색 메소드
	public ArrayList selectList() throws Exception;
}
